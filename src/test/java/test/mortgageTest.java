package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.mortgagePage;

public class mortgageTest extends TestBase{
	
	mortgagePage mp;
	
	public mortgageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() {
		initialization();
		mp = new mortgagePage();
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void calculateMortgage() throws InterruptedException {
		mp.manulifeBankClick();
		mp.homeCalculate();
		mp.affordCalculate();
		
	}
}
