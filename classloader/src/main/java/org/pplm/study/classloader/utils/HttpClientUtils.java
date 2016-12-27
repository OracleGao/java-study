package org.pplm.study.classloader.utils;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientUtils {
	public static byte[] onGetBytes(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse closeableHttpResponse = null;
		try {
			closeableHttpResponse = httpClient.execute(httpGet);
			if (closeableHttpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				return null;
			}
			HttpEntity httpEntity = closeableHttpResponse.getEntity();
			if (httpEntity == null) {
				return null;
			}
			int size = new Long(httpEntity.getContentLength()).intValue();
			return IOUtils.readFully(httpEntity.getContent(), size);
		} finally {
			if (closeableHttpResponse != null) {
				closeableHttpResponse.close();
			}
		}
	}
}
