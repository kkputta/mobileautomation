package com.tresbu.demo.api.apps.speedtest.home;

import org.openqa.selenium.NoSuchElementException;

import com.tresbu.demo.api.android.Android;
import com.tresbu.demo.api.interfaces.Activity;
import com.tresbu.demo.core.DemoLogger;

public class Home implements Activity{
	
	public HomeUiObjects uiObject = new HomeUiObjects();
	
	public String getPingSpeed(){
		try{
			DemoLogger.log.info("Getting Ping Speed ");
			return uiObject.pingSpeed().getText();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not get ping speed, element absent or blocked");
		}
	}
	
	public String getUploadSpeed(){
		try{
			DemoLogger.log.info("Getting Upload Speed ");
			return uiObject.uploadspeed().getText();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not get upload speed, element absent or blocked");
		}
	}
	
	public String getDownloadSpeed(){
		try{
			DemoLogger.log.info("Getting Download Speed ");
			return uiObject.downloadSpeed().getText();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not get download speed, element absent or blocked");
		}
	}
	
	public Home tapTestAgain(){
		try{
			DemoLogger.log.info("Taping Test Again button");
			uiObject.testAgainButton().tap().waitToDisappear(5).waitToAppear(120);
			return Android.app.speedtest.home;
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not get testagain button, element absent or blocked");
		}
	}

	
	public Home waitToLoad() {
		try{
			DemoLogger.log.info("Waiting for Home activity");
			uiObject.testAgainButton().waitToAppear(10);
			return Android.app.speedtest.home;
		}catch(AssertionError e){
			throw new AssertionError("Home activity failed to load/open");
		}
		
	}
}
