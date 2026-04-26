package Dropdown_Handling;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;

public class DropDown_002 {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright=Playwright.create();
		
		BrowserType browsertype=playwright.chromium();
		
		LaunchOptions options=new LaunchOptions();
		options.setHeadless(false);
		ArrayList<String> arguments=new ArrayList<String>();
		arguments.add("--start-maximized"); 
		options.setArgs(arguments); 
		
		Browser browser=browsertype.launch(options);
		
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));  
		
		Page page=context.newPage();
		
		page.navigate("https://www.wikipedia.org/");
		
		// Wait until full page is loaded
		page.waitForLoadState(LoadState.LOAD);   // if you mention the " LoadState.LOAD " it will wait until DOM is ready [ All resources (CSS, images, JS) ] loaded

		System.out.println("Page fully loaded");
		
		/*
		 * 1. DOM Content Loaded
page.waitForLoadState(LoadState.DOMCONTENTLOADED);

👉 Waits until:

HTML is parsed
DOM is ready
❌ Images/CSS may NOT be loaded
2. Full Page Load (Most Common)
page.waitForLoadState(LoadState.LOAD);

👉 Waits until:

DOM is ready
All resources (CSS, images, JS) loaded

✔ This is what interviewer expects for “fully loaded page”

3. Network Idle (Advanced)
page.waitForLoadState(LoadState.NETWORKIDLE);

👉 Waits until:

No network calls for some time

✔ Useful for:

SPA apps (Angular/React)
		 */
		                 
		 //page.locator("#searchLanguage").selectOption(new SelectOption().setValue("bg")); 
		 page.locator("#searchLanguage").selectOption(new SelectOption().setLabel("Sinugboanong Binisaya"));
		// page.locator("#searchLanguage").selectOption(new SelectOption().setIndex(5));
		 
		Thread.sleep(2000);
		page.reload();
		page.waitForURL("https://www.wikipedia.org/");  
		page.waitForLoadState();  // this will wait until DOM is loaded (if you provide LoadState.LOAD it will wait until all images CSS loaded fully )
		String title=page.title();
		System.out.println("Title :: "+title);  
		String currentURL=page.url();
		System.out.println("Current URL :: "+currentURL);  
		
		page.navigate("https://www.google.com/");
		page.waitForLoadState();  // this will wait until DOM is loaded (if you provide LoadState.LOAD it will wait until all images CSS loaded fully )
		String title1=page.title();
		System.out.println("Title1 :: "+title1);  
		String currentUR1L=page.url();
		System.out.println("Current URL1 :: "+currentUR1L);  
		
		page.goBack();
		
		page.reload();
		page.waitForURL("https://www.wikipedia.org/");  
		page.waitForLoadState();  // this will wait until DOM is loaded (if you provide LoadState.LOAD it will wait until all images CSS loaded fully )
		String title2=page.title();
		System.out.println("Title :: "+title2);  
		String currentURL2=page.url();
		System.out.println("Current URL2 :: "+currentURL2); 
		
		page.close();
		playwright.close();
	}

}
