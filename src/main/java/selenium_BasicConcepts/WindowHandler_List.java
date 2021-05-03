package selenium_BasicConcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandler_List {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM']")).click();
		Set<String> handler = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(handler);
		
		String PID = windowsList.get(0);
		String ChildID = windowsList.get(1);
		driver.switchTo().window(ChildID);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(PID);
		System.out.println(driver.getTitle());
	}

}
