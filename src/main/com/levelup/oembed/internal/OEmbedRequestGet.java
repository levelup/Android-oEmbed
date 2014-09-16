package com.levelup.oembed.internal;

import com.levelup.http.BaseHttpRequest;
import com.levelup.http.HttpRequest;
import com.levelup.http.HttpUriParameters;
import com.levelup.http.ResponseHandler;
import com.levelup.http.gson.BodyViaGson;
import com.levelup.oembed.OEmbed;
import com.levelup.oembed.OEmbedRequest;

public class OEmbedRequestGet extends BaseHttpRequest<OEmbed> implements OEmbedRequest {

	private static final BodyViaGson<OEmbed> OEMBED_TRANSFORM = new BodyViaGson(OEmbed.class);
	private static final ResponseHandler<OEmbed> OEMBED_RESPONSE_PARSER = new ResponseHandler<OEmbed>(OEMBED_TRANSFORM);

	public OEmbedRequestGet(String url) {
		this(url, null);
	}

	public OEmbedRequestGet(String baseUrl, HttpUriParameters uriParams) {
		super(new ChildBuilder<OEmbed, OEmbedRequestGet>() {
					@Override
					protected OEmbedRequestGet build(ChildBuilder<OEmbed, OEmbedRequestGet> builder) {
						return new OEmbedRequestGet(builder);
					}
				}
						.setUrl(baseUrl, uriParams)
						.setResponseHandler(OEMBED_RESPONSE_PARSER)
		);
		setHeader(HttpRequest.HEADER_ACCEPT, "application/json");
	}

	protected OEmbedRequestGet(ChildBuilder<OEmbed, ? extends OEmbedRequestGet> builder) {
		super(builder);
	}
}
