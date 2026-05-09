package Window_PopUp_Handling;

import java.nio.file.Paths;

import java.util.Arrays;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DriverSetUP {
	static Playwright playwright;

	static Browser browser;
	static BrowserContext context;
	static Page page;
	static String DirPath = System.getProperty("user.dir");
	static String Path_Evidence = DirPath+"\\src\\main\\resources\\Screenshots\\";

	public static Page Driver(String BrowerName) {
		System.out.println(Path_Evidence);  
		playwright = Playwright.create();
		BrowserType type;
		LaunchOptions Launch_options = launchOptions();
		Browser.NewContextOptions newcontextoptions = Newcontextoptions();

		switch (BrowerName.toLowerCase()) {
		case "chromium":
			type = playwright.chromium();
			break;
		case "webkit":
			type = playwright.webkit();
			
			break;
		case "firefox":
			type = playwright.firefox();
		case "chrome" :
					
		default:
			type = playwright.chromium();
		
			break;
		}
		browser = type.launch(Launch_options);
		context = browser.newContext(newcontextoptions);
		page = context.newPage();
		
		return page;
	}

	public static LaunchOptions launchOptions() {
		LaunchOptions options = new LaunchOptions();
		options.setHeadless(false);
		options.setArgs(Arrays.asList("--start-maximized"));
		return options;
	}

	public static Browser.NewContextOptions Newcontextoptions() {
		Browser.NewContextOptions newcontextoptions = new Browser.NewContextOptions();
		newcontextoptions.setViewportSize(null);
		newcontextoptions.setRecordVideoDir(Paths.get(Path_Evidence+"Video"));
		return newcontextoptions;
	}

	public static Page application_Launch(String BrowserName, String URL) {
		System.out.println("BrowserName : "+BrowserName); 
		System.out.println("URL : "+URL); 
		page = Driver(BrowserName);
		page.navigate(URL);
		page.waitForLoadState(LoadState.LOAD);
		assertThat(page).hasURL(URL);
		return page;
	}
	
	public static void Close()
	{
		page.close();
		context.close();
		browser.close();
		playwright.close();
	}
}