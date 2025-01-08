package testcases;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;


public class Diagnosis extends BaseTest {
	
		@Test(priority = 0)
		public static void Logintest() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin-email")));
		username.sendKeys("damien");

		WebElement password = driver.findElement(By.id("signin-password"));
		password.sendKeys("Admin@123");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(8000);

		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", menuIcon);
		Thread.sleep(5000);

	}
	
		@Test(priority = 1)
	public static void OP_Diagnosis() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
		WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'X')]")));
		close.click();
		
		WebElement searchbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='icon-magnifier paginationSearch'])[1]")));
		searchbutton.click();
		
		WebElement doctorname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//thead/tr[2]/th[5]/input[1]")));
		doctorname.sendKeys("damien",Keys.ENTER);
		
		WebElement firstRowFirstColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[1]/span")));
		String valueOfFirstRowFirstColumn = firstRowFirstColumn.getText();
		System.out.println("Before Start Diagnosis Patient Code : " + valueOfFirstRowFirstColumn);

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
		
		// Capture OP Diagnosis Status Before Start
        WebElement Diagnosis_Status = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[6]")));
        String beforeDiagnosis_Status = Diagnosis_Status.getText();
        System.out.println("Patient Diagnosis Status - Before Start: "+ beforeDiagnosis_Status);
        
		
		WebElement firstElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[8]/div[1]/a[1]/span[1]")));
		firstElement.click();
		
		WebElement clickdiagnosis = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Diagnosis')]")));
		clickdiagnosis.click();
		
		WebElement heightField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Height']")));
		heightField.sendKeys("170");
        
        WebElement weightField = driver.findElement(By.xpath("//input[@placeholder='Weight']"));
        weightField.sendKeys("68");
        
        WebElement bpField = driver.findElement(By.xpath("//input[@placeholder='BP']"));
        bpField.sendKeys("120/80");
        
        WebElement tempField = driver.findElement(By.xpath("(//input[@placeholder='0'])[1]"));
        tempField.sendKeys("98.6");
        
        WebElement glucoseField = driver.findElement(By.xpath("(//input[@placeholder='0'])[2]"));
        glucoseField.sendKeys("116");
        
        WebElement o2SaturationField = driver.findElement(By.xpath("(//input[@placeholder='0'])[3]"));
        o2SaturationField.sendKeys("98"); 
        
        WebElement pulseField = driver.findElement(By.xpath("(//input[@placeholder='0'])[4]"));
        pulseField.sendKeys("72");
        
        WebElement respRateField = driver.findElement(By.xpath("(//input[@placeholder='0'])[5]"));
        respRateField.sendKeys("16");
        
        WebElement painField = driver.findElement(By.xpath("//input[@title='0']"));
        painField.sendKeys("9");
        
        WebElement Chief_Complaint = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Enter Chief Complaint Here']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", Chief_Complaint);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        wait.until(ExpectedConditions.elementToBeClickable(Chief_Complaint));
        Chief_Complaint.sendKeys("Acute lower back pain, possibly muscle strain");
        
        WebElement Previous_Medical_Condition = driver.findElement(By.xpath("//textarea[@placeholder='Enter Previous Medical Condition Here']"));
        Previous_Medical_Condition.sendKeys("History of episodic back pain for 2 years");
        
        
       WebElement addTemplatemedicine = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@title='Add Template'])[1]")));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addTemplatemedicine);
       ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
       wait.until(ExpectedConditions.elementToBeClickable(addTemplatemedicine));
       addTemplatemedicine.click();
       
        WebElement templatename = driver.findElement(By.xpath("//input[@placeholder='Search Template...']"));
        templatename.sendKeys("BP");		
        WebElement selectTemplate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),' BP Tablets ')]")));
        selectTemplate.click();
        
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        
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
		
		WebElement addTemplatelab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@title='Add Template'])[2]")));
	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addTemplatelab);
	       ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
	       wait.until(ExpectedConditions.elementToBeClickable(addTemplatelab));
	       addTemplatelab.click();
	       
	    WebElement templatenamelab = driver.findElement(By.xpath("//input[@placeholder='Search Template...']"));
	    templatenamelab.sendKeys("Blood");		
	    WebElement selectTemplatelab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Blood Test')]")));
	    selectTemplatelab.click();
	    Thread.sleep(2000);
		
	    WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Save')])[4]")));
	    saveButton.click();
	    
	    WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@value='null']")));
	    Select dropdown = new Select(dropdownElement);
	    dropdown.selectByVisibleText("Fertility");
		
	    WebElement startButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Start']")));
	    startButton.click();
	    
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement saveAndNextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Save and Next')])")));
		js.executeScript("arguments[0].scrollIntoView(true);", saveAndNextButton1);
		saveAndNextButton1.click();
		
		WebElement opTab1scan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='opScanId']")));
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].click();", opTab1scan);
		Thread.sleep(2000);
		
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
		
		WebElement saveButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='scanSave']")));
		saveButton1.click();
		
		WebElement opTab0Female = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='opTab0']")));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", opTab0Female);
		Thread.sleep(2000);
	
		WebElement tab0Textarea2Female = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@type='text'])[2]")));
		tab0Textarea2Female.clear();
		tab0Textarea2Female.sendKeys("4 Years");
		
		WebElement tab0Textarea3Female = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@type='text'])[3]")));
		tab0Textarea3Female.clear();
		tab0Textarea3Female.sendKeys("2 Years");

		
		WebElement opTab1male = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='opTab1']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", opTab1male);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		
		opTab1male = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='opTab1']")));
		opTab1male.click();
		Thread.sleep(2000);
		
		WebElement tab1Textarea2male = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@type='text'])[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tab1Textarea2male);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
		
		
		WebElement tab1Textarea2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@type='text'])[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tab1Textarea2);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
		tab1Textarea2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@type='text'])[2]")));
		tab1Textarea2.clear();
		tab1Textarea2.sendKeys("4 Years");
		
		WebElement tab1Textarea3male = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@type='text'])[3]")));
		tab1Textarea3male.clear();
		tab1Textarea3male.sendKeys("2 Years");
		
		
		WebElement elementHistory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='opTab2']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementHistory);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		elementHistory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='opTab2']")));
		elementHistory.click();
		Thread.sleep(2000);
		
		WebElement Mother_Diabetics = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@type='text'])[2]")));
		Mother_Diabetics.clear();
		Mother_Diabetics.sendKeys("Diabetes can affect the risk of diabetes in her offspring, "
				+ "and can also increase the risk of complications during pregnancy");
		
		WebElement Mother_Blood_Pressure = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@type='text'])[3]")));
		Mother_Blood_Pressure.clear();
		Mother_Blood_Pressure.sendKeys("A mother's blood pressure history can be important for identifying risks to her and her baby");
		
		WebElement opTab3Allergy  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='opTab3']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", opTab3Allergy);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		wait.until(ExpectedConditions.elementToBeClickable(opTab3Allergy));
		opTab3Allergy.click();
		Thread.sleep(2000);
		
		WebElement Medicine_Allergy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@type='text'])[2]")));
		Medicine_Allergy.clear();
		Medicine_Allergy.sendKeys("A medicine allergy occurs when your body's immune system mistakenly identifies "
				+ "a medication as a harmful substance");
		
		WebElement Allergic_Reaction = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@type='text'])[3]")));
		Allergic_Reaction.clear();
		Allergic_Reaction.sendKeys("Allergic reactions are sensitivities to substances called allergens that "
				+ "come into contact with the skin, nose, eyes, respiratory tract, and gastrointestinal tract");
		
		WebElement opTab4Investigations = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='opTab4']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", opTab4Investigations);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		wait.until(ExpectedConditions.elementToBeClickable(opTab4Investigations));
		opTab4Investigations.click();
		Thread.sleep(2000);
		
		WebElement Investigations = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@type='text'])[2]")));
		Investigations.clear();
		Investigations.sendKeys("Blood tests, FSH and LH, Progesterone, Thyroid function, and Prolactin");
		
		WebElement opTab5DoctorNotes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='opTab4']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", opTab5DoctorNotes);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		wait.until(ExpectedConditions.elementToBeClickable(opTab5DoctorNotes));
		opTab5DoctorNotes.click();
		
		WebElement DoctorNotes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@type='text'])[2]")));
		DoctorNotes.clear();
		DoctorNotes.sendKeys("Moderate physical activity, vegetarian diet, occasional junk food.");
		
		
		WebElement opTabsum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='opTabsum']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", opTabsum);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
		wait.until(ExpectedConditions.elementToBeClickable(opTabsum));
		opTabsum.click();
		
		WebElement adviceTextArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Enter Advice Details Here']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", adviceTextArea);
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
		adviceTextArea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@placeholder='Enter Advice Details Here']")));
		adviceTextArea.clear();  
		adviceTextArea.sendKeys("The procedure was performed under [anesthesia type] "
				+ "and was completed successfully without complications.");
		Thread.sleep(2000);
		
		try {
		    // Wait for the date picker input field to be visible
			WebElement datePickerInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='DD-MM-YYYY']")));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView(true);", datePickerInput);
			js1.executeScript("arguments[0].click();", datePickerInput);
		    
		    // Wait for the date to be clickable and click it
		    LocalDate today = LocalDate.now();
		    LocalDate dateAfterTwoDays = today.plusDays(2);
		    
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
		    String formattedDate = dateAfterTwoDays.format(formatter);
		    
		    WebElement dateToSelect = wait.until(ExpectedConditions.presenceOfElementLocated(
		            By.xpath("//td[@class='available'][normalize-space()='" + formattedDate + "']")));		   
		    dateToSelect.click();
		    WebElement SaveDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='daterangepicker ltr single opensright show-calendar']//button[@type='button'][normalize-space()='Apply']")));
	        SaveDate .click();
		    
		} catch (TimeoutException e) {
		    System.out.println("Timeout while waiting for date picker input: " + e.getMessage());
		} catch (Exception e) {
		    System.out.println("Error occurred: " + e.getMessage());
		}
		Thread.sleep(2000);
        
		WebElement Comments = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@placeholder='Notes']")));
		Comments.clear();
		Comments.sendKeys("The surgery was successful, and the patient is expected to recover well with proper follow-up care. ");
		
		WebElement OPsaveclose = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='saveAndCl']")));
		OPsaveclose .click();
		
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchButton.click();
		
		WebElement SearchStatusafter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//thead/tr[2]/th[1]/input[1]")));
		SearchStatusafter.sendKeys(valueOfFirstRowFirstColumn);
		SearchStatusafter.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		// Capture OP Diagnosis Status after completed
        WebElement Diagnosis_Status1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[6]")));
        String beforeDiagnosis_Status1 = Diagnosis_Status1.getText();
        System.out.println("Patient Diagnosis Status - After Complete: "+ beforeDiagnosis_Status1);
		
		
	}
		
	

}
