package FrameWork.Selenium_Framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EndToEnd {
	public static void main(String[] args) {
		String uname="sam@123gmail.com";
		String upassword="Sam@!123";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
	
		driver.findElement(By.cssSelector("#userEmail")).sendKeys(uname);
		driver.findElement(By.cssSelector("#userPassword")).sendKeys(upassword);
		driver.findElement(By.cssSelector("#login")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		
	     List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	     
	
			
			  WebElement prod=products.stream().filter(product->
			  product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).
			  findFirst().orElse(null);
			 
	

	
	 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body button:last-of-type")));
	  prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	 
	/*
	 * for(int i=0;i<products.size();i++) { String
	 * product=products.get(i).getText();
	 * 
	 * if(product.contains("ADIDAS ORIGINAL")) {
	 * driver.findElements(By.xpath("//div[@class='card-body']/button[2]")).get(i).
	 * click();
	 * 
	 * //driver.findElements(By.cssSelector(".card-body button:last-of-type")).get(i
	 * ).click(); } }
	 */
		
	}

}
