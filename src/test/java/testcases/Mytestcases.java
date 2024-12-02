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

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin-email")));
		    username.sendKeys("intulogicMulti");

		    WebElement password = driver.findElement(By.id("signin-password"));
		    password.sendKeys("Intulogic@123");

		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		    Thread.sleep(8000);
		    
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
		
		@Test(priority = 1)
		public static void Create_Appointment() throws InterruptedException {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			driver.findElement(By.xpath("//a[contains(text(),' Patient Search')]")).click();

	        // Wait for the page to load (you might want to use a more specific condition)
	        Thread.sleep(5000);

	     // Loop for five appointments
	        for (int i = 1; i <= 5; i++) {
	            // Click the appointment button on the ith row
	            WebElement appointmentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr[\" + i + \"]//button[@title='Appointment']")));
	            appointmentButton.click();

	            // Wait for the success message or existing appointment message (you might want to use a more specific condition)
	            Thread.sleep(2000);
	            
	         // Wait for the purpose dropdown to be clickable
	            WebElement purposeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Purpose of Visit']")));
	            purposeDropdown.click();

	            // Select "Out Patient" from the purpose dropdown
	            Select selectPurposeofVisit = new Select(purposeDropdown);
	            selectPurposeofVisit.selectByVisibleText("Out Patient");

	            // Wait for the doctor dropdown to be clickable
	            WebElement selectDoctorDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Doctor']")));
	            selectDoctorDropdown.click();

	            // Select "Dr.Madan S" from the doctor dropdown
	            Select selectDoctor = new Select(selectDoctorDropdown);
	            selectDoctor.selectByVisibleText(" Dr.Madan S ");

	            // Click the "Save & Close" button
	            driver.findElement(By.xpath("//button[contains(text(),' Save & Close ')]")).click();
	            Thread.sleep(3000);

	            // Check for the presence of the success message
	            if (isSuccessMessageDisplayed()) {
	                // If the success message is displayed, continue to the next iteration
	                continue;
	            }

	            // Check for the presence of the existing appointment message
	            try {
	                WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),' Close ')]")));
	                closeButton.click();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	            // Continue with the next appointment in the loop
	        }
	    }

	    private static boolean isSuccessMessageDisplayed() {
	        // Check if the success message is displayed
	        try {
	            WebElement successMessage = driver.findElement(By.xpath("//div[@aria-label='Appointment Saved Successfully']"));
	            return successMessage.isDisplayed();
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	            return false;
	        }
	    }

	    private static boolean isExistingAppointmentMessageDisplayed() {
	        // Check if the existing appointment message is displayed
	        try {
	            WebElement existingAppointmentMessage = driver.findElement(By.xpath("//div[@aria-label='Appointment Already Created For This Patient']"));
	            return existingAppointmentMessage.isDisplayed();
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	            return false;
	        }
		
}
	    
}	    	
	



