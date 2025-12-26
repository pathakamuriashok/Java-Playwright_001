package Playwright_Methods;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class EnterText_TextBoxes01 {
	
	@Test
	public void BrowserLaunch() throws InterruptedException {
		
		Playwright playwright=Playwright.create();
		
		Browser browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false)); 
		
		Page page=browser.newPage();
		
		page.navigate("https://www.lambdatest.com/selenium-playground/input-form-demo");
		
		
		/*
		 * Below three locater are ID so we have used # symbol : like #name
		 * ,#inputEmail4 and #inputPassword4 here name ,inputEmail4 and inputPassword4
		 * are ID's
		 */
		
		page.locator("#name").fill("ASHOK KUMAR");
		page.locator("#inputEmail4").fill("ASHOK KUMAR ASHOK KUMAR");
		page.locator("#inputPassword4").fill("ASHOK KUMAR");
		
		/**
		 * Below Two locater are name so we have used [name='company'] and
		 * [name='website'] here company and website are name locater properties
		 */
		
		page.locator("[name='company']").fill("ASHOK KUMAR");
		page.locator("[name='website']").fill("ASHOK KUMAR AKAKAKAKA");
		
		/**
		 *  we can place the X-Path directly ,like how we will do in selenium
		 */
		page.locator("//input[@id='inputCity']").fill("PATHAKAMURI");
		page.locator("//input[@id='inputAddress1']").fill("PATHAKAMURI ASHOK KUMAR PATHAKAMURI ASHOK KUMAR NAIDU");
		page.locator("//input[@id='inputAddress2']")
				.fill("PATHAKAMURI ASHOK KUMAR PATHAKAMURI ASHOK PATHAKAMURI ASHOK KUMAR PATHAKAMURI ASHOK");
		
		
		
		
		Thread.sleep(10000); 
		
		browser.close();
		page.close();
		playwright.close();
		
		
		
	}

}
