package com.levelup.oembed;

import junit.framework.TestCase;

public class sourceTest extends TestCase {

	private static final String YOUTUBE1 = "http://www.youtube.com/watch?v=SqfJPKgkdgg";
	private static final String YOUTUBE2 = "http://www.youtube.com/embed/SqfJPKgkdgg?rel=0&amp;autoplay=0&amp;wmode=opaque&amp;controls=2&amp;autohide=1&amp;showinfo=0";
	private static final String VIMEO1 = "http://vimeo.com/7100569";
	private static final String INSTAGRAM1 = "http://instagram.com/p/oTYiNETBRO/";
	private static final String VIDDLER1 = "http://www.viddler.com/v/1646c55";
	private static final String FUNNYORDIE1 = "http://www.funnyordie.com/videos/a7311134ac/patton-oswalt-in-heavy-metal";
	private static final String HULU1 = "http://www.hulu.com/watch/20807/late-night-with-conan-obrien-wed-may-21-2008";
	private static final String IMGUR1 = "http://imgur.com/gallery/VWtX56r";
	private static final String IMGUR2 = "http://i.imgur.com/emxcraW.jpg";
	private static final String IMGUR3 = "http://imgur.com/PDnO8rG";
	private static final String FAIL_IMGUR1 = "http://imgur.com/a/N5vY5";

	private static void testOEmbedThumbnail(String url) throws Exception {
		OEmbedSource dataSource = OEmbedFinder.parse(url);
		assertNotNull(dataSource);
		String thumbnail = dataSource.getThumbnail();
		assertNotNull(thumbnail);
	}
	
	private static void testOEmbedNoThumbnail(String url) throws Exception {
		OEmbedSource dataSource = OEmbedFinder.parse(url);
		assertNull(dataSource);
	}
	
	public void testYoutube1() throws Exception {
		testOEmbedThumbnail(YOUTUBE1);
	}
	
	public void testYoutube2() throws Exception {
		testOEmbedThumbnail(YOUTUBE2);
	}
	
	public void testVimeo1() throws Exception {
		testOEmbedThumbnail(VIMEO1);
	}
	
	public void testInstagram1() throws Exception {
		testOEmbedThumbnail(INSTAGRAM1);
	}
	
	public void testViddler1() throws Exception {
		testOEmbedThumbnail(VIDDLER1);
	}
	
	public void testFunnyOrDie1() throws Exception {
		testOEmbedThumbnail(FUNNYORDIE1);
	}
	
	public void testHulu1() throws Exception {
		testOEmbedThumbnail(HULU1);
	}
	
	public void testImgur1() throws Exception {
		testOEmbedThumbnail(IMGUR1);
	}
	
	public void testImgur2() throws Exception {
		testOEmbedThumbnail(IMGUR2);
	}
	
	public void testImgur3() throws Exception {
		testOEmbedThumbnail(IMGUR3);
	}
	
	public void testImgurFail1() throws Exception {
		testOEmbedNoThumbnail(FAIL_IMGUR1);
	}
}
