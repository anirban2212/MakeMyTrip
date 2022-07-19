package com.mmt.tescases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmt.base.TestBase;
import com.mmt.pages.HomePage; 
import com.mmt.pages.SearchResultPage;
import com.mmt.utils.TestUtils;

public class SearchResultPageTest extends TestBase{
	
	HomePage homePage;
	SearchResultPage searchResultPage;
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		homePage=new HomePage();	
	}
	
	//get the minimum flight price and click on bookNow
	
	@Test(priority = 1,enabled = true)
	public void bookFlightTest() throws Exception{
		Assert.assertTrue(homePage.verifyMmLogo());	
		TestUtils.implicitWait();
		homePage.enterDepartureCity();
		TestUtils.implicitWait();
		//Thread.sleep(4000);
		homePage.enterReturnCity();
		homePage.enterDepartureDate();
		homePage.enterReturnDate();
		homePage.addTraveller();
		searchResultPage=homePage.clickOnSearch();	
		TestUtils.implicitWait();
		String title=searchResultPage.verifySearchResultPageTitle();
		Assert.assertEquals(title, "MakeMyTrip","Title does not Match");
		searchResultPage.getMinFlightPrice();
		searchResultPage.clickOnBookNowBtn();
			
		
	}
	
	
	
	  @AfterMethod public void tearDown() 
	  
	  {
		  driver.quit();
	  
	  }

}
