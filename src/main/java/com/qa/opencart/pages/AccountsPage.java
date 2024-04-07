package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By logoutLink = By.linkText("Logout");
	private By myAccountLink = By.linkText("My Account");
	private By searchField = By.name("search");
	private By accountsPageHeader = By.cssSelector("div#content h2");
	private By searchBtn = By.cssSelector("div#search button");
	
	
	public String getAccountPageTitle()
	{
		String accountsPageTitle = driver.getTitle();
		System.out.println("Accounts page title is : " + accountsPageTitle);
		return accountsPageTitle;
	}
	
	public boolean isMyAccountLinkExist()
	{
		return driver.findElement(myAccountLink).isDisplayed();
	}
	
	public boolean isLogoutLinkVisible()
	{
		return driver.findElement(logoutLink).isDisplayed();
	}
	
	public List<String> accountsPageHeaderLinksList()
	{
		List<WebElement> accPageHeaderList = driver.findElements(accountsPageHeader);
		List<String> accPageHeaderValList = new ArrayList<String>();
		
		for(WebElement e : accPageHeaderList)
		{
			String text = e.getText();
			accPageHeaderValList.add(text);
		}
		return accPageHeaderValList;
	}
	
	public ResultsPage doSearch(String searchPattern)
	{
		driver.findElement(searchField).clear();
		driver.findElement(searchField).sendKeys(searchPattern);
		driver.findElement(searchBtn).click();
		return new ResultsPage(driver);
	}
}
