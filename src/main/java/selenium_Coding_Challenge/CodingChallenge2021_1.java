package selenium_Coding_Challenge;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CodingChallenge2021_1 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		By populationCount = By.xpath("//div[@class = 'maincounter-number']/span");
		By birthToday = By.xpath("//div[@class = 'sec-counter']/span[@rel= 'births_today']");
		By deathToday = By.xpath("//div[@class = 'sec-counter']/span[@rel= 'dth1s_today']");
		By populationGrowth = By.xpath("//div[@class = 'sec-counter']/span[@rel= 'absolute_growth']");
		By birthThisYear = By.xpath("//div[@class = 'sec-counter']/span[@rel= 'births_this_year']");
		By deathThisYear = By.xpath("//div[@class = 'sec-counter']/span[@rel= 'dth1s_this_year']");
		By absoluteGrowthYear = By.xpath("//div[@class = 'sec-counter']/span[@rel= 'absolute_growth_year']");
		
		retryingFindClick(populationCount,birthToday,deathToday,populationGrowth,birthThisYear,deathThisYear,absoluteGrowthYear);
		
		driver.quit();
		
	}

	public static boolean retryingFindClick(By locator,By locator2,By locator3,By locator4,By locator5,By locator6,By locator7) throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		while (attempts < 10) {
			try {
				WebElement populationCount = driver.findElement(locator);
				WebElement birthToday = driver.findElement(locator2);
				WebElement deathToday = driver.findElement(locator3);
				WebElement populationGrowth = driver.findElement(locator4);
				WebElement birthThisYear = driver.findElement(locator5);
				WebElement deathThisYear = driver.findElement(locator6);
				WebElement absoluteGrowthYear = driver.findElement(locator7);
				System.out.println(populationCount.getText());
				System.out.println(birthToday.getText());
				System.out.println(deathToday.getText());
		 		System.out.println(populationGrowth.getText());
				System.out.println(birthThisYear.getText());
				System.out.println(deathThisYear.getText());
				System.out.println(absoluteGrowthYear.getText());
				System.out.println("The attempts is " +attempts);
				result = true;
			} catch (StaleElementReferenceException e) {
				Thread.sleep(500);
			}
			attempts++;
		}
		return result;
	}
	
	
	


}
