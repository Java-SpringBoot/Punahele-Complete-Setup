package com.punahele.adapters.elasticsearch;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ElasticSearchClient {
	//Ref url https://www.ibm.com/developerworks/library/j-use-elasticsearch-java-apps/index.html
	private static String ELASTIC_SEARCH_URL = "http://localhost:9300/";

	public void insertIndex(String indexName) throws ClientProtocolException, IOException {
		//curl -XPUT "http://localhost:9200/music/"
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpget = new HttpGet(ELASTIC_SEARCH_URL + indexName);
			HttpPut httpput = new HttpPut(ELASTIC_SEARCH_URL + indexName);
			System.out.println("Executing request " + httpget.getRequestLine());

			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				@Override
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			System.out.println("----------------------------------------");
			System.out.println(responseBody);
		} finally {
			httpclient.close();
		}
	}

	public void insertDocument(String doc) {
        //curl -XPUT "http://localhost:9200/music/songs/1" -d '
		//	{ "name": "Deck the Halls", "year": 1885, "lyrics": "Fa la la la la" }'
	}
	
	public void viewDocument(String url) {
		//curl -XGET "http://localhost:9200/music/songs/1"
	}
	
	public void searchDocument(String query) {
		//curl -XGET "http://localhost:9200/music/lyrics/_search?q=lyrics:'you'"
	}
}
