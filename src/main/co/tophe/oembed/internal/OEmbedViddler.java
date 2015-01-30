package co.tophe.oembed.internal;


public class OEmbedViddler extends OEmbedParserWithPattern {

	public static final OEmbedViddler INSTANCE = new OEmbedViddler();

	private OEmbedViddler() {
		super("http://www.viddler.com/v/*", "http://www.viddler.com/oembed/");
	}
}
