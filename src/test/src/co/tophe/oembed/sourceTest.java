package co.tophe.oembed;

import android.test.AndroidTestCase;

public class sourceTest extends AndroidTestCase {

	private static final String YOUTUBE1 = "http://www.youtube.com/watch?v=SqfJPKgkdgg";
	private static final String YOUTUBE2 = "http://www.youtube.com/embed/SqfJPKgkdgg?rel=0&amp;autoplay=0&amp;wmode=opaque&amp;controls=2&amp;autohide=1&amp;showinfo=0";
	private static final String VIMEO1 = "http://vimeo.com/7100569";
	private static final String INSTAGRAM = "http://instagram.com/p/xpaLXzIwd1/";
	private static final String INSTAGRAM_FULL = "http://instagram.com/p/xpaLXzIwd1/?modal=true";
	private static final String INSTAGRAM_VIDEO = "http://instagram.com/p/ydm4ZvLUMo/";
	private static final String VIDDLER1 = "http://www.viddler.com/v/1646c55";
	private static final String FUNNYORDIE1 = "http://www.funnyordie.com/videos/a7311134ac/patton-oswalt-in-heavy-metal";
	private static final String HULU1 = "http://www.hulu.com/watch/20807/late-night-with-conan-obrien-wed-may-21-2008";
	private static final String IMGUR1 = "http://imgur.com/gallery/VWtX56r";
	private static final String IMGUR2 = "http://i.imgur.com/emxcraW.jpg";
	private static final String IMGUR3 = "http://imgur.com/PDnO8rG";
	private static final String IMGUR_GALLERY = "http://imgur.com/gallery/STcRW6c";
	private static final String DAILYMOTION = "http://www.dailymotion.com/video/xl561h_on-peut-tromper-une-fois-mille-personnes_fun";
	private static final String DAILYMOTION_SHORT = "http://dai.ly/q9Mli9";
	private static final String FAIL_IMGUR1 = "http://imgur.com/a/N5vY5";

	private void testOEmbedThumbnail(String url) throws Exception {
		OEmbedSource dataSource = OEmbedFinder.lookup(url);
		assertNotNull(dataSource);
		String thumbnail = dataSource.getThumbnail();
		assertNotNull(thumbnail);
	}
	
	private void testOEmbedNotSupported(String url) throws Exception {
		OEmbedSource dataSource = OEmbedFinder.lookup(url);
		assertNull(dataSource);
	}

	private void testOEmbedNoThumbnail(String url) throws Exception {
		OEmbedSource dataSource = OEmbedFinder.lookup(url);
		assertNotNull(dataSource);
		String thumbnail = dataSource.getThumbnail();
		assertNull(thumbnail);
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
	
	public void testInstagram() throws Exception {
		testOEmbedThumbnail(INSTAGRAM);
	}

	public void testInstagramFull() throws Exception {
		testOEmbedThumbnail(INSTAGRAM_FULL);
	}

	public void testInstagramVideo() throws Exception {
		testOEmbedThumbnail(INSTAGRAM_VIDEO);
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

	public void testImgurGallery() throws Exception {
		testOEmbedNoThumbnail(IMGUR_GALLERY);
	}

	public void testDailymotion() throws Exception {
		testOEmbedThumbnail(DAILYMOTION);
	}

	public void testDailymotionShort() throws Exception {
		testOEmbedThumbnail(DAILYMOTION_SHORT);
	}

	public void testImgurFail1() throws Exception {
		testOEmbedNotSupported(FAIL_IMGUR1);
	}
}
