package week4.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1Assignment3Frames {

	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		Day1Assignment3Frames obj = new Day1Assignment3Frames();
		obj.framesPlayGround();
	}
	
	public void initilaizeBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void framesPlayGround() throws InterruptedException {
		initilaizeBrowser("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		WebElement frame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
		WebElement drop = driver.findElement(By.id("animals"));
		Select animalDropDwn = new Select(drop);
		animalDropDwn.selectByVisibleText("Baby Cat");
		driver.switchTo().defaultContent();
		
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("test");
		
		WebElement frame3 = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following-sibling::input")).click();
		driver.switchTo().defaultContent();
				
	}
}
