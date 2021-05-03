package selenium_BasicConcepts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSelectAllOption {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/open-source/demo/");
		driver.manage().window().maximize();
		
//		WebElement industry = driver.findElement(By.id("Form_submitRequest_Industry"));
//		Select select = new Select (industry);
//		List<WebElement> list = select.getOptions();
//		System.out.println(list.size());
//		for(WebElement x : list) {
//			String text = x.getText();
//			System.out.println(text);
//			if(text.equals("Electronics")) {
//				x.click();
//				break;
//			}

//		}
		
		System.out.println("************ Generic fc************ ");
		By industryCombo = By.id("Form_submitRequest_Industry");
		doSelectgetOptions(industryCombo);
		
	
	}

    
	public static List<String> doSelectgetOptions(By locator) {
		List<String> optionList = new ArrayList<String>();
		Select select = new Select (driver.findElement(locator));
		List<WebElement> list = select.getOptions();
		System.out.println(list.size());
		for(WebElement x : list) {
			String text = x.getText();
			System.out.println(text);
			optionList.add(text);
		}
		
	return optionList;
		}
	}
