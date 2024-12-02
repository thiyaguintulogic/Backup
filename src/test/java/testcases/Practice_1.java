package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class Practice_1 extends BaseTest{

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
	
	@Test(priority = 1)
	public static void OPandLabCombined() throws InterruptedException, AWTException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
//		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", menuIcon);
//		Thread.sleep(5000);
		
		WebElement viewAppointmentsButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' View Appointments')]")));
		viewAppointmentsButton.click();

		WebElement checkInButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Check In'])[1]")));
		checkInButton.click();

		WebElement firstRowFirstColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[1]/span")));
		String valueOfFirstRowFirstColumn = firstRowFirstColumn.getText().trim();
        System.out.println("OP Bill Patient Code :" + valueOfFirstRowFirstColumn);

		WebElement OPmenuIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor OPexecutor = (JavascriptExecutor) driver;
		OPexecutor.executeScript("arguments[0].click();", OPmenuIcon);
		
		WebElement CurretntAdmission = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' Current Admissions']")));
		CurretntAdmission.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@title='Search']")).click();
 		
 		WebElement SearchStatus = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
 		SearchStatus.sendKeys(valueOfFirstRowFirstColumn);
 		SearchStatus.sendKeys(Keys.ENTER);
 		Thread.sleep(2000);

	WebElement firstElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[8]/div[1]/a[1]/span[1]")));
	firstElement.click();
	
	WebElement labElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Lab')]")));
	labElement.click();
	
	WebElement addNewElement1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])")));
	addNewElement1.click();
	
	WebElement selectDropdown1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
	selectDropdown1.click();
	
	WebElement altBloodTest = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'01 lab test ')]")));
	altBloodTest.click();
	
	WebElement addNewElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])")));
	addNewElement2.click();
	
	WebElement selectDropdown2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
	selectDropdown2.click();

	WebElement bilirubinPack = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Allergy Skin Test ')]")));
	bilirubinPack.click();
	
	WebElement addNewElement3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])")));
	addNewElement3.click();
	
	WebElement selectDropdown3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
	selectDropdown3.click();
	
	WebElement liverTestPack = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Antibiotic Sensitivity Test ')]")));
	liverTestPack.click();
	
	WebElement saveAndCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),' Save & Close ')])[2]")));
	saveAndCloseButton.click();
	Thread.sleep(2000);
		

	WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", menuIcon);
	Thread.sleep(5000);
	
		WebElement opButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' OP']")));
		opButton.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchStatus1 = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus1.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
						
		WebElement ActionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[6]/div[1]/div[1]")));
		ActionButton.click();
		Thread.sleep(3000);
		
		WebElement firstAddButton = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@title='View Bill'])[2]")));
		firstAddButton.click();
		
		WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='bill-view-opbilladd']")));
		addButton.click();

		WebElement firstSelectDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
		firstSelectDropdown.click();

		WebElement aadityaConsultationFees = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[contains(text(),'Dr.Neeraj Fees ')]")));
		aadityaConsultationFees.click();

		WebElement secondAddButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='bill-view-opbilladd']")));
		secondAddButton.click();

		WebElement secondSelectDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
		secondSelectDropdown.click();

		WebElement opRegistrationFees = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[contains(text(),'OP Registration fees ')]")));
		opRegistrationFees.click();

		WebElement payBillButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Pay Bill')]")));
		payBillButton.click();

		WebElement yesButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Yes')]")));
		yesButton.click();
		Thread.sleep(2000);

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
		
		driver.findElement(By.xpath("(//a[text()=' OP'])")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchStatus_OP = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus_OP.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus_OP.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement ActionButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[6]/div[1]/div[1]")));
		ActionButton1.click();
		Thread.sleep(3000);
		
		WebElement PatientCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
		String AfterPaidPatientCode = PatientCode.getText();

		WebElement Billnumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[9]")));
		String AfterPaidBillnumber = Billnumber.getText();

		WebElement AfterStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[12]")));
		String AfterPaidStatus = AfterStatus.getText();

		System.out.println("After paying the OP Bill - Patient Code : " + AfterPaidPatientCode);
		System.out.println("After paying the OP Bill - Bill Number  : " + AfterPaidBillnumber);
		System.out.println("After paying the OP Bill - Bill Status  : " + AfterPaidStatus);
		
		// Lab payment
		
		WebElement firstTableButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='View Bill'])[1]")));
		firstTableButton.click();
		
		WebElement payBillButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Pay Bill')]")));
		payBillButton1.click();
		
		WebElement yesButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Yes')]")));
		yesButton1.click();
		
		Thread.sleep(2000);
		
		Actions actions1 = new Actions(driver);
		actions1.sendKeys(Keys.TAB).build().perform();
		actions1.sendKeys(Keys.ENTER).build().perform();

		Robot robot1 = new Robot();
		robot1.delay(2000);

		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyRelease(KeyEvent.VK_TAB);

		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);

		WebElement menuIcon_Lab = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor_Lab = (JavascriptExecutor) driver;
		executor_Lab.executeScript("arguments[0].click();", menuIcon_Lab);
		
		driver.findElement(By.xpath("(//a[text()=' OP'])")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchStatus_Lab = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus_Lab.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus_Lab.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement ActionButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[6]/div[1]/div[1]")));
		ActionButton3.click();
		Thread.sleep(3000);
		
		WebElement PatientCodeLab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
		String AfterPaidPatientCodeLab = PatientCodeLab.getText();

		WebElement LabBillnumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[15]")));
		String AfterPaidlabBillnumber = LabBillnumber.getText();

		WebElement AfterStatusLab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[18]")));
		String AfterPaidLabStatus = AfterStatusLab.getText();
		
		 System.out.println("Lab Bill Patient Code :" + valueOfFirstRowFirstColumn);
		
		System.out.println("After paying the Lab Bill - Patient Code : " + AfterPaidPatientCodeLab);
		System.out.println("After paying the Lab Bill - Bill Number  : " + AfterPaidlabBillnumber);
		System.out.println("After paying the Lab Bill - Bill Status  : " + AfterPaidLabStatus);
		
				
	}
	
}
