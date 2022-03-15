package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1Assignment1MergeContact {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		mergeContact();
	}
	
	public static void mergeContact() throws InterruptedException {
		
//		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
//		 * 2. Enter UserName and Password Using Id Locator
//		 * 3. Click on Login Button using Class Locator
//		 * 4. Click on CRM/SFA Link
//		 * 5. Click on contacts Button
//		 * 6. Click on Merge Contacts using Xpath Locator
//		 * 7. Click on Widget of From Contact
//		 * 8. Click on First Resulting Contact
//		 * 9. Click on Widget of To Contact
//		 * 10. Click on Second Resulting Contact
//		 * 11. Click on Merge button using Xpath Locator
//		 * 12. Accept the Alert
//		 * 13. Verify the title of the page
		
		initilaizeBrowser("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//input[@name='partyIdFrom']/following-sibling::a")).click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Number of Window Handles::"+allWindowHandles.size());
		
		List<String> all= new ArrayList<String>();
		all.addAll(allWindowHandles);
		String win = all.get(1);
		driver.switchTo().window(win);
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//td[1]//a")).click();
		driver.switchTo().window(all.get(0));
		
		
		driver.findElement(By.xpath("//input[@name='partyIdTo']/following-sibling::a")).click();
		Thread.sleep(2000);
		Set<String> allWindowHandlesTO = driver.getWindowHandles();
		System.out.println("Number of Window Handles::"+allWindowHandlesTO.size());
		
		List<String> allTo= new ArrayList<String>();
		allTo.addAll(allWindowHandlesTO);
		String winTo = allTo.get(1);
		driver.switchTo().window(winTo);
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//td[1]//a")).click();
		driver.switchTo().window(allTo.get(0));
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert ale = driver.switchTo().alert();
		ale.accept();
		Thread.sleep(10000);
		
		if(driver.getTitle().contains("View Contact")) {
			System.out.println("Contact Merged Successfully");
		}else {
			System.out.println("Contact not merged");
		}
		
	}
	
	public static void initilaizeBrowser(String url) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}

}
