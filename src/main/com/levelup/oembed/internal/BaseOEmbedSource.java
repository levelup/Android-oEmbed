package com.levelup.oembed.internal;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.levelup.http.HttpClient;
import com.levelup.http.HttpException;
import com.levelup.http.ServerException;
import com.levelup.http.UriParams;
import com.levelup.oembed.OEmbed;
import com.levelup.oembed.OEmbedRequest;
import com.levelup.oembed.OEmbedSource;

public abstract class BaseOEmbedSource implements OEmbedSource {

	private OEmbed oembedData;
	private final String endpoint;
	private final String url;

	protected BaseOEmbedSource(@NonNull String endpoint, @NonNull Uri fromUri) {
		this.endpoint = endpoint;
		this.url = fromUri.toString();
	}
	
	final void assertDataLoaded() throws HttpException, ServerException {
		OEmbedRequest request = getOembedRequest();
		oembedData = HttpClient.parseRequest(request);
	}
	
	@Override
	public final OEmbedRequest getOembedRequest() {
		UriParams params = new UriParams(2);
		params.add("url", url);
		params.add("format", "json");
		return new OEmbedRequestGet(endpoint, params);
	}
	
	@Override
	public String getThumbnail() throws HttpException, ServerException {
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
