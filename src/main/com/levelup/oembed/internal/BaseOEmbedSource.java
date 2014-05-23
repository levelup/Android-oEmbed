package com.levelup.oembed.internal;

import com.levelup.http.HttpException;
import com.levelup.oembed.OEmbedSource;

abstract class BaseOEmbedSource implements OEmbedSource {

	protected abstract void assertDataLoaded() throws HttpException;

}
