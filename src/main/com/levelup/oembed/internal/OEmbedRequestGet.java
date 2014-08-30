package com.levelup.oembed.internal;

import android.content.Context;

import com.levelup.http.BaseHttpRequest;
import com.levelup.http.ResponseHandler;
import com.levelup.http.HttpUriParameters;
import com.levelup.http.gson.ResponseViaGson;
import com.levelup.oembed.OEmbed;
import com.levelup.oembed.OEmbedRequest;

public class OEmbedRequestGet extends BaseHttpRequest<OEmbed> implements OEmbedRequest {

	private static final ResponseViaGson<OEmbed> OEMBED_TRANSFORM = new ResponseViaGson(OEmbed.class);
	private static final ResponseHandler<OEmbed> OEMBED_RESPONSE_PARSER = new ResponseHandler<OEmbed>(OEMBED_TRANSFORM);

	public OEmbedRequestGet(Context context, String url) {
		this(context, url, null);
	}

	public OEmbedRequestGet(Context context, String baseUrl, HttpUriParameters uriParams) {
		super(new ChildBuilder<OEmbed, OEmbedRequestGet>(context) {
					@Override
					protected OEmbedRequestGet build(ChildBuilder<OEmbed, OEmbedRequestGet> builder) {
						return new OEmbedRequestGet(builder);
					}
				}
						.setUrl(baseUrl, uriParams)
						.setResponseParser(OEMBED_RESPONSE_PARSER)
		);
	}

	protected OEmbedRequestGet(ChildBuilder<OEmbed, ? extends OEmbedRequestGet> builder) {
		super(builder);
	}
}
