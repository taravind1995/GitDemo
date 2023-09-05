package Selenium_Framework_pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium_Framework.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#userEmail")
	WebElement userEmail;
	@FindBy(css = "#userPassword")
	WebElement userPassword;
	@FindBy(css = "#login")
	WebElement submit;

	public void loginApplication(String user_email, String user_password) {
		userEmail.sendKeys(user_email);
		userPassword.sendKeys(user_password);
		submit.click();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
