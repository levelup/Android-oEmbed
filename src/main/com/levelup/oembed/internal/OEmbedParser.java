package com.levelup.oembed.internal;

import android.net.Uri;

import com.levelup.oembed.OEmbedSource;

public interface OEmbedParser {
	OEmbedSource getSource(Uri fromUri);
}
