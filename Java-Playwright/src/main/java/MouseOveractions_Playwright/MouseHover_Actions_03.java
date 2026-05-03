package MouseOveractions_Playwright;

import java.util.Arrays;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.LoadState;

import Playwright_Practice.DriverSetUP_BrowserLaunch;

public class MouseHover_Actions_03 {

   Page page;
   
   @BeforeClass
   public void ApplicationLaunch()
   {
	   page=DriverSetUP_BrowserLaunch.DriverSetUP("https://www.way2automation.com/");
   }
 
	@Test(priority = 1)
	public void Mouse_Hover_002() throws InterruptedException
	{
	
		page.locator("#menu-item-27580").hover();
		page.locator("#menu-item-27582").hover();
		page.locator("#menu-item-27584").hover();
		page.locator("#menu-item-27584").click();	
	}
	
   @AfterClass
   public void Close()
   {
	   DriverSetUP_BrowserLaunch.Close();
   }
}
