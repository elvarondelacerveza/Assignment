package com.test.app;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import com.mparra.configuration.Configuration;
import com.mparra.utils.Assertions;
import com.mparra.utils.Util;
import com.test.asserts.AssertionsImpl;
import com.test.webpages.MicrosoftDetailsProductPage;
import com.test.webpages.MicrosoftHomePage;
import com.test.webpages.MicrosoftWindowsPage;

public class MicrosoftApplicationSuite extends Configuration{

	static WebDriver driver;
	
	
	@BeforeTest
	public void configuration() {
		driver=setupDriver();			
	}
	
	@Test(priority=1)
	public void HomePage() throws InterruptedException {
		Assertions s = new AssertionsImpl(); 
//	1. Go to https://www.microsoft.com/en-us/
		driver.get(prop.getProperty("base.url"));
		MicrosoftHomePage home = new MicrosoftHomePage(driver);
//	2. Validate all menu items are present
		List<WebElement> nav = home.GetNavElements();
		//Office - Windows - Surface - Xbox - Deals - Support
		Util.ValidateIfElementsArePresent(nav);
		s.validateIfElementIsPresent(home.GetOfficeLink());
		s.validateIfElementIsPresent(home.GetWindowsNav());
		s.validateIfElementIsPresent(home.GetSurfaceLink());
		s.validateIfElementIsPresent(home.GetXboxLink());
		s.validateIfElementIsPresent(home.GetDealsLink());
		s.validateIfElementIsPresent(home.GetSupportLink());
	    
//	3. Go to Windows Link
		home.GetWindowsNav().click();	
	}
	
	@Test(priority=2)
	public void WindowsPage() throws InterruptedException {
//		driver.get("https://www.microsoft.com/en-us/windows/");
		driver.get(prop.getProperty("base.url")+"windows/");
		MicrosoftWindowsPage windowsPage = new MicrosoftWindowsPage(driver);
		
		Thread.sleep(5000);
//	4. Once in Windows page, click on Windows 10 Menu
		windowsPage.window10menu().click();
		Thread.sleep(7000);
//		Falta Explicit Wait
		List<WebElement> win10Elementslist =windowsPage.dropdownWin10Elements();
//	 5. Print all Elements in the dropdown
		Util.PrintElementsFromList(win10Elementslist);
//	6. Go to Search next to the shopping cart
		windowsPage.searchNavButton().click();
//	7. Search for Visual Studio
		windowsPage.searchField().sendKeys("Visual Studio");
		Thread.sleep(5000);
//	10. Click on the first one to go to the details page
		windowsPage.firstProduct().click();
	}
	
	@Test(priority=3) 
	public void ProductDetailsPage() throws InterruptedException {
		driver.get(prop.getProperty("base.url")+"p/visual-studio-professional-subscription/dg7gmgf0dst3?activetab=pivot%3aoverviewtab");
		MicrosoftDetailsProductPage detailProductPage = new MicrosoftDetailsProductPage(driver);
		
		Thread.sleep(3000);
		detailProductPage.getButtonAlert().click();
		String unit =detailProductPage.getPriceProduct().getText();
		unit = unit.replace("$", "");
		unit = unit.replace(".00", "");
		int unitPrice = Integer.valueOf(unit);
		System.out.println("Price of product = " + unitPrice);
//		12. Click Add To Cart
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", detailProductPage.getAddToCartButton());    
		detailProductPage.getAddToCartButton().click();
//      13. Verify all 3 price amounts are the same
		List<WebElement> amounts =detailProductPage.getPrices();
		Util.ValidatePrices(amounts);
	// 14. On the # of items dropdown select 20 and validate the Total amount is
//        * Unit Price * 20
		Select quantity = new Select(detailProductPage.getAmountProducts());
		quantity.selectByIndex(19);
		int compare = unitPrice*20;
		String calculatedPrice = String.valueOf(compare);
		System.out.println("Calculated Price: " + calculatedPrice);
		Thread.sleep(3000);
		String totalfield = Util.formatingPrice(detailProductPage.getTotalOrderSummary().getText());
		System.out.println("Total Price " + totalfield);
		totalfield = totalfield.replace("$", "");
		totalfield = totalfield.replace(".00", "");
		totalfield = totalfield.replace(",", "");
		if(calculatedPrice.equals(totalfield)) {
			System.out.println("Calculation it´s correct");
		}else {
			System.out.println("Calculation isn´t correct");
		}
	}
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
