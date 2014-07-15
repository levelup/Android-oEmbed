package com.levelup.oembed;

import android.content.Context;

import com.levelup.http.ion.IonClient;

/**
 * Created by Steve Lhomme on 15/07/2014.
 */
public class SourceTestIon extends sourceTest {

	@Override
	public void setContext(Context context) {
		super.setContext(context);
		IonClient.setup(context);
	}
}
