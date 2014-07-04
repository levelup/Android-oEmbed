package com.levelup.oembed.internal;

import java.util.regex.Pattern;

import android.content.Context;
import android.net.Uri;

public abstract class OEmbedParserWithPattern implements OEmbedParser {

	private final Pattern pattern;
	private final String endpoint;

	protected OEmbedParserWithPattern(String pattern, String endpoint) {
		if (null==pattern) throw new NullPointerException();
		if (null==endpoint) throw new NullPointerException();
		this.pattern = Pattern.compile(pattern);
		this.endpoint = endpoint;
	}

	@Override
	public OEmbedSource getSource(Context context, Uri fromUri) {
		if (pattern.matcher(fromUri.toString()).find()) {
			return new OEmbedSource(context, fromUri);
		}
		return null;
	}

	private class OEmbedSource extends BaseOEmbedSource {
		public OEmbedSource(Context context, Uri fromUri) {
			super(context, OEmbedParserWithPattern.this.endpoint, fromUri);
		}
	}
}
