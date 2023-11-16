package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

//modeling page as objects using POM
public class homePage extends TestBase{

	//constructor
	//associates page elements 
	public homePage() {
		PageFactory.initElements(driver, this);
	}
	
	//used in conjuction with pageFactory
	@FindBy(xpath="//nav[@id='navbar']//li[1]")
	WebElement planAndLearn;
	
	@FindBy(xpath = "//ul[@class='submenu'][1]//a")
    public List<WebElement> submenuLinks;

	@FindBy(xpath="//nav[@id='navbar']//li[2]")
	WebElement groupPlans;
	
	@FindBy(xpath="//nav[@id='navbar']//li[6]")
	WebElement vitality;
	
	@FindBy(xpath="//nav[@id='navbar']//li[3]")
	WebElement Insurance;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	
	//to check the buttons on nav
	public void clickFirstNav(){
		
		wait.until(ExpectedConditions.visibilityOf(planAndLearn));
		planAndLearn.click();
	
	}
	
	public void clickSecondNav() {
		wait.until(ExpectedConditions.visibilityOf(groupPlans));
		groupPlans.click();
	
	}
	
	public void clickSixthNav()  {
		wait.until(ExpectedConditions.visibilityOf(vitality));
		vitality.click();
		
	}
	
	public void clickThirdNav() {
		wait.until(ExpectedConditions.visibilityOf(Insurance));
		Insurance.click();
		
	}
	
	
	
}
