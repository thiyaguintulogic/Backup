package testcases;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import io.netty.handler.timeout.TimeoutException;

public class Mytestcases extends BaseTest{
	
		@Test(priority = 0)
		public static void Logintest() throws InterruptedException {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		    WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin-email")));
		    username.sendKeys("intuadmin");

		    WebElement password = driver.findElement(By.id("signin-password"));
		    password.sendKeys("scott");

		    WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		    submitButton.click();
		    
		    WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
	        JavascriptExecutor executor = (JavascriptExecutor) driver;
	        executor.executeScript("arguments[0].click();", menuIcon);
	        Thread.sleep(5000);

		      
		}

		
		public static void PatientRegistration() throws InterruptedException { 
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			driver.findElement(By.xpath("//a[contains(text(),' Patient Registration')]")).click();
			
			driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys("Grace");
			driver.findElement(By.xpath("//input[@title='Age']")).sendKeys("46");
			driver.findElement(By.xpath("//input[@title='Phone Number']")).sendKeys("5665698565");
			driver.findElement(By.xpath("//span[contains(text(),'Female')]")).click();
			
			Select State = new Select(driver.findElement(By.xpath("//select[@id='cityChange']")));
			State.selectByVisibleText(" Tamil Nadu ");
			
			driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-secure[1]/div[2]/div[1]/app-patient-registration[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[14]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]/mat-select[1]/div[1]/div[1]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Chennai')]")).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 500);");
			
			driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
			
	        Thread.sleep(5000);
			
			driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys("Manoj");
			driver.findElement(By.xpath("//input[@title='Age']")).sendKeys("25");
			driver.findElement(By.xpath("//input[@title='Phone Number']")).sendKeys("2545698758");
			driver.findElement(By.xpath("//span[contains(text(),'Male')]")).click();
			
			Select State1 = new Select(driver.findElement(By.xpath("//select[@id='cityChange']")));
			State1.selectByVisibleText(" Tamil Nadu ");
			
			driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-secure[1]/div[2]/div[1]/app-patient-registration[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[14]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]/mat-select[1]/div[1]/div[1]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Aruppukkottai')]")).click();
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0, 500);");
			
			driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	        
	        
	        Thread.sleep(5000);
			
			driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys("Ananya");
			driver.findElement(By.xpath("//input[@title='Age']")).sendKeys("25");
			driver.findElement(By.xpath("//input[@title='Phone Number']")).sendKeys("2543698575");
			driver.findElement(By.xpath("//span[contains(text(),'Female')]")).click();
			
			Select State11 = new Select(driver.findElement(By.xpath("//select[@id='cityChange']")));
			State11.selectByVisibleText(" Tamil Nadu ");
			
			driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-secure[1]/div[2]/div[1]/app-patient-registration[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[14]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]/mat-select[1]/div[1]/div[1]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Coimbatore')]")).click();
			
			JavascriptExecutor js11 = (JavascriptExecutor) driver;
			js11.executeScript("window.scrollBy(0, 500);");
			
			driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
			
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys("Neeraj");
			driver.findElement(By.xpath("//input[@title='Age']")).sendKeys("58");
			driver.findElement(By.xpath("//input[@title='Phone Number']")).sendKeys("6525489685");
			driver.findElement(By.xpath("//span[contains(text(),'Male')]")).click();
			
			Select State111 = new Select(driver.findElement(By.xpath("//select[@id='cityChange']")));
			State111.selectByVisibleText(" Tamil Nadu ");
			
			driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-secure[1]/div[2]/div[1]/app-patient-registration[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[14]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]/mat-select[1]/div[1]/div[1]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Chengalpattu')]")).click();
			
			JavascriptExecutor js111 = (JavascriptExecutor) driver;
			js111.executeScript("window.scrollBy(0, 500);");
			
			driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
			
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys("Radhika");
			driver.findElement(By.xpath("//input[@title='Age']")).sendKeys("44");
			driver.findElement(By.xpath("//input[@title='Phone Number']")).sendKeys("3524569875");
			driver.findElement(By.xpath("//span[contains(text(),'Male')]")).click();
			
			Select State1111 = new Select(driver.findElement(By.xpath("//select[@id='cityChange']")));
			State1111.selectByVisibleText(" Tamil Nadu ");
			
			driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-secure[1]/div[2]/div[1]/app-patient-registration[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[14]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]/mat-select[1]/div[1]/div[1]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Krishnagiri')]")).click();
			
			JavascriptExecutor js1111 = (JavascriptExecutor) driver;
			js1111.executeScript("window.scrollBy(0, 500);");
			
			driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	        
	        
	        
		}
		
		
		public static void Verify_Unallotted() throws InterruptedException {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			
			// Click on 'Patient Registration'
			WebElement patientRegistration = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' Patient Registration')]")));
			patientRegistration.click();

			// Fill out the registration form for the first patient
			WebElement firstName = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='First Name']")));
			firstName.sendKeys("Miriam");
			
			WebElement Lastname = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[2]")));
			Lastname.sendKeys("Elijah");

			WebElement age = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Age']")));
			age.sendKeys("19");

			WebElement phoneNumber = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Phone Number']")));
			phoneNumber.sendKeys("3212452569");

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
			
			WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
	        JavascriptExecutor executor = (JavascriptExecutor) driver;
	        executor.executeScript("arguments[0].click();", menuIcon);

			WebElement patientSearch = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' Patient Search')]")));
			patientSearch.click();

			// Loop for five appointments
			for (int i = 1; i <=1; i++) {
				// Click the appointment button on the ith row
				WebElement appointmentButton = wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Admit'])[\" + i + \"]")));
				appointmentButton.click();

				// Click the doctor dropdown to open options
				WebElement selectDoctorDropdown = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Doctor']")));
				selectDoctorDropdown.click();

				// Wait for the dropdown options to be interactable
				Select selectDoctor = new Select(selectDoctorDropdown);
				selectDoctor.selectByVisibleText(" Dr.Damien S ");

				// Click the "Save & Close" button
				WebElement saveAndCloseButton = wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='caBtn']")));
				saveAndCloseButton.click();
				
				WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Patient Admitted Successfully')]")));
	            String message = successMessage.getText();
				System.out.println("Appointment message:" + message);
				
				
	    }

	  
	    
	
		}	    
}	    	
	



