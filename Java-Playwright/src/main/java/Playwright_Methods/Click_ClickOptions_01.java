package Playwright_Methods;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.regex.Pattern;


public class Click_ClickOptions_01 
{
	Playwright playwright;
	Browser browser;
	Page page;
		
      @Test (priority = 1)
      public void BrowserLaunch() {
    	  
    	   playwright=Playwright.create();
    	  
    	   browser= playwright.chromium().launch(new LaunchOptions().setHeadless(false)); 
    	 
    	   page=browser.newPage();
      }
      
      @Test(priority = 2)
       public void NavigateToURL()
       {
    	   page.navigate("https://demoqa.com/dynamic-properties");
    	   
    	   assertThat(page).hasURL("https://demoqa.com/dynamic-properties");
    	   
    	   assertThat(page).hasTitle("DEMOQA");
    	   assertThat(page).hasTitle(Pattern.compile("DEMOQA"));
    	   
       }
      
      @Test
      public void M1()
      {
    	  page.locator("#simpleLink").click();
    	  
      }
      
      @AfterClass
      public void Quit()
      {
    	  page.close();
    	  browser.close();
    	  playwright.close();
      }
}
