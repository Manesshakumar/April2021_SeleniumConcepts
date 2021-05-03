package selenium_AdvancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium_BasicsFramework.JavaScriptUtil;

public class JSExecutorConcept {

    static WebDriver driver;
    static JavaScriptUtil jsUtil;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		
		WebElement headerCheck = driver.findElement(By.xpath("//h3[text() = 'Group Calendar']"));
		
		 jsUtil = new JavaScriptUtil(driver);
//		 jsUtil.flash(username);
//		 jsUtil.flash(password);
		 
//		 jsUtil.drawBorder(username);
//		 jsUtil.scrollPageDown();
		 
		 jsUtil.scrollIntoView(headerCheck);
		 
		 
		
		
	}

}
