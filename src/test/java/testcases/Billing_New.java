package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import base.BaseTest;

public class Billing_New extends BaseTest {

	@Test(priority = 0)
	public static void Logintest() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin-email")));
		username.sendKeys("intuadmin");

		WebElement password = driver.findElement(By.id("signin-password"));
		password.sendKeys("scott");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(8000);

		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);

	}

	
	public static void OPBill_Appointment() throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Create Patient Registration
		driver.findElement(By.xpath("//a[contains(text(),' Patient Registration')]")).click();

		driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys("Harish");
		driver.findElement(By.xpath("//input[@title='Age']")).sendKeys("39");
		driver.findElement(By.xpath("//input[@title='Phone Number']")).sendKeys("4565896987");
		driver.findElement(By.xpath("//span[contains(text(),'Male')]")).click();

		Select State = new Select(driver.findElement(By.xpath("//select[@id='cityChange']")));
		State.selectByVisibleText(" Tamil Nadu ");

		driver.findElement(By.xpath("//span[text()='Select']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Salem')]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");

		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

		Thread.sleep(5000);

		// Create Appointment
		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),' Patient Search')]")).click();
		Thread.sleep(5000);

		WebElement appointmentButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Appointment'])[1]")));
		appointmentButton.click();

		Thread.sleep(2000);

		WebElement purposeDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Purpose of Visit']")));
		purposeDropdown.click();

		Select selectPurposeofVisit = new Select(purposeDropdown);
		selectPurposeofVisit.selectByVisibleText("Out Patient");

		WebElement selectDoctorDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Doctor']")));
		selectDoctorDropdown.click();

		Select selectDoctor = new Select(selectDoctorDropdown);
		selectDoctor.selectByVisibleText(" Dr.Jeeva S ");

		driver.findElement(By.xpath("//button[contains(text(),' Save & Close ')]")).click();
		Thread.sleep(3000);

		// Appointment Check-In

		WebElement menuIcon1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", menuIcon1);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),' View Appointments')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@title='Check In'])[1]")).click();
		Thread.sleep(2000);

		WebElement firstRowFirstColumn = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/span"));
		String valueOfFirstRowFirstColumn = firstRowFirstColumn.getText();
		System.out.println("Value of First Row First Column: " + valueOfFirstRowFirstColumn);

		WebElement OPmenuIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor OPexecutor = (JavascriptExecutor) driver;
		OPexecutor.executeScript("arguments[0].click();", OPmenuIcon);

		driver.findElement(By.xpath("//a[text()=' OP']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchStatus = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//tbody[1]/tr[1]/td[10]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@title='Add'])[1]")).click();

		driver.findElement(By.xpath("(//mat-select[@placeholder='Select'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Dr. Aaditya Consultation Fees	 ')]")).click();

		driver.findElement(By.xpath("(//button[@title='Add'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//mat-select[@placeholder='Select'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'OP-Registration fees ')]")).click();

		driver.findElement(By.xpath("//button[contains(text(),'Pay Bill')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();

		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();

		Robot robot = new Robot();
		robot.delay(2000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
//		driver.findElement(By.xpath("//button[@title='Search']")).click();
//		
//		WebElement SearchStatus1 = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
//		SearchStatus1.sendKeys(valueOfFirstRowFirstColumn);
//		SearchStatus1.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
		
		
		
		WebElement PatientCode = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
        String AfterPaidPatientCode = PatientCode.getText();
        
        WebElement Billnumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[6]")));
		String AfterPaidBillnumber = Billnumber.getText();
		
		WebElement AfterStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[8]")));
		String AfterPaidStatus = AfterStatus.getText();
		
		System.out.println( "After paying the OP Bill - Patient Code : " + AfterPaidPatientCode);
		System.out.println( "After paying the OP Bill - Bill Number  : " + AfterPaidBillnumber);
		System.out.println( "After paying the OP Bill - Bill Status  : " + AfterPaidStatus);
	}

	
	
	public static void LabBill_Appointment() throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		 WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
//	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
//	    js1.executeScript("arguments[0].click();", menuIcon);
//
//	    Thread.sleep(5000);

		// Create Patient Registration
		driver.findElement(By.xpath("//a[contains(text(),' Patient Registration')]")).click();

		driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys("Harish");
		driver.findElement(By.xpath("//input[@title='Age']")).sendKeys("23");
		driver.findElement(By.xpath("//input[@title='Phone Number']")).sendKeys("5425698785");
		driver.findElement(By.xpath("//span[contains(text(),'Male')]")).click();	
		

		Select State = new Select(driver.findElement(By.xpath("//select[@id='cityChange']")));
		State.selectByVisibleText(" Tamil Nadu ");

		driver.findElement(By.xpath("//span[text()='Select']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Madurai')]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");

		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();	
		

		Thread.sleep(5000);

		// Create Appointment
		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),' Patient Search')]")).click();
		Thread.sleep(5000);

		WebElement appointmentButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Appointment'])[1]")));
		appointmentButton.click();

		Thread.sleep(2000);

		WebElement purposeDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Purpose of Visit']")));
		purposeDropdown.click();

		Select selectPurposeofVisit = new Select(purposeDropdown);
		selectPurposeofVisit.selectByVisibleText("Out Patient");

		WebElement selectDoctorDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Doctor']")));
		selectDoctorDropdown.click();

		Select selectDoctor = new Select(selectDoctorDropdown);
		selectDoctor.selectByVisibleText(" Dr.Jeeva S ");

		driver.findElement(By.xpath("//button[contains(text(),' Save & Close ')]")).click();
		Thread.sleep(3000);

		// Appointment Check-In

		WebElement menuIcon1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", menuIcon1);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),' View Appointments')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@title='Check In'])[1]")).click();
		Thread.sleep(2000);

		WebElement firstRowFirstColumn = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/span"));
		String valueOfFirstRowFirstColumn = firstRowFirstColumn.getText();
		System.out.println("Value of First Row First Column: " + valueOfFirstRowFirstColumn);

		// Lab Billing Steps

		WebElement CurrentmenuIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor Currentmenuexecutor = (JavascriptExecutor) driver;
		Currentmenuexecutor.executeScript("arguments[0].click();", CurrentmenuIcon);

		driver.findElement(By.xpath("//a[contains(text(),' Current Admissions')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchStatus = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//tbody/tr[1]/td[8]/div[1]/a[1]/span[1]")).click();

		driver.findElement(By.xpath("//Span[contains(text(),'Lab')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[contains(text(),'Add New')])[2]")).click();

		driver.findElement(By.xpath("(//mat-select[@placeholder='Select'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),' ALT Blood Test ')]")).click();

		driver.findElement(By.xpath("(//span[contains(text(),'Add New')])[2]")).click();

		driver.findElement(By.xpath("(//mat-select[@placeholder='Select'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),' BILIRUBIN PACK ')]")).click();

		driver.findElement(By.xpath("(//span[contains(text(),'Add New')])[2]")).click();

		driver.findElement(By.xpath("(//mat-select[@placeholder='Select'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),' LIVER TEST PACK ')]")).click();

		driver.findElement(By.xpath("(//button[contains(text(),' Save & Close ')])[2]")).click();
		Thread.sleep(5000);

		WebElement LabtmenuIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor Labexecutor = (JavascriptExecutor) driver;
		Labexecutor.executeScript("arguments[0].click();", LabtmenuIcon);

		driver.findElement(By.xpath("(//a[text()=' Lab'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchPatient = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchPatient.sendKeys(valueOfFirstRowFirstColumn);
		SearchPatient.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//tbody[1]/tr[1]/td[10]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'Pay Bill')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		Thread.sleep(5000);

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();

		Robot robot = new Robot();
		robot.delay(2000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement menuIcon_OP = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor_OP = (JavascriptExecutor) driver;
		executor_OP.executeScript("arguments[0].click();", menuIcon_OP);
		
		driver.findElement(By.xpath("(//a[text()=' Lab'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchStatus_OP = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus_OP.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus_OP.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement PatientCode = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
        String AfterPaidPatientCode = PatientCode.getText();
        
        WebElement Billnumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[6]")));
		String AfterPaidBillnumber = Billnumber.getText();
		
		WebElement AfterStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[8]")));
		String AfterPaidStatus = AfterStatus.getText();
		
		System.out.println( "After paying the Lab Bill - Patient Code : " + AfterPaidPatientCode);
		System.out.println( "After paying the Lab Bill - Bill Number  : " + AfterPaidBillnumber);
		System.out.println( "After paying the Lab Bill - Bill Status  : " + AfterPaidStatus);
		
	}

	
	public void Create_ScanBill() throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//		WebElement menu1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(loc.getProperty("main_menu"))));
//
//	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
//	    js1.executeScript("arguments[0].click();", menu1);
//
//	    Thread.sleep(5000);

		// Create Patient Registration
		driver.findElement(By.xpath("//a[contains(text(),' Patient Registration')]")).click();

		driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys("vivek");
		driver.findElement(By.xpath("//input[@title='Age']")).sendKeys("37");
		driver.findElement(By.xpath("//input[@title='Phone Number']")).sendKeys("3525456987");
		driver.findElement(By.xpath("//span[contains(text(),'Male')]")).click();

		Select State = new Select(driver.findElement(By.xpath("//select[@id='cityChange']")));
		State.selectByVisibleText(" Tamil Nadu ");

		driver.findElement(By.xpath("//span[text()='Select']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Tenkasi')]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");

		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

		Thread.sleep(5000);

		// Create Appointment
		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),' Patient Search')]")).click();
		Thread.sleep(5000);

		WebElement appointmentButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Appointment'])[1]")));
		appointmentButton.click();

		Thread.sleep(2000);

		WebElement purposeDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@title='Select Purpose of Visit'])[1]")));
		purposeDropdown.click();

		Select selectPurposeofVisit = new Select(purposeDropdown);
		selectPurposeofVisit.selectByVisibleText("Scan");

		WebElement Scantype = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@title='Select Purpose of Visit'])[2]")));
		Scantype.click();

		Select selectScantype = new Select(Scantype);
		selectScantype.selectByVisibleText("Andrology");
		
		WebElement selectDoctorDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Doctor']")));
		selectDoctorDropdown.click();

		Select selectDoctor = new Select(selectDoctorDropdown);
		selectDoctor.selectByVisibleText(" Dr.Jeeva S ");

		driver.findElement(By.xpath("//button[contains(text(),' Save & Close ')]")).click();
		Thread.sleep(3000);

		// Appointment Check-In

		WebElement menuIcon1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", menuIcon1);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),' View Appointments')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@title='Check In'])[1]")).click();
		Thread.sleep(2000);

		WebElement firstRowFirstColumn = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/span"));
		String valueOfFirstRowFirstColumn = firstRowFirstColumn.getText();
		System.out.println("Value of First Row First Column: " + valueOfFirstRowFirstColumn);

		WebElement ScanmenuIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor Scanexecutor = (JavascriptExecutor) driver;
		Scanexecutor.executeScript("arguments[0].click();", ScanmenuIcon);

		driver.findElement(By.xpath("//a[text()=' Scan']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchStatus = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//tbody[1]/tr[1]/td[10]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[@title='Add'])[1]")).click();

		driver.findElement(By.xpath("(//mat-select[@placeholder='Select'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'MRI Scan ')]")).click();

		driver.findElement(By.xpath("(//button[@title='Add'])[1]")).click();

		driver.findElement(By.xpath("//mat-select[@placeholder='Select']")).click();

		driver.findElement(By.xpath("//span[contains(text(),'CT Scan ')]")).click();

		driver.findElement(By.xpath("//button[contains(text(),'Pay Bill')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		Thread.sleep(5000);

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();

		Robot robot = new Robot();
		robot.delay(2000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	
	
	public static void OPBill_PartialPayment() throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

//		 WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
//	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
//	    js1.executeScript("arguments[0].click();", menuIcon);
//
//	    Thread.sleep(5000);

		// Create Patient Registration
		WebElement patientRegistrationLink = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' Patient Registration')]")));
		patientRegistrationLink.click();

		driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys("Manoj");
		driver.findElement(By.xpath("//input[@title='Age']")).sendKeys("48");
		driver.findElement(By.xpath("//input[@title='Phone Number']")).sendKeys("3265458965	");
		driver.findElement(By.xpath("//span[contains(text(),'Male')]")).click();

		Select State = new Select(driver.findElement(By.xpath("//select[@id='cityChange']")));
		State.selectByVisibleText(" Tamil Nadu ");

		driver.findElement(By.xpath("//span[text()='Select']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Chennai')]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");

		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

		Thread.sleep(5000);

		// Create Appointment
		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),' Patient Search')]")).click();
		Thread.sleep(5000);

		WebElement appointmentButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Appointment'])[1]")));
		appointmentButton.click();

		Thread.sleep(2000);

		WebElement purposeDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Purpose of Visit']")));
		purposeDropdown.click();

		Select selectPurposeofVisit = new Select(purposeDropdown);
		selectPurposeofVisit.selectByVisibleText("Out Patient");

		WebElement selectDoctorDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Doctor']")));
		selectDoctorDropdown.click();

		Select selectDoctor = new Select(selectDoctorDropdown);
		selectDoctor.selectByVisibleText(" Dr.Jeeva S ");

		driver.findElement(By.xpath("//button[contains(text(),' Save & Close ')]")).click();
		Thread.sleep(3000);

		// Appointment Check-In

		WebElement menuIcon1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", menuIcon1);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),' View Appointments')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@title='Check In'])[1]")).click();
		Thread.sleep(2000);

		WebElement firstRowFirstColumn = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/span"));
		String valueOfFirstRowFirstColumn = firstRowFirstColumn.getText();
		System.out.println("Value of First Row First Column: " + valueOfFirstRowFirstColumn);

		WebElement OPmenuIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor OPexecutor = (JavascriptExecutor) driver;
		OPexecutor.executeScript("arguments[0].click();", OPmenuIcon);

		driver.findElement(By.xpath("//a[text()=' OP']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@title='Search']")).click();

		WebElement SearchStatus = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//tbody[1]/tr[1]/td[10]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@title='Add'])[1]")).click();

		driver.findElement(By.xpath("(//mat-select[@placeholder='Select'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Dr. Aaditya Consultation Fees	 ')]")).click();

		driver.findElement(By.xpath("(//button[@title='Add'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//mat-select[@placeholder='Select'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'OP-Registration fees ')]")).click();

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, 500);");

		// Extract the amount
		String amountText = driver.findElement(By.xpath("(//td[contains(text(),'₹')])[1]")).getText();
		String amountValue = amountText.replaceAll("[^0-9.]", ""); // Extract numeric characters
		double originalAmount = Double.parseDouble(amountValue);

		// Calculate half of the amount
		double halfAmount = originalAmount / 2;

		// Get the whole number part of halfAmount
		int wholeNumberPart = (int) halfAmount;

		System.out.println("Original Amount: " + originalAmount);
		System.out.println("Half Amount: " + halfAmount);

		driver.findElement(By.xpath("(//td)[43]")).click();
		Thread.sleep(2000);
		System.out.println("Before interacting with amount element");

		// Explicit wait for the input box to be clickable
		WebElement amountInputBox = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@title='Amount*'])[1]")));
		System.out.println("After interacting with the amount input box");

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", amountInputBox);

		// Use JavaScript to clear the input box
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", amountInputBox);

		// Set the whole number part directly using sendKeys
		amountInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, String.valueOf(wholeNumberPart));

		// Explicit wait for the element to be clickable

		driver.findElement(By.xpath("//button[contains(text(),'Pay Bill')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();

		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();

		Robot robot = new Robot();
		robot.delay(2000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("OP: Patient registration is completed, the appointment has been scheduled, "
				+ "the patient has checked in for the appointment, "
				+ "and a partial payment has been successfully processed for that patient");
	}

	
	@Test(priority=1)
	public static void IPBill_ExtraAmount() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement IPlink = driver.findElement(By.xpath("//a[text()=' IP']"));
		IPlink.click();
		Thread.sleep(2000);

		// Extract the amount

		driver.findElement(By.xpath("//button[@title='Filter']")).click();
		
		
		WebElement FilterALL = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[2]")));
		FilterALL.click();
		Thread.sleep(3000);
		
//		WebElement FilterUnpaid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[3]")));
//		FilterUnpaid.click();
		
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
	    searchButton.click();
		
		WebElement columnValueElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
		String columnValue = columnValueElement.getText();
//		System.out.println("Value of column (//td)[1]: " + columnValue);
		System.out.println("IP Bill- Patient Code: " + columnValue);
		
		// Capture Bill Status Before Paid
		WebElement beforeStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[1]/tr[1]/td[10]/span[1]")));
		String columnValueStatus = beforeStatus.getText();
		System.out.println(columnValue + " : Before paying the IP bill, status : " + columnValueStatus);

		WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[9]")));
		String amountText = amountElement.getText();
		System.out.println("Amount Text: " + amountText);

		// Remove non-numeric characters using a regular expression
		String amountValue = amountText.replaceAll("[^0-9.]", "");

		System.out.println("Cleaned Amount Text: " + amountValue);

		double originalAmount = Double.parseDouble(amountValue);

		// Calculate half of the amount
		double halfAmount = originalAmount / 2;

		// Get the whole number part of halfAmount
		int wholeNumberPart = (int) halfAmount;

		System.out.println("Original Amount: " + originalAmount);
		System.out.println("Half Amount: " + halfAmount);
		System.out.println("Whole number is: " + wholeNumberPart);

		WebElement viewIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='view bill'])[1]")));
		viewIcon.click();

		// Add Receipt - Payment by Cash

		WebElement AddReceipt = driver.findElement(By.xpath("//button[contains(text(),'Add Receipt')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", AddReceipt);

		// Wait for the PaymentType dropdown to be clickable
		WebElement paymentTypeDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@value='null']")));

		// Use Select class to interact with dropdown
		Select paymentTypeSelect = new Select(paymentTypeDropdown);
		paymentTypeSelect.selectByVisibleText("Advance");

		Select PaymentMode = new Select(driver.findElement(By.xpath("(//app-bill-details//select)[2]")));
		PaymentMode.selectByVisibleText("Cash");

		WebElement amountInputBox = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Amount']	")));
		amountInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, String.valueOf(wholeNumberPart));

		WebElement ReceiptPay = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Pay']")));
		ReceiptPay.click();
		Thread.sleep(5000);

		// Add Receipt - Payment by Card

		

		WebElement IPBills = driver.findElement(By.xpath("//a[contains(text(),'IP Bills')]"));
		wait.until(ExpectedConditions.elementToBeClickable(IPBills));
		IPBills.click();
		Thread.sleep(3000);

		WebElement searchInputCard = driver.findElement(By.xpath("//button[@title='Search']"));
		searchInputCard.click();
		searchInputCard.sendKeys(columnValue);
		Thread.sleep(3000);
		
		WebElement SearchStatus = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus.sendKeys(columnValue);
		SearchStatus.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		// Extract the amount
		WebElement amountElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[9]")));
		String amountText1 = amountElement1.getText();
		System.out.println("Amount Text: " + amountText1);

		// Remove non-numeric characters using a regular expression
		String amountValue1 = amountText1.replaceAll("[^0-9.]", "");

		System.out.println("Cleaned Amount Text: " + amountValue1);

		double originalAmount1 = Double.parseDouble(amountValue1);

		// Calculate half of the amount
		double halfAmount1 = originalAmount1 / 2;

		// Get the whole number part of halfAmount
		int wholeNumberPart1 = (int) halfAmount1;
		
		

		WebElement viewIcon1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='view bill'])[1]")));
		viewIcon1.click();

		WebElement AddReceiptCard = driver.findElement(By.xpath("//button[contains(text(),'Add Receipt')]"));
		JavascriptExecutor executorCard = (JavascriptExecutor) driver;
		executorCard.executeScript("arguments[0].click();", AddReceiptCard);

		// Wait for the PaymentType dropdown to be clickable
		WebElement paymentTypeDropdownCard = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@value='null']")));

		// Use Select class to interact with dropdown
		Select paymentTypeSelectCard = new Select(paymentTypeDropdownCard);
		paymentTypeSelectCard.selectByVisibleText("Advance");

		Select PaymentModeCard = new Select(driver.findElement(By.xpath("(//app-bill-details//select)[2]")));
		PaymentModeCard.selectByVisibleText("Card");

		WebElement amountInputBox1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Amount']	")));
		amountInputBox1.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, String.valueOf(wholeNumberPart1));

		WebElement refcodeTextbox = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter Reference Code*']")));
		refcodeTextbox.sendKeys("2545698745");

		WebElement payButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Pay')]")));

		// Click the "Pay" button
		payButton.click();
		Thread.sleep(4000);
		
		// Pay the extra amount from the original amount.

		//WebElement IPBills1 = driver.findElement(By.xpath("//a[contains(text(),'IP Bills')]"));
		WebElement IPBills1 = driver.findElement(By.xpath("//a[contains(text(),'IP Bills')]"));
		wait.until(ExpectedConditions.elementToBeClickable(IPBills1));
		IPBills1.click();
		Thread.sleep(4000);

		WebElement searchInputCard1 = driver.findElement(By.xpath("//button[@title='Search']"));
		searchInputCard1.click();
		searchInputCard1.sendKeys(columnValue);
		Thread.sleep(3000);
		
		WebElement searchInputCard2 = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		searchInputCard2.sendKeys(columnValue);
		searchInputCard2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		// Extract the amount
		WebElement amountElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[9]")));
		String amountText2 = amountElement2.getText();
		System.out.println("Amount Text: " + amountText2);

		// Remove non-numeric characters using a regular expression
		String amountValue2 = amountText2.replaceAll("[^0-9.]", "");

		// Parse the original amount as a double
		double originalAmount2 = Double.parseDouble(amountValue2);

		// Add 1000 rupees to the original amount
		int amountToAdd = 1000;
		double finalAmount = originalAmount2 + amountToAdd;

		// Convert the final amount to a string
		String finalAmountString = String.valueOf(finalAmount);

		System.out.println("Cleaned Amount Text: " + amountValue2);

		WebElement viewIcon2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='view bill'])[1]")));
		viewIcon2.click();

		WebElement AddReceiptCard2 = driver.findElement(By.xpath("//button[contains(text(),'Add Receipt')]"));
		JavascriptExecutor executorCard2 = (JavascriptExecutor) driver;
		executorCard2.executeScript("arguments[0].click();", AddReceiptCard2);

		// Wait for the PaymentType dropdown to be clickable
		WebElement paymentTypeDropdownCard1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@value='null']")));

		// Use Select class to interact with dropdown
		Select paymentTypeSelectCard1 = new Select(paymentTypeDropdownCard1);
		paymentTypeSelectCard1.selectByVisibleText("Advance");

		Select PaymentModeCard1 = new Select(driver.findElement(By.xpath("(//app-bill-details//select)[2]")));
		PaymentModeCard1.selectByVisibleText("Card");

		WebElement amountInputBox2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Amount'] ")));
		amountInputBox2.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, finalAmountString);

		WebElement refcodeTextbox1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter Reference Code*']")));
		refcodeTextbox1.sendKeys("2545698745");

		WebElement payButton1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Pay')]")));

		// Click the "Pay" button
		payButton1.click();
		Thread.sleep(3000);
		

		// Bill Close

		WebElement IPBills2 = driver.findElement(By.xpath("//a[contains(text(),'IP Bills')]"));
		wait.until(ExpectedConditions.elementToBeClickable(IPBills2));
		IPBills2.click();
		Thread.sleep(3000);

		WebElement searchInputCard3 = driver.findElement(By.xpath("//button[@title='Search']"));
		searchInputCard3.click();
		searchInputCard3.sendKeys(columnValue);
		Thread.sleep(3000);

		WebElement searchInputClose = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		searchInputClose.sendKeys(columnValue);
		searchInputClose.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement viewIconclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='view bill'])[1]")));
		viewIconclose.click();

		// Scroll down using JavaScriptExecutor
		JavascriptExecutor executorScroll = (JavascriptExecutor) driver;
		executorScroll.executeScript("window.scrollBy(0, 500);");

		// Find the element
		WebElement addReceiptclose = driver.findElement(By.xpath("//button[contains(text(),'Bill Close')]"));

		// Click the element using JavaScriptExecutor
		JavascriptExecutor executorClose = (JavascriptExecutor) driver;
		executorClose.executeScript("arguments[0].click();", addReceiptclose);

		WebElement refundYes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Yes')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", refundYes);

		// Wait for the PaymentType dropdown to be clickable
		WebElement paymentTypeDropdownClose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@value='null']")));

		// Use Select class to interact with dropdown
		Select paymentTypeSelectClose = new Select(paymentTypeDropdownClose);
		paymentTypeSelectClose.selectByVisibleText("Refund");

		Select PaymentModeClose = new Select(driver.findElement(By.xpath("(//app-bill-details//select)[2]")));
		PaymentModeClose.selectByVisibleText("Card");

		WebElement balanceAmount = driver.findElement(By.xpath("//label[contains(text(), '-')]"));
		//System.out.println("Balance Amount: " + balanceAmount);
		String dynamicBalance = balanceAmount.getText();

		WebElement amountInputBoxclose = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Amount'] ")));
		amountInputBoxclose.clear();

		amountInputBoxclose.sendKeys(dynamicBalance);

		WebElement refcodeTextboxclose = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter Reference Code*']")));
		refcodeTextboxclose.sendKeys("2545698745");

		WebElement payButtonclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Pay')]")));

		// Click the "Pay" button
		payButtonclose.click();
		Thread.sleep(5000);

		//tbody/tr[7]/td[1]
		WebElement tableRow = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[7]/td[1]")));

		// Extract numeric part from the balance amount using regular expression
		String columnValueclose = tableRow.getText().replaceAll("[^0-9.]", "");
		System.out.println("Balance Amount: " + columnValueclose);

		// Check if the numeric part is zero
		if ("0".equals(columnValueclose.trim())) {
			// Find and click the "Bill Close" button
			WebElement billCloseButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Bill Close')]")));
			billCloseButton.click();
			System.out.println("Triggered the 'Bill Close' button because the balance amount is zero.");
			Thread.sleep(3000);
		} else {
			System.out.println("Since the balance amount is not zero, the 'Bill Close' button was not activated.");
		}
		
		WebElement Confirmclosebill = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Yes')]")));
		Confirmclosebill.click();
		Thread.sleep(2000);
		
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		  
		WebElement IPBills4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'IP Bills')]")));
		IPBills4.click();
		
		WebElement ipBillsElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'IP Bills')]")));
		ipBillsElement.click();
		
		WebElement searchInputCard4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchInputCard4.click();
		
		WebElement searchInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//thead/tr[2]/th[1]/input[1]"))); // Adjust the XPath to the input field if necessary
		searchInputField.sendKeys(columnValue);
		searchInputField.sendKeys(Keys.ENTER);
				
		
		// Capture Bill Status After Paid
		WebElement AfterStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[1]/tr[1]/td[10]/span[1]")));
		String columnValueStatusAfter = AfterStatus.getText();
		System.out.println(columnValue + " : After paying the IP bill, status : " + columnValueStatusAfter);

	}
	
	
}
