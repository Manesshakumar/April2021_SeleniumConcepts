package selenium_BasicConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelect {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/open-source/demo/");
		driver.manage().window().maximize();
	
		//Dropdown without Select by using xpath:
		
		List<WebElement> list = driver.findElements(By.xpath("//select[@id = 'Form_submitRequest_Industry']/option"));
        System.out.println(list.size());
        
        for(WebElement x : list) {
        	String text = x.getText();
        	System.out.println(text);
        	if(text.equals("Electronics")) {
        		x.click();
        		break;
        	}
        	
        }
		
		
	}

}
