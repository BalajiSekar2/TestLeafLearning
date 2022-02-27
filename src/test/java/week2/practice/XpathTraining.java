package week2.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathTraining {
	
	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		initalizeBrowser();
		createLead();
		findLead();
		editLead();
		
	}
	
	public static void initalizeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public static void createLead() throws InterruptedException {
		
		WebElement edtUserName = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement edtPassword = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement btnLogin = driver.findElement(By.xpath("//input[@value='Login']"));
		
		edtUserName.sendKeys("Demosalesmanager");
		edtPassword.sendKeys("crmsfa");
		btnLogin.click();
		
		// click CRM/SFA app
		WebElement btnCRMSFA = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
		btnCRMSFA.click();
		
		WebElement createLeadLink = driver.findElement(By.linkText("Create Lead"));
		createLeadLink.click();

		WebElement lnkCreateLead = driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]"));
		lnkCreateLead.click();
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Bala");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("S");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
	}
	
	public static void findLead() throws InterruptedException {
		
		// Clicking Find Leads Link
		driver.findElement(By.xpath("//a[contains(text(),'Find Lead')]")).click();
		
		// Entering Search Text
		WebElement edtFirstName = driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following-sibling::div/input"));
		edtFirstName.sendKeys("Test");
		
		// Clicking Find Leads Button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		// Identifying the results from Below search table and clicking on first result
		WebElement leadID = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//td[1]//a"));
		leadID.click();	
		
	}

	public static void editLead() {
		
		WebElement btnEdit = driver.findElement(By.xpath("//a[text()='Edit']"));
		btnEdit.click();
		
		WebElement edtFirstName = driver.findElement(By.id("updateLeadForm_firstName"));
		edtFirstName.clear();
		edtFirstName.sendKeys("Zoho");
		
		WebElement btnUpdate = driver.findElement(By.name("submitButton"));
		btnUpdate.click();
		
	}
	
}
