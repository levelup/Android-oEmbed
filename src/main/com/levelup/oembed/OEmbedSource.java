package com.levelup.oembed;

import co.tophe.HttpException;
import co.tophe.ServerException;

public interface OEmbedSource {

	String getThumbnail() throws HttpException, ServerException;
	
	OEmbedRequest getOembedRequest();
	
}
