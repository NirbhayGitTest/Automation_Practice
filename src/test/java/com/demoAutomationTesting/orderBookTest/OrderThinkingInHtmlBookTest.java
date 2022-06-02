package com.demoAutomationTesting.orderBookTest;

import org.testng.annotations.Test;

import com.demoAutomationTesting.genericLibrary.BaseClass;
import com.demoAutomationTesting.genericLibrary.WorkbookLibrary;
import com.demoAutomationTesting.webElementsRepo.HomePage;
import com.demoAutomationTesting.webElementsRepo.ShopPage;

public class OrderThinkingInHtmlBookTest extends BaseClass{
	
	
	
	@Test
	public void orderAnHtmlBook()
	{
		home.clickShopLink(seleniumLibrary);
		
		seleniumLibrary.waitUntilElementVisible(shopPage.headerShop());
		
		shopPage.clickHomeLink(seleniumLibrary);
		
		htmlBookPage.clickonHtmlBook(driver);
		html5BookPage.clickHTML5Book(driver);
		addToBasketPage.clickonAddtoBasket(driver);
		basketPage.clickonViewBasket(driver);
		productSummaryPage.clickonProceedtoCheckout(driver);
		
		
		checkoutPage.getFirstNameTextbox(driver).sendKeys(WorkbookLibrary.getDataFromExcel("checkout", 1, 0));
		
		javalibrary.assertionThroughIfCondition(checkoutPage.getbillingDetails(driver),WorkbookLibrary.getDataFromExcel("checkout", 0, 1) , "showed checked page");
		
		
		
	}
	

}
