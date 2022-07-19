package com.mmt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmt.base.TestBase;
import com.mmt.utils.TestUtils;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//a//img[@alt='Make My Trip']")
	WebElement mmLogo;
	
	@FindBy(xpath = "//input[@id='fromCity']")
	WebElement fromCityElement;
	@FindBy(xpath = "//input[@type='text' and @placeholder='From']")
	WebElement fromCityTextBox;
	
	@FindBy(xpath = "(//ul[@class='react-autosuggest__suggestions-list']//li//div)[2]")
	WebElement firstSuggestedPlace;
	
	@FindBy(xpath = "//a[@class='close']")
	WebElement closeBtn;
	
	@FindBy(xpath = "//input[@id='toCity']")
	WebElement toCity;
	@FindBy(xpath = "//input[@type='text' and @placeholder='To']")
	WebElement toCityTextBox;
	@FindBy (xpath = "//span[contains(text(),'DEPARTURE')]")
	WebElement departureLink;
	
	@FindBy(xpath="//label[@for='departure']//span[contains(text(),'DEPARTURE')]")
	WebElement departureDropLink;
	
	@FindBy(xpath="//label[@for='return']//span[contains(text(),'RETURN')]")
	WebElement returnDropLink;
	
	String departureDate = "//div[@aria-label='%replace%' and @aria-disabled='false']";
	String returnDate = "//div[@aria-label='%replace%' and @aria-disabled='false']";

	@FindBy(xpath="//a[contains(@class,'widgetSearchBtn') and text()='Search']")
	WebElement searchBtn;
	
	@FindBy(xpath ="//span[contains(text(),'Travellers & CLASS')]")
	WebElement travellerDropLink;
	@FindBy(xpath = "//li[@data-cy='adults-2']")
	WebElement addAdult;
	@FindBy(xpath = "//button[@type='button' and text()='APPLY']")
	WebElement applyBtn;
	
	
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyMmLogo() {
		
		return mmLogo.isDisplayed();
	}
	
	public void enterDepartureCity(){
		
		TestUtils.switchToMainFrame(closeBtn);
			
		TestUtils.explicitWait(fromCityElement);
		fromCityElement.click();
		TestUtils.explicitWait(fromCityTextBox);
		fromCityTextBox.sendKeys(prop.getProperty("fromCity"));
		TestUtils.explicitWait(firstSuggestedPlace);
		TestUtils.moveAndClickElement(firstSuggestedPlace);
		}
	
	public void enterReturnCity() {
		TestUtils.explicitWait(toCityTextBox);

		toCityTextBox.sendKeys(prop.getProperty("toCity"));
		TestUtils.explicitWait(firstSuggestedPlace);

		TestUtils.moveAndClickElement(firstSuggestedPlace);	
		
	}
	
	public void enterDepartureDate() {
		TestUtils.explicitWait(departureDropLink);
		departureDropLink.click();
		TestUtils date = TestUtils.getCurrentAndReturnDates();
		driver.findElement(TestUtils.customXpath(departureDate,date.departureDate)).click();
	}
	public void enterReturnDate() {
		TestUtils.explicitWait(returnDropLink);
		returnDropLink.click();
		TestUtils date = TestUtils.getCurrentAndReturnDates();
		driver.findElement(TestUtils.customXpath(returnDate, date.returnDate)).click();
	}
	
	public void addTraveller() {
		TestUtils.explicitWait(travellerDropLink);
		travellerDropLink.click();
		TestUtils.moveAndClickElement(addAdult);
		applyBtn.click();
		
		
	}
	
	public SearchResultPage clickOnSearch() {
		searchBtn.click();
		driver.manage().deleteAllCookies();
		TestUtils.implicitWait();
		return new SearchResultPage();
	}
	
	
	
	
	
	
	
		
		
		
		
	}
	
	


