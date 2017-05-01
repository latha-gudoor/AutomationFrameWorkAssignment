package com.wbl.TestPages;


import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.Base.BaseTest;
import com.wbl.Pages.HomePage;
import com.wbl.Pages.SearchPage;


public class SearchPageTest extends BaseTest  {

	SearchPage serPage;
	HomePage hm;

	@BeforeClass
	public void beforeClass(){
		serPage = new SearchPage(driver);

	}

	@Test
	public void testSearchBoxItem(){
		assertEquals(10, serPage.searchBoxItem());
	}

	@Test
	public void testSearchSort(){
		assertEquals(72, serPage.searchSort());
	}

}
