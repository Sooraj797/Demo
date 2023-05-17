package com.demo.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.demo.base.BaseSetup;

public class ScreenshotUtility extends BaseSetup{
	
	public static void takeScreenshot(String name) throws IOException {

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//src/main//resources/screenshots//" + name + ".png"));

	}

}
