package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.AmazonHomePage;
import SetUp.Generic_methods;

public class SearchFunctionTest extends Generic_methods{
	@Test
	public void setUpBrowser() throws Exception{
		String browserType=getVal("browser");
		setBrowserType(browserType);	
	    driver.get("https://mvnrepository.com/");
			
			
	}
}
