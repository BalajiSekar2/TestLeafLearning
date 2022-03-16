package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1Assignment6Amazon {
	WebDriver driver;
	
	public static void main(String[] args) {
		Day1Assignment6Amazon obj = new Day1Assignment6Amazon();
		obj.amazon();
	}
	
	public void initilaizeBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void amazon() {
		
//		1. Load the uRL https://www.amazon.in/
//		2. search as one plus 9 pro 
//		3. Get the price of the first product
//		4. Print the number of customer ratings for the first displayed product
//		5. click on the stars 
//		6. Get the percentage of ratings for the 5 star.
//		7. Click the first text link of the first image
//		8. Click 'Add to Cart' button
//		9. Get the cart sub total and verify if it is correct.
		
		initilaizeBrowser("https://www.amazon.in/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		driver.findElement(By.name("field-keywords")).sendKeys("OnePlus 9 Pro"+Keys.ENTER);
		
		WebElement price = driver.findElement(By.xpath("(//div[@data-cel-widget='search_result_2']//span[@class='a-offscreen'])[1]/parent::span/span[2]/span[2]"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@data-cel-widget='search_result_2']//span[@class='a-offscreen'])[1]")));
		System.out.println("Price of First Search Result is "+ price.getText());
		
		WebElement numCustRating = driver.findElement(By.xpath("//div[@data-cel-widget='search_result_2']//a[contains(@href,'customerReviews')]"));
		System.out.println("Number of Rating for First Search Result is "+numCustRating.getText());
		
		
		//WebElement star = driver.findElement(By.xpath("//div[@data-cel-widget='search_result_2']//span[contains(@aria-label,'out of 5 stars')]"));
		//star.click();
		
		WebElement productLink = driver.findElement(By.xpath("//div[@data-cel-widget='search_result_2']//span[@class='a-size-medium a-color-base a-text-normal']"));
		productLink.click();
		
		Set<String> allHandles = driver.getWindowHandles();
		List<String> all = new ArrayList<String>();
		all.addAll(allHandles);
		
		String childWind = all.get(1);
		driver.switchTo().window(childWind);
		
		driver.findElement(By.xpath("//input[@name='submit.add-to-cart']")).click();
		WebElement subTotalPrice = driver.findElement(By.xpath("//*[text()='Cart subtotal'] /ancestor::span/parent::div/span[2]/span"));
		System.out.println("SubTotal Price::"+subTotalPrice.getText());
		
	}

}
