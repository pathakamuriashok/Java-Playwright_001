package Playwright_Practice;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserLaunch_002 {

	@Test
	public void DirverSETUP() throws InterruptedException
	{
		Playwright playwright=Playwright.create();
		
		Page page=playwright.chromium().launch(new LaunchOptions().setHeadless(false)).newPage(); 
		
		page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

		System.out.println(page.title());
		assertEquals(page.title(), "Account Login"); 

		page.locator("//*[contains(text(),' Home')]").click();
		
		page.locator("(//*[contains(text(),' Special')])[2]").click();
		
		page.locator("(//*[contains(text(),'Blog')])[2]").click();
		
		page.locator("(//*[contains(text(),' Mega Menu')])").click();
		
		page.locator("(//*[contains(text(),' AddOns')])").click();
		
		page.waitForLoadState();
		
		page.locator("(//*[contains(text(),' My account')])[2]").hover();
		
		page.locator("//*[contains(text(),'Login')]").click();
		
		page.locator("//*[contains(text(),' Home')]").click();
		
		page.waitForLoadState();
		
		page.locator("(//*[contains(text(),' My account')])[2]").hover();
		
		page.locator("//*[contains(text(),' Register')]").click();
		
		
		
		Thread.sleep(10000);
		
		page.close();
		playwright.close();

	}
}
