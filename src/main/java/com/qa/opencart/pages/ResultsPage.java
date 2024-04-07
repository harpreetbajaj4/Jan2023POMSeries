package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage {

	private WebDriver driver;
	
	public ResultsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	private By resultsProduct = By.cssSelector("div.product-layout.product-grid");
	
	public String getResultPageTitle()
	{
		return driver.getTitle();
	}
	
	public int getProductResultsCount()
	{
		int resultCount = driver.findElements(resultsProduct).size();
		System.out.println("Product search result count===>" + resultCount);
		return resultCount;
	}
	
	public ProductInfoPage selectProduct(String productName)
	{
//		List<WebElement> productResLists = driver.findElements(resultsProduct);
		/*
		 * for(WebElement e: productResLists) { String text = e.getText();
		 * System.out.println(text); if(text.contains(productName)) { e.click(); break;
		 * } }
		 */
		
		By productNameLocator = By.linkText(productName);
		driver.findElement(productNameLocator).click();
		return new ProductInfoPage(driver);
		
	}
}

