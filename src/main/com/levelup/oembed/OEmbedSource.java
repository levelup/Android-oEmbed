package com.levelup.oembed;

import com.levelup.http.HttpException;
import com.levelup.http.ServerException;

public interface OEmbedSource {

	String getThumbnail() throws HttpException, ServerException;
	
	OEmbedRequest getOembedRequest();
	
}
