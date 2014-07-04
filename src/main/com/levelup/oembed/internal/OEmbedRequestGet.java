package com.levelup.oembed.internal;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.levelup.http.BaseHttpRequest;
import com.levelup.http.HttpUriParameters;
import com.levelup.http.InputStreamParser;
import com.levelup.http.gson.InputStreamGsonParser;
import com.levelup.oembed.OEmbed;
import com.levelup.oembed.OEmbedRequest;

public class OEmbedRequestGet extends BaseHttpRequest<OEmbed> implements OEmbedRequest {

	public OEmbedRequestGet(Context context, String url) {
		super(new Builder<OEmbed>(context).setUrl(url).setStreamParser(getParser()));
	}

	public OEmbedRequestGet(Context context, String baseUrl, HttpUriParameters uriParams) {
		super(new Builder<OEmbed>(context).setUrl(baseUrl, uriParams).setStreamParser(getParser()));
	}

	private static InputStreamParser<OEmbed> getParser() {
		Gson gson = new GsonBuilder().create();
		return new InputStreamGsonParser<OEmbed>(gson, OEmbed.class);
	}
}
