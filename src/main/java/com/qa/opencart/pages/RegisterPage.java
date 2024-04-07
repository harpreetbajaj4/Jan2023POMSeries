package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

	private WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	// private By Locators
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscriptionYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscriptionNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");
	private By agreeCheckBox = By.xpath("//div[@class='pull-right']//input[@name='agree']");
	private By continueButton = By.xpath("//div[@class='pull-right']//input[@value='Continue']");
	private By successMesg = By.xpath("//div[@id='content']//h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	// actions Method

	public String registeUser(String firstName, String lastName, String email, String telephone, String password,
			String subscription) {
		WebElement fName = driver.findElement(this.firstName);
		fName.clear();
		fName.sendKeys(firstName);

		WebElement lName = driver.findElement(this.lastName);
		lName.clear();
		lName.sendKeys(lastName);

		WebElement emailid = driver.findElement(this.email);
		emailid.clear();
		emailid.sendKeys(email);

		WebElement contactNumber = driver.findElement(this.telephone);
		contactNumber.clear();
		contactNumber.sendKeys(telephone);

		WebElement pwd = driver.findElement(this.password);
		pwd.clear();
		pwd.sendKeys(password);

		WebElement pwdConfirm = driver.findElement(this.confirmPassword);
		pwdConfirm.clear();
		pwdConfirm.sendKeys(password);

		doSubscribe(subscription);
		
		WebElement agreeChkBox = driver.findElement(this.agreeCheckBox);
		agreeChkBox.click();
		
		WebElement continueBtn = driver.findElement(this.continueButton);
		continueBtn.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement successMessage = driver.findElement(this.successMesg);
		String message = successMessage.getText();

		WebElement logout = driver.findElement(this.logoutLink);
		logout.click();
		
		WebElement register = driver.findElement(this.registerLink);
		register.click();
		
		return message;

	}
	
	private void doSubscribe(String subscription)
	{
		if (subscription.equals("yes")) {
			WebElement subsYes = driver.findElement(this.subscriptionYes);
			subsYes.click();
		}

		else {
			WebElement subsNo = driver.findElement(this.subscriptionNo);
			subsNo.click();
		}
	}

}
