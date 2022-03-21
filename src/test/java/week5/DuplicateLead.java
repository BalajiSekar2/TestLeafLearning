package week5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DuplicateLead extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData() {
		excelFilePath="./TestData/TestData.xlsx";
		sheet="duplicateLead";
	}
	
	@Test(dataProvider="getDataFromExcel")
	public void duplicateLead(String userName,String password,String email) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		WebElement leadID = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//td[1]//a"));
		wait.until(ExpectedConditions.elementToBeClickable(leadID));
		leadID.click();
		
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String name=driver.findElement(By.id("createLeadForm_companyName")).getAttribute("value");
				
		if(driver.getTitle().contains("Duplicate Lead")) {
			System.out.println("Duplicate Lead page is displayed Successfully");
		}else {
			System.out.println("Duplicate Lead page is displayed");
		}
		
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		String val = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		if(val.contains(name)) {
			System.out.println("Duplicate Lead Name is same");
		}else {
			System.out.println("Duplicate Lead Name is not same");
		}
		
	}
	
}
