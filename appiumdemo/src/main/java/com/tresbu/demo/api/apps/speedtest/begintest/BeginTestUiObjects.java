package com.tresbu.demo.api.apps.speedtest.begintest;

import com.tresbu.demo.core.UiObject;
import com.tresbu.demo.core.UiSelector;

public class BeginTestUiObjects {
	private static UiObject beginTestButton;
	
	public UiObject beginTestButton(){
		if(beginTestButton == null) beginTestButton = new UiSelector().text("Begin Test").makeUiObject();
		return beginTestButton;
	}
}
