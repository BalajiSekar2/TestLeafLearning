package week4.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1Assignment4Frames {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		Day1Assignment4Frames obj = new Day1Assignment4Frames();
		obj.framesExample();
	}
	
	public void initilaizeBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void framesExample() {
		
//		http://leafground.com/pages/frame.html
//		Find the number of frames
//		find the Elements by tagname - iframe
//		Store it in a list
//		Get the size of the list. (This gives the count of the frames visible to the main page)
		
		initilaizeBrowser("http://leafground.com/pages/frame.html");
		List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of Frames available in Page::"+allFrames.size());
		
	}

}
