package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class Billing_Range extends BaseTest {

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
	public static void OPBill_OneMonthRange() throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement opLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' OP']")));
		opLink.click();
		
		WebElement billList1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='op-bill-list1']")));
		billList1.click();
		
		By labMonthElementLocator = By.xpath("(//li[@data-range-key='1 Month'])[6]");
		WebElement labMonthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(labMonthElementLocator));
		labMonthElement.click();
		Thread.sleep(4000);

		WebElement filterButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Filter']")));
		filterButton.click();

		WebElement FilterALL = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[1]")));
		FilterALL.click();
		Thread.sleep(2000);
		
		WebElement thirdCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='checkbox'])[3]")));
		thirdCheckbox.click();
		

		WebElement columnValueElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
		String columnValue = columnValueElement.getText();
		System.out.println("OP Bill- Patient Code: " + columnValue);

		// Capture Bill Status Before Paid
		WebElement beforeStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[1]/tr[1]/td[8]/span[1]")));
		String columnValueStatus = beforeStatus.getText();
		System.out.println(columnValue + " : Before paying the OP bill, status : " + columnValueStatus);

		WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[1]/tr[1]/td[10]/div[1]/div[1]/button[1]")));
		button1.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		WebElement addButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Add'])[1]")));
		addButton1.click();

		WebElement selectDropdown1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
		selectDropdown1.click();
		
		WebElement neerajConsultationFees = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[contains(text(),'Dr.Neeraj Fees ')]")));
		neerajConsultationFees.click();
		
		WebElement addButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Add'])[1]")));
		addButton2.click();

		WebElement selectDropdown2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select[@placeholder='Select'])[1]")));
		selectDropdown2.click();

		WebElement registrationFeesOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'OP-Registration fees ')]")));
		registrationFeesOption.click();

		WebElement payBillButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Pay Bill')]")));
		payBillButton.click();

		WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Yes')]")));
		yesButton.click();

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
		Thread.sleep(5000);

		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);

		WebElement OPLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' OP']")));
		OPLink.click();

		WebElement billList2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='op-bill-list1']")));
		billList2.click();

		By labMonthElementLocatorStatusVerify = By.xpath("(//li[@data-range-key='1 Month'])[8]");
		WebElement labMonthElementStatusVerify = wait
				.until(ExpectedConditions.visibilityOfElementLocated(labMonthElementLocatorStatusVerify));
		labMonthElementStatusVerify.click();
		Thread.sleep(4000);
		
		WebElement filterButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Filter']")));
		filterButton1.click();

		WebElement FilterALLStatusVerify = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[1]")));
		FilterALLStatusVerify.click();
		Thread.sleep(3000);

		WebElement secondCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[2]")));
		secondCheckbox.click();
		Thread.sleep(3000);
		
		WebElement searchInputCard1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchInputCard1.click();
		
		 WebElement searchInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//thead/tr[2]/th[1]/input[1]")));
         searchInputField.click();
         searchInputField.sendKeys(columnValue);
         searchInputField.sendKeys(Keys.ENTER);
         Thread.sleep(2000);
		
		// Capture Bill Status After Paid
         WebElement PatientCode = wait
 				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
         String AfterPaidPatientCode = PatientCode.getText();
         
         WebElement Billnumber = wait
 				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[5]")));
 		String AfterPaidBillnumber = Billnumber.getText();
 		
 		WebElement BillDate = wait
 				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[6]")));
 		String AfterPaidBillDate = BillDate.getText();
 		
 		WebElement AfterStatus = wait
 				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[8]")));
 		String AfterPaidStatus = AfterStatus.getText();
 		
 		System.out.println( "After paying the OP Bill - Patient Code : " + AfterPaidPatientCode);
 		System.out.println( "After paying the OP Bill - Bill Number  : " + AfterPaidBillnumber);
 		System.out.println( "After paying the OP Bill - Bill Number  : " + AfterPaidBillDate);
 		System.out.println( "After paying the OP Bill - Bill Status  : " + AfterPaidStatus);

	}

	
	public static void LabBill_OneMonthRange() throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

//		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", menuIcon);

		By labLinkLocator = By.xpath("(//a[text()=' Lab'])[1]");
		WebElement labLink = wait.until(ExpectedConditions.elementToBeClickable(labLinkLocator));
		labLink.click();

		driver.findElement(By.xpath("//div[@id='lab-bill-list1']")).click();
		Thread.sleep(5000);

		By labMonthElementLocator = By.xpath("(//li[@data-range-key='1 Month'])[6]");
		WebElement labMonthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(labMonthElementLocator));
		labMonthElement.click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[@title='Filter']")).click();

		WebElement FilterALL = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[1]")));
		FilterALL.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();

		WebElement columnValueElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
		String columnValue = columnValueElement.getText();
		System.out.println("Lab Bill- Patient Code: " + columnValue);

		// Capture Bill Status Before Paid
		WebElement beforeStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[1]/tr[1]/td[8]/span[1]")));
		String columnValueStatus = beforeStatus.getText();
		System.out.println(columnValue + " : Before paying the Lab bill, status : " + columnValueStatus);

		driver.findElement(By.xpath("//tbody[1]/tr[1]/td[10]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("(//span[contains(text(),'Add New')])[1]")).click();

		driver.findElement(By.xpath("(//mat-select[@placeholder='Select'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'Allergy Skin Test ')]")).click();
		
		try {
            // Continuously refresh the rows list after each deletion
            while (true) {
                // Locate all rows in the table body
                java.util.List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

                boolean found = false; // Flag to check if any delete button was clicked

                // Iterate over each row
                for (int i = 0; i < rows.size(); i++) {
                    try {
                        // Construct the XPath for the 16th column of the current row
                        String valueXPath = "//tbody/tr[" + (i + 1) + "]/td[9]";
                        WebElement valueElement = driver.findElement(By.xpath(valueXPath));
                        String valueText = valueElement.getText();

                        // Check if the value is '0.00'
                        if ("0.00".equals(valueText)) {
                            // Construct the XPath for the delete button in the 17th column
                            String deleteButtonXPath = "//tbody/tr[" + (i + 1) + "]/td[10]//button";
                            WebElement deleteButton = driver.findElement(By.xpath(deleteButtonXPath));

                            // Click the delete button
                            deleteButton.click();
                            WebElement Itemdelete = wait
                    				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Yes')]")));
                            Itemdelete.click();

                            // Set the flag to true indicating a delete action was performed
                            found = true;

                            // Wait for the row to be removed or the table to refresh
                            Thread.sleep(2000); // Optional: Adjust the sleep time as needed

                            // Break out of the for loop to refresh the rows
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                // Exit the while loop if no delete actions were performed
                if (!found) {
                    break;
                }
            }

            Thread.sleep(4000);
    		WebElement payBillButton = driver.findElement(By.xpath("//button[contains(text(),'Pay Bill')]"));
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    		js.executeScript("arguments[0].scrollIntoView(true);", payBillButton);

    		payBillButton.click();
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
    		Thread.sleep(5000);

    		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
    		JavascriptExecutor executor = (JavascriptExecutor) driver;
    		executor.executeScript("arguments[0].click();", menuIcon);
    		Thread.sleep(5000);

    		driver.findElement(By.xpath("(//a[text()=' Lab'])[1]")).click();
    		Thread.sleep(2000);

    		driver.findElement(By.xpath("//div[@id='lab-bill-list1']")).click();

    		By labMonthElementLocatorStatusVerify = By.xpath("(//li[@data-range-key='1 Month'])[8]");
    		WebElement labMonthElementStatusVerify = wait
    				.until(ExpectedConditions.visibilityOfElementLocated(labMonthElementLocatorStatusVerify));
    		labMonthElementStatusVerify.click();
    		Thread.sleep(4000);

    		driver.findElement(By.xpath("//button[@title='Filter']")).click();

    		WebElement FilterALLStatusVerify = wait
    				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[1]")));
    		FilterALLStatusVerify.click();
    		Thread.sleep(3000);

    		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
    		Thread.sleep(3000);

    		WebElement searchInputCard1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
    		searchInputCard1.click();
    		
    		 WebElement searchInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//thead/tr[2]/th[1]/input[1]")));
             searchInputField.click();
             searchInputField.sendKeys(columnValue);
             searchInputField.sendKeys(Keys.ENTER);
             Thread.sleep(2000);
    		
    		// Capture Bill Status After Paid
             WebElement PatientCode = wait
     				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
             String AfterPaidPatientCode = PatientCode.getText();
             
             WebElement Billnumber = wait
     				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[5]")));
     		String AfterPaidBillnumber = Billnumber.getText();
     		
     		WebElement BillDate = wait
     				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[6]")));
     		String AfterPaidBillDate = BillDate.getText();
     		
     		WebElement AfterStatus = wait
     				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[8]")));
     		String AfterPaidStatus = AfterStatus.getText();
     		
     		System.out.println( "After paying the Lab Bill - Patient Code : " + AfterPaidPatientCode);
     		System.out.println( "After paying the Lab Bill - Bill Number  : " + AfterPaidBillnumber);
     		System.out.println( "After paying the Lab Bill - Bill Date  : " + AfterPaidBillDate);
     		System.out.println( "After paying the Lab Bill - Bill Status  : " + AfterPaidStatus);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Optionally close the driver
            // driver.quit();
        }	
		

	}

	
	public static void ScanBill_OneMonthRange() throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

//		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", menuIcon);

		By labLinkLocator = By.xpath("//a[text()=' Scan']");
		WebElement labLink = wait.until(ExpectedConditions.elementToBeClickable(labLinkLocator));
		labLink.click();

		driver.findElement(By.xpath("//div[@id='scan-bill-list1']")).click();
		Thread.sleep(5000);

		By labMonthElementLocator = By.xpath("(//li[@data-range-key='1 Month'])[6]");
		WebElement labMonthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(labMonthElementLocator));
		labMonthElement.click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[@title='Filter']")).click();

		WebElement FilterALL = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[1]")));
		FilterALL.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();

		WebElement columnValueElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
		String columnValue = columnValueElement.getText();
		System.out.println("Scan Bill- Patient Code: " + columnValue);

		// Capture Bill Status Before Paid
		WebElement beforeStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[1]/tr[1]/td[8]/span[1]")));
		String columnValueStatus = beforeStatus.getText();
		System.out.println(columnValue + " : Before paying the Lab bill, status : " + columnValueStatus);

		driver.findElement(By.xpath("//tbody[1]/tr[1]/td[10]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("(//span[contains(text(),'Add New')])[1]")).click();

		driver.findElement(By.xpath("(//mat-select[@placeholder='Select'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'Mammography ')]")).click();

		Thread.sleep(3000);
		WebElement payBillButton = driver.findElement(By.xpath("//button[contains(text(),'Pay Bill')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", payBillButton);

		payBillButton.click();
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
		Thread.sleep(5000);

		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[text()=' Scan']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='scan-bill-list1']")).click();

		By labMonthElementLocatorStatusVerify = By.xpath("(//li[@data-range-key='1 Month'])[8]");
		WebElement labMonthElementStatusVerify = wait
				.until(ExpectedConditions.visibilityOfElementLocated(labMonthElementLocatorStatusVerify));
		labMonthElementStatusVerify.click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[@title='Filter']")).click();

		WebElement FilterALLStatusVerify = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[1]")));
		FilterALLStatusVerify.click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		Thread.sleep(3000);

		WebElement searchInputCard1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchInputCard1.click();
		
		 WebElement searchInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//thead/tr[2]/th[1]/input[1]")));
         searchInputField.click();
         searchInputField.sendKeys(columnValue);
         searchInputField.sendKeys(Keys.ENTER);
         Thread.sleep(2000);

		// Capture Bill Status After Paid
         WebElement PatientCode = wait
 				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
         String AfterPaidPatientCode = PatientCode.getText();
         
         WebElement Billnumber = wait
 				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[5]")));
 		String AfterPaidBillnumber = Billnumber.getText();
 		
 		WebElement BillDate = wait
 				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[6]")));
 		String AfterPaidBillDate = BillDate.getText();
 		
 		WebElement AfterStatus = wait
 				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[8]")));
 		String AfterPaidStatus = AfterStatus.getText();
 		
 		System.out.println( "After paying the Scan Bill - Patient Code : " + AfterPaidPatientCode);
 		System.out.println( "After paying the Scan Bill - Bill Number  : " + AfterPaidBillnumber);
 		System.out.println( "After paying the Scan Bill - Bill Date  : " + AfterPaidBillDate);
 		System.out.println( "After paying the Scan Bill - Bill Status  : " + AfterPaidStatus);
		
		
		
	}

	
	
	public static void OPBill_OneMonthRange_PartiallyPaid() throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.findElement(By.xpath("//a[text()=' OP']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='op-bill-list1']")).click();

		By labMonthElementLocator = By.xpath("(//li[@data-range-key='1 Month'])[6]");
		WebElement labMonthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(labMonthElementLocator));
		labMonthElement.click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[@title='Filter']")).click();

		WebElement FilterALL = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[1]")));
		FilterALL.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();

		WebElement columnValueElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
		String columnValue = columnValueElement.getText();
		System.out.println("OP Bill- Patient Code: " + columnValue);

		// Capture Bill Status Before Paid
		WebElement beforeStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[1]/tr[1]/td[8]/span[1]")));
		String columnValueStatus = beforeStatus.getText();
		System.out.println(columnValue + " : Before paying the OP bill, status : " + columnValueStatus);

		driver.findElement(By.xpath("//tbody[1]/tr[1]/td[10]/div[1]/div[2]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//button[@title='Add'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//mat-select[@placeholder='Select'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'OP-Registration fees ')]")).click();

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
		Thread.sleep(5000);

		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);

		WebElement OPLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' OP']")));
		OPLink.click();

		WebElement billList2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='op-bill-list1']")));
		billList2.click();

		By labMonthElementLocatorStatusVerify = By.xpath("(//li[@data-range-key='1 Month'])[8]");
		WebElement labMonthElementStatusVerify = wait
				.until(ExpectedConditions.visibilityOfElementLocated(labMonthElementLocatorStatusVerify));
		labMonthElementStatusVerify.click();
		Thread.sleep(4000);
		
		WebElement filterButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Filter']")));
		filterButton1.click();

		WebElement FilterALLStatusVerify = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[1]")));
		FilterALLStatusVerify.click();
		Thread.sleep(3000);

		WebElement secondCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[2]")));
		secondCheckbox.click();
		Thread.sleep(3000);
		
		WebElement searchInputCard1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchInputCard1.click();
		
		 WebElement searchInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//thead/tr[2]/th[1]/input[1]")));
         searchInputField.click();
         searchInputField.sendKeys(columnValue);
         searchInputField.sendKeys(Keys.ENTER);
         Thread.sleep(2000);
		
		// Capture Bill Status After Paid
         WebElement PatientCode = wait
 				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
         String AfterPaidPatientCode = PatientCode.getText();
         
         WebElement Billnumber = wait
 				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[5]")));
 		String AfterPaidBillnumber = Billnumber.getText();
 		
 		WebElement BillDate = wait
 				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[6]")));
 		String AfterPaidBillDate = BillDate.getText();
 		
 		WebElement AfterStatus = wait
 				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[8]")));
 		String AfterPaidStatus = AfterStatus.getText();
 		
 		System.out.println( "After paying the OP Bill - Patient Code : " + AfterPaidPatientCode);
 		System.out.println( "After paying the OP Bill - Bill Number  : " + AfterPaidBillnumber);
 		System.out.println( "After paying the OP Bill - Bill Number  : " + AfterPaidBillDate);
 		System.out.println( "After paying the OP Bill - Bill Status  : " + AfterPaidStatus);
	}
	
	
}
