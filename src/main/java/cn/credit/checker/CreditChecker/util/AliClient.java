package cn.credit.checker.CreditChecker.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AliClient {

    CloseableHttpClient httpclient = HttpClients.createDefault();

    CloseableHttpResponse get(String url) {
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpclient.execute(httpGet);
            return response;
        } catch (Exception e) {
            log.error("Failed to call " + url);
            throw new RuntimeException("Failed to call " + url, e);
        }
    }
}
