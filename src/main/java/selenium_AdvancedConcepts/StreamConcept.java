package selenium_AdvancedConcepts;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.name("proceed")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();
		
		List<WebElement> headLineList = driver.findElements(By.xpath("//div[@id = 'top_news_container']/ul/li[2]/a"));
           System.out.println(headLineList.size());
           
           //Seq Stream
           
           System.out.println(System.currentTimeMillis());           
           headLineList.stream().forEach(x-> System.out.println(x.getText()));           
           System.out.println(System.currentTimeMillis());
           
           System.out.println("**********************");
           
           //Parallel Stream
           
           System.out.println(System.currentTimeMillis());          
           headLineList.parallelStream().forEach(x-> System.out.println(x.getText()));          
           System.out.println(System.currentTimeMillis());

	}

}
