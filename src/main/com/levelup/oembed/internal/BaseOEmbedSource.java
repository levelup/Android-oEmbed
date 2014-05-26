package com.levelup.oembed.internal;

import android.net.Uri;
import android.text.TextUtils;

import com.levelup.http.HttpClient;
import com.levelup.http.HttpException;
import com.levelup.http.HttpParamsGet;
import com.levelup.oembed.OEmbed;
import com.levelup.oembed.OEmbedRequest;
import com.levelup.oembed.OEmbedSource;

abstract class BaseOEmbedSource implements OEmbedSource {

	protected OEmbed oembedData;
	private final String endpoint;
	private final String url;
	
	protected BaseOEmbedSource(String endpoint, Uri fromUri) {
		this.endpoint = endpoint;
		this.url = fromUri.toString();
	}
	
	final void assertDataLoaded() throws HttpException {
		OEmbedRequest request = getOembedRequest();
		oembedData = HttpClient.parseRequest(request, request.getInputStreamParser());
	}
	
	@Override
	public final OEmbedRequest getOembedRequest() {
		HttpParamsGet params = new HttpParamsGet(2);
		params.add("url", url);
		params.add("format", "json");
		return new OEmbedRequestGet(endpoint, params);
	}
	
	@Override
	public String getThumbnail() throws HttpException {
		assertDataLoaded();
		
		if (null!=oembedData) {
			String thumbnail = oembedData.getThumbnail();
			if (TextUtils.isEmpty(thumbnail))
				thumbnail = oembedData.getPhotoUrl();
			return thumbnail;
		}
		return null;
	}
}
