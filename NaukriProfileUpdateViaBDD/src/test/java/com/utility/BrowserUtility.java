package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserUtility {

	public static WebDriver supplyDriver(String browser)
	{
			if(browser.equals("chrome"))
			{
				ChromeOptions co = new ChromeOptions();
				co.setBrowserVersion("116");
				return new ChromeDriver(co);
			}
			else if(browser.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				return new FirefoxDriver();
			}
			else if(browser.equals("ie"))
			{
				WebDriverManager.iedriver().setup();
				return new InternetExplorerDriver();
			}
			else if(browser.equals("edge"))
			{
				WebDriverManager.edgedriver().setup();
				return new EdgeDriver();
			}
			else
			{
				return null;
			}
	}
	
	public static void openBrowser() {
		
		
	}
	public static void closeBrowser() {
		
	}
	
}
