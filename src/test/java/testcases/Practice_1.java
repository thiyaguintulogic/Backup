package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import io.netty.handler.timeout.TimeoutException;

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
	
	
	public static void PatientRegistrationDOB() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	    WebElement patientRegistration = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' Patient Registration')]")));
		patientRegistration.click();

		// Fill out the registration form for the first patient
		WebElement firstName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='First Name']")));
		firstName.sendKeys("Dhanraj");
		
		WebElement Lastname = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[2]")));
		Lastname.sendKeys("V");

		try {
		    // Wait for the date picker input field to be visible
		    WebElement datePickerInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='DD-MM-YYYY']")));
		    JavascriptExecutor js1 = (JavascriptExecutor) driver;
		    js1.executeScript("arguments[0].scrollIntoView(true);", datePickerInput);
		    js1.executeScript("arguments[0].click();", datePickerInput);
		    
		    // Calculate the date 20 years ago from today
		    LocalDate today = LocalDate.now();
		    LocalDate dateTwentyYearsAgo = today.minusYears(20);
		    
		    // Format the date into components
		    DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d"); // Day without leading zero
		    DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM"); // Full month name
		    DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy"); // Year
		    
		    String formattedDay = dateTwentyYearsAgo.format(dayFormatter);
		    String formattedMonth = dateTwentyYearsAgo.format(monthFormatter);
		    String formattedYear = dateTwentyYearsAgo.format(yearFormatter);
		    
		    // Navigate to the year and month in the date picker (customize this based on your date picker logic)
		    WebElement yearSelector = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@class='year-selector']"))); // Adjust XPath as needed
		    yearSelector.sendKeys(formattedYear);
		    
		    WebElement monthSelector = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@class='month-selector']"))); // Adjust XPath as needed
		    monthSelector.sendKeys(formattedMonth);
		    
		    // Wait for the specific day to be clickable and click it
		    WebElement dateToSelect = wait.until(ExpectedConditions.presenceOfElementLocated(
		            By.xpath("//td[@class='available'][normalize-space()='" + formattedDay + "']")));
		    dateToSelect.click();
		    
		    // Click the Apply or Save button
		    WebElement saveDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='daterangepicker ltr single opensright show-calendar']//button[@type='button'][normalize-space()='Apply']")));
		    saveDate.click();
		    
		} catch (TimeoutException e) {
		    System.out.println("Timeout while waiting for date picker input: " + e.getMessage());
		} catch (Exception e) {
		    System.out.println("Error occurred: " + e.getMessage());
		}

		WebElement phoneNumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Phone Number']")));
		phoneNumber.sendKeys("3212425632");

		WebElement genderFemale = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Female')]")));
		genderFemale.click();

		WebElement stateDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='cityChange']")));
		Select state = new Select(stateDropdown);
		state.selectByVisibleText(" Tamil Nadu ");

		WebElement cityField = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"patientForm\"]/div[1]/div[15]/div/mat-form-field/div/div[1]")));
		cityField.click();

		WebElement cityChennai = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Trichy')]")));
		cityChennai.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");

		WebElement submitButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
		submitButton.click();

		Thread.sleep(5000);

	
	}
	
	@Test(priority = 1)
	public static void IP_Diagnosis() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		WebElement currentAdmissionsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' Current Admissions')]")));
		currentAdmissionsLink.click();
		
		WebElement IPList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='IP List']")));
		IPList.click();
		Thread.sleep(2000);
		
		WebElement firstRowFirstColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[2]/span")));
		String valueOfFirstRowFirstColumn = firstRowFirstColumn.getText();
		System.out.println("Before Start IP Diagnosis Patient Code : " + valueOfFirstRowFirstColumn);
		
		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchStatus = driver.findElement(By.xpath("//thead/tr[2]/th[2]/input[1]"));
		SearchStatus.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement View = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='View']")));
		View.click();
		
		WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Edit']")));
		edit.click();
		
		WebElement Symptoms = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@placeholder='Enter Symptoms Here']")));
		Symptoms.clear();
		Symptoms.sendKeys("Persistent abdominal pain for 3 days");
		
		WebElement Diagnosis = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@placeholder='Enter Diagnosis Here']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Diagnosis);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
		Diagnosis = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@placeholder='Enter Diagnosis Here']")));
		Diagnosis.clear();
		Diagnosis.sendKeys("Difficulty breathing");
		
		WebElement Chief_Complaint = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@placeholder='Enter Chief Complaint Here'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Chief_Complaint);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
		Chief_Complaint = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@placeholder='Enter Chief Complaint Here'])[1]")));
		Chief_Complaint.clear();
		Chief_Complaint.sendKeys("Severe headache for 2 days");
		
		
		WebElement Height = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter Height']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Height);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
		Height = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter Height']")));
		Height.clear();
		Height.sendKeys("175");
		
		WebElement Weight = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter Weight']")));
		Weight.clear();
		Weight.sendKeys("68");
		
		WebElement Allergies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@placeholder='Enter Known Allergies Here']")));
		Allergies.clear();
		Allergies.sendKeys("Skin Prick Test");
		
		WebElement PMC = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@placeholder='Enter Previous Medical Condition Here'])[1]")));
		PMC.clear();
		PMC.sendKeys("History of episodic back pain for 2 years");
		
		WebElement Save_Overview = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='ipsaveBtn']")));
		Save_Overview.click();
		
		JavascriptExecutor jslab = (JavascriptExecutor) driver;
		jslab.executeScript("window.scroll(0,0);");
		
		WebElement labtest = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ipLabtab']")));
		labtest.click();
		
		WebElement addTemplatelab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add Lab Test']")));
		addTemplatelab.click();
		
		WebElement ClicklabTemplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Add Template']")));
		ClicklabTemplate.click();
		
		WebElement templatenamelab = driver.findElement(By.xpath("//input[@placeholder='Search Template...']"));
	    templatenamelab.sendKeys("Blood");		
	    WebElement selectTemplatelab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Blood Test')]")));
	    selectTemplatelab.click();
	    Thread.sleep(2000);
		
	    WebElement savelabtest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='saveLabFunc']")));
	    savelabtest.click();
	    
	    JavascriptExecutor jschart = (JavascriptExecutor) driver;
	    jschart.executeScript("window.scroll(0,0);");
		
		WebElement Chart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ipChart']")));
		Chart.click();
		
		WebElement Temp6AM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-2-0']")));
		Temp6AM.clear();
		Temp6AM.sendKeys("98.6");
		
		WebElement Temp10AM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-2-1']")));
		Temp10AM.clear();
		Temp10AM.sendKeys("99.4");
		
		WebElement Temp2PM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-2-2']")));
		Temp2PM.clear();
		Temp2PM.sendKeys("99.0");
		
		WebElement PR6AM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-3-0']")));
		PR6AM.clear();
		PR6AM.sendKeys("85");
		
		WebElement PR10AM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-3-1']")));
		PR10AM.clear();
		PR10AM.sendKeys("89");
		
		WebElement PR2PM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-3-2']")));
		PR2PM.clear();
		PR2PM.sendKeys("79");
		
		WebElement RESPIRATION6AM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-4-0']")));
		RESPIRATION6AM.clear();
		RESPIRATION6AM.sendKeys("12");
		
		WebElement RESPIRATION10AM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-4-1']")));
		RESPIRATION10AM.clear();
		RESPIRATION10AM.sendKeys("10");
		
		WebElement RESPIRATION2PM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-4-2']")));
		RESPIRATION2PM.clear();
		RESPIRATION2PM.sendKeys("15");
		
		WebElement BP6AM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-5-0']")));
		BP6AM.clear();
		BP6AM.sendKeys("120/80");
		
		WebElement BP10AM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-5-1']")));
		BP10AM.clear();
		BP10AM.sendKeys("122/82");
		
		WebElement BP2PM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-5-2']")));
		BP2PM.clear();
		BP2PM.sendKeys("118/79");
		
		WebElement BFood6AM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-6-0']")));
		BFood6AM.clear();
		BFood6AM.sendKeys("65");
		
		WebElement BFood10AM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-6-1']")));
		BFood10AM.clear();
		BFood10AM.sendKeys("69");
		
		WebElement BFood2PM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-6-2']")));
		BFood2PM.clear();
		BFood2PM.sendKeys("73");
		
		WebElement AFood6AM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-7-0']")));
		AFood6AM.clear();
		AFood6AM.sendKeys("108");
		
		WebElement AFood10AM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-7-1']")));
		AFood10AM.clear();
		AFood10AM.sendKeys("115");
		
		WebElement AFood2PM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='medTPR-7-2']")));
		AFood2PM.clear();
		AFood2PM.sendKeys("120");
		
		JavascriptExecutor chartjs = (JavascriptExecutor) driver;
		chartjs.executeScript("window.scrollBy(0, 500);");
		
		WebElement WEIGHT = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='number'])[2]")));
		WEIGHT.clear();
		WEIGHT.sendKeys("69");
		
		WebElement HEIGHT = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='number'])[3]")));
		HEIGHT.clear();
		HEIGHT.sendKeys("171");
		
		WebElement saveChart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='ipsaveBtn']")));
		saveChart.click();
		
		JavascriptExecutor jsProgressnotes = (JavascriptExecutor) driver;
		jsProgressnotes.executeScript("window.scroll(0,0);");
		
		WebElement Progressnotes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ipProNote']")));
		Progressnotes.click();
		
		WebElement Addnotes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add Notes']")));
		Addnotes.click();
		
		WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@title='Notes Type']")));
	    Select dropdown = new Select(dropdownElement);
	    dropdown.selectByVisibleText("Doctor");
	    
	    WebElement Refferedby = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Referred By *']")));
	    Refferedby.clear();
	    Refferedby.sendKeys("Akshay");
	    
	    WebElement DoctorNotes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@placeholder='Notes']")));
	    DoctorNotes.clear();
	    DoctorNotes.sendKeys("Patient reports significant improvement in abdominal pain");
	    
	    WebElement savePrognotes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='ipProgNote']")));
	    savePrognotes.click();
	    
	    JavascriptExecutor jsmedication = (JavascriptExecutor) driver;
	    jsmedication.executeScript("window.scroll(0,0);");
		
		WebElement medication = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ipMedtab']")));
		medication.click();
	    
		WebElement addPres = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='addPres']")));       
		addPres.click();
		
		JavascriptExecutor jstemp = (JavascriptExecutor) driver;
		jstemp.executeScript("window.scrollBy(0, -500);"); // Scroll up by 500 pixels
        Thread.sleep(1000);
		
		WebElement addtemp =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Add Template']")));       
		addtemp.click();
		
		WebElement templatename = driver.findElement(By.xpath("//input[@placeholder='Search Template...']"));
        templatename.sendKeys("BP");		
        WebElement selectTemplate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),' BP Tablets ')]")));
        selectTemplate.click();
		
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[9]")));       
        element.click();
        
        WebElement Frq_M = driver.findElement(By.xpath("//input[@placeholder='M']"));
		Frq_M.clear();
		Frq_M.sendKeys("1");
		
		WebElement Frq_N = driver.findElement(By.xpath("//input[@placeholder='N']"));
		Frq_N.clear();
		Frq_N.sendKeys("1");
		
		WebElement Instructions = driver.findElement(By.xpath("//input[@placeholder='Instructions']"));
		Instructions.clear();
		Instructions.sendKeys("Store at room temperature");
		
		WebElement BF_AF = driver.findElement(By.xpath("//span[normalize-space()='A']"));
		BF_AF.click();
		
		WebElement Qty = driver.findElement(By.xpath("//input[@title='Quantity']"));
		Qty.clear();
		Qty.sendKeys("2");
        
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[2]/td[8]")));       
        element1.click();
        
        WebElement Frq_M1 = driver.findElement(By.xpath("//input[@placeholder='M']"));
		Frq_M1.clear();
		Frq_M1.sendKeys("1");
		
		WebElement Frq_N1 = driver.findElement(By.xpath("//input[@placeholder='N']"));
		Frq_N1.clear();
		Frq_N1.sendKeys("1");
		
		WebElement Instructions1 = driver.findElement(By.xpath("//input[@placeholder='Instructions']"));
		Instructions1.clear();
		Instructions1.sendKeys("Store at room temperature");
		
		WebElement BF_AF1 = driver.findElement(By.xpath("//span[normalize-space()='A']"));
		BF_AF1.click();
		
		WebElement Qty1 = driver.findElement(By.xpath("//input[@title='Quantity']"));
		Qty1.clear();
		Qty1.sendKeys("3");
		
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[3]/td[8]")));       
        element2.click();
        
        WebElement Frq_M2 = driver.findElement(By.xpath("//input[@placeholder='M']"));
		Frq_M2.clear();
		Frq_M2.sendKeys("1");
		
		WebElement Frq_N2 = driver.findElement(By.xpath("//input[@placeholder='N']"));
		Frq_N2.clear();
		Frq_N2.sendKeys("1");
		
		WebElement Instructions2 = driver.findElement(By.xpath("//input[@placeholder='Instructions']"));
		Instructions2.clear();
		Instructions2.sendKeys("Store at room temperature");
		
		WebElement BF_AF2 = driver.findElement(By.xpath("//span[normalize-space()='A']"));
		BF_AF2.click();
		
		WebElement Qty2 = driver.findElement(By.xpath("//input[@title='Quantity']"));
		Qty2.clear();
		Qty2.sendKeys("5");
        
		WebElement Saveclose = driver.findElement(By.xpath("//button[@id='ipMedSaveBtn']"));
		Saveclose.click();
		
		JavascriptExecutor jsservice = (JavascriptExecutor) driver;
		jsservice.executeScript("window.scroll(0,0);");
		
		WebElement service = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ipServ']")));
		service.click();
		Thread.sleep(2000);
		
		WebElement addNew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add New')]")));
		addNew.click();
		
        WebElement dropdown1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[4]/mat-form-field[1]/div[1]/div[1]/div[3]")));
        dropdown1.click();
        
        WebElement ventilatorCharges = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'VENTILATOR CHARGES')]")));
        ventilatorCharges.click();
        
        WebElement ServiceQty = driver.findElement(By.xpath("//tbody/tr[1]/td[6]/app-input-number[1]/div[1]/input[1]"));
        ServiceQty.clear();
        ServiceQty.sendKeys("2");
        Thread.sleep(2000);
		
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='patSerSave']")));
        saveButton.click();
        
        WebElement Radiology = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ipRadio']")));
        Radiology.click();
		
        WebElement addscan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add Scan Request')]")));
        addscan.click();
        
        WebElement addnewscan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Add New')]")));
		addnewscan.click();
		
		WebElement inputField1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[2]/input[1]")));
		inputField1.sendKeys("x");
		
		WebElement xRayOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'x-Ray')]")));
		xRayOption.click();
		
		WebElement addnewscan1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Add New')]")));
		addnewscan1.click();
		
		WebElement inputField2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[2]/td[2]/input[1]")));
		inputField2.sendKeys("CT");
		
		WebElement ctScanOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'CT Scan')]")));
		ctScanOption.click();
		
		WebElement saveButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='ipScanSave']")));
		saveButton1.click();
		
		WebElement elementToScroll = driver.findElement(By.xpath("//input[@title='Name']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
        elementToScroll.sendKeys("Fluoroscopy");
        
        driver.findElement(By.xpath("//app-textarea[1]/div[1]/textarea[1]")).sendKeys("This procedure enables radiologists to view X-rays in real time on a television monitor.");
        
        WebElement saveRadiology = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='radoSave']")));
        saveRadiology.click();
        Thread.sleep(2000);
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(text(),'Saved Successfully')]")));
		
        JavascriptExecutor jsinitiatedischarge = (JavascriptExecutor) driver;
        jsinitiatedischarge.executeScript("window.scroll(0,0);");  
		
		WebElement initiatedischarge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Initiate Discharge')]")));
		initiatedischarge.click();
		Thread.sleep(2000);
		
		WebElement Dischargetype = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[2]")));
		Dischargetype.clear();
		Dischargetype.sendKeys("Planned Discharge");
		
		WebElement ConsultDoctor = driver.findElement(By.xpath("//textarea[@placeholder='Add Consultant Doctor Details Here']"));
		ConsultDoctor.clear();
		ConsultDoctor.sendKeys("Dr.Damien S\nophthalmologist");
		
		JavascriptExecutor js_initiatedischarge = (JavascriptExecutor) driver;
		js_initiatedischarge.executeScript("window.scrollBy(0, 1000);");
		
		WebElement ReferraltDoctor = driver.findElement(By.xpath("//textarea[@placeholder='Add Referral Doctor Details Here']"));
		ReferraltDoctor.clear();
		ReferraltDoctor.sendKeys("Dr.Manoj S\nNeurosurgery");
		
		WebElement Surgery = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Surgery Date & Time')]")));
		Surgery.click();
		
		try {
		    // Wait for the date picker input field to be visible
		    WebElement datePickerInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'DD-MM-YYYY')]")));
		    JavascriptExecutor js1 = (JavascriptExecutor) driver;
		    js1.executeScript("arguments[0].scrollIntoView(true);", datePickerInput);
		    js1.executeScript("arguments[0].click();", datePickerInput);
		    
		    // Wait for today's date to be clickable and click it
		    WebElement dateToSelect = wait.until(ExpectedConditions.elementToBeClickable(
		            By.xpath("//td[@class='today active start-date active end-date available']")));
		    dateToSelect.click();
		    
		} catch (TimeoutException e) {
		    System.out.println("Timeout while waiting for date picker input: " + e.getMessage());
		} catch (Exception e) {
		    System.out.println("Error occurred: " + e.getMessage());
		}
		Thread.sleep(2000);
		
		JavascriptExecutor js_initiatedischarge1 = (JavascriptExecutor) driver;
		js_initiatedischarge1.executeScript("window.scrollBy(0, 1000);");
		
		WebElement Diabetes = driver.findElement(By.xpath("//textarea[@placeholder='Enter History of Diabetes Mellitus Here']"));
		Diabetes.clear();
		Diabetes.sendKeys("Fasting and postprandial blood sugar levels.");
		
		WebElement Hypertension = driver.findElement(By.xpath("//textarea[@placeholder='Enter History Of Hypertension Here']"));
		Hypertension.clear();
		Hypertension.sendKeys("Blood pressure under control with medications. No recent hypertensive crises.");
		
		WebElement Coronary  = driver.findElement(By.xpath("//textarea[@placeholder='Enter History Of Coronary Artery Disease Here']"));
		Coronary .clear();
		Coronary .sendKeys("Record previous treatments like stents (angioplasty), coronary artery bypass grafting (CABG), or thrombolytic therapy.");
		
		WebElement Asthma = driver.findElement(By.xpath("//textarea[@placeholder='Enter History Of Asthma Details Here']"));
		Asthma.clear();
		Asthma.sendKeys("Record previous and current medications, including inhalers, nebulization, or oral medications.");
		
		WebElement Medical = driver.findElement(By.xpath("//textarea[@placeholder='Enter Medical Details Here']"));
		Medical.clear();
		Medical.sendKeys("Document all medications the patient is currently taking, including dosages and frequency..");
		
		WebElement Surgical = driver.findElement(By.xpath("//textarea[@placeholder='Enter Surgical Details Here']"));
		Surgical.clear();
		Surgical.sendKeys("Monitoring: Frequency of vital signs, lab tests, or imaging.");
		
		WebElement History = driver.findElement(By.xpath("//textarea[@placeholder='Add Your Social History Here']"));
		History.clear();
		History.sendKeys("The patient has a history of smoking, having quit five years ago after smoking one pack daily for 15 years.");
		
		WebElement Pallor = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		Pallor.clear();
		Pallor.sendKeys("Trauma");
		
		WebElement Clubbing = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		Clubbing.clear();
		Clubbing.sendKeys("Absent");
		
		WebElement Cavity = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		Cavity.clear();
		Cavity.sendKeys("Normal");
		
		WebElement LymphNodes = driver.findElement(By.xpath("(//input[@type='text'])[6]"));
		LymphNodes.clear();
		LymphNodes.sendKeys("Not palpable");
		
		WebElement Pulse = driver.findElement(By.xpath("(//input[@type='text'])[7]"));
		Pulse.clear();
		Pulse.sendKeys("65");
		
		WebElement BP = driver.findElement(By.xpath("(//input[@type='text'])[8]"));
		BP.clear();
		BP.sendKeys("120/80");
		
		WebElement CVS = driver.findElement(By.xpath("(//input[@type='text'])[9]"));
		CVS.clear();
		CVS.sendKeys("S1");
		
		WebElement Cyanosis = driver.findElement(By.xpath("(//input[@type='text'])[10]"));
		Cyanosis.clear();
		Cyanosis.sendKeys("Absent");
		
		WebElement Oedema = driver.findElement(By.xpath("(//input[@type='text'])[11]"));
		Oedema.clear();
		Oedema.sendKeys("Absent");
		
		WebElement Icterus = driver.findElement(By.xpath("(//input[@type='text'])[12]"));
		Icterus.clear();
		Icterus.sendKeys("Moderate");
		
		WebElement Temperature = driver.findElement(By.xpath("(//input[@type='text'])[13]"));
		Temperature.clear();
		Temperature.sendKeys("97.6");
		
		WebElement RS = driver.findElement(By.xpath("(//input[@type='text'])[14]"));
		RS.clear();
		RS.sendKeys("Normal vesicular breath sounds");
		
		WebElement Abdomen = driver.findElement(By.xpath("(//input[@type='text'])[15]"));
		Abdomen.clear();
		Abdomen.sendKeys("Soft");
		
		WebElement CNS = driver.findElement(By.xpath("(//input[@type='text'])[16]"));
		CNS.clear();
		CNS.sendKeys("Conscious and oriented");
		
		WebElement Course_in_hospital = driver.findElement(By.xpath("//textarea[@placeholder='Add Course Details Here']"));
		Course_in_hospital.clear();
		Course_in_hospital.sendKeys("Patient admitted on [Date] with [Primary Diagnosis]."
				+ " Initial assessment and investigations were done, revealing [key findings]");
		
		WebElement Condition_at_Discharge = driver.findElement(By.xpath("//input[@title='Condition at Discharge']"));
		Condition_at_Discharge.clear();
		Condition_at_Discharge.sendKeys("Stable");
		
		WebElement GCS = driver.findElement(By.xpath("(//input[@type='text'])[18]"));
		GCS.clear();
		GCS.sendKeys("11/15");
		
		WebElement HR = driver.findElement(By.xpath("(//input[@type='text'])[19]"));
		HR.clear();
		HR.sendKeys("71 bpm");
		
		WebElement SaO2 = driver.findElement(By.xpath("(//input[@type='text'])[20]"));
		SaO2.clear();
		SaO2.sendKeys("95%");
		
		WebElement PIA = driver.findElement(By.xpath("(//input[@type='text'])[21]"));
		PIA.clear();
		PIA.sendKeys("Removed");
		
	    WebElement addTemplatemedicine = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Add Template']")));
	    addTemplatemedicine.click();
	    
	    WebElement IPmedtemplatename = driver.findElement(By.xpath("//input[@placeholder='Search Template...']"));
	    IPmedtemplatename.sendKeys("BP");
        
        WebElement IPmedselectTemplate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),' BP Tablets ')]")));
        IPmedselectTemplate.click();
        
        WebElement IPmedelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[9]")));       
        IPmedelement.click();
        
        WebElement IPmedFrq_M = driver.findElement(By.xpath("//input[@placeholder='M']"));
        IPmedFrq_M.clear();
        IPmedFrq_M.sendKeys("1");
		
		WebElement IPmedFrq_N = driver.findElement(By.xpath("//input[@placeholder='N']"));
		IPmedFrq_N.clear();
		IPmedFrq_N.sendKeys("1");
		
		WebElement IPmedInstructions = driver.findElement(By.xpath("//input[@placeholder='Instructions']"));
		IPmedInstructions.clear();
		IPmedInstructions.sendKeys("Store at room temperature");
		
		WebElement IPmedBF_AF = driver.findElement(By.xpath("//span[normalize-space()='A']"));
		IPmedBF_AF.click();
		
		WebElement IPmedQty = driver.findElement(By.xpath("//input[@title='Quantity']"));
		IPmedQty.clear();
		IPmedQty.sendKeys("2");
        
		WebElement IPmedelement1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[2]/td[8]")));       
		IPmedelement1.click();
        
        WebElement IPmedFrq_M1 = driver.findElement(By.xpath("//input[@placeholder='M']"));
        IPmedFrq_M1.clear();
        IPmedFrq_M1.sendKeys("1");
		
		WebElement IPFrq_N1 = driver.findElement(By.xpath("//input[@placeholder='N']"));
		IPFrq_N1.clear();
		IPFrq_N1.sendKeys("1");
		
		WebElement IPmedInstructions1 = driver.findElement(By.xpath("//input[@placeholder='Instructions']"));
		IPmedInstructions1.clear();
		IPmedInstructions1.sendKeys("Store at room temperature");
		
		WebElement IPmedBF_AF1 = driver.findElement(By.xpath("//span[normalize-space()='A']"));
		IPmedBF_AF1.click();
		
		WebElement IPmedQty1 = driver.findElement(By.xpath("//input[@title='Quantity']"));
		IPmedQty1.clear();
		IPmedQty1.sendKeys("3");
		
		WebElement IPmedelement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[3]/td[8]")));       
		IPmedelement2.click();
        
        WebElement IPmedFrq_M2 = driver.findElement(By.xpath("//input[@placeholder='M']"));
        IPmedFrq_M2.clear();
        IPmedFrq_M2.sendKeys("1");
		
		WebElement IPmedFrq_N2 = driver.findElement(By.xpath("//input[@placeholder='N']"));
		IPmedFrq_N2.clear();
		IPmedFrq_N2.sendKeys("1");
		
		WebElement IPmedInstructions2 = driver.findElement(By.xpath("//input[@placeholder='Instructions']"));
		IPmedInstructions2.clear();
		IPmedInstructions2.sendKeys("Store at room temperature");
		
		WebElement IPBF_AF2 = driver.findElement(By.xpath("//span[normalize-space()='A']"));
		IPBF_AF2.click();
		
		WebElement IPmedQty2 = driver.findElement(By.xpath("//input[@title='Quantity']"));
		IPmedQty2.clear();
		IPmedQty2.sendKeys("5");
		
		WebElement PatientStatusdropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@title='Patient Status']")));
		Select PatientStatus = new Select(PatientStatusdropdown);
		PatientStatus.selectByVisibleText("Alive");
		
		WebElement FollowUp = driver.findElement(By.xpath("//textarea[@placeholder='Add Follow Up Details Here']"));
		FollowUp.clear();
		FollowUp.sendKeys("The patient is advised to follow up in the cardiology department on 12th January 2025 for a routine check-up. "
				+ "During this visit, a series of blood tests including CBC and renal function tests will be conducted to monitor "
				+ "the patient's progress.");
		
		WebElement Final_Summary = driver.findElement(By.xpath("//textarea[@placeholder='Add Your Summary Here']"));
		Final_Summary.clear();
		Final_Summary.sendKeys("The patient was admitted on [admission date] with [primary diagnosis], and after receiving necessary medical interventions, "
				+ "they have shown significant improvement/stabilization. During their hospital stay, "
				+ "they underwent [procedures/treatments] and responded well to the prescribed treatment regimen.");
		
		JavascriptExecutor jssavesum = (JavascriptExecutor) driver;
		jssavesum.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		WebElement IPsumsave= driver.findElement(By.xpath("//button[@id='ipSumSave']"));
		IPsumsave.click();
		System.out.println("IP Summary Saved Successfully");
		
	}	
	
}