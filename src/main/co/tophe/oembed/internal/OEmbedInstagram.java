package co.tophe.oembed.internal;


public class OEmbedInstagram extends OEmbedParserWithPattern {
	
	public static final OEmbedInstagram INSTANCE = new OEmbedInstagram();

	private OEmbedInstagram() {
		super("http://(instagram.com|instagr.am)/p/*", "http://api.instagram.com/oembed");
	}
}
