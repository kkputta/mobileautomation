import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.log4j.Level;
import org.junit.runner.JUnitCore;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.tresbu.demo.api.android.Android;
import com.tresbu.demo.api.apps.speedtest.home.Home;
import com.tresbu.demo.core.ADB;
import com.tresbu.demo.core.DemoLogger;
import com.tresbu.demo.core.UiObject;
import com.tresbu.demo.core.UiSelector;
import com.tresbu.demo.core.managers.DriverManager;
import com.tresbu.demo.tests.TestPrimer;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;


public class Runner {

	public static void main(String[] args) throws MalformedURLException {
		
		
		/*System.out.println("Android Home Path : "+System.getenv("ANDROID_HOME"));
		
		ArrayList<String> list = ADB.getConnectedDevices();
		System.out.println("Device Id : "+list.get(0));
		
		ADB adb = new ADB("DU7SSS69QKUK8HAA");
		System.out.println("ForegroundActivity  : "+adb.getForegroundActivity());
		System.out.println("AndroidVersion as String : "+adb.getAndroidVersionAsString());
		System.out.println("AndroidVersion as Integer : "+adb.getAndroidVersion());
		System.out.println("Installed Packages : "+adb.getInstalledPackages());
		System.out.println("Android Device Model : "+adb.getDeviceModel());
		System.out.println("Android Device Serial number : "+adb.getDeviceSerialNumber());
		System.out.println("Android Device carrier : "+adb.getDeviceCarrier());
		System.out.println();
		System.out.println();*/
		/*System.out.println("Processes prior to starting new logcat : "+adb.getLogcatProcesses());
		Object PID = adb.startLogcat("1", "");
		System.out.println("Started logcat on  PID : "+PID);
		System.out.println();
		System.out.println("Processes after to starting new logcat : "+adb.getLogcatProcesses());
		adb.stopLogcat(PID);
		System.out.println("Processes after to stopping new logcat : "+adb.getLogcatProcesses());*/
		//adb.openAppsActivity("com.android.gallery3d", "com.android.gallery3d.app.GalleryActivity");
		//com.android.calendar/com.android.calendar.AllInOneActivity
		//org.zwanoo.android.speedtest/com.ookla.speedtest.softfacade.MainActivity
		
		try{
			
			DriverManager.createDriver();
			JUnitCore.runClasses(TestPrimer.class);
			
		}finally{
			DriverManager.killDriver();		
		}
	}

}
