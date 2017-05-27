package com.tresbu.demo.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tresbu.demo.api.android.Android;
import com.tresbu.demo.api.apps.speedtest.Speedtest;
import com.tresbu.demo.core.managers.TestManager;

public class Navigation extends TestManager{
	private static Speedtest speedtest = Android.app.speedtest;
	
	@BeforeClass
	public static void beforeClass(){
		
		speedtest.open();
	}
	
	@Test
	public void test1(){
		testInfo.suite("Navigation").id("test1").name("Verify that Home Activity has all the elements");
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
	
	@Test
	public void test2(){
		testInfo.suite("Navigation").id("test2").name("Verify that results has sorting buttons");
		speedtest.menu.tapResults();
		Assert.assertTrue(speedtest.results.uiObject.toolsButton().exists());
		Assert.assertTrue(speedtest.results.uiObject.resultsLabel().exists());
		Assert.assertTrue(speedtest.results.uiObject.toolsButton().exists());
		Assert.assertTrue(speedtest.results.uiObject.sortByDownload().exists());
		Assert.assertTrue(speedtest.results.uiObject.sortByPing().exists());
		Assert.assertTrue(speedtest.results.uiObject.sortByTime().exists());
		Assert.assertTrue(speedtest.results.uiObject.sortByType().exists());
		Assert.assertTrue(speedtest.results.uiObject.sortByUpload().exists());
		Assert.assertTrue(speedtest.results.uiObject.logo().exists());
	}
	
	@Test
	public void test3(){
		testInfo.suite("Navigation").id("test3").name("veryfy that About activity has Privacy and terms links");
		speedtest.menu.tapAbout();
		Assert.assertTrue(speedtest.about.uiObject.privacyPolicy().exists());
		Assert.assertTrue(speedtest.about.uiObject.termsOfUse().exists());
	}
}
