package Playwright_Methods;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.*;

//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Playwright;
//import com.microsoft.playwright.BrowserType.LaunchOptions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Dropdown_002_MultiSelect {
	
	 Page page;
	   Dropdown_002_MultiSelect()
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
			Locator multiselect_DropDown=page.locator("select#multi-select");
			
			String[] selected_States=new String[] {"New Jersey","Texas"};    
			
			multiselect_DropDown.selectOption(selected_States); 
			
			Thread.sleep(10000); 
		}
		
		@Test(priority=3)
		public void Dropdown_02() throws InterruptedException
		{
			page.reload();
			
            Locator multiselect_DropDown=page.locator("select#multi-select");
			
			multiselect_DropDown.selectOption(new String[] {"New Jersey","Pennsylvania","Ohio"});
			
			Thread.sleep(10000); 
		}
		
		@AfterClass
		public void quit()
		{
			page.close();
		}
		

}
