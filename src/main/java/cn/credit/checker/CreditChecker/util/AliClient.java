package cn.credit.checker.CreditChecker.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class AliClient {

	private static Logger LOG = LoggerFactory.getLogger("AliClient");
	
    CloseableHttpClient httpclient = HttpClients.createDefault();

    CloseableHttpResponse get(String url) {
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpclient.execute(httpGet);
            return response;
        } catch (Exception e) {
        	LOG.error("Failed to call " + url);
            throw new RuntimeException("Failed to call " + url, e);
        }
    }
}
