package com.levelup.oembed.internal;

import android.net.Uri;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.levelup.http.HttpGetParameters;
import com.levelup.http.HttpRequestGet;
import com.levelup.http.InputStreamParser;
import com.levelup.http.gson.InputStreamGsonParser;
import com.levelup.oembed.OEmbed;
import com.levelup.oembed.OEmbedRequest;

public class OEmbedRequestGet extends HttpRequestGet implements OEmbedRequest {

	public OEmbedRequestGet(String url) {
		super(url);
	}

	public OEmbedRequestGet(String baseUrl, HttpGetParameters httpParams) {
		super(baseUrl, httpParams);
	}

	public OEmbedRequestGet(Uri baseUri, HttpGetParameters httpParams) {
		super(baseUri, httpParams);
	}

	@Override
	public InputStreamParser<OEmbed> getInputStreamParser() {
		Gson gson = new GsonBuilder().create();
		return new InputStreamGsonParser<OEmbed>(gson, OEmbed.class);
	}

}
