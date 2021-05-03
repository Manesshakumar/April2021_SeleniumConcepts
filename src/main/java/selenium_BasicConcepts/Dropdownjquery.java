package selenium_BasicConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdownjquery {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		driver.findElement(By.id("justAnInputBox")).click();

		By options = By.xpath("//div[contains(@id , 'comboTree') and @class = 'comboTreeDropDownContainer']//ul/li/span");

		//		selectChoiceDropDownJquery(options, "choice 5");
		//		selectChoiceDropDownJquery(options,"choice 2");

		selectMultiChoiceDropDownJquery(options, "choice 5" ,"choice 2");

		//selectMultiChoiceDropDownJquery(options,"All");
	}


	//Single Select Option
	public static void selectChoiceDropDownJquery(By locator , String value) {
		List<WebElement> list = driver.findElements(locator);
		System.out.println(list.size());

		for (WebElement x : list) {
			String MultiSelecttext = x.getText();
			if (!MultiSelecttext.isEmpty()) {
				System.out.println(x.getText());
				if (MultiSelecttext.equals(value)) {
					x.click();
					break;
				}

			}
		}
	}

	//Every time need to call the method for multiple Options.So Create a Static String to Hold the Multiple Value.

	public static void selectMultiChoiceDropDownJquery(By locator , String...value) {	
		List<WebElement> list = driver.findElements(locator);
		System.out.println(list.size());

		for (WebElement x : list) {
			String MultiSelecttext = x.getText();

			if(!value[0].equalsIgnoreCase("All")) {
				
				for(int j = 0; j< value.length;j++) {
					if(MultiSelecttext.equals(value[j])) {
						x.click();
						break;
					}
				}
			}
			else {
				try {
					x.click();
				}catch (ElementNotInteractableException e) {
				}
			}



		}


	}


}
