package com.wbl.Pages;

import java.util.List;
//import java.util.List;
//import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wbl.HelperPackage.ByClass;


public class HomePage {
	WebDriver driver;

	// Homepage constructor-- for initialising driver
	public HomePage(WebDriver driver){
		this.driver=driver;
	}

	public int headerLinks(){
		List<WebElement> elements = driver.findElements(ByClass.getByObj("css-headerLink"));
		return elements.size();
	}

	public SignInPage clickSignIn(){
		driver.findElement(ByClass.getByObj("id-signInclick")).click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		return new SignInPage(driver); // want to assert for title
	}

	public CreateAccountPage ClickMyAccount(){
		//  implicit wait
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByClass.getByObj("id-myAccount")));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

		WebElement element1= wait.until(ExpectedConditions.visibilityOfElementLocated(ByClass.getByObj("link-creAcct")));
		action.moveToElement(element1).click().perform();
		System.out.println("Element : "+ element.getText());
		return new CreateAccountPage(driver); /// assert for text
	}

	public String stores(){
		driver.findElement(ByClass.getByObj("css-stores")).click();
		System.out.println("Stores Current URL : " + driver.getCurrentUrl());
		System.out.println("Stores title : " + driver.getTitle());
		return driver.getTitle();
	}

	public String shoppingBag(){
		WebElement element = driver.findElement(ByClass.getByObj("xpath-shopingBag"));
		System.out.println("TagName : " + element.getTagName());
		System.out.println("Text :" +element.getText());
		System.out.println("Title : " + driver.getTitle());
		return driver.getTitle();
	}

	public String searchBoxClick(){
		driver.findElement(ByClass.getByObj("css-searBoxClick")).sendKeys("handbags");
		driver.findElement(ByClass.getByObj("id-submitClick")).click();
		System.out.println("title : " + driver.getTitle());
		return driver.getTitle();
	}


}
