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

public class ServiceNow_AssignIncident extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData(){
		excelFilePath="./TestData/TestData - ServiceNow.xlsx";
		sheet="SN_AssignIncident";
	}
	
	@Test(dataProvider="getDataFromExcel")
	public void assignIncident(String userName,String passWord, String updatedNotes,String group) throws InterruptedException {
		
//		1. Launch ServiceNow application
//		2. Login with valid credentials 
//		3.  Enter Incident in filter navigator and press enter
//		4. click on open and Search for the existing incident and click on  the incident
//		5. Assign the incident to  Software group
//		6. Update the incident with Work Notes
//		7. Verify the Assignment group and Assigned for the incident
		
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
		
		driver.findElement(By.id("incident.short_description")).sendKeys("Test");
		String incidentNum = driver.findElement(By.name("incident.number")).getAttribute("value");
		System.out.println("Incident Number::"+incidentNum);
		
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='New']")));
		driver.findElement(By.xpath("(//label[text()='Search'])[2]//following-sibling::input")).sendKeys(incidentNum,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='"+incidentNum+"']")).click();
		
		driver.findElement(By.xpath("//button[@name='lookup.incident.assignment_group']//span[@class='icon icon-search']")).click();
		
		Set<String> allWindowSet1 = driver.getWindowHandles();
		List<String> allWinList1 = new ArrayList<String>(allWindowSet1);
		String parentWindow1 = allWinList1.get(0);
		String childWindow = allWinList1.get(1);

		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(group,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Software']")).click();

		driver.switchTo().window(parentWindow1);
		driver.switchTo().frame(0);		
		
		Thread.sleep(3000);		
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='New']")));
		driver.findElement(By.xpath("(//label[text()='Search'])[2]//following-sibling::input")).sendKeys(incidentNum);
		driver.findElement(By.xpath("//a[text()='"+incidentNum+"']")).click();
		
		String groupVal = driver.findElement(By.name("sys_display.incident.assignment_group")).getAttribute("value");
		
		if(groupVal.equalsIgnoreCase("Software")) {
			System.out.println("Assignment Group Value is updated successfully");
		}else {
			System.out.println("Assignment Group Value is not updated successfully");
		}
		
	}

}
