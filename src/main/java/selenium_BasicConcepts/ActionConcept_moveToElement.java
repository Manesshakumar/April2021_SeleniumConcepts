package selenium_BasicConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionConcept_moveToElement {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		driver.manage().window().maximize();

		WebElement headerDropdown = driver.findElement(By.xpath("//ul[@class = 'horizontal-list product-menu']/li/a[@title = 'Developers Dropdown']"));
		Actions action = new Actions(driver);
		action.moveToElement(headerDropdown).perform();
		Thread.sleep(3000);

		WebElement documentation =  driver.findElement(By.xpath("//ul[@id = 'developers-menu-dropdown']/li/a[text() = 'Documentation']"));

		//Click:
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", documentation);
		String labels = js.executeScript("return document.documentElement.innerText;").toString();
		System.out.println(labels);

		//doubleClick:
		WebElement doubleClickEle = driver.findElement(By.xpath("//ul[@class = 'sidenav-list-h1']/li/a[@data-name = 'Selenium']"));
		action.doubleClick(doubleClickEle).perform();




	}

}
