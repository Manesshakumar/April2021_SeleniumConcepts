package selenium_AdvancedConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicExplicitWaitConcept {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
	
		/**
		 * Explicit wait --> Dynamic wait,for specific WebElement.
		 */
		
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		
		By suggestionList = By.xpath("//div[@class = 'ac_results']/ul/li");	
		WebDriverWait wait = new WebDriverWait(driver,5);
		List<WebElement> optionList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestionList));
		System.out.println(optionList.size());
		
		for(WebElement x:optionList) {
			String suggestion = x.getText();
			System.out.println(suggestion);
			if(suggestion.contains("Blouse")) {
				x.click();
			}
		}
		
		
		

	}

}
