package com.wbl.TestPages;

import com.wbl.Base.BaseTest;
import com.wbl.HelperPackage.ExcelUtilMacys;
import com.wbl.Pages.HomePage;
import com.wbl.Pages.SignInPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SignInPageTest extends BaseTest  {

	SignInPage sp;
	HomePage hm;

	static Logger logger = LogManager.getLogger(SignInPageTest.class);

	@BeforeClass
	public void beforeClass(){
		hm=new HomePage(driver);
		sp=hm.clickSignIn();
	}
	@DataProvider(name="signindata")
	public Object[][] testData(){
		Object[][] data = ExcelUtilMacys.getExcelData("Macys_SignInData.xlsx");
		return data;
	}

	@Test
	public void testSignInTitle(){
		assertNotNull(sp.signInTitle());
	}

	/*@Test(dependsOnMethods={"testSignInTitle"})//(dataProvider="signindata")
		public void testValidSignIn(){//String email,String pwd){
			assertEquals("https://www.macys.com/?FromSignin=true",sp.validSignIn());
		}*/

	@Test(dataProvider="signindata")
	public void testValidSignIn(String email,String pwd){
		logger.info("SignIn page data...");
		assertEquals("https://www.macys.com/?FromSignin=true",sp.validSignIn(email,pwd));
	}
}
