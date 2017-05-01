package com.wbl.Base;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.wbl.HelperPackage.ByClass;
import com.wbl.HelperPackage.WebUIDriver;

public class BaseTest{

	protected WebDriver driver; // it can be accessed in diff packages too 


	@BeforeSuite
	public void beforeSuite(){

		try {
			WebUIDriver.loadProperties("config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = WebUIDriver.getDriver();
		driver.get(WebUIDriver.URL);
		ByClass.loadProperties();
	}


	@AfterSuite
	public void afterSuite(){
		driver.close();
	}








}