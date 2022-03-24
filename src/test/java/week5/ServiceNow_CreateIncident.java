package week5;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ServiceNow_CreateIncident extends ProjectSpecificMethods{

	@BeforeTest
	public void setData() {
		excelFilePath="./TestData/TestData.xlsx";
		sheet="SN_CreateIncident";
	}
	
	@Test(dataProvider="getDataFromExcel")
	public void createIncident(String userName,String passWord,String description) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		driver.findElement(By.id("user_name")).sendKeys(userName);
		driver.findElement(By.id("user_password")).sendKeys(passWord);
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
		
		driver.findElement(By.id("incident.short_description")).sendKeys(description);
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
