package com.levelup.oembed.internal;

import java.util.regex.Pattern;

import android.net.Uri;

import com.levelup.http.HttpParamsGet;
import com.levelup.oembed.OEmbedRequest;

public abstract class OEmbedParserWithPattern implements OEmbedParser {

	private final Pattern pattern;
	private final String endpoint;

	public OEmbedParserWithPattern(String pattern, String endpoint) {
		if (null==pattern) throw new NullPointerException();
		if (null==endpoint) throw new NullPointerException();
		this.pattern = Pattern.compile(pattern);
		this.endpoint = endpoint;
	}

	@Override
	public OEmbedSource getSource(Uri fromUri) {
		if (pattern.matcher(fromUri.toString()).find()) {
			return new OEmbedSource(fromUri);
		}
		return null;
	}

	private class OEmbedSource extends BaseOEmbedSource {
		private final Uri fromUri;

		public OEmbedSource(Uri fromUri) {
			this.fromUri = fromUri;
		}

		@Override
		public OEmbedRequest getOembedRequest() {
			HttpParamsGet params = new HttpParamsGet(2);
			params.add("url", fromUri.toString());
			params.add("format", "json");
			return new OEmbedRequestGet(endpoint, params);
		}
	}
}
