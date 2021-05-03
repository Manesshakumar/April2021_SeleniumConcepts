package selenium_AdvancedConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableConcepts {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/bangladesh-in-nz-2020-21-1233967/new-zealand-vs-bangladesh-2nd-odi-1233977/full-scorecard");
		driver.manage().window().maximize();
		getCricWicketKeeperInfo("Mahmudullah");
		getBatsManName();
		getScoreCard("Soumya Sarkar");
		
		
	}
	
	public static void getCricWicketKeeperInfo(String value) {
		WebElement wicketKeeper = driver.findElement(By.xpath("//a[text()='"+value+"']//parent::td/following-sibling::td/span"));
		System.out.println(wicketKeeper.getText());
		
	}
	/**
	 * Sort the List of WebElements ->Create a arraylist and add the Values from the List <Web>
	 */
	public static void getBatsManName() {
		List<String> ar = new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath("//td[@class = 'batsman-cell text-truncate out']/a"));
		System.out.println(list.size());
		for(WebElement x:list) {
			String batsManName = x.getText();
			ar.add(batsManName);
		}
		System.out.println(ar);
		Collections.sort(ar);
		
	}
	
	public static void getScoreCard(String value) {
		
		List<WebElement> scoreList = driver.findElements(By.xpath("//a[text()='"+value+"']//parent::td//following-sibling::td"));
		System.out.println(scoreList.size());
		for(int i = 0;i<scoreList.size();i++) {			
			String scoreText = scoreList.get(i).getText();
			if(!scoreText.isEmpty()) {
				System.out.println(i + " "+ scoreText);
			}
			
		}
	}

}
