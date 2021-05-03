package selenium_BasicConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInitialization_Chrome {
	
	static WebDriver driver;

	public static void main(String[] args) {
		String browser = "Firefox";
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get("http:\\www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
		

	}

}
