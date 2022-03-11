package week3.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2_AJIO {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		Day2_AJIO obj = new Day2_AJIO();
		obj.ajio();
		
	}
	
	public void ajio() throws InterruptedException {
		
//		1. Launch the URL https://www.ajio.com/
//		2. In the search box, type as "bags" and press enter
//		3. To the left  of the screen under " Gender" click the "Men"
//		4. Under "Category" click "Fashion Bags"
//		5. Print the count of the items Found. 
//		6. Get the list of brand of the products displayed in the page and print the list.
//		7. Get the list of names of the bags and print it
		
		initilazeBrowser("https://www.ajio.com/");
		driver.findElement(By.name("searchVal")).sendKeys("Bags",Keys.ENTER);
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'Fashion Bags')]")).click();
		Thread.sleep(5000);
		WebElement itemCount = driver.findElement(By.xpath("//div[@class='length']"));
		System.out.println("Items Found::"+itemCount.getText());	
		
		System.out.println("************** Brands List *************");
		List<WebElement> brandsEle = driver.findElements(By.className("brand"));
		for(WebElement x:brandsEle) {
			String val = x.getText();
			System.out.println(val);
		}
		
		System.out.println("************** Bag Names *************");
		List<WebElement> namesEle = driver.findElements(By.xpath("//div[@class='nameCls']"));
		for(WebElement x:namesEle) {
			String val = x.getText();
			System.out.println(val);
		}
		
	}
	
	public void initilazeBrowser(String url) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}

}
