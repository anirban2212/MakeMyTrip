package com.mmt.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmt.base.TestBase;
import com.mmt.utils.TestUtils;

public class SearchResultPage extends TestBase{
	
	@FindBy(xpath = "//button[contains(@id,'bookbutton') and text()='Book Now']")
	WebElement bookNowBtn;
	By allPrice=By.xpath("//div[contains(@class,'splitfare ')]//p[starts-with(text(),'₹')]");
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifySearchResultPageTitle() {
		
		return driver.getTitle();
	}
	
	
	public void clickOnBookNowBtn() {
		
		TestUtils.explicitWait(bookNowBtn);
		bookNowBtn.click();
	}
	
	public void getMinFlightPrice() {
		List<WebElement>li=driver.findElements(allPrice);
		WebElement ele1=li.get(0);
		String minimumAmout=ele1.getText();
		int miniMumAmount=Integer.parseInt(minimumAmout.replaceAll("[^a-zA-Z0-9]", "").toString());
		if (li.size()!=0) {
			for(int i=1;i<li.size();i++) {
				WebElement ele2=li.get(i);
				String amount1=ele2.getText();
				int amount2=Integer.parseInt(amount1.replaceAll("[^0-9]", "").toString());
				if (miniMumAmount >= amount2) {
					miniMumAmount = amount2;
				}
	        }
	        System.out.println("Cheapest Flight Price is = ₹"
	                           + miniMumAmount);
	
			}
		
		}
		
		
	}
	
	
	
	
	
	


