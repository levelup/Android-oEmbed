package com.levelup.oembed;

import com.levelup.http.HttpRequest;
import com.levelup.http.InputStreamParser;

public interface OEmbedRequest extends HttpRequest {

	InputStreamParser<OEmbed> getInputStreamParser();
	
}
