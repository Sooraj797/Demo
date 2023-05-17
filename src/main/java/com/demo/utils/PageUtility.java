package com.demo.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageUtility {
	
static WebDriver driver;
	
	public static void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public static void enterWithoutClearText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public static void clickButton(WebDriver driver, WebElement element) {
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", element);	 
	}
	
	public static void clickActionButton(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.click(element).build().perform();
	}
	
	public static String getText(WebElement element) {
		String txt= element.getText();
		return txt;
	}
	
	public static void enterKey(WebElement element) {
		element.clear();
		element.sendKeys(Keys.ENTER);
	}

	public static boolean displayed(WebElement element) {
		boolean b = element.isDisplayed();
		return b;
	}
	
	public static boolean selected(WebElement element) {
		boolean b = element.isSelected();
		return b;
	}
	
	public static boolean enabled(WebElement element) {
		boolean b = element.isEnabled();
		return b;
	}

}
