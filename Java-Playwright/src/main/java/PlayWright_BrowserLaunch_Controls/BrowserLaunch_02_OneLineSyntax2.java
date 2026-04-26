package PlayWright_BrowserLaunch_Controls;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserLaunch_02_OneLineSyntax2 {

	public static void main(String[] args) throws InterruptedException {
		
	   Playwright playwright=Playwright.create();
	   Page page=playwright.chromium().launch(new LaunchOptions().setHeadless(false)).newPage();
		
		page.navigate("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
		Thread.sleep(5000); 
		
		page.close();
		playwright.close();
		
	}
}
