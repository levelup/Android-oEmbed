package com.levelup.oembed.internal;

import android.net.Uri;
import android.test.AndroidTestCase;

import com.levelup.http.HttpDataParserException;
import com.levelup.http.HttpException;
import com.levelup.http.HttpIOException;
import com.levelup.http.HttpMimeException;
import com.levelup.oembed.OEmbedSource;

public class OEmbedSourceTest extends AndroidTestCase {

	public void testBogusMime() throws Exception {
		OEmbedSource source = new BaseOEmbedSource("http://goo.gl/json", Uri.parse("http://mydomain.com/path")){};
		try {
			source.getThumbnail();
		} catch (HttpMimeException e) {
			// ok
		}
	}

	public void testBogusData() throws Exception {
		OEmbedSource source = new BaseOEmbedSource("http://httpbin.org/ip", Uri.parse("http://mydomain.com/path")){};
		try {
			source.getThumbnail();
		} catch (HttpDataParserException e) {
			// ok
		}
	}

	public void testBogusDomain() throws Exception {
		OEmbedSource source = new BaseOEmbedSource("http://goo.goo/json", Uri.parse("http://mydomain.com/path")){};
		try {
			source.getThumbnail();
		} catch (HttpIOException e) {
			// ok
		}
	}

	public void testBogusUrl() throws Exception {
		OEmbedSource source = new BaseOEmbedSource("http://www.google.com/totosdk", Uri.parse("http://mydomain.com/path")){};
		try {
			source.getThumbnail();
		} catch (HttpException e) {
			if (e.httpStatusCode!=HttpException.HTTP_STATUS_NOT_FOUND)
				throw e;
		}
	}
}