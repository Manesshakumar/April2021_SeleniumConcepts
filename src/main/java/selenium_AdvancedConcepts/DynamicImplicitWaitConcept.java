package selenium_AdvancedConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicImplicitWaitConcept {
	

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/**
		 * Implicit wait ---> only for WebElements not for other WebElements.
		 */
		
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.name("proceed")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();
		
		List<WebElement> headLineList = driver.findElements(By.xpath("//div[@id = 'top_news_container']/ul/li[2]/a"));
           System.out.println(headLineList.size());
           
           

           
	}

}
