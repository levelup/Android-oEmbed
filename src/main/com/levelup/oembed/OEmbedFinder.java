package com.levelup.oembed;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.levelup.oembed.internal.OEmbedFunnyOrDie;
import com.levelup.oembed.internal.OEmbedHulu;
import com.levelup.oembed.internal.OEmbedImgur;
import com.levelup.oembed.internal.OEmbedInstagram;
import com.levelup.oembed.internal.OEmbedParser;
import com.levelup.oembed.internal.OEmbedViddler;
import com.levelup.oembed.internal.OEmbedVimeo;
import com.levelup.oembed.internal.OEmbedVine;
import com.levelup.oembed.internal.OEmbedYoutube;

public final class OEmbedFinder {

	private static final OEmbedParser parsers[] = new OEmbedParser[] {
		OEmbedYoutube.instance,
		OEmbedInstagram.instance,
		OEmbedImgur.instance,
		OEmbedFunnyOrDie.instance,
		OEmbedVimeo.instance,
		OEmbedHulu.instance,
		OEmbedViddler.instance,
		OEmbedVine.instance,
	};

	/**
	 * Find an OEmbed source for the specified URL.
	 * <p>After that you can call {@link OEmbedSource#getThumbnail()} to get a picture representation of the URL.</p>
	 * <p>When a source is not found you may still use fallback sources like {@link com.levelup.oembed.fallback.OEmbedEmbedly OEmbedEmbedly},
	 * {@link com.levelup.oembed.fallback.OEmbedOohembed OEmbedOohembed} or {@link com.levelup.oembed.fallback.OEmbedReembed OEmbedReembed}</p>
	 *
	 * @return {@code null} if no source if found for this URL.
	 */
	@Nullable
	public static OEmbedSource parse(String sourceUrl) {
		if (!TextUtils.isEmpty(sourceUrl)) {
			Uri sourceUri = Uri.parse(sourceUrl);

			for (OEmbedParser parser : parsers) {
				OEmbedSource src = parser.getSource(sourceUri);
				if (null != src)
					return src;
			}
		}
		return null;
	}

}
