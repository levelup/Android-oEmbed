package com.levelup.oembed.internal;


public class OEmbedViddler extends OEmbedParserWithPattern {

	public static final OEmbedViddler instance = new OEmbedViddler();

	private OEmbedViddler() {
		super("http://www.viddler.com/v/*", "http://www.viddler.com/oembed/");
	}
}
