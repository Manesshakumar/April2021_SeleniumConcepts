package selenium_BasicConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/open-source/demo/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		//		driver.navigate().to("https://classic.crmpro.com/");
		//		driver.navigate().back();
		//		driver.navigate().forward();


		//1st Approach:
		//		driver.findElement(By.id("Form_submitRequest_FirstName")).sendKeys("Sid");
		//		driver.findElement(By.id("Form_submitRequest_LastName")).sendKeys("Arjun");
		//		driver.quit();

		//2nd Approach:
		//		WebElement firstName = driver.findElement(By.id("Form_submitRequest_FirstName"));
		//		firstName.sendKeys("Sheraya");

		//3rd Approach:
//		By firstName = By.id("Form_submitRequest_FirstName");
//		driver.findElement(firstName).sendKeys("Sheraya");

		//4th Approach:
//		By firstName = By.id("Form_submitRequest_FirstName");
//		getElement(firstName).sendKeys("Shreya");

		
		//5th approach:
		By firstName = By.id("Form_submitRequest_FirstName");
		By submit_btn = By.linkText("Services");
		doSendKeys(firstName, "Shreya");
		doClick(submit_btn);
	}

	//Create Generic Functions:
	public static WebElement  getElement(By locator) {
		return driver.findElement(locator);

	}
	public static void doSendKeys(By locator,String Value) {
		getElement(locator).sendKeys(Value);

	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}

}
