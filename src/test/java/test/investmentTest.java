package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.investmentPage;

public class investmentTest extends TestBase{

	investmentPage ip;
	
	public investmentTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		ip = new investmentPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void navClick() throws InterruptedException {
		ip.clickNavFour();
		ip.gatherResources();
	}
}
