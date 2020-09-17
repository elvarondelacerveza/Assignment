package com.mparra.utils;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.WebElement;

public class Util {

	
	public static void ValidateIfElementsArePresent(List<WebElement> elements) {
		
		if(elements.size() != 0){
			 //If list size is non-zero, element is present
			 System.out.println("Nav Elements present");
			}
		else{
			 //Else if size is 0, then element is not present
			 System.out.println("Nav Elements are not present");
		}
	}
	
	public static void PrintElementsFromList(List<WebElement> list) {
		
		for(int i=0; i<list.size(); i++)        
	    {
	        System.out.println(list.get(i).getText());
	    }
	}
	
	public static void ValidatePrices(List<WebElement> amounts) {
		HashSet<String> set=new HashSet<String>();
		
		for(int i=0; i<amounts.size(); i++)        
	    {
			set.add(amounts.get(i).getText());
	        System.out.println(amounts.get(i).getText());
	    }
		if(set.size()>1) {
			System.out.println("Elements are diferent");
		}else {
			System.out.println("Amount Price Consist");
		}		
	}
	public static String formatingPrice(String price) {
		price.replace("$", "");
		price.replace(".00", "");
		price.replace(",", "");
		
		return price;
	}
	
}
