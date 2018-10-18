package cn.credit.checker.CreditChecker.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;

public class SignatureUtil {

    private static final Logger LOG = LoggerFactory.getLogger(SignatureUtil.class);

    private static final String KEYSTORE = "ssh/creditchecker.jsk";
    private static final String KEY_ALIAS = "CreditChecker";
    private static final String SIGNATURE_ALGORITHM = "SHA256WithRSA";

    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    private SignatureUtil(final PrivateKey privateKey, final PublicKey publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public static SignatureUtil create() throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        final KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream(KEYSTORE), "flower0224".toCharArray());
        final PrivateKey privateKey = (PrivateKey) ks.getKey(KEY_ALIAS, "flower0224".toCharArray());
        final Certificate cert = ks.getCertificate(KEY_ALIAS);
        final PublicKey publicKey = cert.getPublicKey();
        return new SignatureUtil(privateKey, publicKey);
    }


    public String sign(byte[] data) throws Exception {
        LOG.debug("sign {}", new String(data, StandardCharsets.UTF_8));
        final Signature sign = Signature.getInstance(SIGNATURE_ALGORITHM);
        sign.initSign(privateKey);
        sign.update(data);
        final byte[] result = sign.sign();
        return Base64.getEncoder().encodeToString(result);
    }

}
