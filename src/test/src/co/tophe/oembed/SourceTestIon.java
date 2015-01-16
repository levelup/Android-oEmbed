package co.tophe.oembed;

import android.content.Context;

import co.tophe.ion.IonClient;

/**
 * @author Created by Steve Lhomme on 15/07/2014.
 */
public class SourceTestIon extends sourceTest {

	@Override
	public void setContext(Context context) {
		super.setContext(context);
		IonClient.setup(context);
	}
}
