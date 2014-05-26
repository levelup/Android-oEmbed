package com.levelup.oembed.internal;

import android.net.Uri;

import com.levelup.http.HttpParamsGet;
import com.levelup.oembed.OEmbedRequest;
import com.levelup.oembed.OEmbedSource;

public class OEmbedImgur implements OEmbedParser {

	public static final OEmbedImgur instance = new OEmbedImgur();

	private OEmbedImgur() {
	}

	@Override
	public OEmbedSource getSource(Uri fromUri) {
		if ("i.imgur.com".equalsIgnoreCase(fromUri.getHost())) {
			return new OEmbedSourceImgur(fromUri);
		}
		if ("imgur.com".equalsIgnoreCase(fromUri.getHost())) {
			if (fromUri.getPath().startsWith("/gallery/")) {
				return new OEmbedSourceImgur(fromUri);
			}
		}
		return null;
	}

	private static class OEmbedSourceImgur extends BaseOEmbedSource {

		private final Uri fromUri;

		OEmbedSourceImgur(Uri fromUri) {
			this.fromUri = fromUri;
		}

		@Override
		public OEmbedRequest getOembedRequest() {
			HttpParamsGet params = new HttpParamsGet(2);
			params.add("url", fromUri.toString());
			params.add("format", "json");
			return new OEmbedRequestGet("http://api.imgur.com/oembed.json", params);
		}
	}
}
