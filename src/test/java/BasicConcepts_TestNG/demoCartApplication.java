package BasicConcepts_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoCartApplication {
	
         WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void titleCheck() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Your Store");
	}
	
	@Test(priority = 2)
	public void logoDisplayCheck() {
		Assert.assertTrue(driver.findElement(By.id("logo")).isDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
