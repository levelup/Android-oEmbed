package com.levelup.oembed;

import com.levelup.http.HttpException;

public interface OEmbedSource {

	String getThumbnail() throws HttpException;
	
	OEmbedRequest getOembedRequest();
	
}
