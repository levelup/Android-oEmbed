package com.levelup.oembed.internal;

import android.content.Context;
import android.net.Uri;

import com.levelup.oembed.OEmbedSource;

public interface OEmbedParser {
	OEmbedSource getSource(Context context, Uri fromUri);
}
