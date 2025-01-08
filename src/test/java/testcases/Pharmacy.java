package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class Pharmacy extends BaseTest {

	
	@Test(priority = 0)
	public static void Logintest() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

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
	
	
	public static void Walking_Bill() throws InterruptedException, AWTException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//a[text()=' Billing']")).click();
		
		
		
		driver.findElement(By.xpath("//button[text()='Create New Bill']")).click();
		Thread.sleep(2000);
		
		WebElement Patient_Name = driver.findElement(By.xpath("//input[@title='Patient Name']"));
		Patient_Name.clear();
		Patient_Name.sendKeys("William");
		
		driver.findElement(By.xpath("//input[@title='Phone Number']")).sendKeys("1232124524");
		
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Dinesh");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()=' Dinesh R ']")).click();
		
		driver.findElement(By.xpath("//span[text()='Add New']")).click();
		
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("VITALWIN");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'VITALWIN 5mg')]")).click();
		
	
		driver.findElement(By.xpath("//span[text()='Add New']")).click();
		
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Finasteride");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Finasteride 5mg')]")).click();
		Thread.sleep(2000);
		
		WebElement Qty = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
		Qty.clear();
		Qty.sendKeys("5");
		
		driver.findElement(By.xpath("//button[contains(text(),'Generate Bill')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Pay & Print')]")).click();
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

		driver.findElement(By.xpath("//a[text()=' Billing']")).click();
		Thread.sleep(3000);
		
		WebElement tableCell1 = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]"));
        String CapturePatient_Name1 = tableCell1.getText();
        System.out.println("Walking Bill - Patient Name : " + CapturePatient_Name1);
		
		WebElement tableCell = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[4]"));
        String Bill_Number = tableCell.getText();
        System.out.println("Walking Bill - Bill Number : " + Bill_Number);
		
	}
	
	
	public static void OP_Pharmacy() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement viewAppointmentsButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' View Appointments')]")));
		viewAppointmentsButton.click();
		
		WebElement firstRowFirstColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[1]/span")));
		String valueOfFirstRowFirstColumn = firstRowFirstColumn.getText().trim();
        //System.out.println("OP Pharmacy Bill Patient Code :" + valueOfFirstRowFirstColumn);
		
		WebElement CurrentmenuIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor Currentmenuexecutor = (JavascriptExecutor) driver;
		Currentmenuexecutor.executeScript("arguments[0].click();", CurrentmenuIcon);

		driver.findElement(By.xpath("//a[contains(text(),' Current Admissions')]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchStatus = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus.clear();
		SearchStatus.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//tbody/tr[1]/td[8]/div[1]/a[1]/span[1]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Prescription')]")).click();
		Thread.sleep(3000);
		
		WebElement addNewButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])[1]")));
		addNewButton.click();
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Medicine']")).sendKeys("VOMILAST");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'VOMILAST')]")).click();
		
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
		
		WebElement Qty = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
		Qty.clear();
		Qty.sendKeys("2");
		
	
		driver.findElement(By.xpath("//span[text()='Add New']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Medicine']")).sendKeys("ACESOFT");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'ACESOFT ')]")).click();
		Thread.sleep(2000);
		
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
		
		WebElement Qty1 = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
		Qty1.clear();
		Qty1.sendKeys("3");
		
		driver.findElement(By.xpath("//span[text()='Add New']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Medicine']")).sendKeys("CETRITREAT");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'CETRITREAT ')]")).click();
		Thread.sleep(2000);
		
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
		
		WebElement Qty2 = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
		Qty2.clear();
		Qty2.sendKeys("5");
		
		driver.findElement(By.xpath("//span[text()='Add New']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Medicine']")).sendKeys("DEFLOLAG");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'DEFLOLAG')]")).click();
		Thread.sleep(2000);
		
		WebElement Frq_M3 = driver.findElement(By.xpath("//input[@placeholder='M']"));
		Frq_M3.clear();
		Frq_M3.sendKeys("1");
		
		WebElement Frq_N3 = driver.findElement(By.xpath("//input[@placeholder='N']"));
		Frq_N3.clear();
		Frq_N3.sendKeys("1");
		
		WebElement Instructions3 = driver.findElement(By.xpath("//input[@placeholder='Instructions']"));
		Instructions3.clear();
		Instructions3.sendKeys("Store at room temperature");
		
		WebElement BF_AF3 = driver.findElement(By.xpath("//span[normalize-space()='A']"));
		BF_AF3.click();
		
		WebElement Qty3 = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
		Qty3.clear();
		Qty3.sendKeys("2");
		
		driver.findElement(By.xpath("(//button[text()=' Save & Close '])[1]")).click();
		Thread.sleep(4000);
		
		WebElement menuIcon2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", menuIcon2);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//a[text()=' Pharmacy'])[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		WebElement SearchStatus1 = driver.findElement(By.xpath("//thead/tr[2]/th[1]/input[1]"));
		SearchStatus1.clear();
		SearchStatus1.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatus1.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		WebElement columnValueElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
		String columnValue = columnValueElement.getText();
		System.out.println("OP Pharmacy Bill- Patient Code: " + columnValue);

		// Capture Bill Status Before Paid
		WebElement beforeStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Status']")));
		String columnValueStatus = beforeStatus.getText();
		System.out.println(columnValue + " : Before paying the OP Pharmacy bill, status : " + columnValueStatus);
		
		driver.findElement(By.xpath("//tbody/tr[1]/td[9]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(5000);
		
		//WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement generateBillButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Generate Bill')]")));
        generateBillButton.click();
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(3000);
		
		
        //WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement paybutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Pay')])[2]")));
        paybutton.click();
        Thread.sleep(10000);
	
		//WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
//        WebElement close = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(text(),'X')]")));
//        close.click();
        
        WebElement searchInputCard1 = driver.findElement(By.xpath("//button[@title='Search']"));
		searchInputCard1.click();
        
        WebElement searchInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//thead/tr[2]/th[1]/input[1]")));
        searchInputField.click();
        searchInputField.sendKeys(valueOfFirstRowFirstColumn);
        searchInputField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
		
		// Capture Bill Status After Paid
        
        WebElement Billnumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[4]")));
		String AfterPaidBillnumber = Billnumber.getText();
		
				WebElement AfterStatus = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[7]")));
				String columnValueStatusAfter = AfterStatus.getText();
				System.out.println(valueOfFirstRowFirstColumn + " : After paying the OP Pharmacy bill, status : " + columnValueStatusAfter);
				System.out.println("After paying the Pharmacy Bill - Bill Number  : " + AfterPaidBillnumber);
		
	}
	
	
	public static void Old_OP_Pharmacy() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		driver.findElement(By.xpath("(//a[text()=' Pharmacy'])[1]")).click();
		Thread.sleep(2000);
		
		WebElement calender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='pharmacy-list1']")));
		calender.click();
		
		By PharmacyMonthElementLocator = By.xpath("/html/body/div[7]/div[1]/ul/li[3]");
		WebElement PharmacyMonthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PharmacyMonthElementLocator));
		PharmacyMonthElement.click();
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
		System.out.println("OP Pharmacy Bill- Patient Code: " + columnValue);

		// Capture Bill Status Before Paid
		WebElement beforeStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[1]/tr[1]/td[7]/span[1]")));
		String columnValueStatus = beforeStatus.getText();
		System.out.println(columnValue + " : Before paying the OP Pharmacy bill, status : " + columnValueStatus);
		
		driver.findElement(By.xpath("//tbody[1]/tr[1]/td[9]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(5000);
		
		
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
                        String valueXPath = "//tbody/tr[" + (i + 1) + "]/td[16]";
                        WebElement valueElement = driver.findElement(By.xpath(valueXPath));
                        String valueText = valueElement.getText();

                        // Check if the value is '0.00'
                        if ("0.00".equals(valueText)) {
                            // Construct the XPath for the delete button in the 17th column
                            String deleteButtonXPath = "//tbody/tr[" + (i + 1) + "]/td[17]//button";
                            WebElement deleteButton = driver.findElement(By.xpath(deleteButtonXPath));

                            // Click the delete button
                            deleteButton.click();

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

            // After exiting the loop, you can perform any further actions if needed
            // For example, wait for the Generate Bill button to be clickable
          //WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement generateBillButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Generate Bill')]")));
            generateBillButton.click();
            Thread.sleep(3000);
    		
    		JavascriptExecutor js2 = (JavascriptExecutor) driver;
    		js2.executeScript("window.scrollBy(0, 500);");
    		Thread.sleep(3000);
    		
    		WebElement paybutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Pay')])[2]")));
            paybutton.click();
            Thread.sleep(10000);
    			
    		WebElement searchInputCard1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Search']")));
    		searchInputCard1.click();
            
            WebElement searchInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//thead/tr[2]/th[1]/input[1]")));
            searchInputField.click();
            searchInputField.sendKeys(columnValue);
            searchInputField.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
    		
    		// Capture Bill Status After Paid
    				WebElement AfterStatus = wait
    						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[7]")));
    				String columnValueStatusAfter = AfterStatus.getText();
    				
    				WebElement columnValueAfterpaidBillnumber = wait
    						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[4]")));
    				String AfterpaidBillnumber = columnValueAfterpaidBillnumber.getText();
    				
    				System.out.println(columnValue + " : After paying the OP Pharmacy bill, status : " + columnValueStatusAfter);
    				System.out.println(columnValue + " : After paying the OP Pharmacy Bill Number  : " + AfterpaidBillnumber);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Optionally close the driver
            // driver.quit();
        }	
				
	}
	
	
	
	public static void Pharmacy_CreateNewBill_WithCASH() throws InterruptedException {
			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		driver.findElement(By.xpath("(//a[text()=' Pharmacy'])[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Add Bill']")).click();
		
		WebElement searchName = driver.findElement(By.xpath("//input[@name='patientCode']"));
		searchName.clear();
		searchName.sendKeys("Christian");
		
		WebElement selectName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-option-text']")));
		selectName.click();
				
		
		Select DoctorName = new Select(driver.findElement(By.xpath("//select[@title='Select Doctor']")));
		DoctorName.selectByIndex(1);
		
		WebElement addNewButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])[1]")));
		addNewButton1.click();
		
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("ACESOFT");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'ACESOFT ')]")).click();
		Thread.sleep(2000);
		
		WebElement Qty1 = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
		Qty1.clear();
		Qty1.sendKeys("3");
		
		WebElement addNewButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])[1]")));
		addNewButton2.click();
		
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("CETRITREAT");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'CETRITREAT ')]")).click();
		Thread.sleep(2000);
		
		WebElement Qty2 = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
		Qty2.clear();
		Qty2.sendKeys("6");
		
		WebElement addNewButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])[1]")));
		addNewButton3.click();
		
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Mounjaro");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Mounjaro tab ')]")).click();
		Thread.sleep(2000);
		
		WebElement Qty3 = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
		Qty3.clear();
		Qty3.sendKeys("2");
		
		WebElement addNewButton4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])[1]")));
		addNewButton4.click();
		
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("rantac");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Rantac')]")).click();
		Thread.sleep(2000);
		
		WebElement Qty4 = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
		Qty4.clear();
		Qty4.sendKeys("6");
		
		WebElement generateBillButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Generate Bill')]")));
        generateBillButton.click();
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(3000);
		
		
        //Payment With - CASH
        WebElement paybutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Pay')])[2]")));
        paybutton.click();
        Thread.sleep(10000);
        
     // Capture Bill Status After Paid
        
        WebElement PatientCode = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
        String AfterPaidPatientCode = PatientCode.getText();
        
		WebElement AfterStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[7]")));
		String AfterPaidStatus = AfterStatus.getText();
		
		WebElement Billnumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[4]")));
		String AfterPaidBillnumber = Billnumber.getText();
		
		
		System.out.println( "After paying the OP Pharmacy bill - Patient Code : " + AfterPaidPatientCode);
		System.out.println( "After paying the OP Pharmacy Bill - Bill Number  : " + AfterPaidBillnumber);
		System.out.println( "After paying the OP Pharmacy Bill - Bill Status  : " + AfterPaidStatus);
		
	}
	
	
	@Test(priority = 1)
	public static void Pharmacy_CreatenewBill_WithUPI_Payment () throws InterruptedException {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		driver.findElement(By.xpath("(//a[text()=' Pharmacy'])[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Add Bill']")).click();
		
		WebElement searchName = driver.findElement(By.xpath("//input[@name='patientCode']"));
		searchName.clear();
		searchName.sendKeys("Raghav");

		WebElement selectName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-option-text']")));
		selectName.click();

		Select DoctorName = new Select(driver.findElement(By.xpath("//select[@title='Select Doctor']")));
		DoctorName.selectByIndex(1);
		
		WebElement patientcodecolumn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//table/tr[2]/td[3])[1]")));
		String patientcode = patientcodecolumn.getText();
		System.out.println("Before paying the OP Pharmacy bill - Patient Code : "+patientcode);
		
		WebElement addNewButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])[1]")));
		addNewButton1.click();
		
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("ACESOFT");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'ACESOFT ')]")).click();
		Thread.sleep(2000);
		
		WebElement Qty1 = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
		Qty1.clear();
		Qty1.sendKeys("3");
		
		WebElement addNewButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])[1]")));
		addNewButton2.click();
		
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("CETRITREAT");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'CETRITREAT ')]")).click();
		Thread.sleep(2000);
		
		WebElement Qty2 = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
		Qty2.clear();
		Qty2.sendKeys("6");
		
		WebElement addNewButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])[1]")));
		addNewButton3.click();
		
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Mounjaro");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Mounjaro tab ')]")).click();
		Thread.sleep(2000);
		
		WebElement Qty3 = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
		Qty3.clear();
		Qty3.sendKeys("2");
		
		WebElement addNewButton4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Add New')])[1]")));
		addNewButton4.click();
		
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("rantac");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Rantac')]")).click();
		Thread.sleep(2000);
		
		WebElement Qty4 = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
		Qty4.clear();
		Qty4.sendKeys("6");
		
		WebElement generateBillButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Generate Bill')]")));
        generateBillButton.click();
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(3000);
		
	// Extract the amount
				String amountText = driver.findElement(By.xpath("//tbody/tr[7]/td[1]")).getText();
				String amountValue = amountText.replaceAll("[^0-9.]", ""); // Extract numeric characters
				//System.out.println("Cleaned Amount Text: " + amountValue);
				
				double originalAmount = Double.parseDouble(amountValue);
				
				int wholeNumberPart = (int) originalAmount; // Cast to int to remove decimal part
				//System.out.println("Whole Amount: " + wholeNumberPart);
				
		
		//table[1]/tfoot[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]
		//tbody/tr[1]/td[1]/select[1]
		
		driver.findElement(By.xpath("//table[1]/tfoot[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]")).click();
		
		Select PaymentMode = new Select(driver.findElement(By.xpath("//tbody/tr[1]/td[1]/select[1]")));
		PaymentMode.selectByVisibleText("UPI");
		
		WebElement ReferenceCode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[2]/input[1]")));
		ReferenceCode.clear();
		ReferenceCode.sendKeys("2545698758");
		
		WebElement amountInputBox = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Amount']")));
		amountInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, String.valueOf(wholeNumberPart));
	
        WebElement paybutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Pay')])[2]")));
        paybutton.click();
        Thread.sleep(10000);

        WebElement PatientCode = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[1]")));
        String AfterPaidPatientCode = PatientCode.getText();
        
		WebElement AfterStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[7]")));
		String AfterPaidStatus = AfterStatus.getText();
		
		WebElement Billnumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[4]")));
		String AfterPaidBillnumber = Billnumber.getText();
		
		
		System.out.println( "After paying the OP Pharmacy bill - Patient Code : " + AfterPaidPatientCode);
		System.out.println( "After paying the OP Pharmacy Bill - Bill Number  : " + AfterPaidBillnumber);
		System.out.println( "After paying the OP Pharmacy Bill - Bill Status  : " + AfterPaidStatus);
		
	}
}
