package com.wbl.TestPages;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import com.wbl.Base.BaseTest;
import com.wbl.Pages.CreateAccountPage;
import com.wbl.Pages.HomePage;
import com.wbl.Pages.SignInPage;

public class HomePageTest extends BaseTest  {

	HomePage hm;

	@BeforeClass
	public void beforeClass(){
		hm = new HomePage(driver); // passing the driver from test class to homepage
	}

	@Test
	public void testHeaderLink(){
		//assertEquals(13,hm.headerLinks());
		assertEquals(0,hm.headerLinks());
	}

	@Test
	public void testClickSignIn(){
		SignInPage sp = hm.clickSignIn();
		assertEquals("Sign In - Macy's", sp.signInTitle());
	}

	// method-2 returns element text
	@Test
	public void testClickMyAccount(){
		CreateAccountPage ca = hm.ClickMyAccount();
		assertEquals("Macy's - Shop Fashion Clothing & Accessories - Official Site - Macys.com", ca.getCreateAcctTitle());
	}

	// method-3 returns title
	@Test
	public void testStores(){
		assertEquals("Our Stores - Macy's", hm.stores());
	}

	// method-4 returns title
	@Test
	public void testShoppingBag(){
		//assertEquals("Sign In - Macy's", hm.shoppingBag());
		assertEquals("handbags - Shop for and Buy handbags Online - Macy's", hm.shoppingBag());
	}

	//method-5 returns title
	@Test
	public void testSearchBoxClick(){
		assertEquals("handbags - Shop for and Buy handbags Online - Macy's", hm.searchBoxClick());
	}
}
