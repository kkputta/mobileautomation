package com.test.appiumdemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class AppiumIOSTest {
	private static IOSDriver wd;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("appium-version", "1.6");
		cap.setCapability("platformName", "iOS");
		cap.setCapability("platformVersion", "10.2");
		cap.setCapability("deviceName", "iPhone 5s");
		cap.setCapability("app", "/Users/kiranp/Downloads/IntegrationApp.app");
		cap.setCapability("bundleId", "com.facebook.IntegrationAp");
		
		wd = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(5000);
		wd.findElementByName("Alerts").click();
		Thread.sleep(2000);
		wd.findElementByAccessibilityId("Back").click();
		Thread.sleep(2000);
		wd.findElementByName("Scrolling").click();
		Thread.sleep(2000);
		wd.findElementByAccessibilityId("Back").click();
		Thread.sleep(5000);
		
		wd.quit();
	}

}
