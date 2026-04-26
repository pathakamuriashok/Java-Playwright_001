package Dropdown_Handling;

import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
        
public class Dropdown_001 {
        
	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright=Playwright.create();
		
		BrowserType browsertype=playwright.chromium();
		
		LaunchOptions options=new LaunchOptions(); 
		options.setHeadless(false);
		options.setArgs(Arrays.asList("--start-maximized"));
		
		Browser browser=browsertype.launch(options);
		
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		
		Page page=context.newPage();
		
		page.navigate("https://www.wikipedia.org/");
		
	//	page.waitForLoadState();
		page.waitForURL("https://www.wikipedia.org/");  
		
		String title=page.title();
		System.out.println("Title :"+title);
		String url=page.url();
		System.out.println("URL :"+url);
        
		page.locator("#searchLanguage").selectOption("Deutsch");
		Thread.sleep(2000);
		page.reload();
		page.waitForURL("https://www.wikipedia.org/");  
		
		page.locator("#searchLanguage").selectOption("Galego");
		Thread.sleep(2000);
		page.reload();
		page.waitForURL("https://www.wikipedia.org/");  
		
		page.locator("#searchLanguage").selectOption("Italiano");
		Thread.sleep(2000);
		page.reload();
		page.waitForURL("https://www.wikipedia.org/");  
		
		page.locator("#searchLanguage").selectOption("Lietuvių");
		Thread.sleep(2000);
		page.reload();
		page.waitForURL("https://www.wikipedia.org/");  
		
		page.close();
		playwright.close();
	}   

}
