package PlayWright_BrowserLaunch_Controls;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Browser_Maximizing {

	
	/**
	 * Providing the Page size dynamically , it's not good Practice
	 * @throws InterruptedException
	 */
	public void Mazimizing_001() throws InterruptedException
	{
		Playwright playwright=Playwright.create();
		
		BrowserType type=playwright.chromium();
		
		LaunchOptions options=new LaunchOptions();
		options.setHeadless(false); 
		
		Browser browser=type.launch(options);
		
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(1970, 970)); 
		
		Page page=context.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
		
		Thread.sleep(5000);
		page.close();
		playwright.close();
		
	}
	/**
	 * We are not going to pass the size directly, but we are using method called setArgs and saying that get the maximum height and width
	 * This is good practice 
	 * @throws InterruptedException
	 */
	public void Mazimizing_002() throws InterruptedException
	{
		Playwright playwright=Playwright.create();
		
		BrowserType type=playwright.chromium();
		
		LaunchOptions options=new LaunchOptions();
		options.setHeadless(false);
		options.setArgs(Arrays.asList("--start-maximized"));
		
		Browser browser=type.launch(options);
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null)); 
		
		Page page=context.newPage();
		
		page.navigate("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
		
		Thread.sleep(5000);
		page.close();
		playwright.close();
	}
	
	/**
	 * We are using Java Interface called Dimension to identifying the height and Width and passing in playwright script
	 * This is also good practice but second method will be highly  preferable 
	 * @throws InterruptedException
	 */
	public void Mazimizing_003()throws InterruptedException
	{
		Playwright playwright=Playwright.create();
		
		BrowserType type=playwright.chromium();
		
		LaunchOptions option=new LaunchOptions();
		option.setHeadless(false);
		
		Browser browser=type.launch(option);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		System.out.println(width+"---"+height);
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setScreenSize((int) width, (int)height));  
		Page page=context.newPage();
		
        page.navigate("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
		
		Thread.sleep(5000);
		page.close();
		playwright.close();
	}
	public static void main(String[] args) throws InterruptedException {
		
		Browser_Maximizing b=new Browser_Maximizing();
		b.Mazimizing_001();
		b.Mazimizing_002(); 
		b.Mazimizing_003();

	}

}
