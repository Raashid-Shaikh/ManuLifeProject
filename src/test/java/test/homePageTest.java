package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.homePage;

public class homePageTest extends TestBase{

	//Initialize page object
	homePage hp ;
	
	//calls the parent class constructor
	public homePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		hp = new homePage();
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void clickNavbar()  {
		hp.clickFirstNav();
		
		driver.navigate().back();
		
		hp.clickSecondNav();
		
		driver.navigate().back();
		
		hp.clickSixthNav();
		
		driver.navigate().back();
		
		hp.clickThirdNav();
		
		
	}
}
