package com.wbl.HelperPackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ByClass {

	static Properties prop;
	public static void loadProperties(){
		try {
			prop = ConfigUtils.loadProperties("\\locators.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static By getByObj(String key){
		By by=null;

		if(key.trim().startsWith("id")){
			return By.id(prop.getProperty(key));
		}else if(key.trim().startsWith("css")){
			System.out.println(prop);
			System.out.println(prop.getProperty(key));
			return By.cssSelector(prop.getProperty(key));
		}else if(key.trim().startsWith("class")){
			return By.className(prop.getProperty(key));
		}else if (key.trim().startsWith("xpath")){
			return By.xpath(prop.getProperty(key));
		}else if (key.trim().startsWith("tag")){
			return By.tagName(prop.getProperty(key));
		}else if(key.trim().startsWith("link")){
			return By.linkText(prop.getProperty(key));
		}else if(key.trim().startsWith("partial")){
			return By.partialLinkText(prop.getProperty(key));
		}else if(key.trim().startsWith("name")){
			return By.name(prop.getProperty(key));
		}

		return by;

	}
}
