package co.tophe.oembed;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import co.tophe.oembed.internal.OEmbedDailymotion;
import co.tophe.oembed.internal.OEmbedFunnyOrDie;
import co.tophe.oembed.internal.OEmbedHulu;
import co.tophe.oembed.internal.OEmbedImgur;
import co.tophe.oembed.internal.OEmbedInstagram;
import co.tophe.oembed.internal.OEmbedParser;
import co.tophe.oembed.internal.OEmbedViddler;
import co.tophe.oembed.internal.OEmbedVimeo;
import co.tophe.oembed.internal.OEmbedVine;
import co.tophe.oembed.internal.OEmbedYoutube;

/**
 * Helper class to find a suitable {@link co.tophe.oembed.OEmbedSource} for a specified URL.
 *
 * @see #lookup(String)
 */
public final class OEmbedFinder {

	private static final OEmbedParser parsers[] = new OEmbedParser[]{
			OEmbedYoutube.INSTANCE,
			OEmbedInstagram.INSTANCE,
			OEmbedImgur.INSTANCE,
			OEmbedVimeo.INSTANCE,
			OEmbedHulu.INSTANCE,
			OEmbedDailymotion.INSTANCE,
			OEmbedFunnyOrDie.INSTANCE,
			OEmbedVine.INSTANCE,
			OEmbedViddler.INSTANCE,
	};

	/**
	 * Find an OEmbed source for the specified URL.
	 * <p>After that you can call {@link OEmbedSource#getThumbnail()} to get a picture representation of the URL.</p>
	 * <p>When a source is not found you may still use fallback sources like {@link co.tophe.oembed.fallback.OEmbedEmbedly OEmbedEmbedly},
	 * {@link co.tophe.oembed.fallback.OEmbedOohembed OEmbedOohembed} or {@link co.tophe.oembed.fallback.OEmbedReembed OEmbedReembed}</p>
	 *
	 * @return {@code null} if no source if found for this URL.
	 */
	@Nullable
	public static OEmbedSource lookup(String sourceUrl) {
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
