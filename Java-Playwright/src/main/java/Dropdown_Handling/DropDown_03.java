package Dropdown_Handling;

import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;

public class DropDown_03 {

	Playwright playwright;
	BrowserType browsertype;
	LaunchOptions options;
	Browser browser;
	BrowserContext context;
	static Page page;  
	
	
	public Page BrowserLaunch()
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
	public void LoadApplication(String URL)
	{
		page.navigate(URL);
		//page.navigate("https://www.wikipedia.org/");
		page.waitForLoadState(LoadState.LOAD); 
		String url=page.url();
		if (URL.equals(url)) {
			System.out.println("Application launch sucssfully");
		} else {
        System.out.println("Application NOT launch sucssfully");
		}		
	}
	public void HandleDropdown_001()
	{
		page.locator("#searchLanguage").selectOption("Svenska"); 
		page.reload();
		page.waitForLoadState(LoadState.LOAD);  
	}
	
	public void HandleDropdown_setLabel()
	{
		page.locator("#searchLanguage").selectOption(new SelectOption().setLabel("Latviešu"));
		page.reload();
		page.waitForLoadState(LoadState.LOAD); 
	}
	public void HandleDropdown_setIndex()
	{
		page.locator("#searchLanguage").selectOption(new SelectOption().setIndex(10));
		page.reload();
		page.waitForLoadState(LoadState.LOAD);
	}
	public void HandleDropdown_setValue()
	{
		page.locator("#searchLanguage").selectOption(new SelectOption().setValue("yue"));
		page.reload();
		page.waitForLoadState(LoadState.LOAD); 
	}
	
	public void Close()
	{
		page.close();
		playwright.close();
		System.out.println(" Closed !!!!! ");
		
	}
	
	
	public static void main(String[] args) {
		
		
		DropDown_03 d=new DropDown_03(); 
		
		d.BrowserLaunch();
		d.LoadApplication("https://www.wikipedia.org/");
		System.out.println(" 1");
		d.HandleDropdown_001();
		System.out.println(" 2");
		d.HandleDropdown_setIndex();
		System.out.println(" 3");
		d.HandleDropdown_setLabel();
		System.out.println(" 4");
		d.HandleDropdown_setValue();
		System.out.println(" 5");
		d.Close();

	}

}
