package selenium_BasicConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightTicketSearch {
	/**
	 * 
	 * ID may get differ in Future.Entered From,To and Search Button
	 * Need to create Generic Function
	 */

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.kayak.co.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement flightTab = driver.findElement(By.xpath("//div[@class = 'ZRVS']/a/div[text() = 'Flights']"));
		flightTab.click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div[contains(@id,'origin-airport-display')]/div/div[contains(@class,'_Hk')]/button)[1]")).click();
		//driver.findElement(By.xpath("(//div[contains(@id ,'origin-airport-display-multi-container')]/div/div/button)[1]")).click();
		
		//From Place
		WebElement fromPlace = driver.findElement(By.xpath("//input[contains(@id ,'origin-airport')]"));
		fromPlace.sendKeys("Beng");
		
		Thread.sleep(2000);
		
		List<WebElement> fromList = driver.findElements(By.xpath("//div[contains(@id,'origin-airport-smartbox-dropdown')]/ul/li/div[@class = 'item-info']/div[1]"));				
		System.out.println(fromList.size());
		
		for(int i =0 ;i<fromList.size();i++) {
			String fromPlaceText = fromList.get(i).getText();
			System.out.println(fromPlaceText);
			if(fromPlaceText.equals("Bengaluru, India")) {
				fromList.get(i).click();
				break;
			}
		}
		
		//To Place
		driver.findElement(By.xpath("(//div[contains(@id,'destination-airport-display')]//div[contains(@id , 'destination-airport-display-inner')])[1]")).click();
		WebElement toPlace = driver.findElement(By.xpath("//input[contains(@id , 'destination-airport')]"));
		toPlace.sendKeys("Chen");
		
		Thread.sleep(2000);
		
		List<WebElement> toList = driver.findElements(By.xpath("//div[contains(@id,'destination-airport-smartbox-dropdown')]/ul/li/div[@class = 'item-info']/div[1]"));				
		System.out.println(toList.size());
		
		for(int i =0 ;i<toList.size();i++) {
			String toPlaceText = toList.get(i).getText();
			System.out.println(toPlaceText);
			if(toPlaceText.equals("Longnan, China")) {
				toList.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("(//button[contains(@id,'submit')and @title ='Search flights'])[1]")).click();
	}

}
