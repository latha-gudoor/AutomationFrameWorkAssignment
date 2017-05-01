package com.wbl.TestPages;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.Base.BaseTest;
import com.wbl.Pages.CreateAccountPage;
import com.wbl.Pages.HomePage;

public class CreateAccountTest extends BaseTest  {

	CreateAccountPage ca;
	HomePage hm;

	@BeforeClass
	public void beforeClass(){
		hm = new HomePage(driver);
		ca = hm.ClickMyAccount();
	}

	@Test(priority=0)
	public void testCreateAcctTitle(){
		assertEquals("My Account - Create Profile - Macy's",ca.getCreateAcctTitle());
	}

	@Test
	public void testCreateAccount(){
		assertEquals("https://www.macys.com/account/profile", ca.createAccount());
	}
}
