package com.demoAutomationTesting.webElementsRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {

	@FindBy(xpath = "//a[@class='button wc-forward']")
	private WebElement clickonViewBasketBtn;
	
	public BasketPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonViewBasket(WebDriver driver)
	{
		
		clickonViewBasketBtn.click();
	}
	
}
