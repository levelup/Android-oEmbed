package co.tophe.oembed.internal;

import java.util.List;

import android.net.Uri;
import android.support.annotation.NonNull;

import co.tophe.oembed.OEmbedSource;

public class OEmbedYoutube implements OEmbedParser {

	public static final OEmbedYoutube INSTANCE = new OEmbedYoutube();
	
	private OEmbedYoutube() {
	}
	
	@Override
	public OEmbedSource getSource(@NonNull Uri fromUri) {
		if (fromUri.getHost().endsWith("youtube.com")) {
			List<String> path = fromUri.getPathSegments();
			if (path.size() > 1 && "embed".equals(path.get(0))) {
				fromUri = Uri.parse("http://www.youtube.com/watch?v=" + path.get(1));
			}
			
			return new OEmbedSourceYoutube(fromUri);
		}
		return null;
	}

	private static class OEmbedSourceYoutube extends BaseOEmbedSource {
		OEmbedSourceYoutube(@NonNull Uri fromUri) {
			super("http://www.youtube.com/oembed", fromUri);
		}
	}
}
