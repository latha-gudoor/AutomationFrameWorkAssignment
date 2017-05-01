package com.wbl.HelperPackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class WebUIDriver {

	static String browserName;
	public static String URL;

	public static void loadProperties(String fileName) throws FileNotFoundException, IOException{
		Properties prop = ConfigUtils.loadProperties(fileName);
		browserName=prop.getProperty("browser");
		URL=prop.getProperty("url");
	}
	public static WebDriver getDriver(){
		WebDriver driver = null;

		switch(browserName){
		case "firefox":
			System.setProperty("webdriver.gecko.driver", IConstants.LOCATION+"drivers\\"+"geckodriver.exe");
			driver= new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", IConstants.LOCATION+"drivers\\"+"chromedriver.exe");
			driver=new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", IConstants.LOCATION+"drivers\\"+"IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			break;
		default:
			System.setProperty("webdriver.gecko.driver", IConstants.LOCATION+"drivers\\"+"geckodriver.exe");
			driver= new FirefoxDriver();
		}

		return driver;
	}
}