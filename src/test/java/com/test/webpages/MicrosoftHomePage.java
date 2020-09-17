package com.test.webpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MicrosoftHomePage {
	WebDriver driver;

	public MicrosoftHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='js-paddle-items']//li[@class='single-link js-nav-menu uhf-menu-item']/a")
	List<WebElement> navElements;

	@FindBy(id = "shellmenu_2")
	WebElement windowsLink;

	@FindBy(id = "shellmenu_1")
	WebElement officeLink;

	@FindBy(id = "shellmenu_3")
	WebElement surfaceLink;

	@FindBy(id = "shellmenu_4")
	WebElement xboxLink;

	@FindBy(id = "shellmenu_5")
	WebElement dealsLink;

	@FindBy(id = "l1_support")
	WebElement supportLink;

	public List<WebElement> GetNavElements() {
		return navElements;
	}

	public WebElement GetWindowsNav() {
		return windowsLink;
	}

	public WebElement GetOfficeLink() {
		return officeLink;
	}

	public WebElement GetSurfaceLink() {
		return surfaceLink;
	}

	public WebElement GetXboxLink() {
		return xboxLink;
	}

	public WebElement GetDealsLink() {
		return dealsLink;
	}

	public WebElement GetSupportLink() {
		return supportLink;
	}

}
