package Gestures_Playwright;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.options.LoadState;
import Window_PopUp_Handling.DriverSetUP;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Handling_MouseOver extends DriverSetUP {
	Page page;

	@BeforeClass
	public void Launch() {
		page = application_Launch("chrome", "https://www.testmuai.com/selenium-playground/");
		assertThat(page).hasTitle("Selenium Grid Online | Run Selenium Test On Cloud");

	}

	/*
	 * Below method will help to click on the "Hover Demo"
	 */
	@Test(priority = 1)
	public void GoTo_HoverDemo() {

		page.getByText("Hover Demo").click();
		page.waitForLoadState(LoadState.LOAD);
		assertThat(page).hasTitle("Selenium Playground | TestMu AI (Formerly LambdaTest)");
	}
	// CSS Hover Effects on Button

	/**
	 * Below Method help us to get the locator background color before and after
	 * mouse over
	 */
	@Test(priority = 2)
	public void Hover_Me_Validate() {
		System.out.println("======================= Hover_Me_Validate =============================");
		String beforeBgColor = page.getByText("Hover Me").first().evaluate("e=>getComputedStyle(e).backgroundColor")
				.toString();
		System.out.println("background Color before Mouse Over :" + beforeBgColor);

		page.getByText("Hover Me").first().hover();

		String AfterBgColor = page.getByText("Hover Me").first().evaluate("e=>getComputedStyle(e).backgroundColor")
				.toString();
		System.out.println("background Color AFTER Mouse Over :" + AfterBgColor);

		if (!beforeBgColor.equals(AfterBgColor)) {
			System.out.println("mouse over is Done");
		} else {
			System.out.println("mouse over is NOT Done");
		}

	}

	/**
	 * Below Method help us to validate the tool tip when mouse over on the image
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void Validate_ToolTip_MouseOver() throws InterruptedException {
		page.locator("(//img[@alt='Image'])[1]").hover();
		Locator tooltip = page.locator("//p[text()='Hover']");

		assertThat(tooltip).isVisible();
		assertThat(tooltip).containsText("Hover");
		

	}

	/**
	 * Below Method help us to validate the ZOOM IN when mouse over on the image
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 4)
	public void Validate_ScreenZoom_in_MouseOver() throws InterruptedException {
		System.out.println("======================= Validate_ScreenZoom_in_MouseOver =============================");

		Locator image = page.locator("(//img[@alt='Image'])[2]");

		double Before_width = image.boundingBox().width;
		double Before_height = image.boundingBox().height;

		System.out.println(" Before_width " + Before_width + " Before_height " + Before_height);

		String Before_MouseOver = page.locator("(//img[@alt='Image'])[2]").evaluate("e=>getComputedStyle(e).transform")
				.toString();
		System.out.println(Before_MouseOver);

		image.hover();

		String After_MouseOver = page.locator("(//img[@alt='Image'])[2]").evaluate("e=>getComputedStyle(e).transform")
				.toString();
		System.out.println(Before_MouseOver);

		double After_width = image.boundingBox().width;
		double After_height = image.boundingBox().height;

		System.out.println(" After_width " + After_width + " After_height " + After_height);

		if (!Before_MouseOver.equals(After_MouseOver)) {
			System.out.println("mouse over is Done");
		} else {
			System.out.println("mouse over is NOT Done");
		}
		
	}

	/**
	 * Below Method help us to validate the ZOOM OUT when mouse over on the image
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void Validate_ScreenZoom_Out_MouseOver() throws InterruptedException {
		System.out.println("======================= Validate_ScreenZoom_Out_MouseOver =============================");

		Locator image = page.locator("(//img[@alt='Image'])[3]");

		double Before_width = image.boundingBox().width;
		double Before_height = image.boundingBox().height;
		System.out.println(" Before_width " + Before_width + " Before_height " + Before_height);

		image.hover();

		double After_width = image.boundingBox().width;
		double After_height = image.boundingBox().height;

		System.out.println(" After_width " + After_width + " After_height " + After_height);

		if (!(Before_width == (After_width)) || !(Before_height == After_height)) {
			System.out.println("mouse over is Done");
		} else {
			System.out.println("mouse over is NOT Done");
		}
	}

	/**
	 * Below Method help us to validate the Screen PAN when mouse over on the image
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 6)
	public void Validate_Screen_PAN_MouseOver() throws InterruptedException {
		System.out.println("======================= Validate_Screen_PAN_MouseOver =============================");

		Locator image = page.locator("(//img[@alt='Image'])[4]");  
		double Before_x = image.boundingBox().x;
		double Before_y = image.boundingBox().y;
		
		System.out.println(" Before X " + Before_x + " Before Y " + Before_y);

		
		image.hover();
		double After_x = image.boundingBox().x;
		double After_y = image.boundingBox().y;

		System.out.println(" After X " + After_x + " After Y " + After_y);

		if (!(Before_x == (After_x)) || !(Before_y == After_y)) {
			System.out.println("mouse over is Done");
		} else {
			System.out.println("mouse over is NOT Done");
		}
	}

	@Test(priority = 7)
	public void Validate_Screen_Blur_MouseOver() throws InterruptedException {
		System.out.println("======================= Validate_Screen_BLUR_MouseOver =============================");

		Locator image = page.locator("(//img[@alt='Image'])[6]");

		// String Rotate_Before_MouseOver=image.evaluate("e =>getComputedStyle(e).filter").toString();
		String Rotate_Before_MouseOver = image.evaluate("e => getComputedStyle(e).transform").toString();
		System.out.println(Rotate_Before_MouseOver);

		image.hover();

		// String After_Before_MouseOver=image.evaluate("e =>getComputedStyle(e).filter").toString();
		String After_Before_MouseOver = image.evaluate("e => getComputedStyle(e).transform").toString();
		System.out.println(After_Before_MouseOver);

		if (!Rotate_Before_MouseOver.equals(After_Before_MouseOver)) {
			System.out.println("mouse over is Done");
		} else {
			System.out.println("mouse over is NOT Done");
		}
	}

	@AfterClass
	public void Quite() {
		Close();
	}
}
