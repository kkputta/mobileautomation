package com.tresbu.demo.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tresbu.demo.api.android.Android;
import com.tresbu.demo.api.apps.speedtest.Speedtest;
import com.tresbu.demo.core.managers.TestManager;

public class Functionality extends TestManager{
	private static Speedtest speedtest = Android.app.speedtest;
	
	@Test
	public void test4(){
		testInfo.id("test4").suite("Functionality").name("Verify that you can test again");
		speedtest.menu.tapSpeedtest();
		speedtest.home.tapTestAgain();
		Assert.assertTrue(speedtest.home.uiObject.ping().exists());
		Assert.assertTrue(speedtest.home.uiObject.pingSpeed().exists());
		Assert.assertTrue(speedtest.home.uiObject.download().exists());
		Assert.assertTrue(speedtest.home.uiObject.downloadSpeed().exists());
		Assert.assertTrue(speedtest.home.uiObject.upload().exists());
		Assert.assertTrue(speedtest.home.uiObject.uploadspeed().exists());
		Assert.assertTrue(speedtest.home.uiObject.shareButton().exists());
		Assert.assertTrue(speedtest.home.uiObject.removeAdsButton().exists());
		Assert.assertTrue(speedtest.home.uiObject.testAgainButton().exists());
		Assert.assertTrue(speedtest.home.uiObject.logo().exists());
	}
}
