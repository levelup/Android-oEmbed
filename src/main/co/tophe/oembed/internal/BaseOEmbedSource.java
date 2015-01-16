package co.tophe.oembed.internal;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import co.tophe.oembed.OEmbed;
import co.tophe.oembed.OEmbedRequest;
import co.tophe.oembed.OEmbedSource;

import co.tophe.TopheClient;
import co.tophe.HttpException;
import co.tophe.ServerException;
import co.tophe.UriParams;

public abstract class BaseOEmbedSource implements OEmbedSource {

	private OEmbed oembedData;
	private final String endpoint;
	private final String url;

	protected BaseOEmbedSource(@NonNull String endpoint, @NonNull Uri fromUri) {
		this.endpoint = endpoint;
		this.url = fromUri.toString();
	}
	
	final void assertDataLoaded() throws ServerException, HttpException {
		OEmbedRequest request = createOembedRequest();
		oembedData = TopheClient.parseRequest(request);
	}

	@NonNull
	@Override
	public final OEmbedRequest createOembedRequest() {
		UriParams params = new UriParams(2);
		params.add("url", url);
		params.add("format", "json");
		return new OEmbedRequestGet(endpoint, params);
	}

	@Nullable
	@Override
	public String getThumbnail() throws ServerException, HttpException {
		assertDataLoaded();
		
		if (null!=oembedData) {
			String thumbnail = oembedData.isLink() ? null : oembedData.getThumbnail();
			if (TextUtils.isEmpty(thumbnail))
				thumbnail = oembedData.getPhotoUrl();
			return thumbnail;
		}
		return null;
	}
}
