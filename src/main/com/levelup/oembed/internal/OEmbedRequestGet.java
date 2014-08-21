package com.levelup.oembed.internal;

import android.content.Context;

import com.levelup.http.BaseHttpRequest;
import com.levelup.http.HttpEngine;
import com.levelup.http.HttpUriParameters;
import com.levelup.http.gson.InputStreamGsonParser;
import com.levelup.http.parser.ResponseParser;
import com.levelup.oembed.OEmbed;
import com.levelup.oembed.OEmbedRequest;

public class OEmbedRequestGet extends BaseHttpRequest<OEmbed> implements OEmbedRequest {

	private static final InputStreamGsonParser<OEmbed> OEMBED_PARSER = new InputStreamGsonParser<OEmbed>(OEmbed.class);

	public OEmbedRequestGet(Context context, String url) {
		this(context, url, null);
	}

	public OEmbedRequestGet(Context context, String baseUrl, HttpUriParameters uriParams) {
		super(new AbstractBuilder<OEmbed, OEmbedRequestGet>(context) {
			@Override
			protected OEmbedRequestGet build(HttpEngine<OEmbed> impl) {
				return new OEmbedRequestGet(impl);
			}
		}.setUrl(baseUrl, uriParams).setResponseParser(getParser())
				.buildImpl());
	}

	protected OEmbedRequestGet(HttpEngine<OEmbed> impl) {
		super(impl);
	}

	private static ResponseParser<OEmbed,?> getParser() {
		return new ResponseParser<OEmbed, Object>(OEMBED_PARSER, null);
	}
}
