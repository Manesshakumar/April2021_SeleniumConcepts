package selenium_BasicConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("main");
		String headerTitle = driver.findElement(By.xpath("//h2[text() ='Title bar ']")).getText();
		System.out.println(headerTitle);
	}

}
