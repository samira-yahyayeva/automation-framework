package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Page;

public class BaseTests {

	private static WebDriver webDriver;
	protected static Page homePage;

	@BeforeClass
	public static void launchApplication(){
		setChromeDriverProperty();
		webDriver = new ChromeDriver();
		webDriver.get(Links.HOME);
		homePage = new Page(webDriver);
	}

	@AfterClass
	public static void closeBrowser(){
		webDriver.quit();
	}

	public static WebDriver getWebDriver(){
		return webDriver;
	}

	private static void setChromeDriverProperty(){
		if(System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		}
		else{
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		}
	}
}
