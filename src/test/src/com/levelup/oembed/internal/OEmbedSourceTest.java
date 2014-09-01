package com.levelup.oembed.internal;

import android.net.Uri;
import android.test.AndroidTestCase;

import com.levelup.http.HttpException;
import com.levelup.oembed.OEmbedSource;

public class OEmbedSourceTest extends AndroidTestCase {

	public void testBogusData() throws Exception {
		OEmbedSource source = new BaseOEmbedSource("http://goo.gl/json", Uri.parse("http://mydomain.com/path")){};
		try {
			source.getThumbnail();
		} catch (HttpException e) {
			if (e.getErrorCode()!=HttpException.ERROR_PARSER)
				throw e;
		}
	}

	public void testBogusDomain() throws Exception {
		OEmbedSource source = new BaseOEmbedSource("http://goo.goo/json", Uri.parse("http://mydomain.com/path")){};
		try {
			source.getThumbnail();
		} catch (HttpException e) {
			if (e.getErrorCode()!=HttpException.ERROR_NETWORK)
				throw e;
		}
	}

	public void testBogusUrl() throws Exception {
		OEmbedSource source = new BaseOEmbedSource("http://www.google.com/totosdk", Uri.parse("http://mydomain.com/path")){};
		try {
			source.getThumbnail();
		} catch (HttpException e) {
			if (e.getHttpStatusCode()!=HttpException.ERROR_HTTP_NOT_FOUND)
				throw e;
		}
	}
}