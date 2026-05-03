package Screenshot_Playwright;

import java.nio.file.Paths;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;

import Playwright_Practice.DriverSetUP_BrowserLaunch;

public class Screenshot_01 {

	   Page page;
	   
	   String dir=System.getProperty("user.dir"); 
	   String path=dir+"\\src\\main\\resources\\Screenshots\\";
	   
	   @BeforeClass
	   public void ApplicationLaunch()
	   {
		   page=DriverSetUP_BrowserLaunch.DriverSetUP("https://www.way2automation.com/");
	   }
	  
		@Test(priority = 1)
		public void Screen_shot_001() throws InterruptedException
		{
		  
		   page.screenshot(new ScreenshotOptions().setPath(Paths.get(path+"HomePage.png"))); 
		}
		@Test(priority = 2)
		public void Method_01()
		{	
			page.locator("#menu-item-27580").hover();
			page.screenshot(new ScreenshotOptions().setPath(Paths.get(path+"Mouse Over_Method_01.png")));
			
		} 
		@Test(priority = 3)
		public void Method_02()
		{
			ScreenshotOptions options=new ScreenshotOptions();
			options.setPath(Paths.get(path+"MouseOver_Method_02.png"));
			
			page.locator("#menu-item-27580").hover();
			page.screenshot(options);
		}   
		@Test(priority = 4)
		public void Method_03_With_Element()
		{
			page.locator("#menu-item-27617").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(path+"Method_03_With_Element.png")));
		
		}
		@Test(priority = 5)
		public void Method_04_With_Element()
		{
			Locator.ScreenshotOptions options = new Locator.ScreenshotOptions();
			options.setPath(Paths.get(path + "Method_04_With_Element_Element Screenshort.png"));

			Locator locator = page.locator("#menu-item-27617");
			locator.screenshot(options);
		}
	   @AfterClass
	   public void Close()
	   {
		   DriverSetUP_BrowserLaunch.Close();
	   }
	
}
