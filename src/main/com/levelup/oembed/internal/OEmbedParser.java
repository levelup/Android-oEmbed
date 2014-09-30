package com.levelup.oembed.internal;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.levelup.oembed.OEmbedSource;

public interface OEmbedParser {
	OEmbedSource getSource(@NonNull Uri fromUri);
}
