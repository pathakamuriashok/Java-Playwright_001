package Playwright_Methods;

import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Dropdowns_001 
{
    Page page;
	Dropdowns_001()
	{
		page=Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false)).newPage();
		
		
	}
	@Test(priority = 1)
	public void LaunchBrowser()
	{		
		page.navigate("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
	 	assertThat(page).hasURL("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
	    assertThat(page).hasTitle("Selenium Grid Online | Run Selenium Test On Cloud");	
	}
	@Test(priority = 2)
	public void Dropdown_01() throws InterruptedException
	{
		page.locator("select#select-demo").selectOption("Wednesday");
		
		Thread.sleep(2000); 
		
		page.locator("select#select-demo").selectOption("Sunday");
		
		Thread.sleep(2000); 
		
		page.locator("select#select-demo").selectOption("Tuesday");
		
		Thread.sleep(2000); 
		
		page.locator("select#select-demo").selectOption("Saturday");
		
		Thread.sleep(2000); 
		
		page.locator("select#select-demo").selectOption("Monday");
		
		Thread.sleep(2000); 
		
		page.locator("select#select-demo").selectOption("Friday");
	}
	@Test(priority = 3)
	public void Dropdown_02() throws InterruptedException
	{
		Locator locater=page.locator("select#select-demo");
		
		locater.selectOption("Saturday"); 
		
		Thread.sleep(5000); 
	
	}
	@Test(priority = 4)
	
	public void Dropdown_03() throws InterruptedException
	{
		
		Locator locater=page.locator("select#select-demo");
		
        locater.selectOption(new SelectOption().setIndex(3));
        
        Thread.sleep(2000); 
        
        locater.selectOption(new SelectOption().setLabel("Friday")); 
		
		Thread.sleep(5000);   
	}
    @Test(priority = 5)
	
	public void Dropdown_04() throws InterruptedException
	{
    	System.out.println("In Dropdown 4 A");
    	Locator locater=page.locator("select#select-demo");
    	System.out.println("In Dropdown 4 B ");
    	SelectOption option=new SelectOption();  
    	System.out.println("In Dropdown 4 C");
    	locater.selectOption(option.setIndex(4));  
    	System.out.println("In Dropdown 4 D");
    	locater.selectOption(option.setLabel("Tuesday"));  
    	System.out.println("In Dropdown 4 E");
    	locater.selectOption(option.setValue("Saturday"));     
    	System.out.println("In Dropdown 4 F");
    	

    	/**
    	 *  ❌ Common Mistakes (Important)
			❌ Reusing Same SelectOption Object

			SelectOption option = new SelectOption();
			locator.selectOption(option.setIndex(4));  --> This will work 
			locator.selectOption(option.setValue("Saturday")); // ❌ risky   --> this will not work 
			
			👉 Always create a new SelectOption object per selection because  
			
			Playwright ❌ does not use: new Select(webElement); // ❌
    	 */
	}
    
	@AfterClass
	public void quit()
	{
		page.close();
	}
		
}
