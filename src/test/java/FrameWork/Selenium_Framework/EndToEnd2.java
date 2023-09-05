package FrameWork.Selenium_Framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium_Framework_pageobject.LandingPage;
import Selenium_Framework_pageobject.ProductCatalog;

public class EndToEnd2 {
	public static void main(String[] args) {
		String user_email="sam@123gmail.com";
		String user_password="Sam@!123";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		LandingPage lp=new LandingPage(driver);
		lp.goTo();
		lp.loginApplication(user_email, user_password);
		
		ProductCatalog pc= new ProductCatalog(driver);
		pc.getProductsList();
		
	
		
		
	
		
		
	     
	
			
	
	}

}
