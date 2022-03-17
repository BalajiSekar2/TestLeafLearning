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

public class Day1Assignment2ServiceNow {

	WebDriver driver;
	
	public static void main(String[] args) {
		Day1Assignment2ServiceNow obj = new Day1Assignment2ServiceNow();
		obj.serviceNow();
	}
	
	public void initilaizeBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void serviceNow() {
		
		initilaizeBrowser("https://dev58945.service-now.com/login.do?user_name=admin&sys_action=sysverb_login&user_password=QrYgEdTecW32");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Test@1234");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		WebElement filter = driver.findElement(By.xpath("//input[@placeholder='Filter navigator']"));
		filter.sendKeys("incident",Keys.ENTER);
		
		driver.findElement(By.xpath("(//div[text()='All'][@class='sn-widget-list-title'])[2]")).click();
		
		driver.switchTo().frame(0);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='New']")));
		driver.findElement(By.xpath("//button[text()='New']")).click();
		
		// select caller name from lookup
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lookup.incident.caller_id")));
		driver.findElement(By.id("lookup.incident.caller_id")).click();

		Set<String> allWindowSet = driver.getWindowHandles();
		List<String> allWinList = new ArrayList<String>(allWindowSet);
		String parentWindow = allWinList.get(0);
		String callerListWindow = allWinList.get(1);

		driver.switchTo().window(callerListWindow);
		driver.findElement(By.xpath("(//tbody[@class='list2_body']/tr)[1]//a")).click();

		driver.switchTo().window(parentWindow);
		driver.switchTo().frame(0);		
		
		driver.findElement(By.id("incident.short_description")).sendKeys("Test");
		String incidentNum = driver.findElement(By.name("incident.number")).getAttribute("value");
		System.out.println("Incident Number::"+incidentNum);
		
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='New']")));
		WebElement inc = driver.findElement(By.xpath("//a[text()='"+incidentNum+"']"));
		
		if(inc.isDisplayed()) {
			System.out.println("Incident is created successfully and its displayed");
		}else {
			System.out.println("Incident is not created successfully");
		}
	}

}

