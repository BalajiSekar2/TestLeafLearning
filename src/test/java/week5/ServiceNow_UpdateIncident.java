package week5;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ServiceNow_UpdateIncident extends ProjectSpecificMethods{

	@BeforeTest
	public void setData() {
		excelFilePath="./TestData/TestData.xlsx";
		sheet="SN_UpdateIncident";
	}
	
	@Test(dataProvider="getDataFromExcel")
	public void updateIncident(String userName,String passWord,String description,String updatedNotes) {
		
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
		driver.findElement(By.xpath("(//label[text()='Search'])[2]//following-sibling::input")).sendKeys(incidentNum,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='"+incidentNum+"']")).click();
		
		WebElement urgency = driver.findElement(By.xpath("//select[@aria-labelledby='label.incident.urgency']"));
		Select urgencyList = new Select(urgency);
		urgencyList.selectByVisibleText("1 - High");
		
		WebElement state = driver.findElement(By.xpath("//select[@aria-labelledby='label.incident.state']"));
		Select stateList = new Select(state);
		stateList.selectByVisibleText("In Progress");
		
		driver.findElement(By.xpath("(//*[@placeholder='Work notes'])[1]")).sendKeys(updatedNotes);
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='New']")));
		driver.findElement(By.xpath("(//label[text()='Search'])[2]//following-sibling::input")).sendKeys(incidentNum);
		driver.findElement(By.xpath("//a[text()='"+incidentNum+"']")).click();
		
		String urgencyVal = driver.findElement(By.xpath("//select[@aria-labelledby='label.incident.urgency']")).getText();
		String stateVal = driver.findElement(By.xpath("//select[@aria-labelledby='label.incident.state']")).getText();
		
		if(urgencyVal.contains("High")) {
			System.out.println("Urgency Value is updated successfully");
		}else {
			System.out.println("Urgency Value is not updated successfully");
		}
		
		if(stateVal.contains("Progress")) {
			System.out.println("Progress Value is updated successfully");
		}else {
			System.out.println("Progress Value is not updated successfully");
		}
		
	}
	
}
