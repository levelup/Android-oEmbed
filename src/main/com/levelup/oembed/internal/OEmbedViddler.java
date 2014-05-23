package com.levelup.oembed.internal;

import java.util.regex.Pattern;

import android.net.Uri;

import com.levelup.http.HttpParamsGet;
import com.levelup.oembed.OEmbedRequest;
import com.levelup.oembed.OEmbedSource;

public class OEmbedViddler implements OEmbedParser {

	public static final OEmbedViddler instance = new OEmbedViddler();
	
	private OEmbedViddler() {
	}

	private final Pattern URLS = Pattern.compile("http://www.viddler.com/v/*");

	@Override
	public OEmbedSource getSource(Uri fromUri) {
		if (URLS.matcher(fromUri.toString()).find()) {
			return new OEmbedSourceViddler(fromUri);
		}
		return null;
	}

	private static class OEmbedSourceViddler extends BaseOEmbedSource {

		private final Uri fromUri;
		
		public OEmbedSourceViddler(Uri fromUri) {
			this.fromUri = fromUri;
		}

		@Override
		public OEmbedRequest getOembedRequest() {
			HttpParamsGet params = new HttpParamsGet(1);
			params.add("url", fromUri.toString());
			return new OEmbedRequestGet("http://www.viddler.com/oembed/", params);
		}
	}
}
