package cn.credit.checker.CreditChecker.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;

public class SignatureUtil {

    private static final Logger LOG = LoggerFactory.getLogger(SignatureUtil.class);

    private static SignatureUtil instance;


    private static final String KEYSTORE = "ssh/creditchecker.jks";
    private static final String KEY_ALIAS = "CreditChecker";
    private static final String SIGNATURE_ALGORITHM = "SHA256WithRSA";

    private static final ClassPathResource KEYSTORE_RESOURCE = new ClassPathResource(KEYSTORE);

    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public static SignatureUtil getInstance() {
        return instance == null ? instance = create() : instance;
    }

    private SignatureUtil(final PrivateKey privateKey, final PublicKey publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public static SignatureUtil create()  {
        PrivateKey privateKey;
        PublicKey publicKey;
        try {
            final KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(new FileInputStream(KEYSTORE_RESOURCE.getFile()), "flower0224".toCharArray());
            privateKey = (PrivateKey) ks.getKey(KEY_ALIAS, "flower0224".toCharArray());
            final Certificate cert = ks.getCertificate(KEY_ALIAS);
            publicKey = cert.getPublicKey();
        } catch (Exception e) {
            LOG.warn("FAILED to create SignatureUtil instance");
            throw new RuntimeException("FAILED to create SignatureUtil instance");
        }
        return new SignatureUtil(privateKey, publicKey);
    }


    public String sign(byte[] data) {
        LOG.debug("sign {}", new String(data, StandardCharsets.UTF_8));
        try {
            final Signature sign = Signature.getInstance(SIGNATURE_ALGORITHM);
            sign.initSign(privateKey);
            sign.update(data);
            final byte[] result = sign.sign();
            return Base64.getEncoder().encodeToString(result);
        } catch (Exception e) {
            LOG.warn("FAILED to sign");
            throw new RuntimeException("FAILED to sign", e);
        }
    }

}
