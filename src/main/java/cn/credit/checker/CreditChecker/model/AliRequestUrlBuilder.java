package cn.credit.checker.CreditChecker.model;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;

public abstract class AliRequestUrlBuilder {

	protected String appId;
	protected String method;
	protected String format;
	protected String charset;
	protected String signType;
	protected String sign;
	protected String timestamp;
	protected String version;
	protected String appAuthToken;
	protected String bizContent;

	protected URIBuilder builder = new URIBuilder();
	
	public abstract URI build() throws URISyntaxException;
	
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
	
	public void bizContent(final String bizContent) {
		builder.setParameter("biz_content", bizContent);
	}
}
