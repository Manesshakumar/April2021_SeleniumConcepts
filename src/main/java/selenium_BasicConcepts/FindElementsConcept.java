package selenium_BasicConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		// 1.Find No of Links available:
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());

		// 2.Print the Text of Each link: by using for-each loop:
		// for(WebElement e : list) {
		// String text = e.getText();
		// if(!text.isEmpty()) {
		// System.out.println(text);
		// }
		// }

		// 2.Print the Text of Each link: by using for loop & get the attribute of href

		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();

			if (!text.isEmpty()) {
				System.out.println(i + "-->" + text);
				System.out.println(list.get(i).getAttribute("href"));
			}
		}

		By links_amazon = By.tagName("a");

		System.out.println("*************Called via Generic Function**************");

		List<WebElement> amazonLinks = getElements(links_amazon);
		System.out.println(amazonLinks.size());

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
