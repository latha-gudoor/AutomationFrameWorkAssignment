package com.wbl.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.wbl.HelperPackage.ByClass;

public class CreateAccountPage {

	WebDriver driver;

	// cretate account page constructor
	public CreateAccountPage(WebDriver driver){
		this.driver=driver;
	}
	public String getCreateAcctTitle(){
		return driver.getTitle(); // assert for title to check whether we are in create account page or not
	}

	public String createAccount(){
		driver.get("https://www.macys.com/account/profile");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(ByClass.getByObj("id-firstName")).sendKeys("sree");
		driver.findElement(ByClass.getByObj("id-lastname")).sendKeys("G");
		driver.findElement(ByClass.getByObj("css-email")).sendKeys("sks.void@gmail.com");
		driver.findElement(ByClass.getByObj("xpath-password")).sendKeys("abcd1234");

		WebElement element = driver.findElement(ByClass.getByObj("css-month"));
		Select select = new Select(element);
		select.selectByVisibleText("February");

		element = driver.findElement(ByClass.getByObj("id-day"));
		select = new Select(element);
		select.selectByValue("16");

		element = driver.findElement(ByClass.getByObj("xpath-year"));
		select = new Select(element);
		select.selectByVisibleText("2004");

		driver.findElement(ByClass.getByObj("css-checkBoxEmailClick")).click();
		driver.findElement(ByClass.getByObj("xpath-checkBoxTextClick")).click();
		driver.findElement(ByClass.getByObj("id-phone")).sendKeys("12345678");
		driver.findElement(ByClass.getByObj("id-formSubmit")).submit();
		return driver.getCurrentUrl(); //asserting for url :  assert for message later after creating account 

	}

}
