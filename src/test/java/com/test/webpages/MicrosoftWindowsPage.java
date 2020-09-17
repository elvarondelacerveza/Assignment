package com.test.webpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MicrosoftWindowsPage {
	WebDriver driver;
	
	public MicrosoftWindowsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Win 10 menu
	@FindBy(id = "c-shellmenu_52")
	WebElement win10menu;
	
	// Agregar un Explicit Wait
	@FindBy(xpath = "//button[@aria-expanded='true']/following-sibling::ul//a")
	List<WebElement> dropdownWin10Elements;
	
	// Search Button
	@FindBy(id="search")
	WebElement searchNavButton;
	
	//Search Field
	@FindBy(id="cli_shellHeaderSearchInput")
	WebElement searchField;
	
	//First Product Result of Search 
	@FindBy(xpath="//a[@aria-posinset=1]")
    WebElement firstProduct;
	
	public WebElement window10menu() {
		return win10menu;
	}
	
	public WebElement searchNavButton() {
		return searchNavButton;
	}
	
	public WebElement searchField() {
		return searchField;
	}
	
	// Selector for all elements in win10 dropdown

	public List<WebElement> dropdownWin10Elements() {
		return dropdownWin10Elements;
	}
	
	// Selector for all results from test
	public WebElement firstProduct() {
		return firstProduct;
	}
}
