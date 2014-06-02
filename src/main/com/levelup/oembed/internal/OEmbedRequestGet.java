package com.levelup.oembed.internal;

import android.net.Uri;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.levelup.http.HttpUriParameters;
import com.levelup.http.HttpRequestGet;
import com.levelup.http.InputStreamParser;
import com.levelup.http.gson.InputStreamGsonParser;
import com.levelup.oembed.OEmbed;
import com.levelup.oembed.OEmbedRequest;

public class OEmbedRequestGet extends HttpRequestGet<OEmbed> implements OEmbedRequest {

	public OEmbedRequestGet(String url) {
		super(url, getParser());
	}

	public OEmbedRequestGet(String baseUrl, HttpUriParameters httpParams) {
		super(baseUrl, httpParams, getParser());
	}

	public OEmbedRequestGet(Uri baseUri, HttpUriParameters httpParams) {
		super(baseUri, httpParams, getParser());
	}

	private static InputStreamParser<OEmbed> getParser() {
		Gson gson = new GsonBuilder().create();
		return new InputStreamGsonParser<OEmbed>(gson, OEmbed.class);
	}
}
