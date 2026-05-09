package Gestures_Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import Window_PopUp_Handling.DriverSetUP;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Resizable_Window extends DriverSetUP {

	Page page;
	@BeforeClass
	public void m()
	{
		page=application_Launch("chrome", "https://jqueryui.com/resources/demos/resizable/default.html");
		assertThat(page).hasTitle("jQuery UI Resizable - Default functionality");
	}
	@Test(priority = 1)
	public void Resize() throws InterruptedException {
	
	  Locator L1=page.locator("//*[@id=\"resizable\"]/div[3]");
	  
	
		  page.mouse().move(L1.boundingBox().x+L1.boundingBox().width/2,L1.boundingBox().y+L1.boundingBox().height/2);
		  page.mouse().down();
	
		  page.mouse().move(L1.boundingBox().x+L1.boundingBox().width+500,L1.boundingBox().y+L1.boundingBox().width+500);
		  Thread.sleep(5000);  
		  page.mouse().move(L1.boundingBox().x+L1.boundingBox().height+500,L1.boundingBox().y+L1.boundingBox().height+500);
		  Thread.sleep(5000);  
		  page.mouse().move(L1.boundingBox().x+L1.boundingBox().width+500,L1.boundingBox().y+L1.boundingBox().width+500);
	      page.mouse().up();
	      Thread.sleep(5000);  
	}
	@AfterClass
	public void Qut()
	{
		Close();
	}
}
