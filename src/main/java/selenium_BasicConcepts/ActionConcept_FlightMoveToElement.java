package selenium_BasicConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionConcept_FlightMoveToElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		WebElement loginEle = driver.findElement(By.xpath("//a[text()= 'Login / Signup' and @id = 'ctl00_HyperLinkLogin']"));
		WebElement SpiceclubEle = driver.findElement(By.xpath("//a[text() ='SpiceClub Members']"));
		WebElement SignupEle = driver.findElement(By.xpath("//a[text() ='Sign up']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(loginEle).moveToElement(SpiceclubEle).build().perform();
		Thread.sleep(2000);
	//	action.moveToElement(SpiceclubEle).perform();
	//	Thread.sleep(2000);
		SignupEle.click();
		

		
		
		
		
		
		
	}

}
