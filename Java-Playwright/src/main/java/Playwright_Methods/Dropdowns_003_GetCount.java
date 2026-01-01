package Playwright_Methods;
        
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
        
public class Dropdowns_003_GetCount 
{       
	     Page page;
	    Dropdowns_003_GetCount()
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
			Locator dropdown=page.locator("select#select-demo");
			
			Locator allOptions=dropdown.locator("option");
			
			System.out.println(" allOptions :"+allOptions);
			System.out.println(" ------------------------- =============="); 
			System.out.println(" allOptions.count :"+allOptions.count());
			System.out.println(" ------------------------- "); 
			
			List<String> states=allOptions.allInnerTexts();
			
			System.out.println(" states :");
			System.out.println(states);
			
			states.forEach(AKState ->System.out.println(AKState)); 
			System.out.println("]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
			 for (String string : states) {
				System.out.println(states);
			}		
		}		
}       