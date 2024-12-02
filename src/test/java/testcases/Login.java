package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class Login extends BaseTest  {
	
	
	@Test(priority = 0)
	public static void Logintest() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin-email")));
		username.sendKeys("FAC-155-support");

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
	public static void PatientRegistration() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Click on 'Patient Registration'
		WebElement patientRegistration = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' Patient Registration')]")));
		patientRegistration.click();

		// Fill out the registration form for the first patient
		WebElement firstName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='First Name']")));
		firstName.sendKeys("Suhani");

		WebElement age = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Age']")));
		age.sendKeys("39");

		WebElement phoneNumber = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Phone Number']")));
		phoneNumber.sendKeys("4565478956");

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
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Chennai')]")));
		cityChennai.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");

		WebElement submitButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
		submitButton.click();

		Thread.sleep(5000);

		// Fill out the registration form for the second patient
		WebElement firstName2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='First Name']")));
		firstName2.sendKeys("Abhinav");

		WebElement age2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Age']")));
		age2.sendKeys("65");

		WebElement phoneNumber2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Phone Number']")));
		phoneNumber2.sendKeys("1545657896");

		WebElement genderMale = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Male')]")));
		genderMale.click();

		WebElement stateDropdown2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='cityChange']")));
		Select state2 = new Select(stateDropdown2);
		state2.selectByVisibleText(" Tamil Nadu ");

		WebElement cityField2 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"patientForm\"]/div[1]/div[15]/div/mat-form-field/div/div[1]")));
		cityField2.click();

		WebElement cityAruppukkottai = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Aruppukkottai')]")));
		cityAruppukkottai.click();

		js.executeScript("window.scrollBy(0, 500);");

		WebElement submitButton2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
		submitButton2.click();

	}

	
	@Test(priority = 2)
	public static void Create_Appointment() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mega-menu-nav-btn")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", menuIcon);

		WebElement patientSearch = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' Patient Search')]")));
		patientSearch.click();

		// Loop for five appointments
		for (int i = 1; i <=2; i++) {
			// Click the appointment button on the ith row
			WebElement appointmentButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Appointment'])[" + i + "]")));
			appointmentButton.click();

			// Wait for the purpose dropdown to be clickable
			WebElement purposeDropdown = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Purpose of Visit']")));
			purposeDropdown.click();

			// Select "Out Patient" from the purpose dropdown
			Select selectPurposeofVisit = new Select(purposeDropdown);
			selectPurposeofVisit.selectByVisibleText("Out Patient");

			// Click the doctor dropdown to open options
			WebElement selectDoctorDropdown = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@title='Select Doctor']")));
			selectDoctorDropdown.click();

			// Wait for the dropdown options to be interactable
			Select selectDoctor = new Select(selectDoctorDropdown);
			selectDoctor.selectByVisibleText(" Dr.Alice Brooks ");

			// Click the "Save & Close" button
			WebElement saveAndCloseButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),' Save & Close ')]")));
			saveAndCloseButton.click();
			
			WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Appoinment Saved Successfully')]")));
            String message = successMessage.getText();
			System.out.println("Appointment message:" + message);

		}

	}
}
