package Playwright_Methods;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Click_ClickLinks 
{

	@Test
	public void Click_001() throws InterruptedException
	{
		Playwright playwright=Playwright.create();
		
		Browser browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		
		Page page=browser.newPage();
		
		page.navigate("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
		
		page.click("(//input[@name='optradio'])[2]");
		
		page.locator("#buttoncheck").click();
		
		page.waitForLoadState();
		
		System.out.println(page.locator("//*[text()='Get value']//following::p[1]").textContent());
		
		if (page.locator("//*[text()='Get value']//following::p[1]").textContent().contains("Female")) 
		{
			System.out.println("Female is selected");
		}
		
		page.locator("//*[text()='Radio Button 2']").click();
		
		Thread.sleep(10000); 
		
		browser.close();
		page.close();
		playwright.close();
		
	}
}
