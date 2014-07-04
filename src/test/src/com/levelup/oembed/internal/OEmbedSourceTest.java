package com.levelup.oembed.internal;

import android.content.Context;
import android.net.Uri;
import android.test.AndroidTestCase;

import com.levelup.oembed.OEmbedSource;

public class OEmbedSourceTest extends AndroidTestCase {

	public void testBogusData() throws Exception {
		OEmbedSource source = new BaseOEmbedSource(getContext(), "http://goo.gl/json", Uri.parse("http://mydomain.com/path")){};
		source.getThumbnail();
	}

	public void testBogusDomain() throws Exception {
		OEmbedSource source = new BaseOEmbedSource(getContext(), "http://goo.goo/json", Uri.parse("http://mydomain.com/path")){};
		source.getThumbnail();
	}

	public void testBogusUrl() throws Exception {
		OEmbedSource source = new BaseOEmbedSource(getContext(), "http://www.google.com/totosdk", Uri.parse("http://mydomain.com/path")){};
		source.getThumbnail();
	}
}