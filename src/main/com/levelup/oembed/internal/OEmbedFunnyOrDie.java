package com.levelup.oembed.internal;

public class OEmbedFunnyOrDie extends OEmbedParserWithPattern {

	public final static OEmbedFunnyOrDie instance = new OEmbedFunnyOrDie();
	
	private OEmbedFunnyOrDie() {
		super("http://www.funnyordie.com/videos/*", "http://www.funnyordie.com/oembed.json");
	}

}
