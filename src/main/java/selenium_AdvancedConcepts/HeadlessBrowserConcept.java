package selenium_AdvancedConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowserConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		//option.addArguments("--incognito");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());

	}

}
