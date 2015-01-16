package co.tophe.oembed.fallback;

import android.net.Uri;
import android.support.annotation.NonNull;

import co.tophe.oembed.internal.BaseOEmbedSource;

/**
 * @author Created by robUx4 on 30/09/2014.
 */
public class OEmbedOohembed extends BaseOEmbedSource {
    public OEmbedOohembed(@NonNull Uri fromUri) {
        super("http://www.oohembed.com/oohembed", fromUri);
    }

    public OEmbedOohembed(@NonNull String url) {
        this(Uri.parse(url));
    }
}
