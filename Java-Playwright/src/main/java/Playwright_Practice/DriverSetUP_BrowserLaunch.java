package Playwright_Practice;

import java.util.Arrays;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.LoadState;

public class DriverSetUP_BrowserLaunch 
{
	    static Playwright playwright;
	   	static BrowserType browsertype;
	   	static LaunchOptions options;
	   	static Browser browser;
	   	static BrowserContext context;
	   	static Page page;  
	   	  

	   public static Page DriverSetUP(String URL)
	   {

		    playwright=Playwright.create();
	  		browsertype=playwright.chromium();
	  		options=new LaunchOptions();
	  		
	  		options.setHeadless(false);
	  		options.setArgs(Arrays.asList("--start-maximized"));
	  		
	  		browser=browsertype.launch(options);
	  		
	  		context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null)); 
	  		page=context.newPage();
	  		page.navigate(URL);
			page.waitForLoadState(LoadState.LOAD);  // Due to this command , it will wait until all elements and css images are loaded fully
			String url=page.url();
			System.out.println("URL : After loading --> "+url); 

	  		return page;
	   }
	   public static void Close()
	   {
		   page.close();
		   browser.close();
		   playwright.close();
	   }
}
