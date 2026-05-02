package Frames_Handling;

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

public class Handling_Frames_002 {

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
		page.navigate("https://letcode.in/frame");
		
		page.waitForLoadState(LoadState.LOAD);  // Due to this command , it will wait until all elements and css images are loaded fully
		String url=page.url();
		System.out.println("URL : After loading --> "+url); 
	}
	@Test(priority = 2)
	public void NestedFrames() throws InterruptedException
	{
		
		page.frameLocator("#firstFr")
		.frameLocator("iframe.has-background-white")
		.locator("Enter email").fill("ASHOK KUMAR");
	    Thread.sleep(5000); 
	}
	
    @AfterClass
    public void Close()
    {
 	   page.close();
 	   browser.close();
 	   playwright.close();
    }
    
}
