package com.levelup.oembed.internal;

import android.support.annotation.NonNull;

import com.levelup.oembed.OEmbed;
import com.levelup.oembed.OEmbedRequest;

import co.tophe.BaseHttpRequest;
import co.tophe.BaseResponseHandler;
import co.tophe.HttpRequest;
import co.tophe.HttpUriParameters;
import co.tophe.ServerException;
import co.tophe.gson.BodyViaGson;

public class OEmbedRequestGet extends BaseHttpRequest<OEmbed,ServerException> implements OEmbedRequest {

	private static final BodyViaGson<OEmbed> OEMBED_TRANSFORM = new BodyViaGson<OEmbed>(OEmbed.class);
	private static final BaseResponseHandler<OEmbed> OEMBED_RESPONSE_PARSER = new BaseResponseHandler<OEmbed>(OEMBED_TRANSFORM);

	public OEmbedRequestGet(@NonNull String url) {
		this(url, null);
	}

	public OEmbedRequestGet(@NonNull String baseUrl, HttpUriParameters uriParams) {
		super(new ChildBuilder<OEmbed, ServerException, OEmbedRequestGet>() {
					@Override
					protected OEmbedRequestGet build(ChildBuilder<OEmbed, ServerException, OEmbedRequestGet> builder) {
						return new OEmbedRequestGet(builder);
					}
				}
						.setUrl(baseUrl, uriParams)
						.setResponseHandler(OEMBED_RESPONSE_PARSER)
		);
		setHeader(HttpRequest.HEADER_ACCEPT, "application/json");
	}

	protected OEmbedRequestGet(ChildBuilder<OEmbed, ServerException, ? extends OEmbedRequestGet> builder) {
		super(builder);
	}
}
