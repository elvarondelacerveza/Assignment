package com.test.asserts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mparra.utils.Assertions;

public class AssertionsImpl implements Assertions {

	@Override
	public void validateIfElementIsPresent(WebElement element) {
		// TODO Auto-generated method stub
		Assert.assertTrue(element.isDisplayed());	
		System.out.println("El elemento "+element.getText() + " se encuentra en el sitio");
	}

}
