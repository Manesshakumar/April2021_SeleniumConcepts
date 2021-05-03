package BasicConcepts_TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Inheritance_Application extends BaseTest{
	
	
	@BeforeClass
	public void launchUrl() {
		driver.get("https://www.amazon.in/");
	}
	
	@Test(priority = 1)
	public void titleCheck() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	@Test(priority = 2)
	public void logoDisplayCheck() {
		Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());
	}
	
	@Test(priority = 3)
	public void searchEntryCheck() {
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Phone");;
	}

}
