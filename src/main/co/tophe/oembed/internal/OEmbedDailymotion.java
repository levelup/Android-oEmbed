package co.tophe.oembed.internal;

import java.util.regex.Pattern;

import android.net.Uri;
import android.support.annotation.NonNull;

import co.tophe.oembed.OEmbedSource;

public class OEmbedDailymotion implements OEmbedParser {

	public static final OEmbedDailymotion INSTANCE = new OEmbedDailymotion();

	private final Pattern pattern;
	private final Pattern patternShort;

	private OEmbedDailymotion() {
		this.pattern = Pattern.compile("http://www.dailymotion.com/video/*");
		this.patternShort = Pattern.compile("http://dai.ly/*");
	}

	@Override
	public OEmbedSource getSource(@NonNull Uri fromUri) {
		if (pattern.matcher(fromUri.toString()).find()) {
			return new OEmbedSource(fromUri);
		}
		if (patternShort.matcher(fromUri.toString()).find()) {
			return new OEmbedSource(fromUri);
		}
		return null;
	}

	private static class OEmbedSource extends BaseOEmbedSource {
		OEmbedSource(@NonNull Uri fromUri) {
			super("http://www.dailymotion.com/services/oembed", fromUri);
		}
	}
}
