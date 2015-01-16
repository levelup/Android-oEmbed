package co.tophe.oembed.fallback;

import android.test.AndroidTestCase;

public class OEmbedEmbedlyTest extends AndroidTestCase {

    private void testOEmbedThumbnail(String url) throws Exception {
        OEmbedEmbedly dataSource = new OEmbedEmbedly(url);
        assertNotNull(dataSource);
        String thumbnail = dataSource.getThumbnail();
        assertNotNull(thumbnail);
    }

    public void testAndroidCentral() throws Exception {
        testOEmbedThumbnail("http://www.androidcentral.com/ac-editors-apps-week-hacked-lux-ticket-ride-and-more");
    }

}