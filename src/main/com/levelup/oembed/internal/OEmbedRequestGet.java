package com.levelup.oembed.internal;

import android.content.Context;

import com.levelup.http.BaseHttpRequest;
import com.levelup.http.HttpEngine;
import com.levelup.http.HttpResponseHandler;
import com.levelup.http.HttpUriParameters;
import com.levelup.http.gson.ResponseViaGson;
import com.levelup.oembed.OEmbed;
import com.levelup.oembed.OEmbedRequest;

public class OEmbedRequestGet extends BaseHttpRequest<OEmbed> implements OEmbedRequest {

	private static final ResponseViaGson<OEmbed> OEMBED_TRANSFORM = new ResponseViaGson(OEmbed.class);
	private static final HttpResponseHandler<OEmbed> OEMBED_PARSER = new HttpResponseHandler<OEmbed>(OEMBED_TRANSFORM);

	public OEmbedRequestGet(Context context, String url) {
		this(context, url, null);
	}

	public OEmbedRequestGet(Context context, String baseUrl, HttpUriParameters uriParams) {
		super(new AbstractBuilder<OEmbed, OEmbedRequestGet>(context) {
			@Override
			protected OEmbedRequestGet build(HttpEngine<OEmbed> impl) {
				return new OEmbedRequestGet(impl);
			}
		}.setUrl(baseUrl, uriParams)
				.setResponseParser(OEMBED_PARSER)
				.buildImpl());
	}

	protected OEmbedRequestGet(HttpEngine<OEmbed> impl) {
		super(impl);
	}
}
