package com.levelup.oembed.internal;

import java.util.regex.Pattern;

import android.net.Uri;

import com.levelup.http.HttpParamsGet;
import com.levelup.oembed.OEmbedRequest;
import com.levelup.oembed.OEmbedSource;

public class OEmbedVimeo implements OEmbedParser {

	public static final OEmbedVimeo instance = new OEmbedVimeo();
	
	private OEmbedVimeo() {
	}
	
	private final Pattern URLS = Pattern.compile("http://vimeo.com/*");

	@Override
	public OEmbedSource getSource(Uri fromUri) {
		if (URLS.matcher(fromUri.toString()).find()) {
			return new OEmbedSourceVimeo(fromUri);
		}
		return null;
	}

	private static class OEmbedSourceVimeo extends BaseOEmbedSource {

		private final Uri fromUri;
		
		public OEmbedSourceVimeo(Uri fromUri) {
			this.fromUri = fromUri;
		}

		@Override
		public OEmbedRequest getOembedRequest() {
			HttpParamsGet params = new HttpParamsGet(1);
			params.add("url", fromUri.toString());
			return new OEmbedRequestGet("http://vimeo.com/api/oembed.json", params);
		}
	}
}