package com.tresbu.demo.core;

public class TestInfo {
	private static String 
					TIMESTAMP,
					SUITE,
					ID,
					NAME,
					NOTES,
					EXPECTED,
					ACTUAL,
					VERSION;
	
	public TestInfo reset(){
		TIMESTAMP = null;
		SUITE = null;
		ID = null;
		NAME = null;
		NOTES = null;
		EXPECTED = null;
		ACTUAL = null;
		VERSION = null;
		return this;
	}
	public TestInfo timestamp(String value){
		TIMESTAMP = value;
		return this;
	}
	public TestInfo suite(String value){
		SUITE = value;
		return this;
	}
	public TestInfo id(String value){
		ID = value;
		return this;
	}
	public TestInfo name(String value){
		NAME = value;
		return this;
	}
	public TestInfo notes(String value){
		NOTES = value;
		return this;
	}
	public TestInfo expected(String value){
		EXPECTED = value;
		return this;
	}
	public TestInfo actual(String value){
		ACTUAL = value;
		return this;
	}
	public TestInfo version(String value){
		VERSION = value;
		return this;
	}
	
	public static String timestamp(){
		return TIMESTAMP;
	}
	public static String suite(){
		return SUITE;
	}
	public static String id(){
		return ID;
	}
	public static String name(){
		return NAME;
	}
	public static String notes(){
		return NOTES;
	}
	public static String expected(){
		return EXPECTED;
	}
	public static String actual(){
		return ACTUAL;
	}
	public static String version(){
		return VERSION;
	}
	public static void printResults(){
		DemoLogger.log.info("Test suite :"+suite());
		DemoLogger.log.info("Test id : "+id());
		DemoLogger.log.info("Test name : "+name());
	}
}
