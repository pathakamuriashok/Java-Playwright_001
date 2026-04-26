package NavigationMethods;

import java.util.ArrayList;
import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NavigationMethods_01 {

	/*
	 * | Method                | Purpose                          |
| --------------------- | -------------------------------- |
| `navigate()`          | Open URL                         |
| `goBack()`            | Previous page                    |
| `goForward()`         | Next page                        |
| `reload()`            | Refresh page                     |
| `waitForURL()`        | Wait for URL change              |
| `waitForLoadState()`  | Wait for page load               |
| `url()`               | Get current URL                  |
| `waitForNavigation()` | Wait for navigation after action |

	 */
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright=Playwright.create();
		
		BrowserType type=playwright.chromium();
		
		LaunchOptions options=new LaunchOptions();
		options.setHeadless(false);
		options.setArgs(Arrays.asList("--start-maximized"));
		
		/*
		 * We can do Multiple setArgs
		 */
	//	options.setArgs(Arrays.asList("--start-maximized","--start-fullscreen","--start-fullscreen"));
	
		/*
		 * We can create ArrayList and we can add all setArgs there and simple can pass array object Like below
		 
		ArrayList<String> al=new ArrayList<String>();
		al.add("--start-maximized");al.add("--start-fullscreen");al.add("--window-size=1920,1080");al.add("--disable-web-security");
		al.add("--ignore-certificate-errors");
		
		options.setArgs(al); 
		
		*/
		
		/**
		 *  "--start-maximized"
			"--start-fullscreen"
			"--window-size=1920,1080"
			"--disable-web-security"
			"--ignore-certificate-errors"
			"--allow-running-insecure-content"
			"--disable-notifications"
			"--disable-infobars"
			"--disable-extensions"
			"--disable-popup-blocking"
			"--disable-dev-shm-usage"
			"--no-sandbox"
			"--disable-gpu"
						
		 */
		
		
		Browser browser=type.launch(options);
		
		BrowserContext context1=browser.newContext(new Browser.NewContextOptions().setViewportSize(null)); 
	
		Page page=context1.newPage();
		
        page.navigate("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
        page.waitForLoadState();
        System.out.println(page.title());
        System.out.println(page.url());
        
        
        page.navigate("https://github.com/");
        page.waitForLoadState();
        System.out.println(page.title());
        System.out.println(page.url());
        
       
        page.goForward();
        page.waitForLoadState();
        page.waitForURL("https://github.com/");
        System.out.println(page.title());
       
        
        page.reload();
        page.waitForLoadState();
        System.out.println(page.title());
        System.out.println(page.url());
       
       
        page.goBack();
        page.waitForLoadState();
        System.out.println(page.title());
        System.out.println(page.url());
		
		
		
		page.close();
		playwright.close();

	}

}
