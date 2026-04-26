package Playwright_Methods;

import javax.print.attribute.standard.Chromaticity;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Screenshorts_01 {

	Playwright playwright;
	BrowserType Browsertype;
	Browser browser;
	Page page;
	
	@BeforeClass
	public void BrowserLaunch()
	{
		playwright=Playwright.create();
		
		Browsertype=playwright.chromium();
		
		LaunchOptions options=new LaunchOptions();
		options.setHeadless(false);
		
		
		browser=Browsertype.launch(options); 
		
		page=browser.newPage();
		
	}
	
	@Test(priority = 1)
	public void URL_Navigate()
	{
		page.navigate("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		System.out.println(page.title());
		assertThat(page).hasURL("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		assertThat(page).hasTitle("Selenium Grid Online | Run Selenium Test On Cloud");
		
		/*
		 *   TestNG assertions
		 */

		System.out.println("Below is TestNG assertion - Hard Assertion");
		Assert.assertEquals(page.title(), "Selenium Grid Online | Run Selenium Test On Cloud"); 
		
	}
	
	@Test(priority = 2)
	public void GetScreenshort()
	{
		
	}
	
	@AfterClass
	public void Quit()
	{
		page.close();
		browser.close();
		playwright.close();
	}
}
