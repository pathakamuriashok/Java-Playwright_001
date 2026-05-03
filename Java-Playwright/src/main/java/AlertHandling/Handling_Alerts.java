package AlertHandling;

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
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.options.LoadState;

public class Handling_Alerts 
{
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
   	//	https://the-internet.herokuapp.com/javascript_alerts
   		//https://demoqa.com/alerts
   		
   		page.navigate("https://demoqa.com/alerts");
		
		page.waitForLoadState(LoadState.LOAD);  // Due to this command , it will wait until all elements and css images are loaded fully
		String url=page.url();
		System.out.println("URL : After loading --> "+url); 
   	}
   	@Test(priority = 2)
   	public void Handling_Alert_Accept() throws InterruptedException  
   	{

   	//	page.getByTestId("#alertButton").click();
   		page.locator("#alertButton").click();
   		page.onDialog(dailog->{
   			dailog.accept();
            
   		});
   		
   	}
   	@Test(priority = 3)
   	public void Handling_Alert_Dismiss() throws InterruptedException
   	{
   		
   		//page.getByTestId("#confirmButton").click();
   		
   		page.locator("#confirmButton").click();
   		Thread.sleep(5000);
   		page.onceDialog(ashok->{
   			ashok.dismiss();
   		});
   		
   		
   	}
	@Test(priority = 4)
   	public void Handling_Alert_Wait_Dismiss() throws InterruptedException
   	{
   		
   		//page.getByTestId("#confirmButton").click();
   		
   		page.locator("#timerAlertButton").click();
   		page.onceDialog(ashok->{
   			try {
				ashok.wait(6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
   			ashok.dismiss();
   		});
   		
   	}
   	@Test(priority = 5)
   	public void Handling_Alert_Promt_Accept() throws InterruptedException
   	{
   	//	page.reload();
   	//	page.waitForLoadState(LoadState.LOAD);
   		page.locator("#promtButton").click();
   		
   		page.onceDialog(ashok->{
   			ashok.accept("ASHOK");
   		});
   		
   	}	
   	
       @AfterClass
       public void Close()
       {
    	   page.close();
    	   browser.close();
    	   playwright.close();
       }
}
