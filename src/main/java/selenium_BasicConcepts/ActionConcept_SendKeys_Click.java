package selenium_BasicConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionConcept_SendKeys_Click {

	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		By firstname = By.name("firstname");
		By searchbtn = By.xpath("//button[@class = 'btn btn-default btn-lg']");
		
		doActionSendKeys(firstname, "Shreya");
		doActionClick(searchbtn);
		
		
		
	}
	
	//To Handle ElementInteractException 
	
	public static void doActionSendKeys(By locator,String Value) {
		Actions action = new Actions(driver);
		action.sendKeys(driver.findElement(locator),Value).perform();
		
	}
	
	public static void doActionClick(By locator) {
		Actions action = new Actions(driver);
		action.click(driver.findElement(locator)).perform();
		
	}

}
