package selenium_BasicConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownSelectConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/open-source/demo/");
		driver.manage().window().maximize();
		
		WebElement industry = driver.findElement(By.id("Form_submitRequest_Industry"));
		
//		//1.Dropdown with Select:
//		Select select = new Select(industry);
//		
//		//->selectByIndex:
//		select.selectByIndex(2);
//		
//		//selectByVisibleText:
//		select.selectByVisibleText("Education");
//		
//		//selectByValue:
//		select.selectByValue("Retail");
		
		System.out.println("*****Calling via Generic Functions********");
		By industryCombo = By.id("Form_submitRequest_Industry");
		By countryCombo = By.id("Form_submitRequest_Country");
		By empCombo = By.id("Form_submitRequest_No_of_Employees");
	
		doSelectDropdownByVisibleText(industryCombo, "Education");
		doSelectDropdownByIndex(countryCombo, 2);
		doselectDropdownByValue(empCombo, "51 - 75");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);

	}
	public static void doSelectDropdownByVisibleText(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	public static void doSelectDropdownByIndex(By locator,int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doselectDropdownByValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

}
