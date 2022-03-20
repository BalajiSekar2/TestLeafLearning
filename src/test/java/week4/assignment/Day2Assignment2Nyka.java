package week4.assignment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2Assignment2Nyka {

	WebDriver driver;
	
	public static void main(String[] args) {
		Day2Assignment2Nyka obj = new Day2Assignment2Nyka();
		obj.nyka();
	}
	
	public void initilaizeBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void nyka() {
		
		initilaizeBrowser("https://www.nykaa.com/");
		
		
		
		
	}
	
}
