package cn.credit.checker.CreditChecker.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import cn.credit.checker.CreditChecker.util.SignatureUtil;
import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AliContractInitializeRequestUrlBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(AliContractInitializeRequestUrlBuilder.class);
    private static final Gson GSON = new Gson();

    private URIBuilder builder = new URIBuilder();

    private String appId;
    private String method;
    private String format;
    private String charset;
    private String signType;
    private String sign;
    private String timestamp;
    private String version;
    private String appAuthToken;

    public static class BizContent {
        private String productCode;
        private String contractName;
        private String contractFile;


        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(final String productCode) {
            this.productCode = productCode;
        }

        public String getContractName() {
            return contractName;
        }

        public void setContractName(final String contractName) {
            this.contractName = contractName;
        }

        public String getContractFile() {
            return contractFile;
        }
        public void setContractFile(final String contractFile) {
            this.contractFile = contractFile;
        }

    }

	public URI build() {
        try {
            createAndSetSignValue();
            return builder.build();
        } catch (URISyntaxException e) {
            LOG.warn("FAILED to build AliContractInitializeRequestUrl");
            throw new RuntimeException("FAILED to build AliContractInitializeRequestUrl", e);
        }
    }

    private void createAndSetSignValue() {
        List<NameValuePair> queryParams = builder.getQueryParams();
        List<NameValuePair> filteredQueryParams = queryParams.stream().
                filter(v -> !v.getName().equals("sign") && !v.getName().equals("sign_type")).
                collect(Collectors.toList());
        Collections.sort(filteredQueryParams, Comparator.comparing(NameValuePair::getName));
        StringBuilder sb = new StringBuilder();
        filteredQueryParams.stream().forEach(v-> sb.append("&").append(v.getName()).append("=").append(v.getValue()));
        if(sb.length()>0) {
            sb.deleteCharAt(0);
        }
        byte[] toSignBytes = sb.toString().getBytes(StandardCharsets.UTF_8);
        String signValue = SignatureUtil.getInstance().sign(toSignBytes);
        sign(signValue);
    }

    ;
	
	public void appId(final String appId) {
		builder.setParameter("app_id", appId);
	}
	
	public void method(final String method) {
		builder.setParameter("method", method);
	}
	
	public void format(final String format) {
		builder.setParameter("format", format);
	}
	
	public void charset(final String charset) {
		builder.setParameter("charset", charset);
	}
	
	public void signType(final String signType) {
		builder.setParameter("sign_type", signType);
	}
	
	public void sign(final String sign) {
		builder.setParameter("sign", sign);
	}
	
	public void timestamp(final String timestamp) {
		builder.setParameter("timestamp", timestamp);
	}
	
	public void version(final String version) {
		builder.setParameter("version", version);
	}
	
	public void appAuthToken(final String appAuthToken) {
		builder.setParameter("app_auth_token", appAuthToken);
	}

	public void bizContent(final BizContent bizContent) {
        final String gson = GSON.toJson(bizContent);
        builder.setParameter("biz_content", gson);
    }
}
