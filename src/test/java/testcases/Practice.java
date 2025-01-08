package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;

public class Practice extends BaseTest {

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
	
	
	public static void IPBill_Close() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement IPlink = driver.findElement(By.xpath("//a[text()=' IP']"));
		IPlink.click();
		Thread.sleep(2000);

		WebElement filterButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Filter']")));
		filterButton.click();

		WebElement FilterALL = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[1]")));
		FilterALL.click();
		Thread.sleep(3000);

		WebElement FilterUnpaid = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[3]")));
		FilterUnpaid.click();
		Thread.sleep(3000);

		WebElement searchButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchButton.click();

		WebElement columnValueElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
		String columnValue = columnValueElement.getText();
		System.out.println("Patient Code: " + columnValue);

		// Extract the amount

		WebElement searchInput = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		searchInput.clear();
		searchInput.sendKeys(columnValue);
		Thread.sleep(2000);

		// Capture Bill Status Before Paid
		WebElement beforeStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[1]/tr[1]/td[10]/span[1]")));
		String columnValueStatus = beforeStatus.getText();
		Reporter.log(columnValue + " : Before Paid IP Bill Status : " + columnValueStatus);
		System.out.println(columnValue + "Before Paid IP Bill Status : " + columnValueStatus);

		WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[9]")));
		String amountText = amountElement.getText();
		System.out.println("Amount Text: " + amountText);

		// Remove non-numeric characters using a regular expression
		String amountValue = amountText.replaceAll("[^0-9.]", "");

		System.out.println("Cleaned Amount Text cash: " + amountValue);

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
		Thread.sleep(4000);

		// Add Receipt - Payment by Card

		WebElement IPBills = driver.findElement(By.xpath("//a[contains(text(),'IP Bills')]"));
		wait.until(ExpectedConditions.elementToBeClickable(IPBills));
		IPBills.click();
		Thread.sleep(2000);

		WebElement filterButton1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Filter']")));
		filterButton1.click();

		WebElement FilterALL1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[1]")));
		FilterALL1.click();
		Thread.sleep(3000);

		WebElement FilterUnpaid1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[3]")));
		FilterUnpaid1.click();
		Thread.sleep(3000);

		WebElement searchButton1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchButton1.click();

		// Extract the amount
		WebElement amountElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[9]")));
		String amountText1 = amountElement1.getText();
		System.out.println("Amount Text: " + amountText1);

		// Remove non-numeric characters using a regular expression
		String amountValue1 = amountText1.replaceAll("[^0-9.]", "");

		System.out.println("Cleaned Amount Text Card: " + amountValue1);

		double originalAmount1 = Double.parseDouble(amountValue1);

		// Calculate half of the amount
		double halfAmount1 = originalAmount1 / 2;

		// Get the whole number part of halfAmount
		int wholeNumberPart1 = (int) halfAmount1;
		System.out.println("Card Amount " + wholeNumberPart1);

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

		// Bill Close

		// Scroll down using JavaScriptExecutor

		WebElement IPBillsclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'IP Bills')]")));
		IPBillsclose.click();
		Thread.sleep(2000);

		WebElement filterButton2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Filter']")));
		filterButton2.click();

		WebElement FilterALL2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[1]")));
		FilterALL2.click();
		Thread.sleep(3000);

		WebElement FilterUnpaid2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[3]")));
		FilterUnpaid2.click();
		Thread.sleep(3000);

		WebElement searchButton2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchButton2.click();

		// Extract the amount
		WebElement amountElementClose = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[9]")));
		String amountTextClose = amountElementClose.getText();
		System.out.println("Amount Text: " + amountTextClose);

		// Remove non-numeric characters using a regular expression
		String amountValueclose = amountTextClose.replaceAll("[^0-9.]", "");

		System.out.println("Cleaned Amount Text Bill Close: " + amountValueclose);

		double originalAmountclose = Double.parseDouble(amountValueclose);

		int wholeNumberPartclose = (int) originalAmountclose;
		System.out.println("Bill close Amount: " + wholeNumberPartclose);

		WebElement viewIconclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='view bill'])[1]")));
		viewIconclose.click();
		Thread.sleep(3000);

		// Scroll down using JavaScriptExecutor
		JavascriptExecutor executorScrollclose = (JavascriptExecutor) driver;
		executorScrollclose.executeScript("window.scrollBy(0, 500);");

		WebElement billCloseButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Bill Close')]")));
		billCloseButton.click();
		Thread.sleep(3000);

		WebElement Clickbillclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Yes')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Clickbillclose);
		Clickbillclose.click();

		// Bill close by Cash
		WebElement paymentTypeDropdownclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@value='null']")));

		// Use Select class to interact with dropdown
		Select paymentTypeSelectclose = new Select(paymentTypeDropdownclose);
		paymentTypeSelectclose.selectByVisibleText("Advance");

		Select PaymentModeclose = new Select(driver.findElement(By.xpath("(//app-bill-details//select)[2]")));
		PaymentModeclose.selectByVisibleText("Cash");

		WebElement amountInputBoxclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Amount']	")));
		amountInputBoxclose.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, String.valueOf(wholeNumberPartclose));

		WebElement ReceiptPayclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Pay']")));
		ReceiptPayclose.click();
		Thread.sleep(4000);

		WebElement clickbillCloseAgain = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Bill Close')]")));
		clickbillCloseAgain.click();
		Thread.sleep(3000);

		WebElement Confirmbillclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Yes')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Confirmbillclose);
		Confirmbillclose.click();
		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		
		WebElement PatientCode = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[1]/tr[2]/td[3])[1]")));
        String AfterPaidPatientCode = PatientCode.getText();
        
        WebElement Billnumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[1]/tr[4]/td[3])[2]")));
		String AfterPaidBillnumber = Billnumber.getText();
	
		System.out.println( "After paying the IP Bill - Patient Code : " + AfterPaidPatientCode);
		System.out.println( "After paying the IP Bill - Bill Number  : " + AfterPaidBillnumber);

	}

	@Test(priority = 1)
	public static void IPBill_Add_Delete() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement IPlink = driver.findElement(By.xpath("//a[text()=' IP']"));
		IPlink.click();
		Thread.sleep(2000);

		// Extract the amount

		WebElement filterButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Filter']")));
		filterButton.click();

		WebElement FilterALL = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[1]")));
		FilterALL.click();
		Thread.sleep(3000);

		WebElement FilterUnpaid = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[3]")));
		FilterUnpaid.click();
		Thread.sleep(3000);

		WebElement searchButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchButton.click();

		WebElement columnValueElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
		String columnValue = columnValueElement.getText();
		System.out.println("Patient Code: " + columnValue);

		WebElement viewIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='view bill'])[1]")));
		viewIcon.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		Thread.sleep(2000);

		WebElement Editbill = driver.findElement(By.xpath("//button[contains(text(),'Edit Bill')]"));
		Editbill.click();

		// Add Lab
		driver.findElement(By.xpath("//span[contains(text(),'Add New')]")).click();

		Select ItemTypeLab = new Select(driver.findElement(
				By.xpath("//select[@class='form-control ng-star-inserted ng-untouched ng-pristine ng-valid']")));
		ItemTypeLab.selectByVisibleText("Lab");

		driver.findElement(By.xpath("//span[text()='Select']")).click();

		WebElement elementLab = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),' ANA (Antinuclear Antibody)')]")));
		elementLab.click();

		driver.findElement(By.xpath("//span[contains(text(),'Add New')]")).click();

		Select ItemTypeLab1 = new Select(driver.findElement(
				By.xpath("//select[@class='form-control ng-star-inserted ng-untouched ng-pristine ng-valid']")));
		ItemTypeLab1.selectByVisibleText("Lab");

		driver.findElement(By.xpath("//span[text()='Select']")).click();

		driver.findElement(By.xpath("//span[contains(text(),' Allergy Skin Test ')]")).click();
		

		// Add Scan
		driver.findElement(By.xpath("//span[contains(text(),'Add New')]")).click();

		Select ItemTypeScan = new Select(driver.findElement(
				By.xpath("//select[@class='form-control ng-star-inserted ng-untouched ng-pristine ng-valid']")));
		ItemTypeScan.selectByVisibleText("Scan");

		driver.findElement(By.xpath("//span[text()='Select']")).click();

		driver.findElement(By.xpath("//span[contains(text(),' CT Scan ')]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Add New')]")).click();

		Select ItemTypeScan1 = new Select(driver.findElement(
				By.xpath("//select[@class='form-control ng-star-inserted ng-untouched ng-pristine ng-valid']")));
		ItemTypeScan1.selectByVisibleText("Scan");

		driver.findElement(By.xpath("//span[text()='Select']")).click();

		driver.findElement(By.xpath("//span[contains(text(),' MRI SCAN ')]")).click();

		// Add Service
		driver.findElement(By.xpath("//span[contains(text(),'Add New')]")).click();

		Select ItemTypeService = new Select(driver.findElement(
				By.xpath("//select[@class='form-control ng-star-inserted ng-untouched ng-pristine ng-valid']")));
		ItemTypeService.selectByVisibleText("Service");

		driver.findElement(By.xpath("//span[text()='Select']")).click();

		driver.findElement(By.xpath("//span[contains(text(),' Physiotheraphy ')]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Add New')]")).click();

		Select ItemTypeService1 = new Select(driver.findElement(
				By.xpath("//select[@class='form-control ng-star-inserted ng-untouched ng-pristine ng-valid']")));
		ItemTypeService1.selectByVisibleText("Service");

		driver.findElement(By.xpath("//span[text()='Select']")).click();

		driver.findElement(By.xpath("//span[contains(text(),' VENTILATOR CHARGES ')]")).click();

		// Add Others
		driver.findElement(By.xpath("//span[contains(text(),'Add New')]")).click();

		Select ItemTypeOthers = new Select(driver.findElement(
				By.xpath("//select[@class='form-control ng-star-inserted ng-untouched ng-pristine ng-valid']")));
		ItemTypeOthers.selectByVisibleText("Others");

		driver.findElement(By.xpath("//span[text()='Select']")).click();

		driver.findElement(By.xpath("//span[contains(text(),' Bladder Wash ')]")).click();

		JavascriptExecutor jsSave = (JavascriptExecutor) driver;
		jsSave.executeScript("window.scrollBy(0,500);");

		WebElement Savebill = driver.findElement(By.xpath("//button[text()='Save']"));
		Savebill.click();
		Thread.sleep(4000);

		WebElement clickedit = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Edit Bill')]")));
		clickedit.click();
		Thread.sleep(3000);

		// Delete Lab,scan and service

		JavascriptExecutor scrollUp = (JavascriptExecutor) driver;
		scrollUp.executeScript("window.scrollBy(0, -100);");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//tbody/tr[3]/td[12]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//tbody/tr[4]/td[12]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//tbody/tr[6]/td[12]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);

		JavascriptExecutor scrollUp1 = (JavascriptExecutor) driver;
		scrollUp1.executeScript("window.scrollBy(0, -document.body.scrollHeight);");

		WebElement ipBillsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'IP Bills')]")));
		ipBillsLink.click();
		Thread.sleep(3000);

		// Capture Bill Status Before Paid

		WebElement searchButton1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchButton1.click();

		WebElement SavePatient = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SavePatient.sendKeys(columnValue);
		SavePatient.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement beforeStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[1]/tr[1]/td[10]/span[1]")));
		String columnValueStatus = beforeStatus.getText();
		System.out.println(columnValue + " : Before Paid IP Bill Status : " + columnValueStatus);

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

		WebElement viewIcon2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='view bill'])[1]")));
		viewIcon2.click();

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
		Thread.sleep(4000);

		// Add Receipt - Payment by Card

		WebElement IPBills = driver.findElement(By.xpath("//a[contains(text(),'IP Bills')]"));
		wait.until(ExpectedConditions.elementToBeClickable(IPBills));
		IPBills.click();
		Thread.sleep(2000);

		WebElement searchButton2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchButton2.click();

		WebElement SavePatient1 = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SavePatient1.sendKeys(columnValue);
		SavePatient1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		// Extract the amount
		WebElement amountElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[9]")));
		String amountText1 = amountElement1.getText();
		System.out.println("Amount Text: " + amountText1);

		// Remove non-numeric characters using a regular expression
		String amountValue1 = amountText1.replaceAll("[^0-9.]", "");

		System.out.println("Cleaned Amount Text Card: " + amountValue1);

		double originalAmount1 = Double.parseDouble(amountValue1);

		// Calculate half of the amount
		double halfAmount1 = originalAmount1 / 2;

		// Get the whole number part of halfAmount
		int wholeNumberPart1 = (int) halfAmount1;
		System.out.println("Card Amount " + wholeNumberPart1);

		WebElement viewIcon3 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='view bill'])[1]")));
		viewIcon3.click();

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
		payButton.click();
		Thread.sleep(4000);

		// Bill Close

		// Scroll down using JavaScriptExecutor

		WebElement IPBillsclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'IP Bills')]")));
		IPBillsclose.click();
		Thread.sleep(2000);

		WebElement searchButton3 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchButton3.click();

		WebElement SavePatient2 = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SavePatient2.sendKeys(columnValue);
		SavePatient2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		// Extract the amount
		WebElement amountElementClose = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[9]")));
		String amountTextClose = amountElementClose.getText();
		System.out.println("Amount Text: " + amountTextClose);

		// Remove non-numeric characters using a regular expression
		String amountValueclose = amountTextClose.replaceAll("[^0-9.]", "");

		System.out.println("Cleaned Amount Text Bill Close: " + amountValueclose);

		double originalAmountclose = Double.parseDouble(amountValueclose);

		int wholeNumberPartclose = (int) originalAmountclose;
		System.out.println("Bill close Amount: " + wholeNumberPartclose);

		WebElement viewIconclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='view bill'])[1]")));
		viewIconclose.click();
		Thread.sleep(3000);

		// Scroll down using JavaScriptExecutor
		JavascriptExecutor executorScrollclose = (JavascriptExecutor) driver;
		executorScrollclose.executeScript("window.scrollBy(0, 500);");

		WebElement billCloseButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Bill Close')]")));
		billCloseButton.click();
		Thread.sleep(3000);

		WebElement Clickbillclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Yes')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Clickbillclose);
		Clickbillclose.click();

		// Bill close by Cash
		WebElement paymentTypeDropdownclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@value='null']")));

		// Use Select class to interact with dropdown
		Select paymentTypeSelectclose = new Select(paymentTypeDropdownclose);
		paymentTypeSelectclose.selectByVisibleText("Advance");

		Select PaymentModeclose = new Select(driver.findElement(By.xpath("(//app-bill-details//select)[2]")));
		PaymentModeclose.selectByVisibleText("Cash");

		WebElement amountInputBoxclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Amount']	")));
		amountInputBoxclose.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, String.valueOf(wholeNumberPartclose));

		WebElement ReceiptPayclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Pay']")));
		ReceiptPayclose.click();
		Thread.sleep(4000);

		WebElement clickbillCloseAgain = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Bill Close')]")));
		clickbillCloseAgain.click();
		Thread.sleep(3000);

		WebElement Confirmbillclose = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Yes')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Confirmbillclose);
		Confirmbillclose.click();
		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

		WebElement PatientCode = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[1]/tr[2]/td[3])[1]")));
        String AfterPaidPatientCode = PatientCode.getText();
        
        WebElement Billnumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[1]/tr[4]/td[3])[2]")));
		String AfterPaidBillnumber = Billnumber.getText();
	
		System.out.println( "After paying the IP Bill - Patient Code : " + AfterPaidPatientCode);
		System.out.println( "After paying the IP Bill - Bill Number  : " + AfterPaidBillnumber);

	}
}
