package selenium_Coding_Challenge;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CodingChallenge_3_OLD {
	
	static WebDriver driver;
	
	/**
	 * 1st part of Search is done.Need to Convert this into POM Approach.
	 * Thread Exception is Occurred.Apart from that Working Fine.
	 * @param args
	 * @throws InterruptedException
	 */

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// by loc
		By roundTrip = By.xpath("//li[contains(text(),'Round Trip')]/child::span");
		By fromCity = By.xpath("//input[@id= 'fromCity']");
		// By toCity = By.xpath("//input[@id= 'toCity']");
		By fromField = By.xpath("//input[@placeholder = 'From']");
		By toField = By.xpath("//input[@placeholder = 'To']");
		By fromSuggestionList = By.xpath(
				"//div[@role = 'listbox']//div[contains(@class,'calc')]/p[@class = 'font14 appendBottom5 blackText']");

		By monthCaption = By.xpath("//div[@class = 'DayPicker-Months']//div[contains(@class,'DayPicker-Caption')]/div");
		By nextBtn = By.xpath("//span[@role= 'button' and @aria-label = 'Next Month']");
		By dateList = By.xpath("//div[@class = 'DayPicker-Body']//div[@class = 'dateInnerCell']/p");
		By searchBtn = By.xpath("//a[@class = 'primaryBtn font24 latoBold widgetSearchBtn ']");

		doFromFlightDetails(roundTrip, fromCity, fromField, "Delhi", fromSuggestionList);
		doToFlightDetails(toField, "Goa", fromSuggestionList);
		departureDate(monthCaption, nextBtn, dateList);
		returnDate(dateList);
		doSearchbtnClick(searchBtn);

	}

	public static void doFromFlightDetails(By roundTrip, By fromCity, By fromField, String fromValue,
			By fromSuggestionList) throws InterruptedException {

		driver.findElement(roundTrip).click();
		try {
			WebElement ele = new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(fromCity));
			Actions action = new Actions(driver);
			action.moveToElement(ele).click().build().perform();
		} catch (StaleElementReferenceException e) {
			Thread.sleep(500);
		}
		driver.findElement(fromField).sendKeys(fromValue);
		try {
			List<WebElement> fromList = new WebDriverWait(driver, 15)
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fromSuggestionList));
			for (WebElement x : fromList) {
				System.out.println(x.getText());
				String fromPlaceText = x.getText();
				if (fromPlaceText.contains("Delhi, India")) {
					x.click();
					break;
				}
			}
		} catch (StaleElementReferenceException e) {
		}

	}

	public static void doToFlightDetails(By toField, String toCityValue, By fromSuggestionList) {
		driver.findElement(toField).sendKeys(toCityValue);

		try {
			List<WebElement> fromList = new WebDriverWait(driver, 15)
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fromSuggestionList));
			for (WebElement x : fromList) {
				System.out.println(x.getText());
				String fromPlaceText = x.getText();
				if (fromPlaceText.contains("Goa, India")) {
					x.click();
					break;
				}
			}
		} catch (StaleElementReferenceException e) {
		}

	}

	public static void departureDate(By monthCaption, By nextBtn, By dateList) throws InterruptedException {
	//driver.findElement(By.xpath("//span[@class = 'lbl_input latoBold appendBottom10' and text() = 'DEPARTURE']")).click();
		String month = "July 2021";
		String dep_date = "25";
		WebElement mon = driver.findElement(monthCaption);
		while (true) {
			if (mon.getText().contains(month)) {
				System.out.println(mon.getText());
				break;
			} else {
				driver.findElement(nextBtn).click();
				Thread.sleep(3000);
			}
		}

		List<WebElement> date = driver.findElements(dateList);
		for (WebElement x : date) {
			String depDate = x.getText();
			if(depDate.equals(dep_date)) {
				x.click();
				break;
			}
		}
	}
	
	
	public static void returnDate(By dateList) {
		//driver.findElement(By.xpath("//span[@class = 'lbl_input latoBold appendBottom10' and text() = 'RETURN']")).click();
		String return_date = "31";
		List<WebElement> date = driver.findElements(dateList);
		for (WebElement x : date) {
			String depDate = x.getText();
			if(depDate.equals(return_date)) {
				x.click();
				break;
			}
		}
	}

	
	public static void doSearchbtnClick(By searchBtn) {
		driver.findElement(searchBtn).click();
	}
}
