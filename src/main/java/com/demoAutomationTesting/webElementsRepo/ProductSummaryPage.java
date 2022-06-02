package com.demoAutomationTesting.webElementsRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSummaryPage {
	
	@FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
	private WebElement clickonProceedtoCheckoutBtn;
	
	public ProductSummaryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonProceedtoCheckout(WebDriver driver)
	{
		
		clickonProceedtoCheckoutBtn.click();
	}

}
