package week5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteLead extends ProjectSpecificMethods{
	
	@BeforeTest
	 public void setData() {
		excelFilePath="./TestData/TestData.xlsx";
		sheet="deleteLead";
	 }
	
	@Test(dataProvider="getDataFromExcel")
	public void deleteLead(String userName,String password,String phoneNum) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNum);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		WebElement leadID = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//td[1]//a"));
		wait.until(ExpectedConditions.elementToBeClickable(leadID));
		leadID.click();
		
		String val=driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String lead = val.substring(val.length()-6,val.length()-1);
		System.out.println("Lead ID::"+ lead);
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(lead);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		if(driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed()) {
			System.out.println("Lead is deleted Successfully");
		}else {
			System.out.println("Lead is not deleted");
		}
		
	}

}
