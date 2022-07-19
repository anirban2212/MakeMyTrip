package com.mmt.tescases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmt.base.TestBase;
import com.mmt.pages.HomePage;
import com.mmt.utils.TestUtils;

public class HomePageTest extends TestBase{
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		homePage=new HomePage();
		
		
		
	}
	
	//Complete flow with selecting all required data and clicking on Search button
	  
	@Test(priority = 1, enabled =true )
	public void searchFlightTest() throws Exception {
		Assert.assertTrue(homePage.verifyMmLogo());	
		TestUtils.implicitWait();
		homePage.enterDepartureCity();
		TestUtils.implicitWait();
		//Thread.sleep(4000);
		homePage.enterReturnCity();
		homePage.enterDepartureDate();
		homePage.enterReturnDate();
		homePage.addTraveller();
		homePage.clickOnSearch();	
		
	}
	 @AfterMethod public void tearDown() 
	  
	  {
		  driver.quit();
	  
	  }
	 
	
	
	
	
	

}
