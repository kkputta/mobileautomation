package com.tresbu.demo.core;

import org.apache.log4j.Level;


public class DemoLogger {
	public static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DemoLogger.class);
	static{
		log.setLevel(Level.DEBUG);
	}
}
