package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1Assignment5AlertsAndFrames {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		Day1Assignment5AlertsAndFrames obj = new Day1Assignment5AlertsAndFrames();
		//obj.alersAndFrames();
		obj.irctc();
	}
	
	public void initilaizeBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void alersAndFrames() {
		
//		https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm
//		Click Try It Button
//		Click OK/Cancel in the alert
//		Confirm the action is performed correctly by verifying the text !!

//		Switch to the frame
//		Then click Try It with Xpath
//		Switch to the alert
//		Then perform accept / dismiss
//		Get the text using id 
//		Verify the text based on the action
		
		initilaizeBrowser("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");	
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeResult"));
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		String val = driver.findElement(By.id("demo")).getText();
		
		if(val.contains("OK")) {
			System.out.println("OK Button is clicked successfully");
		}else {
			System.out.println("OK Button is not clicked");
		}
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert b = driver.switchTo().alert();
		b.dismiss();
		String val1 = driver.findElement(By.id("demo")).getText();
		
		if(val1.contains("Cancel")) {
			System.out.println("Cancel Button is clicked successfully");
		}else {
			System.out.println("Cancel Button is not clicked");
		}
		
	}
	
	public void irctc() {

//		1. Load https://www.irctc.co.in/
//		2. Click on OK button in the dialog  
//		3. Click on FLIGHTS link            
//		4. Go to the Flights tab
//		5. Print the customer care email id
//		6. Close the First tab(Train ticket booking) alone
		
		initilaizeBrowser("https://www.irctc.co.in/");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.alertIsPresent());
//		Alert initialAlert = driver.switchTo().alert();		
//		initialAlert.accept();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.linkText("FLIGHTS")).click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(allWindowHandles);
		
		System.out.println("Size of All Windows::"+handles.size());
		driver.switchTo().window(handles.get(1));
		
		driver.findElement(By.linkText("Contact Us")).click();
		String val = driver.findElement(By.xpath("//div[@aria-labelledby='dropdown10']/a[3]")).getText();
		System.out.println(val);
		
		driver.switchTo().window(handles.get(0));
		driver.close();
		
	}
}
