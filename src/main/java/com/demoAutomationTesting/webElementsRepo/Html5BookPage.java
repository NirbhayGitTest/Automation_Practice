package com.demoAutomationTesting.webElementsRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Html5BookPage {
	
	@FindBy(xpath = "//h3[text()='HTML5 WebApp Develpment']")
	private WebElement clickHTML5BookTxt;
	
	public Html5BookPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickHTML5Book(WebDriver driver)
	{
		
		clickHTML5BookTxt.click();
	}

}
