package com.levelup.oembed.internal;

import com.levelup.oembed.OEmbedSource;

import android.net.Uri;

public interface OEmbedParser {
	OEmbedSource getSource(Uri fromUri);
}
