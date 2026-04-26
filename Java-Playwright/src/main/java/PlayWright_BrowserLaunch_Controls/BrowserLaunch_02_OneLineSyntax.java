package PlayWright_BrowserLaunch_Controls;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserLaunch_02_OneLineSyntax {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * If we use this sytax we can close the page but we can not close the playwright , 
		 * so the program will be execution mode till you close it from console 
		 */
		
		Page page=Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false)).newPage();
		
		page.navigate("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
		Thread.sleep(5000); 
		page.close();
      
	}
}
