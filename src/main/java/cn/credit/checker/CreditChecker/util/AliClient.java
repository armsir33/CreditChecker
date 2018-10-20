package cn.credit.checker.CreditChecker.util;

import java.net.URI;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AliClient {

	private static Logger LOG = LoggerFactory.getLogger("AliClient");
	
    private final CloseableHttpClient httpclient;

    public AliClient() {
    	httpclient = HttpClients.createDefault();
    }
    
    public CloseableHttpResponse doGet(String host, URI uri) {
        HttpGet httpGet = new HttpGet(host+uri.toString());
        try {
            CloseableHttpResponse response = httpclient.execute(httpGet);
            return response;
        } catch (Exception e) {
            LOG.warn("FAILED to call {}", host + uri.toString());
            throw new RuntimeException("Failed to call " + host + uri.toString(), e);
        }
    }
}
