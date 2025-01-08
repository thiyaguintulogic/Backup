package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	
	
	@BeforeTest
	public void setUp() throws IOException {
		
		if (driver==null) {
			
			FileReader fr = new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\configfiles\\config.properties");
			prop.load(fr);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				
			WebDriverManager.chromedriver().setup();
			//WebDriverManager.chromedriver().browserVersion("124.0.6367.208").setup();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-cache"); 
	        options.addArguments("--disable-logging");
	        options.addArguments("--disable-extensions");
	        //options.addArguments("--incognito");
	        driver = new ChromeDriver(options);
			 driver.manage().window().maximize();
			driver.get(prop.getProperty("UAT"));
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			driver.get(prop.getProperty("UAT"));
		}
		
		else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
			driver.get(prop.getProperty("UAT"));
		}
		
		
	}

	@AfterTest
	public void tearDown() {

		
	       // driver.quit();
	    
	}
}
