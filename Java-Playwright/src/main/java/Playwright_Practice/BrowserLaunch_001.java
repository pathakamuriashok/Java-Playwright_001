package Playwright_Practice;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import com.microsoft.playwright.options.LoadState;

public class BrowserLaunch_001 
{
   @Test
   
   public void DriverSetup() throws InterruptedException 
   {
	 // 1. We should Create the Playwright  "  Playwright.create();"
	    
	 // 2. Assign Created Playwright ( Playwright.create() ) to the playwright Object   
	   
	   Playwright playwright=Playwright.create();
	   
	   // 3. We should Declare Browser Type with the help of  "playwright created" Object 
	   
	   BrowserType browserType1=playwright.chromium(); 
	    
	   //   BrowserType browserType2=playwright.firefox();
	    
	   //   BrowserType browserType3=playwright.webkit();
	   
	   // 4. We Can launch the browser with the help of  "BrowserType " Object 
	  
	   // 5. Playwright by default executed in headless mode , if we want open the browser physically , then we should setheadless(false)
	   
	   LaunchOptions options=new LaunchOptions();
	   options.setHeadless(false);
	   
	   // 6. We can Assign "LaunchOptions" Object to launch to launch the browser Physically
	   
	   // 7. We should Assign Browser Launch [ browserType1.launch(options); ] to the Browser 
	   
	    Browser browser=browserType1.launch(options);
	    
	    // 8. We should create Page with the help of "Browser" Object and Assign to the Page
	  
	    Page page=browser.newPage();
	    
	    
	    // 9. We can Open the URL and perform actions from the created page Object
	    page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
	    
	    page.waitForLoadState();  
	    
	    /**
	     *   Default timeout is 30 seconds
	     *   
	     *   If the load state is not reached within 30s → TimeoutException
	     *   
	     *   The default load state for page.waitForLoadState() in Playwright is load, which waits until the page and all its sub-resources are fully loaded. The default timeout is 30 seconds.
	     *   
	     *   page.waitForLoadState(LoadState.LOAD,new Page.WaitForLoadStateOptions().setTimeout(60000));
	     */
	    
	    System.out.println(page.title()); 
	    assertEquals(page.title(), "Account Login");
	    
	    Thread.sleep(10000); 
	    
	    browser.close();
	    playwright.close();
	   
   }
}
