package com.mmt.utils;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mmt.base.TestBase;

public class TestUtils extends TestBase{
	
	public static long IMPLICIT_WAIT=20;
	public static long PAGELOAD_TIMEOUT=10;
	public static String departureDate;
	public static String returnDate;
	
	public static void explicitWait(WebElement ele) {
		WebDriverWait wait= new WebDriverWait(driver,20 );
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		System.out.println("applied explicit wait for element "+ele);
		
	}
	
	public static void implicitWait() {
		
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	}
	
	//closing the notification poup and moving the pointer the mainwindow
	public static void switchToMainFrame(WebElement ele) {
		
		try {
			driver.switchTo().frame("notification-frame-~19713b227");
			explicitWait(ele);
			ele.click();
			//switching to original frame after closing notification popup
			driver.switchTo().parentFrame();
			System.out.println("sucessfully switched to main HomePage");
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("failed to Switch on MainHomePag"+e);
			
		}
		
	}
	
	public static void  moveAndClickElement( WebElement ele) {
		try {
			explicitWait(ele);
			Actions act=new Actions(driver);
			act.moveToElement(ele).click().build().perform();
			System.out.println("Sucessfully clicked on element by xpath: "+ele);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Failed to click on element"+e);
		}
		
		
	}
	
	public static By customXpath(String xpath, String param) {
		String rawPath = xpath.replaceAll("%replace%", param);
		return By.xpath(rawPath);
	}
	
	
	public static TestUtils getCurrentAndReturnDates() {
		TestUtils date = new TestUtils();
		Calendar cal=Calendar.getInstance();
		//added tomorrows date
		cal.add(Calendar.DATE, 1);  
		String[] dateArr=cal.getTime().toString().split(" ");
		TestUtils.departureDate=dateArr[0]+" "+dateArr[1]+" "+dateArr[2]+" "+dateArr[5];
		cal.add(Calendar.DATE, Integer.parseInt(prop.getProperty("NoOfdays")));
		dateArr=cal.getTime().toString().split(" ");
		TestUtils.returnDate=dateArr[0]+" "+dateArr[1]+" "+dateArr[2]+" "+dateArr[5];
		return date;
	}
	
	
	
	
	
	
	

}
