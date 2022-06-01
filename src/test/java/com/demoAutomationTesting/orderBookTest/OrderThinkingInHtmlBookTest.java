package com.demoAutomationTesting.orderBookTest;

import org.testng.annotations.Test;

import com.demoAutomationTesting.genericLibrary.BaseClass;
import com.demoAutomationTesting.webElementsRepo.HomePage;
import com.demoAutomationTesting.webElementsRepo.ShopPage;

public class OrderThinkingInHtmlBookTest extends BaseClass{
	
	
	
	@Test
	public void orderAnHtmlBook()
	{
		home.clickShopLink(seleniumLibrary);
		
		seleniumLibrary.waitUntilElementVisible(shopPage.headerShop());
		
		shopPage.clickHomeLink(seleniumLibrary);
		
		
		
		
		
	}
	

}
