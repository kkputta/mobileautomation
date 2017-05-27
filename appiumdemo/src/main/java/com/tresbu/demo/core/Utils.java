package com.tresbu.demo.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

public class Utils {
	
	public static HashMap<String, URL> getUrlMap() {

		HashMap<String, URL> hosts = new HashMap<String, URL>();
		Properties prop = new Properties();
		try {
			
			prop.load(Utils.class.getResourceAsStream("/devicehosts.properties"));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (final Entry<Object, Object> entry : prop.entrySet()) {
			try {
				DemoLogger.log.info("Device Properties in Utils :" +entry.getKey()+" : "+entry.getValue());
				hosts.put((String) entry.getKey(), new URL(entry.getValue().toString()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return hosts;
	}
}
