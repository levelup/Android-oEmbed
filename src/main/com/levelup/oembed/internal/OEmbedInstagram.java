package com.levelup.oembed.internal;

import java.util.regex.Pattern;

import android.net.Uri;

import com.levelup.http.HttpParamsGet;
import com.levelup.oembed.OEmbedRequest;
import com.levelup.oembed.OEmbedSource;

public class OEmbedInstagram implements OEmbedParser {
	
	public static final OEmbedInstagram instance = new OEmbedInstagram();

	private OEmbedInstagram() {
	}

	private final Pattern URLS = Pattern.compile("http://(instagram.com|instagr.am)/p/*");

	@Override
	public OEmbedSource getSource(Uri fromUri) {
		if (URLS.matcher(fromUri.toString()).find()) {
			return new OEmbedSourceInstagram(fromUri);
		}
		return null;
	}

	private static class OEmbedSourceInstagram extends BaseOEmbedSource {
		private final Uri fromUri;
		
		public OEmbedSourceInstagram(Uri fromUri) {
			this.fromUri = fromUri;
		}

		@Override
		public OEmbedRequest getOembedRequest() {
			HttpParamsGet params = new HttpParamsGet(1);
			params.add("url", fromUri.toString());
			return new OEmbedRequestGet("http://api.instagram.com/oembed", params);
		}
		
	}
}
