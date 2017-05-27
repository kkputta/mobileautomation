package com.tresbu.demo.api.apps.speedtest.results;

import org.openqa.selenium.NoSuchElementException;

import com.tresbu.demo.api.android.Android;
import com.tresbu.demo.api.interfaces.Activity;
import com.tresbu.demo.core.DemoLogger;

public class Results implements Activity{
	
	public ResultsUiObjects uiObject = new ResultsUiObjects();
	
	public Results sortBy(String sortType){
		try{
			sortType = sortType.toLowerCase();
			DemoLogger.log.info("Sorting by "+sortType);
			if(sortType.equals("type"))uiObject.sortByType().tap();
			else if(sortType.equals("time"))uiObject.sortByTime().tap();
			else if(sortType.equals("download"))uiObject.sortByDownload().tap();
			else if(sortType.equals("upload"))uiObject.sortByUpload().tap();
			else if(sortType.equals("ping"))uiObject.sortByPing().tap();
			else throw new RuntimeException("Sorting by type : "+sortType+" is not supported");
			return Android.app.speedtest.results;
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not sort by "+sortType+", element absent or blocked");
		}
	}

	
	public Results waitToLoad() {
		try{
			DemoLogger.log.info("Waiting for results Activity");
			uiObject.resultsLabel().waitToAppear(10);
			return Android.app.speedtest.results;
		}catch(AssertionError e){
			throw new AssertionError("Results Activity failed to load/open");
		}
	}
}
