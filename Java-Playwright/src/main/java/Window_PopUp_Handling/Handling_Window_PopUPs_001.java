package Window_PopUp_Handling;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import Playwright_Practice.DriverSetUP_BrowserLaunch;

public class Handling_Window_PopUPs_001 
{
   Page page;
	@BeforeClass
	public void ApplicationLaunch()
	{
		page=DriverSetUP_BrowserLaunch.DriverSetUP("https://sso.teachable.com/secure/673/identity/sign_up/email");
	}
	@Test(priority = 1)
	public void PopUP_Window_01()
	{
		    Page PopUp=page.waitForPopup(()-> {
			page.locator("text=Privacy Policy").nth(0).click();
		});
		    
		PopUp.locator("#header-sign-up-btn").click();
		PopUp.locator("//input[@id='name']").fill("PATHAKAMURI ASHOK KUMAR");
		PopUp.close();
	}
	@Test(priority = 2)
	public void PopUP_Window_02()
	{
		page.waitForLoadState(LoadState.LOAD);
		
		    Page PopUp1=page.waitForPopup(()-> {
			page.locator("(//a[text()='Privacy Policy'])[2]").click();
		});
		    Page PopUp2=PopUp1.waitForPopup(()-> {
		    	PopUp1.locator("//a[@data-wf-element-id='42095de0-f1cc-82cc-8f8c-c52990d42f63']").click();
			});
		PopUp2.waitForLoadState(LoadState.LOAD);
		PopUp2.locator("(//span[text()='OK'])[1]").click();
		
		PopUp1.close();
		PopUp2.close();
	}
	@AfterClass
	public void Cloe()
	{
		DriverSetUP_BrowserLaunch.Close();
	}
}
