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
	
	public void testYoutube1() throws Exception {
		OEmbedSource dataSource = OEmbedFinder.parse(YOUTUBE1);
		assertNotNull(dataSource);
		String thumbnail = dataSource.getThumbnail();
		assertNotNull(thumbnail);
	}
	
	public void testYoutube2() throws Exception {
		OEmbedSource dataSource = OEmbedFinder.parse(YOUTUBE2);
		assertNotNull(dataSource);
		String thumbnail = dataSource.getThumbnail();
		assertNotNull(thumbnail);
	}
	
	public void testVimeo1() throws Exception {
		OEmbedSource dataSource = OEmbedFinder.parse(VIMEO1);
		assertNotNull(dataSource);
		String thumbnail = dataSource.getThumbnail();
		assertNotNull(thumbnail);
	}
	
	public void testInstagram1() throws Exception {
		OEmbedSource dataSource = OEmbedFinder.parse(INSTAGRAM1);
		assertNotNull(dataSource);
		String thumbnail = dataSource.getThumbnail();
		assertNotNull(thumbnail);
	}
	
	public void testViddler1() throws Exception {
		OEmbedSource dataSource = OEmbedFinder.parse(VIDDLER1);
		assertNotNull(dataSource);
		String thumbnail = dataSource.getThumbnail();
		assertNotNull(thumbnail);
	}
	
	public void testFunnyOrDie1() throws Exception {
		OEmbedSource dataSource = OEmbedFinder.parse(FUNNYORDIE1);
		assertNotNull(dataSource);
		String thumbnail = dataSource.getThumbnail();
		assertNotNull(thumbnail);
	}
	
	public void testHulu1() throws Exception {
		OEmbedSource dataSource = OEmbedFinder.parse(HULU1);
		assertNotNull(dataSource);
		String thumbnail = dataSource.getThumbnail();
		assertNotNull(thumbnail);
	}
}
