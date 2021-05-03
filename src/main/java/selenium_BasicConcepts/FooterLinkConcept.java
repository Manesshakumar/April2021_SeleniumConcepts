package selenium_BasicConcepts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinkConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		// List<WebElement> list = driver.findElements(By.xpath("//div[@id =
		// 'SIvCob']/a"));
		// System.out.println(list.size());
		// for(WebElement x : list) {
		// System.out.println(x.getText());
		// }

		By langList = By.xpath("//div[@id = 'SIvCob']/a");
		By footerlinks = By.xpath("//div[@class= 'KxwPGc SSwjIe']/div/a");
		
		getlanglinkstext(langList);
		googleLinksStaticArray(langList);
		getlanglinkstext(footerlinks);


	}

	// ***********Function Create list of lang links text:
	public static void getlanglinkstext(By locator) {
		List<WebElement> list = driver.findElements(locator);
		System.out.println(list.size());
		for (WebElement x : list) {
			String text = x.getText();
			System.out.println(text);

		}
       System.out.println("*********getlanglinkstext*****************");
	}
	
	

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	// *******Function Create the Static array of the List:
	public static void googleLinksStaticArray(By locator) {
		String str[] = new String[9];

		for (int i = 0; i < getElements(locator).size(); i++) {
			str[i] = getElements(locator).get(i).getText();
			System.out.println(str[i]);
		}
	       System.out.println("*********googleLinksStaticArray*****************");

	}
		

}
