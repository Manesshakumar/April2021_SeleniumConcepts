package selenium_BasicConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	
	static WebDriver driver;


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/open-source/demo/");
		driver.manage().window().maximize();
		
		//1.id:
		driver.findElement(By.id("Form_submitRequest_FirstName")).sendKeys("Shraz");
		
		//2.name:
		driver.findElement(By.name("LastName")).sendKeys("Sid");
		
		
		//3.linkText:
		driver.findElement(By.linkText("Services")).click();
		
		Thread.sleep(3000);
		
		//4.partialLinkText():
		driver.findElement(By.partialLinkText("Premier Open")).click();
		
		//5.xpath:
		String text = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/h1")).getText();
		System.out.println(text);
		
		//6.CSS Selector
		driver.findElement(By.cssSelector("#header-navbar > ul.nav.navbar-nav.navbar-right.extended-nav > li:nth-child(1) > a")).click();
		
		//7.tagName:
		String headerText = driver.findElement(By.tagName("h5")).getText();
		System.out.println(headerText);
		
		//8.className:
		
		
		
		
	}

}
