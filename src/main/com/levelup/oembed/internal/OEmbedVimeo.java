package com.levelup.oembed.internal;

import java.util.regex.Pattern;

import android.net.Uri;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.levelup.http.HttpClient;
import com.levelup.http.HttpException;
import com.levelup.http.HttpParamsGet;
import com.levelup.http.HttpRequestGet;
import com.levelup.http.gson.InputStreamGsonParser;
import com.levelup.oembed.OEmbed;
import com.levelup.oembed.OEmbedSource;

public class OEmbedVimeo implements OEmbedParser {

	public static final OEmbedVimeo instance = new OEmbedVimeo();
	
	private OEmbedVimeo() {
	}
	
	private final Pattern URLS = Pattern.compile("http://vimeo.com/*");

	@Override
	public OEmbedSource getSource(Uri fromUri) {
		if (URLS.matcher(fromUri.toString()).find()) {
			return new OEmbedSourceVimeo(fromUri);
		}
		return null;
	}

	private static class OEmbedSourceVimeo extends BaseOEmbedSource {

		private final Uri fromUri;
		private OEmbed oembedData;
		
		public OEmbedSourceVimeo(Uri fromUri) {
			this.fromUri = fromUri;
		}

		@Override
		protected void assertDataLoaded() throws HttpException {
			HttpParamsGet params = new HttpParamsGet(1);
			params.add("url", fromUri.toString());
			HttpRequestGet request = new HttpRequestGet("http://vimeo.com/api/oembed.json", params);
			
			Gson gson = new GsonBuilder().create();
			InputStreamGsonParser<OEmbed> parser = new InputStreamGsonParser<OEmbed>(gson, OEmbed.class);
			
			oembedData = HttpClient.parseRequest(request, parser);
		}
		
		@Override
		public String getThumbnail() throws HttpException {
			assertDataLoaded();
			if (null!=oembedData)
				return oembedData.getThumbnail();
			return null;
		}
	}
}
