package com.demo.base;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class BaseTearDown extends BaseSetup{
	
	@AfterClass(alwaysRun = true)
	public void closeUp(ITestResult result) throws IOException {

		driver.close();

	}

}
