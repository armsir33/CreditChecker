package cn.credit.checker.CreditChecker.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class AliClient {

	private static Logger LOG = LoggerFactory.getLogger("AliClient");
	
	private static String API_INITIATE_CERTIFICATE = "zhima.customer.certification.initialize";
	private static String API_DO_CERTIFICATE = "zhima.customer.certification.certify";
	private static String API_QUERY_CERTIFICATE = "zhima.customer.certification.query";
	
	
	private static String GATEWAY = "https://openapi.alipaydev.com/gateway.do";
	private static String APP_ID = "2016072200101845";
	
	
    private CloseableHttpClient httpclient = HttpClients.createDefault();

    public AliClient() {
    	
    }
    
    CloseableHttpResponse initiateCertificate() {
    	
    	return null;
    }
    
    CloseableHttpResponse doCertificate() {
    	
    	return null;
    }

    CloseableHttpResponse queryCertificate() {
	
    	return null;
    }
    
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
