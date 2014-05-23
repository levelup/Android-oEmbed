package com.levelup.oembed;

import android.net.Uri;

import com.levelup.oembed.internal.OEmbedInstagram;
import com.levelup.oembed.internal.OEmbedParser;
import com.levelup.oembed.internal.OEmbedViddler;
import com.levelup.oembed.internal.OEmbedVimeo;
import com.levelup.oembed.internal.OEmbedYoutube;

public final class OEmbedFinder {

	private static final OEmbedParser parsers[] = new OEmbedParser[] {
		OEmbedYoutube.instance,
		OEmbedVimeo.instance,
		OEmbedInstagram.instance,
		OEmbedViddler.instance,
	};
	
	public static OEmbedSource parse(String sourceUrl) {
		Uri sourceUri = Uri.parse(sourceUrl);

		for (OEmbedParser parser : parsers) {
			OEmbedSource src = parser.getSource(sourceUri);
			if (null!=src)
				return src;
		}
		return null;
	}

}
