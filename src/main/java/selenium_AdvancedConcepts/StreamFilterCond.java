package selenium_AdvancedConcepts;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamFilterCond {
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		By amazonLink = By.xpath("//div[@class = 'navFooterVerticalRow navAccessibility']/div/ul/li/a");
		
		List<String> linkText = filterLinkText(amazonLink,"Amazon");			
		linkText.stream().forEach(x -> System.out.println(x));
		
		
	}
	
	public static List<String> filterLinkText(By Locator,String Value) {
		List<WebElement> list = driver.findElements(Locator);
		System.out.println(list.size());
		List<String> linkText = list.stream()
		.filter(x-> (!x.getText().isEmpty()))
		.filter(x -> (x.getText().contains(Value)))
		.map(x-> x.getText().trim())
		.collect(Collectors.toList());
		
		return linkText;
		
	}

}
