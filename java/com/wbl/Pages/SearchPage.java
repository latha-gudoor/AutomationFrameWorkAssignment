package com.wbl.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.wbl.HelperPackage.ByClass;

public class SearchPage {

	WebDriver driver;

	// search page constructor
	public SearchPage(WebDriver driver){
		this.driver=driver;
	}

	public int searchBoxItem(){
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(ByClass.getByObj("css-searchBox")).sendKeys("handbags");

		List<WebElement> searchList = driver.findElements(ByClass.getByObj("css-searchItem"));
		for(WebElement list : searchList){
			if(list.getText().equalsIgnoreCase("coach handbags")){
				list.click();
				break;
			}
			System.out.println("SearchPage Title : " + driver.getTitle());
		}
		return searchList.size();
	}


	public int searchSort(){
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement element = driver.findElement(ByClass.getByObj("css-sortSearch"));
		element.click();
		Select select = new Select(element);
		select.selectByValue("PRICE_HIGH_TO_LOW");
		List<WebElement> searchList = driver.findElements(ByClass.getByObj("css-sortOrder"));
		//searchList.get(0).click();
		System.out.println("Highest price Item : " + searchList.get(0).getTagName()); 
		return searchList.size(); 
	}
}








//css-- productThumbnailLink .productThumbnailLink -- count 121
//css -- .first-range -- highest range --61 items

/*
@Test(priority=4)
public String searchBox(){

	driver.findElement(By.cssSelector("#globalSearchInputField")).sendKeys("handbags");

	WebDriverWait wait = new WebDriverWait(driver,20);
	String result = wait.until(function);
	 return result;
}
	Function <WebDriver,String> function = new Function<WebDriver,String>(){

		public String apply(WebDriver args0) {
			WebDriverWait wait = new WebDriverWait(driver,20);
			List<WebElement> searchList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".suggestion")));
			for(WebElement list : searchList){
				if(list.getText().equalsIgnoreCase("coach handbags")){
					list.click();
					break;

		}

	}
			return driver.getTitle();
	System.out.println("searchlist size : " + searchList.size());
		}
	};*/



