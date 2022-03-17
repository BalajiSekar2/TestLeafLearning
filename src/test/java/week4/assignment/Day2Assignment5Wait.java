package week4.assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2Assignment5Wait {
	
	WebDriver driver;

	public static void main(String[] args) {
		Day2Assignment5Wait obj = new Day2Assignment5Wait();
		obj.disApper();
		obj.textChange();
		obj.appear();
	}
	
	public void initilaizeBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void disApper() {
		
		initilaizeBrowser("http://www.leafground.com/pages/disapper.html");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		WebElement beforeDisapper = driver.findElement(By.xpath("//b[contains(text(),'going to disappear. Keep looking at me!!')]"));
		WebElement afterDisappertext = driver.findElement(By.xpath("//strong[contains(text(),'I know you can do it! Button is disappeared!')]"));
		
		if(beforeDisapper.isDisplayed()) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//b[contains(text(),'going to disappear. Keep looking at me!!')]")));
			System.out.println("Button is displayed");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'I know you can do it! Button is disappeared!')]")));
			if(afterDisappertext.isDisplayed()){
				System.out.println("Text after disappearing is dispalying as expected");
				driver.quit();
			}else {
				System.out.println("Text after disappearing is not dispalying");
			}
		
		}else {
			System.out.println("Unable to identify the Button");
		}
		
	}

	public void textChange() {
		
		initilaizeBrowser("http://www.leafground.com/pages/TextChange.html");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		WebElement btnAfterChange = driver.findElement(By.xpath("//button[contains(text(),'Click ME')]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Click ME')]")));
		btnAfterChange.click();
		
		Alert alert = driver.switchTo().alert();
		String val = alert.getText();
		System.out.println(val);
		
		if(val.equalsIgnoreCase("Click ME!")) {
			System.out.println("Click ME text is displayed as expected");
			alert.accept();
			driver.close();
		}else {
			System.out.println("Click ME text is not displayed as expected");
		}
		
	}
	
	public void appear() {
		
		initilaizeBrowser("http://www.leafground.com/pages/appear.html");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		System.out.println("Before Time::"+java.time.LocalTime.now()); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[3]")));
		System.out.println("After Time::"+java.time.LocalTime.now()); 
		String val = driver.findElement(By.xpath("//button[3]")).getText();
		System.out.println(val);
		driver.close();
		
	}
	
}
