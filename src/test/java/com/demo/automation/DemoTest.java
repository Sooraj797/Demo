package com.demo.automation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.demo.constants.Constants;
import com.demo.pages.LoginPage;
import com.demo.utils.ExcelRead;
import com.demo.base.BaseSetup;

public class DemoTest extends BaseSetup{
	
	LoginPage loginPage;
	
	@Test(dataProvider="LogInDetails", testName = "Demo1TestCase" ,  priority = 1)
	public void demo1TestCase(String emailId, String password, String key) {
		
		loginPage = new LoginPage(driver);
		loginPage.logIn(emailId, password, key);
		
		SoftAssert valid = new SoftAssert();
		valid.assertEquals(driver.getTitle(),Constants.DASHBOARDTITLE);
		valid.assertAll();

	}
	
	@Test(testName = "Demo2TestCase" ,  priority = 2)
	public void demo2TestCase() {
		
		SoftAssert valid = new SoftAssert();
		valid.assertTrue(false);
		valid.assertAll();

	}
	
	@DataProvider(name ="LogInDetails")
	public Object[][] LogInDetails() throws IOException, EncryptedDocumentException, InvalidFormatException{
		
		Object[][] data = ExcelRead.getDataFromExcel(Constants.LoginCases, "Sheet1");
		return data;
		
	}

}
