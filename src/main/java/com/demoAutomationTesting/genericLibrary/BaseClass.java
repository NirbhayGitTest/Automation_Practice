package com.demoAutomationTesting.genericLibrary;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.demoAutomationTesting.webElementsRepo.AddToBasketPage;
import com.demoAutomationTesting.webElementsRepo.BasketPage;
import com.demoAutomationTesting.webElementsRepo.CheckoutPage;
import com.demoAutomationTesting.webElementsRepo.HomePage;
import com.demoAutomationTesting.webElementsRepo.Html5BookPage;
import com.demoAutomationTesting.webElementsRepo.HtmlBookPage;
import com.demoAutomationTesting.webElementsRepo.ProductSummaryPage;
import com.demoAutomationTesting.webElementsRepo.ShopPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains implementation of all basic configuration annotations
 * @author Nirbhay The Omen
 *this is a base class and
 */

public class BaseClass {
	
	public WebDriver driver;
	public JavaLibrary javalibrary;
	public String userName;
	public String password;
	public String browser;
	public long longTimeOut;
	public int randomNumber;
	
	public ShopPage shopPage;
	public HtmlBookPage htmlBookPage;
	public Html5BookPage html5BookPage;
	public AddToBasketPage addToBasketPage;
	public BasketPage basketPage;
	public ProductSummaryPage productSummaryPage;
	public CheckoutPage checkoutPage;
	
	public HomePage home;
	public Actions action;
	public WebDriverWait wait;
	public SeleniumWebDriverLibrary seleniumLibrary;
	public static WebDriver staticDriver;
	
	
	/**
	 * In this annotation we open database  
	 * , open property file , 
	 * open excel
	 * 
	 */
	
	@BeforeSuite(groups="baseclass")
	public void beforeSuite1Test()
	{
		//Open database also if it is required (for vtiger not required)
		//Property File :-
		try {
			PropertyFileLibrary.openPropertyFile(IallPathDataLibrary.PROPERTYFILEPATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Workbook :-
		try {
			WorkbookLibrary.openExcel(IallPathDataLibrary.EXCELFILEPATH);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	/**
	 * In this annotation we fetch the common data from the property file ,
	 *  create the instance for all generic utility , 
	 *  launch browser, do browser settings
	 *  create the instance for common object repository class
	 */
	
	//@Parameters(value = "browser")
	@BeforeClass(groups = "baseclass")
	public void beforeClass1Test(/*String browser*/)
	{
		//create instance for all generic utility
		javalibrary = new JavaLibrary();
		String url = PropertyFileLibrary.getDataFromPropertyFile("url");
//		userName = PropertyFileLibrary.getDataFromPropertyFile("userName");
//		password = PropertyFileLibrary.getDataFromPropertyFile("password");
		String timeout = PropertyFileLibrary.getDataFromPropertyFile("timeout");
		String browser = PropertyFileLibrary.getDataFromPropertyFile("browser");
		longTimeOut = javalibrary.stringToLong(timeout);
		randomNumber = javalibrary.getRandomNumber(10000);
		
		//To fetch data from terminal (Command :-  mvn test -DBROWSER=chrome -DUSERNAME=admin -DPASSWORD=root )
//		browser = System.getProperty("BROWSER");
//		userName = System.getProperty("USERNAME");
//		password = System.getProperty("PASSWORD");
//		
		//launch browser instance
		switch(browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("please specify proper browser key");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		
		staticDriver=driver;
		
		//browser settings(maximize,implicit,actions,explicit)
		SeleniumWebDriverLibrary.browserSetting(longTimeOut, driver);
		seleniumLibrary = new SeleniumWebDriverLibrary(driver);
		seleniumLibrary.initializeActions(driver);
		seleniumLibrary.explicitlyWait(driver, longTimeOut);
		SeleniumWebDriverLibrary.initializeJs(driver);
		
		//create the instance for common object repository
		
		home = new HomePage(driver);
		shopPage = new ShopPage(driver);
		htmlBookPage = new HtmlBookPage(driver);
		html5BookPage = new Html5BookPage(driver);
		addToBasketPage = new AddToBasketPage(driver);
		basketPage = new BasketPage(driver);
		productSummaryPage = new ProductSummaryPage(driver);
		checkoutPage = new CheckoutPage(driver);
		
		
		//navigate to the application
		SeleniumWebDriverLibrary.navigateApp(url, driver);
	
	}
	
	/**
	 * In this annotation we we do login action
	 */
	
	@BeforeMethod(groups="baseclass")
	public void beforeMethodTest()
	{
		javalibrary.printStatement("website opened");
	}
	
	/**
	 * In this annotation we we do signout action
	 */
	@AfterMethod(groups="baseclass")
	public void afterMethodTest()
	{
		
		
		
	}
	
	/**
	 * In this annotation we will close the browser instance
	 */
	@AfterClass(groups="baseclass")
	public void afterClass1Test()
	{
		SeleniumWebDriverLibrary.quitBrowser(driver);
	}
	
	/**
	 * In this annotation we will close database
	 * In this annotation we will close excel
	 * And Save the excel file
	 */
	@AfterSuite(groups="baseclass")
	public void afterSuite1Test()
	{
		try {
			WorkbookLibrary.writeDataInExcel(IallPathDataLibrary.EXCELFILEPATH);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			WorkbookLibrary.closeExcel();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//close the database connection code (outside the try/catch block)
		
	}

}
