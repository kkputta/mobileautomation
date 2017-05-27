package com.tresbu.demo.core.managers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.tresbu.demo.core.DemoLogger;
import com.tresbu.demo.core.Retry;
import com.tresbu.demo.core.TestInfo;

public class TestManager {
	
	public static TestInfo testInfo = new TestInfo();
	@Rule
	public Retry retry = new Retry(3);
	@Before
	public void before(){
		testInfo.reset();
	}
	@Rule
	public TestRule listen = new TestWatcher(){
		@Override
		public void failed(Throwable t,Description description){
			DemoLogger.log.info("Test Failed : ");
			TestInfo.printResults();
		}
		@Override
		public void succeeded(Description description){
			DemoLogger.log.info("Test Passed : ");
			TestInfo.printResults();
		}
	};
	
}
