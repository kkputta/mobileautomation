package com.tresbu.demo.api.apps.speedtest.begintest;

import org.openqa.selenium.NoSuchElementException;

import com.tresbu.demo.api.android.Android;
import com.tresbu.demo.api.apps.speedtest.home.Home;
import com.tresbu.demo.api.interfaces.Activity;
import com.tresbu.demo.core.DemoLogger;

public class BeginTest implements Activity{
	public BeginTestUiObjects uiObject = new BeginTestUiObjects();
	
	public Home tapBeginTest(){
		try{
			DemoLogger.log.info("Tapping begin test button");
			Android.app.speedtest.beginTest.uiObject.beginTestButton().waitToAppear(120);
			uiObject.beginTestButton().tap();
			Android.app.speedtest.home.uiObject.testAgainButton().waitToAppear(120);
			return Android.app.speedtest.home;
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap begin test button, element absent or blocked");
		}catch(AssertionError e){
			throw new AssertionError("Speedtest failed to complete within 120 seconds");
		}
	}

	
	public BeginTest waitToLoad() {
		try{
			DemoLogger.log.info("Waiting for begin test activity");
			uiObject.beginTestButton().waitToAppear(10);
			return Android.app.speedtest.beginTest;
		}catch(AssertionError e){
			throw new AssertionError("Begin Test Acticity failed to load/open");
		}
	}
}
