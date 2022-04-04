package com.nandha.wiki.wikiminer.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 *
 * @author Nandhakumar Subramanian
 * 
 * @version 0.0.1
 *
 * @since 04 Apr 2022
 **/

public class WikiCrawler {
	
	private static final OkHttpClient client = new OkHttpClient();
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonWriter.class);
	
	public static String run(String url) throws IOException {
		LOGGER.info("sending http request....");
		Request req = new Request.Builder().url(url).build();
		Call call = client.newCall(req);
		Response resp = call.execute();
		return resp.body().string();
	}
}
