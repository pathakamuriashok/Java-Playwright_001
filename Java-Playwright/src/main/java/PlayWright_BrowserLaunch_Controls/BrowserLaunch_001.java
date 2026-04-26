package PlayWright_BrowserLaunch_Controls;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserLaunch_001 {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright=Playwright.create();
		
		BrowserType type=playwright.chromium();
		
		LaunchOptions options=new LaunchOptions();
		options.setHeadless(false);
		
		Browser browser=type.launch(options);
		
		Page page=browser.newPage();
		
		page.navigate("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
		
		Thread.sleep(5000);   // this is not recommended but just used to see the browser launching 
		
		browser.close();
		page.close();
		playwright.close();
	

	}

}
