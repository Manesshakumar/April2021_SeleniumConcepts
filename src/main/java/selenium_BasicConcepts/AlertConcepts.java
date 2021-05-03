package selenium_BasicConcepts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertConcepts {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		WebElement btn1 = driver.findElement(By.xpath("//button[text() = 'Click for JS Alert']"));
		WebElement btn2 = driver.findElement(By.xpath("//button[text() = 'Click for JS Confirm']"));
		WebElement btn3 = driver.findElement(By.xpath("//button[text() = 'Click for JS Prompt']"));
		
		btn1.click();
		Alert alert = driver.switchTo().alert();
		String btn1text = alert.getText();
		System.out.println(btn1text);
		alert.accept();
		driver.switchTo().defaultContent();
		
		String result = driver.findElement(By.xpath("//div[@class = 'example']/p[@id = 'result']")).getText();
		
		btn2.click();
		alert.dismiss();
	
		
	}

}
