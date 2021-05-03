package selenium_BasicConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("search_query_top")).sendKeys("T-Shirt");
		Thread.sleep(3000);

		// List<WebElement> list = driver.findElements(By.xpath("//div[@class =
		// 'ac_results']//li"));
		// System.out.println(list.size());
		//
		// for(WebElement e :list) {
		// String text = e.getText();
		// System.out.println(text);
		// if(text.equals("T-shirts > Faded Short Sleeve T-shirts")) {
		// e.click();
		// break;
		// }
		// }

		System.out.println("******Generic Func Calling***********");
		By suggestionValue = By.xpath("//div[@class = 'ac_results']//li");
		doselectFromSuggestionList(suggestionValue, "T-shirts > Faded Short Sleeve T-shirts");

	}

	// Generic Function:
	public static void doselectFromSuggestionList(By locator, String Value) {
		List<WebElement> list = driver.findElements(locator);
		System.out.println(list.size());

		for (WebElement e : list) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(Value)) {
				e.click();
				break;
			}
		}
	}
}
