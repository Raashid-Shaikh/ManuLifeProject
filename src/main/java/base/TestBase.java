package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		
		
		 
		try {
			prop = new Properties();
			FileInputStream fileReader = new FileInputStream("/Users/raashidshaikh/Desktop/QA/SeleniumWorkSpace/ManulifeProject/src/main/java/config/config.properties");
			prop.load(fileReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void initialization() {
		String browser = prop.getProperty("browser");
		
		
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		
		else {
			driver = new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
	}
}
