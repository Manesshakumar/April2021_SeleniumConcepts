package selenium_BasicConcepts;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionConcept_RightClick {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();

		WebElement rightClickEle = driver.findElement(By.xpath("//span[text() = 'right click me']"));

		Actions action = new Actions(driver);
		action.contextClick(rightClickEle).perform();

		//Get the Text from Context menu:
		List<WebElement> contextList = driver.findElements(By.xpath("//ul[@class = 'context-menu-list context-menu-root']/li/span"));

		System.out.println(contextList.size());
		
		for(WebElement x : contextList) {
			String val = x.getText();
			System.out.println(val);
			if(val.equals("Cut")) {
				x.click();
				break;
			}
		}
		
		//Alert Operation:
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	





	}

}
