package com.levelup.oembed;

import com.levelup.oembed.OEmbedFinder;
import com.levelup.oembed.OEmbedSource;

import junit.framework.TestCase;

public class sourceTest extends TestCase {

	private static final String YOUTUBE1 = "http://www.youtube.com/watch?v=SqfJPKgkdgg";
	private static final String YOUTUBE2 = "http://www.youtube.com/embed/SqfJPKgkdgg?rel=0&amp;autoplay=0&amp;wmode=opaque&amp;controls=2&amp;autohide=1&amp;showinfo=0";
	
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
	
}
