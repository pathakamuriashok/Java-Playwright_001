package Window_PopUp_Handling;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.options.KeyboardModifier;
import com.microsoft.playwright.options.LoadState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Handling_Window_PopUp_002 extends DriverSetUP {
	
	Page page;
	@BeforeClass
	public void OpenApplication() {
		page=application_Launch("chromium", "https://www.testmuai.com/selenium-playground/window-popup-modal-demo/");
		assertThat(page).hasTitle("Selenium Grid Online | Run Selenium Test On Cloud");
		page.screenshot(new ScreenshotOptions().setPath(Paths.get(Path_Evidence+"Selenium Grid Online Run Selenium Test On Cloud Application Launch.png")));
	}

	@Test(priority = 1)
	public void OpenTwitterWindow() {
	
		/*Page PopUp_Twitter = page.waitForPopup(new Page.WaitForPopupOptions().setTimeout(10000),() -> {
		//	 page.getByText("Follow On Twitter").click(new Locator.ClickOptions().setModifiers(Arrays.asList(KeyboardModifier.CONTROL)));
			page.getByText("Like us On Facebook").click();
		// 
		});
		*/

	//	Page PopUp_Twitter = page.waitForPopup(new Page.WaitForPopupOptions().setTimeout(10000),() -> {
		Page PopUp_Twitter = page.waitForPopup(() -> {
			page.getByText("Like us On Facebook").click();
		
		});
		boolean a=page.locator("").isVisible();  
		boolean b=page.locator("").isHidden(); 
		page.locator("").isDisabled();
		page.locator("").isChecked();
		page.locator("").uncheck();
		page.locator("").isEditable();
		
		
	//	PopUp_Twitter.waitForLoadState();
	//	 System.out.println("Title :: "+PopUp_Twitter.title());
	//	 System.out.println("URL :: " + PopUp_Twitter.url());
		//PopUp_Twitter.getByText("Create new account").first().click();
//		PopUp_Twitter.waitForLoadState(LoadState.LOAD);
	//	String ss=PopUp_Twitter.title();
	  //  System.out.println(ss);
		/*
		 * * PopUp_Twitter.waitForLoadState(LoadState.LOAD);
		 * 
		 * System.out.println("Title :: "+PopUp_Twitter.title());
		 * System.out.println("URL :: " + PopUp_Twitter.url());
		 */
		 
	//	page.screenshot(new ScreenshotOptions().setPath(Paths.get(Path_Evidence+"Twitter.png")));
		try {
			page.getByText("Create new account").first().click();
			System.out.println("From Try");
		} catch (Exception e) {
			page.locator("//*[text()='Create new account']").first().click();
			System.out.println("From Catch");
		}
	//	assertThat(page).hasTitle("TestMu AI | Facebook");
	//	PopUp_Twitter.locator("//*[text()='Log in']").click();
		page.screenshot(new ScreenshotOptions().setPath(Paths.get(Path_Evidence+"Login.png")));
	}

	@AfterClass
	public void close() {
		page.close();
		browser.close();
		context.close();
		playwright.close();
	}
}