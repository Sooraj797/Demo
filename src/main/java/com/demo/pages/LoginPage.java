package com.demo.pages;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.utils.PageUtility;
import com.demo.utils.WaitUtility;

public class LoginPage {
	
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		this.driver=driver;
		
	}
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement logInEmailField;
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextButton;
	@FindBy(xpath = "//input[@type='password']")
	WebElement logInPasswordField;
	@FindBy(xpath = "//input[@type='tel']")
	WebElement mfaCodeField;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement askAgainCheckbox;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement logInSubmitButton;
	@FindBy(xpath = "//h1[text()='Welcome, Test Demo']")
	public WebElement dashboardTitle;
	
	public void logIn(String email, String password, String secretKey) {
		

        try {
        	PageUtility.enterWithoutClearText(logInEmailField, email);
    		PageUtility.clickButton(driver, nextButton);
    		WaitUtility.waitExplicitToBevisibilityOfAllElements(logInPasswordField);
    		
    		PageUtility.enterWithoutClearText(logInPasswordField, password);
    		PageUtility.clickButton(driver, nextButton);
    		WaitUtility.waitExplicitToBevisibilityOfAllElements(mfaCodeField);
    		
    		Totp totp = new Totp(secretKey); // 2FA secret key
            String twoFactorCode = totp.now();
            System.out.println(twoFactorCode);
            
    		PageUtility.enterWithoutClearText(mfaCodeField, twoFactorCode);
    		PageUtility.clickButton(driver, askAgainCheckbox);
    		PageUtility.clickButton(driver, nextButton);
    		
    		WaitUtility.waitExplicitToBevisibilityOfAllElements(dashboardTitle);
    		dashboardTitle.isDisplayed();
        }catch(StaleElementReferenceException e) {
        	e.printStackTrace();
        }
	}

}
