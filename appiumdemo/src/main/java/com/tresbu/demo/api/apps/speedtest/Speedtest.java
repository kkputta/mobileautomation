package com.tresbu.demo.api.apps.speedtest;

import com.tresbu.demo.api.android.Android;
import com.tresbu.demo.api.apps.speedtest.about.About;
import com.tresbu.demo.api.apps.speedtest.begintest.BeginTest;
import com.tresbu.demo.api.apps.speedtest.home.Home;
import com.tresbu.demo.api.apps.speedtest.menu.Menu;
import com.tresbu.demo.api.apps.speedtest.results.Results;
import com.tresbu.demo.api.interfaces.Application;

public class Speedtest implements Application{

	public Menu menu = new Menu();
	public Home home = new Home();
	public About about = new About();
	public BeginTest beginTest = new BeginTest();
	public Results results = new Results();
	
	
	public void forceStop() {
		Android.adb.forceStopApp(packageID());
	}

	
	public void clearData() {
		Android.adb.clearAppsData(packageID());
	}

	
	public Object open() {
		Android.adb.openAppsActivity(packageID(), activityID());
		return null;
	}

	
	public String packageID() {
		return "org.zwanoo.android.speedtest";
	}

	
	public String activityID() {
		return "com.ookla.speedtest.softfacade.MainActivity";
	}
}
