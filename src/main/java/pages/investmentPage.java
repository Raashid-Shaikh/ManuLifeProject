package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class investmentPage extends TestBase{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	
	//constructor
	//associates page elements 
	public investmentPage() {
		PageFactory.initElements(driver, this);
	}
	
	//used in conjuction with pageFactory
	@FindBy(xpath="//nav[@id='navbar']//li[4]")
	WebElement investments;
	
	@FindBy(xpath="//input[@id='search-input']")
	WebElement searchBar;
	
	@FindBy(xpath="//ul[@class='input-search__suggestion-list']//a")
	List<WebElement> searchElements;
	
	@FindBy(xpath="//button[@class='input-search__close-icon']")
	WebElement closeSearch;
	
	@FindBy(xpath="//li[@id='sidebar-submenu4']")
	WebElement resources;
	
	@FindBy(xpath="//input[@id='resource-filters-search']")
	WebElement searchType;
	
	@FindBy(xpath="//div[@class='resourceFilters__section'][1]/div//button")
	WebElement allTopics;
	
	@FindBy(xpath="//div[@class='resourceFilters__section'][2]/div//button")
	WebElement allAudience;
	
	/*
	@FindBy(css="button.cc-select__trigger#dropdown-g6f7fhsqq5f")
	WebElement allTopics;
	
	@FindBy(css="button.cc-select__trigger#dropdown-obbgn9qfs6")
	WebElement allAudience; */
	
	@FindBy(xpath="//button[@class='resourceFilters__submit']")
	WebElement submit;
	
	@FindBy(xpath="//ul[@class='resources__list']//a")
	List<WebElement> resourcesList;
	
	@FindBy(css="button[class='cc-select__item'][data-di-id='di-id-f8a4c559-bdadb9e1']")
	WebElement mutualFunds;
	
	@FindBy(css=".cc-select__dropdown > li:nth-child(2)")
	WebElement advisors;
	
	public void clickNavFour() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOf(investments));
		investments.click();
		
		//retieves the window handle of currently focused window
		String currentHandle= driver.getWindowHandle();
		System.out.println("Pointer to current window :" +currentHandle);
		System.out.println('\n');
		
		//iterates over set of window handles
		//switches to the current window on driver's instance
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.sendKeys("Education");
		Thread.sleep(2000);
		
		//prints the list of suggestions
		System.out.println("The search bar suggestions are:");
		for(WebElement i: searchElements) {
			System.out.println(i.getText());
		}
		System.out.println('\n');
		closeSearch.click();
	}
	
	//navigates to resources in navbar and selects respective fields
	public void gatherResources() throws InterruptedException {
		resources.click();
		wait.until(ExpectedConditions.visibilityOf(searchType));
		searchType.sendKeys("A");
		
		wait.until(ExpectedConditions.visibilityOf(allTopics));
		allTopics.click();
		
		wait.until(ExpectedConditions.visibilityOf(mutualFunds));
		mutualFunds.click();

		wait.until(ExpectedConditions.visibilityOf(allAudience));
		allAudience.click();
		
		wait.until(ExpectedConditions.visibilityOf(advisors));
		advisors.click();
		submit.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("Resource Documents Generated: ");
		for(WebElement i: resourcesList) {
			System.out.println(i.getText());
		}
		System.out.println('\n');
		
		
	}
	
	
	
	

}
