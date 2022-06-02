package com.demoAutomationTesting.webElementsRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HtmlBookPage {
	
	@FindBy(xpath = "//h3[text()='Thinking in HTML']")
	private WebElement clickonHtmlBookTxt;
	
	public HtmlBookPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonHtmlBook(WebDriver driver)
	{
		
		clickonHtmlBookTxt.click();
	}

}
