package week5;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LearnAtrributes {

	@Test(invocationCount = 10) 
	public void tc001() {
		System.out.println("Test case 001"); 
	}

	@Test(invocationCount = 10, threadPoolSize = 5) 
	public void tc002() {
		System.out.println("Test case 002"); }

	@Test(invocationCount = 5, invocationTimeOut = 7000) 
	public void tc003() throws InterruptedException { 
		Thread.sleep(2000);
		System.out.println("Test case 003"); 
	}

	@Test(invocationCount = 5, timeOut = 1000 ) 
	public void tc004() throws InterruptedException { 
		Thread.sleep(2000);
		System.out.println("Test case 004"); 
	}


	@Ignore
	@Test() public void tc005() { 
		System.out.println("Test case 001"); 
	}

	@Test(enabled = false) 
	public void tc006() {
		System.out.println("Test case 006"); 
	}

	@Test(priority = -1) 
	public void tc007() {
		System.out.println("Test case 007"); 
	}


	@Test(dependsOnMethods = {"week5.day1.LearnAttributes.tc003"},alwaysRun = true)
	public void tc011()  {
		System.out.println("Test case 001");
	}

	@Test()
	public void tc012()  {
		System.out.println("Test case 003");
		throw new RuntimeException();
	}

	@Test(priority = -1)
	public void tc013()  {
		System.out.println("Test case 002");
	}

	@Test()
	public void tc014()  {
		System.out.println("Test case 004");
	}

}

