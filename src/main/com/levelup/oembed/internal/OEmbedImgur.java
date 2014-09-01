package com.levelup.oembed.internal;

import android.net.Uri;

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
			if (!fromUri.getPath().startsWith("/a/")) { // albums are not supported (rich typed, rather than photo/video)
				return new OEmbedSourceImgur(fromUri);
			}
		}
		return null;
	}

	private static class OEmbedSourceImgur extends BaseOEmbedSource {
		OEmbedSourceImgur(Uri fromUri) {
			super("http://api.imgur.com/oembed.json", fromUri);
		}
	}
}
