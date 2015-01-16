package co.tophe.oembed.internal;

import android.net.Uri;
import android.test.AndroidTestCase;

import co.tophe.oembed.OEmbedSource;

import co.tophe.HttpDataParserException;
import co.tophe.HttpIOException;
import co.tophe.HttpMimeException;
import co.tophe.ServerException;

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
		} catch (ServerException e) {
			if (e.getStatusCode()!= ServerException.HTTP_STATUS_NOT_FOUND)
				throw e;
		}
	}
}