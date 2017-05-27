package com.tresbu.demo.api.apps.speedtest.about;


import com.tresbu.demo.api.android.Android;
import com.tresbu.demo.api.interfaces.Activity;
import com.tresbu.demo.core.DemoLogger;

public class About implements Activity {
	public AboutUiObjects uiObject = new AboutUiObjects();

	
	public About waitToLoad() {
		try{
			DemoLogger.log.info("Waiting for about activity");
			uiObject.termsOfUse().waitToAppear(5);
			return Android.app.speedtest.about;
		}catch(AssertionError e){
			throw new AssertionError("About activity failed to load/open");
		}
	}
}
