package com.test.webpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MicrosoftDetailsProductPage {

	WebDriver driver;

	public MicrosoftDetailsProductPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Modal keep on us page
	@FindBy(xpath = "//button[@id='R1MarketRedirect-close']")
	WebElement buttonAlert;

	@FindBy(xpath = "//*[@id='ProductPrice_productPrice_PriceContainer']/span")
	WebElement price;

	@FindBy(xpath = "//button[@id='buttonPanel_AddToCartButton']")
	WebElement addToCartbutton;

	// Get 3 prices amount
	@FindBy(css = "span[itemprop='price']")
	List<WebElement> prices;

	//Select items order
	@FindBy(xpath = "//div[@class='item-quantity']//select")
	WebElement amountProducts;
	
	@FindBy(xpath = "//div[@aria-live='polite']//span[@itemprop='price']")
	WebElement totalOrderSummary;
	
	
	public WebElement getButtonAlert() {
		return buttonAlert;
	}

	public WebElement getPriceProduct() {
		return price;
	}

	public WebElement getAddToCartButton() {
		return addToCartbutton;
	}

	public List<WebElement> getPrices() {
		return prices;
	}
	public WebElement getAmountProducts() {
		return amountProducts;
	}
	public WebElement getTotalOrderSummary() {
		return totalOrderSummary;
	}

}
