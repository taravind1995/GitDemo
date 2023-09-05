package FrameWork.Selenium_Framework;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EndToEnd {
	public static void main(String[] args) {
		String uname = "sam@123gmail.com";
		String upassword = "Sam@!123";
		String product_name="ADIDAS ORIGINAL";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.cssSelector("#userEmail")).sendKeys(uname);
		driver.findElement(By.cssSelector("#userPassword")).sendKeys(upassword);
		driver.findElement(By.cssSelector("#login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(product_name))
				.findFirst().orElse(null);

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body
		// button:last-of-type")));
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='toast-message']")));

		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cart .infoWrap h3"));
		boolean match=cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equals(product_name));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("aus");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='list-group-item']")));
		List<WebElement> DD_options=driver.findElements(By.cssSelector("[class*='list-group-item']"));
		
	WebElement dd_option=	DD_options.stream().filter(DD_option->DD_option.getText().equalsIgnoreCase("Australia")).findFirst().orElse(null);
	dd_option.click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
	//driver.findElement(By.cssSelector(".actions [class*='action__submit']")).click(); 
	

	Actions actions = new Actions(driver); 
	actions.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).click().build().perform();

	}

}

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
