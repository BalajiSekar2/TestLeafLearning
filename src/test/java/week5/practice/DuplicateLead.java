package week5.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	RemoteWebDriver driver;
	
	@Parameters({"URL","BROWSER_NAME"})
	@BeforeMethod
	public void initalizeBrowser(String url,String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}	
	
	@DataProvider(name="getData")
	public String[][] data(){
		String data[][]=new String[3][3];
		
		//row1
		data[0][0]="Demosalesmanager";
		data[0][1]="crmsfa";
		data[0][2]="123";
		
		//row2
		data[1][0]="Demosalesmanager";
		data[1][1]="crmsfa";
		data[1][2]="234";
		
		//row3
		data[2][0]="Demosalesmanager";
		data[2][1]="crmsfa";
		data[2][2]="345";
		
		return data;
	}
	
	@Test(dataProvider = "getData")
	public void createLead(String username,String password,String companyName) {

		WebElement edtUserName = driver.findElement(By.id("username"));
		WebElement edtPassword = driver.findElement(By.id("password"));
		WebElement btnLogin = driver.findElement(By.className("decorativeSubmit"));

		edtUserName.sendKeys(username);
		edtPassword.sendKeys(password);
		btnLogin.click();

		// click CRM/SFA app
		WebElement btnCRMSFA = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
		btnCRMSFA.click();

		WebElement createLeadLink = driver.findElement(By.linkText("Create Lead"));
		createLeadLink.click();

		WebElement lnkCreateLead = driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]"));
		lnkCreateLead.click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Bala");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Balaji");
		driver.findElement(By.name("departmentName")).sendKeys("Test");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test Desc");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("TestEmail@gmail.com");
		
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateObj =new Select(state);
		stateObj.selectByVisibleText("New York");	
				
		driver.findElement(By.name("submitButton")).click();
		
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("Lead is Created Successfully");
		}else {
			System.out.println("Lead is not created");
		}
	}
	
	
}
