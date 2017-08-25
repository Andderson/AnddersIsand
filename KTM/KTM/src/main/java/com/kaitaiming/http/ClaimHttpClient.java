package com.kaitaiming.http;

import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class ClaimHttpClient {
	
//	 private final Logger logger = LoggerFactory.getLogger(ClaimHttpClient.class);

	private int claimHttpClient(String serviceUrl, String claimContents) {

        OutputStreamWriter out = null;
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(serviceUrl);

            StringEntity input = new StringEntity(claimContents, "utf-8");
            input.setContentType("application/json;charset=utf-8");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);
            if (response.getStatusLine().getStatusCode() != 200) {
                String resultString = EntityUtils.toString(response.getEntity());
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
//			logger.error("同步url:{} 案件同步错误，error:{}");
            return 2;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
