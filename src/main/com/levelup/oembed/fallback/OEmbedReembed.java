package com.levelup.oembed.fallback;

import android.net.Uri;

import com.levelup.oembed.internal.BaseOEmbedSource;

/**
 * Created by robUx4 on 30/09/2014.
 */
public class OEmbedReembed extends BaseOEmbedSource {
    public OEmbedReembed(Uri fromUri) {
        super("http://reembed.me/api/v1/oembed/", fromUri);
    }

    public OEmbedReembed(String url) {
        this(Uri.parse(url));
    }
}
