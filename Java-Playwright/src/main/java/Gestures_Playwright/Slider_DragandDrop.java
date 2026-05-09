package Gestures_Playwright;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import Window_PopUp_Handling.DriverSetUP;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Slider_DragandDrop extends DriverSetUP
{
	Page page;
	@BeforeClass
	public void m()
	{
		page=application_Launch("chrome", "https://jqueryui.com/resources/demos/slider/default.html");
		assertThat(page).hasTitle("jQuery UI Slider - Default functionality");
	}
	@Test(priority = 1)
	public void Slider() throws InterruptedException {
	
	   Locator slider=page.locator("#slider");
	   
	   page.mouse().move(slider.boundingBox().x+slider.boundingBox().width/2, slider.boundingBox().y+slider.boundingBox().height/2);  
       page.mouse().down();
       Thread.sleep(5000);
       page.mouse().move(slider.boundingBox().x/2, slider.boundingBox().y/2);  
       Thread.sleep(5000);
       page.mouse().move(1000,1000);  
       Thread.sleep(5000);
       page.mouse().up();
	  
	}
	@AfterClass
	public void Qut()
	{
		Close();
	}
}
