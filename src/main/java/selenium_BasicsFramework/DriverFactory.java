package selenium_BasicsFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This is used to initialize the Driver & return the driver itself
 * @author user
 * @param browserName
 *
 */

public class DriverFactory {
	
	private WebDriver driver;
	
	public WebDriver init_driver(String browserName) {
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
	}else {
		System.out.println("Please pass driver");
	}
		
		return driver;
	}
	
	
	public void launchUrl(String url) {
		driver.get(url);
	}
	
}
