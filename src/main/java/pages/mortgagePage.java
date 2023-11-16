package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class mortgagePage extends TestBase{
	
	//constructor
	//associates page elements 
	public mortgagePage() {
		PageFactory.initElements(driver, this);
	}
	
	//used in conjuction with pageFactory
	@FindBy(xpath="//ul[@class='navbar-nav']//li[3]")
	WebElement mortgages;
	
	@FindBy(xpath="//ul[@class='navbar-nav']//li[5]")
	WebElement manulifeBank;
	
	@FindBy(linkText="I'm buying a home")
	WebElement buyingHome;
	
	@FindBy(id="homepayment")
	WebElement homePrice;
	
	@FindBy(name="inputPayment")
	WebElement downPayment;
	
	@FindBy(id="calci")
	WebElement submit;
	
	@FindBy(linkText="See what you can afford")
	WebElement affordButton;
	
	@FindBy(id="monthlyIncome")
	WebElement 	grossHouseIncome;
	
	@FindBy(id="income_type")
	WebElement selectType;
	
	@FindBy(id="heatingCosts")
	WebElement totalUtilities;
	
	@FindBy(id="propertyTaxes")
	WebElement propTax;
	
	@FindBy(id="mortgageDetail")
	WebElement nextButton;
	
	@FindBy(id="calculate")
	WebElement calculate;
	
	@FindBy(xpath="//div[@class='interest__chequing--account']//ul")
	List<WebElement> downPaymentAmounts;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//clicks on 5th element on navbar
	public void manulifeBankClick() {
		
		wait.until(ExpectedConditions.visibilityOf(manulifeBank));
		manulifeBank.click();
		
		String currentHandle = driver.getWindowHandle();
		System.out.println("Pointer to current window: " +currentHandle);
		
		//iterates over set of window handles
		//switches to the current window on driver's instance
		for(String winHandles: driver.getWindowHandles()) {
			driver.switchTo().window(winHandles);
		}
		
		wait.until(ExpectedConditions.visibilityOf(mortgages));
		mortgages.click();
			
	}
	
	public void homeCalculate() {
		wait.until(ExpectedConditions.visibilityOf(buyingHome));
		buyingHome.click();
		
		homePrice.sendKeys("100000");
		downPayment.sendKeys("1000");
		wait.until(ExpectedConditions.visibilityOf(submit));
		submit.click();
		//get the location of "see what you can afford"
		System.out.println("Location of Button:");
		System.out.println(affordButton.getLocation());
		System.out.println('\n');
		//scroll to the location to get the element on screen
		js.executeScript("window.scrollBy(537, 967)");
		
		wait.until(ExpectedConditions.visibilityOf(affordButton));
		affordButton.click();
		
	}
	
	public void affordCalculate() {
		//next should not be displayed if no value is entered in the fields
		Boolean invisiblebutton = nextButton.isEnabled();
		System.out.println("Is next button enabled T/F: " +invisiblebutton);
		System.out.println('\n');
		grossHouseIncome.sendKeys("10000");
		//use select class to change the dropdown option
		Select select = new Select(selectType);
		select.selectByIndex(1);
		totalUtilities.sendKeys("1000");
		propTax.sendKeys("2000");
		
		wait.until(ExpectedConditions.visibilityOf(nextButton));
		nextButton.click();
		
		wait.until(ExpectedConditions.visibilityOf(calculate));
		calculate.click();
		
		Boolean visiblebutton = nextButton.isEnabled();
		System.out.println("Is next button enabled T/F: " +visiblebutton);
		System.out.println('\n');
		
		//use implicit wait as explicit wait does not take list
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("Below are the options based on payment amounts: ");
		for(WebElement i: downPaymentAmounts) {
			System.out.println(i.getText() + '\n');
		}
		
	}
	
	
}
