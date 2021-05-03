package selenium_BasicsFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HRMLoginPage {


	public static void main(String[] args) {
		
		DriverFactory df = new DriverFactory();
		String browserName = "chrome";
		WebDriver driver = df.init_driver(browserName);
		df.launchUrl("https://www.orangehrm.com/open-source/demo/");
	

		By firstName = By.id("Form_submitRequest_FirstName");
		By submit_btn = By.linkText("Services");

		ElementUtil element = new ElementUtil(driver);
		element.doSendKeys(firstName,"Shreya");
		element.doClick(submit_btn);

	}

}
