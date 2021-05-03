package selenium_AdvancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium_BasicsFramework.ElementUtil;

public class CustomWait {
	
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();
		
		ElementUtil elementUtil = new ElementUtil(driver);		
		By username = By.name("username");
		elementUtil.retryingElement(username).sendKeys("batchautomation");;
	}
	
	public static WebElement retryingElement(By Locator) {
		
		WebElement element= null;
		
		int attempt = 0;
		
		while(attempt<50){
			
			try {
				element = driver.findElement(Locator);
				break;
			}catch (NoSuchElementException e) {
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {					
					e1.printStackTrace();
				}
				
			}catch (StaleElementReferenceException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {					
					e1.printStackTrace();
				}
			}
			
			System.out.println("Element is not Visible " + (attempt+1));
			
			attempt++;			
		}
		
		return element;
	}

}
