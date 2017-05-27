package com.tresbu.demo.api.apps.speedtest.menu;

import org.openqa.selenium.NoSuchElementException;

import com.tresbu.demo.api.android.Android;
import com.tresbu.demo.api.apps.speedtest.about.About;
import com.tresbu.demo.api.apps.speedtest.home.Home;
import com.tresbu.demo.api.apps.speedtest.results.Results;
import com.tresbu.demo.core.DemoLogger;

public class Menu {
	
	public MenuUiObjects uiObject = new MenuUiObjects();
	
	public Home tapSpeedtest(){
		try{
			DemoLogger.log.info("Tapping on the Speedtest menu button");
			uiObject.speedtest().tap();
			return Android.app.speedtest.home.waitToLoad();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap Speedtest button, element is absent or blocked");
		}
	}
	
	public Results tapResults(){
		try{
			DemoLogger.log.info("Tapping on the results menu button");
			uiObject.results().tap();
			return Android.app.speedtest.results.waitToLoad();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap results button, element is absent or blocked");
		}
	}
	
	public void tapSettings(){
		try{
			DemoLogger.log.info("Tapping on the Settings menu button");
			uiObject.settings().tap();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap Settings button, element is absent or blocked");
		}
	}
	
	public About tapAbout(){
		try{
			DemoLogger.log.info("Tapping on the About menu button");
			uiObject.about().tap();
			return Android.app.speedtest.about.waitToLoad();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap About button, element is absent or blocked");
		}
	}
}
