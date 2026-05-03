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

public class MouseHover_Actions_01 {

    Playwright playwright;
   	BrowserType browsertype;
   	LaunchOptions options;
   	Browser browser;
   	BrowserContext context;
   	static Page page;  
   	

   @BeforeClass
   public Page DriverSetUP()
   {
	    playwright=Playwright.create();
  		browsertype=playwright.chromium();
  		options=new LaunchOptions();
  		
  		options.setHeadless(false);
  		options.setArgs(Arrays.asList("--start-maximized"));
  		
  		browser=browsertype.launch(options);
  		
  		context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null)); 
  		page=context.newPage();
  		return page;
  		
   }
 
	@Test(priority = 1)
	public void BrowserLaunch()
	{
		page.navigate("https://www.way2automation.com/");
	
	page.waitForLoadState(LoadState.LOAD);  // Due to this command , it will wait until all elements and css images are loaded fully
	String url=page.url();
	System.out.println("URL : After loading --> "+url); 
	}

	@Test(priority = 2)
	public void Mouse_Hover_001() throws InterruptedException  
	{
               page.locator("(//span[text()='Resources'])[1]").hover();
               page.locator("(//span[text()='Practice Site 3'])[1]").click();
	}
            

	
   @AfterClass
   public void Close()
   {
	   page.close();
	   browser.close();
	   playwright.close();
   }
}
