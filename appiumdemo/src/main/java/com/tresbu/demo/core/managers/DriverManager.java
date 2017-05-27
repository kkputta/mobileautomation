package com.tresbu.demo.core.managers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import com.tresbu.demo.api.android.Android;
import com.tresbu.demo.core.ADB;
import com.tresbu.demo.core.DemoLogger;
import com.tresbu.demo.core.Utils;
import com.tresbu.demo.core.constants.Arg;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverManager {
	
	private static String nodeJs = System.getenv("APPIUM_HOME")+"/node.exe";
	private static String appiumJs = System.getenv("APPIUM_HOME")+"/node_modules/appium/bin/appium.js";
	private static DriverService service;
	private static String deviceID;
	
	private static HashMap<String,URL> hosts;
	private static String unlockPackage = "io.appium.unlock";
	
	private static DesiredCapabilities getCap(String deviceID){
		
		DemoLogger.log.info("Creating driver caps for the device : "+deviceID);
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", deviceID);
		caps.setCapability("plaform", "Android");
		caps.setCapability("app", "E:\\unlock_apk-debug.apk");
		
		return caps;
	}
	
	private static URL host(String deviceID){
		
		if(hosts == null) hosts = Utils.getUrlMap();
		return hosts.get(deviceID);
	}
	
	private static ArrayList<String> getAvailableDevices(){
		
		DemoLogger.log.info("Checking for Available Devices");
		
		ArrayList<String> availableDevices = new ArrayList<String>();
		ArrayList connectedDevices = ADB.getConnectedDevices();
		
		for(Object connectedDevice:connectedDevices){
			String device = connectedDevice.toString();
			ArrayList apps = new ADB(device).getInstalledPackages();
			if(!apps.contains(unlockPackage)) availableDevices.add(device);
			else DemoLogger.log.info("Device : "+device+" has "+unlockPackage+" installed, assuming it under testing.");
		}
		
		if(availableDevices.size() == 0) throw new RuntimeException("Not a single device is available for testing at this time.");
		return availableDevices;
	}
	
	private static DriverService createService(){
		service = new AppiumServiceBuilder()
					.usingDriverExecutable(new File(nodeJs))
					.withAppiumJS(new File(appiumJs))
					.withIPAddress(host(deviceID).toString().split(":")[1].replace("//", ""))
					.usingPort(Integer.parseInt(host(deviceID).toString().split(":")[2].replace("/wd/hub", "")))
					.withArgument(Arg.TIMEOUT,"120")
					.withArgument(Arg.LOG_LEVEL, "warn")
					.build();
		return service;
	}
	
	public static void createDriver(){
		ArrayList<String> devices = getAvailableDevices();
		for(String device:devices){
			try{
				deviceID=device;
				DemoLogger.log.info("Trying to create new Driver for device : "+device);
				createService().start();
				Android.driver = new AndroidDriver(host(device),getCap(device));
				Android.adb = new ADB(device);
				break;
			}catch(Exception e){
				e.printStackTrace();
				//Ignore and try next device
			}
		}
	}
	
	public static void killDriver(){
		if(Android.driver != null) {
			DemoLogger.log.info("Killing Android driver....");
			Android.driver.quit();
			Android.adb.uninstallApp(unlockPackage);
			service.stop();
		}else DemoLogger.log.info("Android Driver is not initialised, nothing to kill");
			
	}
}
