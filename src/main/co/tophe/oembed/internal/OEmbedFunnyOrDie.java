package co.tophe.oembed.internal;

public class OEmbedFunnyOrDie extends OEmbedParserWithPattern {

	public final static OEmbedFunnyOrDie INSTANCE = new OEmbedFunnyOrDie();
	
	private OEmbedFunnyOrDie() {
		super("http://www.funnyordie.com/videos/*", "http://www.funnyordie.com/oembed.json");
	}

}
