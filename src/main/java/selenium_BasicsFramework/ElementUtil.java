package selenium_BasicsFramework;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class ElementUtil {
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);

	}
	public void doSendKeys(By locator,String Value) {
		getElement(locator).sendKeys(Value);

	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	//*******************DropDownUtils********************************//
	
	public  void doSelectDropdownByVisibleText(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	public  void doSelectDropdownByIndex(By locator,int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public  void doselectDropdownByValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
   
	//*********Function return the Text of Each Options(getOptions)*************//
	public  List<String> doSelectgetOptions(By locator) {
		List<String> optionList = new ArrayList<String>();
		Select select = new Select (getElement(locator));
		List<WebElement> list = select.getOptions();
		for(WebElement x : list) {
			String text = x.getText();
			optionList.add(text);
		}
		
	return optionList;
		}
	
	
	
	//**************getSearchSuggestionList***********************//

	public void doSelectFromSuggestionList(By locator, String Value) {
		List<WebElement> list = getElements(locator);

		for (WebElement e : list) {
			String text = e.getText();
			if (text.equals(Value)) {
				e.click();
				break;
			}
		}
	}
	
	//*************Action - SendKeys & Click*******************
	
	public  void doActionSendKeys(By locator,String Value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator),Value).perform();
		
	}
	
	public  void doActionClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
		
	}
	
	
	//***********************Dropdown_JQuery*********************************************
	/**
	 * For Single Select,Multiple Select Operation and All --->All Options Selection
	 * @param locator
	 * @param value
	 */
	
	public void selectMultiChoiceDropDownJquery(By locator , String...value) {	
		List<WebElement> list = driver.findElements(locator);

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
	
	//****************************Custom Wait******************************************
	
	/**
	 * This is a custom method to provide the dynamic wait to find the webelement
	 */
	
	public WebElement retryingElement(By locator) {

		WebElement element = null;
		int attempts = 0;

		while (attempts < 30) {
			try {
				element = driver.findElement(locator);
				break;
			} 
			catch (NoSuchElementException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
				}
			}
			catch (StaleElementReferenceException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
				}
			}
			System.out.println("element is not found : " + (attempts+1));

			attempts++;
		}
		return element;
	}
	
	/**
	 * Fluent Wait for particular WebElement
	 * @return WebElement
	 */
	
     public WebElement waitForElementWithFluentWait(By locator,int timeOut,int pollingTime) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		 return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		
	}
	
}
