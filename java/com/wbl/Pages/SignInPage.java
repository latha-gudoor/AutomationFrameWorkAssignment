package com.wbl.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wbl.HelperPackage.ByClass;

public class SignInPage {

	WebDriver driver;

	// Signin page  Class constructor
	public SignInPage(WebDriver driver){
		this.driver=driver;
	}

	public String signInTitle(){
		System.out.println("SignIn Title : " + driver.getTitle());
		return driver.getTitle(); // assert for title to check whether we are in signin page or not
	}

	public String validSignIn(String email, String pwd){
		//	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		List<WebElement> element = driver.findElements(ByClass.getByObj("css-emailSignIn"));
		System.out.println("List Size" + element.size());
		element.get(0).sendKeys(email);
		driver.findElement(ByClass.getByObj("css-password")).sendKeys(pwd);
		driver.findElement(ByClass.getByObj("xpath-SignInbutton")).click();
		System.out.println("Signin Current URL : " + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
}
