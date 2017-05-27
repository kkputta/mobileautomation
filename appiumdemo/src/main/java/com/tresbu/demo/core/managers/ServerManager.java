package com.tresbu.demo.core.managers;

import java.io.IOException;
import java.util.Scanner;

public class ServerManager {
	
	private static String OS;
	private static String ANDROID_HOME;
	
	public static String getAndroidHome(){
		if(ANDROID_HOME == null){
			ANDROID_HOME = System.getenv("ANDROID_HOME");
			if(ANDROID_HOME == null) throw new RuntimeException("Failed to find ANDROID_HOME, make sure the envronment"
					+ " variable is set.");
		}
		return ANDROID_HOME;
	}
	public static String getOS(){
		if(OS == null) OS = System.getenv("os");
		return OS;
	}
	
	public static boolean isWindows(){
		return getOS().startsWith("Windows");
	}
	
	public static boolean isMac(){
		return getOS().startsWith("Mac");
	}
	
	public static String runCommand(String command){
		String output = null;
		try{
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(Runtime.getRuntime().exec(command).getInputStream()).useDelimiter("\\A");
			if(scanner.hasNext()) output = scanner.next();
		}catch(IOException e){
			throw new RuntimeException(e.getMessage());
		}
		return output;
	}
}
