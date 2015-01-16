package co.tophe.oembed.internal;

public class OEmbedHulu extends OEmbedParserWithPattern {

	public static final OEmbedHulu instance = new OEmbedHulu();
	
	private OEmbedHulu() {
		super("http://www.hulu.com/watch/*", "http://www.hulu.com/api/oembed.json");
	}

}
