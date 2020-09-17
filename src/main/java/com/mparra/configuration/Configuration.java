package com.mparra.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Configuration {

	public WebDriver driver;
	public Properties prop;

	
	public WebDriver setupDriver() {
		// Indicate Type of Browser
		// DataDriven

		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("configuration.properties");
			prop.load(fis);

			String browser = prop.getProperty("browser");
			System.out.println("Navegador Seleccionado " + browser);
			
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();			
				driver = new FirefoxDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();			
				driver = new InternetExplorerDriver();
				break;
			}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	
}
