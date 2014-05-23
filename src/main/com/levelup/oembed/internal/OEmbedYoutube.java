package com.levelup.oembed.internal;

import java.util.List;

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

public class OEmbedYoutube implements OEmbedParser {

	public static final OEmbedYoutube instance = new OEmbedYoutube();
	
	private OEmbedYoutube() {
	}
	
	@Override
	public OEmbedSource getSource(Uri fromUri) {
		if (fromUri.getHost().endsWith("youtube.com")) {
			List<String> path = fromUri.getPathSegments();
			if (path.size() > 1 && "embed".equals(path.get(0))) {
				fromUri = Uri.parse("http://www.youtube.com/watch?v=" + path.get(1));
			}
			
			return new OEmbedSourceYoutube(fromUri);
		}
		return null;
	}

	private static class OEmbedSourceYoutube extends BaseOEmbedSource {
		
		private final Uri fromUri;
		private OEmbed oembedData;
		
		OEmbedSourceYoutube(Uri fromUri) {
			this.fromUri = fromUri;
		}

		@Override
		protected void assertDataLoaded() throws HttpException {
			HttpParamsGet params = new HttpParamsGet(2);
			params.add("url", fromUri.toString());
			params.add("format", "json");
			HttpRequestGet request = new HttpRequestGet("http://www.youtube.com/oembed", params);
			
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
