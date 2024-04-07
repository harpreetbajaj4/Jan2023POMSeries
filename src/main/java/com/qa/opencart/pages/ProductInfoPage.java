package com.qa.opencart.pages;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductInfoPage {

	private WebDriver driver;
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By productHeader = By.cssSelector("div.col-sm-4 h1");
	private By productImages = By.cssSelector("ul.thumbnails li");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");
	private By productQuatity = By.id("input-quantity");
	private By addToCart = By.id("button-cart");
	
	private Map<String, String> productInfoMap;
	
	public String getProductHeaderName()
	{
		String productHeaderName = driver.findElement(productHeader).getText();
		return productHeaderName;
	}
	
	public int getProductImagesCount()
	{
		return driver.findElements(productImages).size();
	}
	
	
//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: In Stock
	private void getProductMetaData()
	{
		List<WebElement> metaInfoList = driver.findElements(productMetaData);
		
		for(WebElement e: metaInfoList)
		{
			String metaText = e.getText();
			String[] metainfo = metaText.split(":");
			String key = metainfo[0].trim();
			String value = metainfo[1].trim();
			productInfoMap.put(key, value);
		}
	}
	
	
//	$2,000.00
//	Ex Tax: $2,000.00	
	private void getProductPriceData()
	{
		List<WebElement> priceInfo= driver.findElements(productPriceData);
		String priceValue = priceInfo.get(0).getText();
		String extTaxPriceInfo = priceInfo.get(1).getText(); //Ex Tax: $2,000.00
		String extTaxPriceKey = extTaxPriceInfo.split(":")[0].trim();
		String extTaxPriceValue = extTaxPriceInfo.split(":")[1].trim();
		productInfoMap.put("productprice", priceValue);
		productInfoMap.put(extTaxPriceKey, extTaxPriceValue);
	}
	
	public Map<String, String> getProductInfo()
	{
//		productInfoMap = new HashMap<String, String>();
//		productInfoMap = new LinkedHashMap<String, String>();
		productInfoMap = new TreeMap<String, String>();
		getProductMetaData();
		getProductPriceData();
		productInfoMap.put("productname",getProductHeaderName());
		return productInfoMap;
	}
	
	
}
