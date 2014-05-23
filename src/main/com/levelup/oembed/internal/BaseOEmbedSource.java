package com.levelup.oembed.internal;

import android.text.TextUtils;

import com.levelup.http.HttpClient;
import com.levelup.http.HttpException;
import com.levelup.oembed.OEmbed;
import com.levelup.oembed.OEmbedRequest;
import com.levelup.oembed.OEmbedSource;

abstract class BaseOEmbedSource implements OEmbedSource {

	protected OEmbed oembedData;
	
	final void assertDataLoaded() throws HttpException {
		OEmbedRequest request = getOembedRequest();
		oembedData = HttpClient.parseRequest(request, request.getInputStreamParser());
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
