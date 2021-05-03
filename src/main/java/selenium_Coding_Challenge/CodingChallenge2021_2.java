package selenium_Coding_Challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CodingChallenge2021_2 {
	// Carousel Handling in Java.
	
	
	//Topic is not Over,Yet to Finish.

	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		By RecommendedForYou = By.xpath("(//div[@class = 'swiper-wrapper'])[2]/div//div[@class = 'e3js0d-11 liZdac']");
		By RecommendedForYou_swipeBtn = By.xpath("(//div[contains(@class ,'swiper-button-next')])[2]");
	
		//recommenedGetText(RecommendedForYou, RecommendedForYou_swipeBtn);	
		
	
		
		WebElement arrowBtn = driver.findElement(RecommendedForYou_swipeBtn);
		isClickable(arrowBtn);
	}
	
	
	public static void recommenedGetText(By locator,By swipeBtn ) {	
	List<WebElement> recommendedList = driver.findElements(locator);
	WebElement swipeArrow = driver.findElement(swipeBtn);
		System.out.println(recommendedList.size());
		List<String> listItems = new ArrayList<String>();	
		
		WebDriverWait wait = new WebDriverWait(driver,10);		
		while(!wait.until(ExpectedConditions.invisibilityOf(swipeArrow))) {								
			for(int i=0;i<recommendedList.size();i++) {
				String text = recommendedList.get(i).getText();
				Actions action = new Actions(driver);
				action.click(swipeArrow);
				System.out.println(text);
				listItems.add(text);
			}
		}		
	}
	
	
	public static boolean isClickable(WebElement webe)      
	{
	    try
	    {
	        WebDriverWait wait = new WebDriverWait(driver, 5);
	        wait.until(ExpectedConditions.elementToBeClickable(webe));
	        return true;
	    }
	    catch (Exception e)
	    {
	        return false;
	    }
	}
	
}


