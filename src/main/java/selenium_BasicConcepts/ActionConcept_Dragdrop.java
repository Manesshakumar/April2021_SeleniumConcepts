package selenium_BasicConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionConcept_Dragdrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 1.Drag & Drop:

		WebElement draggable = driver.findElement(By.xpath("//div[@id = 'draggable']"));
		WebElement droppable = driver.findElement(By.xpath("//div[@id = 'droppable']"));

		Actions action = new Actions(driver);
		// action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();

		action.dragAndDrop(draggable, droppable).perform();

		
	}
}
