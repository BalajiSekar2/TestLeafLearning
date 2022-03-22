package week5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateContact extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData(){
		excelFilePath="./TestData/TestData.xlsx";
		sheet="createContact";
	}
	
	@Test(dataProvider="getDataFromExcel")
	public void createContact(String userName, String password, String firstName, String lastName, String department, String description, String email) {
			
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys(firstName);
		driver.findElement(By.id("lastNameField")).sendKeys(lastName);
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys(department);
		driver.findElement(By.id("createContactForm_description")).sendKeys(description);
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(email);
		
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		selectDropDownValue(state,"New York");
		
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Test Update");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println(driver.getTitle());
				
	}
	

	public void selectDropDownValue(WebElement element,String val) {
		 Select s = new Select(element);
		 s.selectByVisibleText(val);
	}

}
