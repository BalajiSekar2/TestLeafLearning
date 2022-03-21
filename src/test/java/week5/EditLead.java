package week5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLead extends ProjectSpecificMethods{
	
	@BeforeTest
	 public void setData() {
		excelFilePath="./TestData/TestData.xlsx";
		sheet="editLead";
	 }
	
	@Test(dataProvider="getDataFromExcel")
	public void editLead(String username,String password,String firstName, String updatedName) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following-sibling::div/input")).sendKeys(firstName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		WebElement leadID = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//td[1]//a"));
		wait.until(ExpectedConditions.elementToBeClickable(leadID));
		leadID.click();
		
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("Find Lead is Successful");
		}else{
			System.out.println("Unable to find Lead");
		}
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(updatedName);
		driver.findElement(By.name("submitButton")).click();

		String updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(updatedCompanyName.contains(updatedName)) {
			System.out.println("Company Name Updated successfully");
		}else {
			System.out.println("Unable to update the company Name");
		}
		
	}

}
