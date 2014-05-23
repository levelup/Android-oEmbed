package com.levelup.oembed;

import android.net.Uri;

import com.levelup.oembed.internal.OEmbedYoutube;

public final class OEmbedFinder {

	public static OEmbedSource parse(String sourceUrl) {
		Uri sourceUri = Uri.parse(sourceUrl);
		
		OEmbedSource src = OEmbedYoutube.instance.getSource(sourceUri);
		if (null!=src)
			return src;
		return null;
	}
	
}
