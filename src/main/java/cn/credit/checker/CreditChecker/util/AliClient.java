package cn.credit.checker.CreditChecker.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class AliClient {
	
	private final RestTemplate client;
	
	public AliClient(final RestTemplate client) {
		this.client = client;
	}
	
	public static AliClient create() {
		final RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		final AliClient aliClient = new AliClient(rt);
		return aliClient;
	}
}
