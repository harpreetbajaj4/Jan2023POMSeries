package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	
	private By emailId = By.id("input-email");
	private By pwd = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgottenPwd = By.linkText("Forgotten Password");
	private By footerLinks = By.xpath("//footer//a");
	private By registerLink = By.linkText("Register");
	
	
	public String getLoginPageTiltle() {
//		String title = driver.getTitle();
//		System.out.println("Login page tilte : " + title);
		String title = eleUtil.waitForTitleIsAndCapture("Account Login", 5);
		return title;
	}
			
	
	public String getLoginPageUrl()
	{
//		String url = driver.getCurrentUrl();
//		System.out.println("Login page url : " + url);
		String url = eleUtil.waitForURLContainsAndCapture("route=account/login", 5);
		return url;
	}
	
	public boolean isForgottnPwdLinkPresent()
	{
//		return driver.findElement(forgottenPwd).isDisplayed();
		return eleUtil.checkElementIsDisplayed(forgottenPwd);
	}
	
	public List<String> getFooterLinksTextList()
	{
//		List<WebElement>  footerLinksLists = driver.findElements(footerLinks);
		List<WebElement>  footerLinksLists = eleUtil.waitForElementsVisible(footerLinks, 10);
		List<String> footerLinksTextLists = new ArrayList<String>();
		for(WebElement e : footerLinksLists)
		{
			String text = e.getText();
			footerLinksTextLists.add(text);
		}
		
		return footerLinksTextLists;
		
	}
	
	public AccountsPage login(String username, String pw) 
	{
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(pwd).sendKeys(pw);
		driver.findElement(loginBtn).click();
//		eleUtil.waitForElementVisible(emailId, 10).sendKeys(username);
//		eleUtil.doSendKeys(pwd, pw);
		return new AccountsPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage()
	{
		driver.findElement(registerLink).click();
		return new RegisterPage(driver);
	}
	
}
