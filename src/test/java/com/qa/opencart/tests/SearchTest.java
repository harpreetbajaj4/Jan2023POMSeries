package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataprovider.ProductDataProvider;

public class SearchTest extends BaseTest{

	
	@BeforeClass
	public void searchSetup()
	{
		ap = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(dataProvider= "productDataWithSearchKey", dataProviderClass = ProductDataProvider.class)
	public void productResultsCountVerification(String searchKey)
	{
//		resPage = ap.doSearch("MacBook");
		resPage = ap.doSearch(searchKey);
		int productCount = resPage.getProductResultsCount();
		System.out.println("Total product result count is:  " + productCount);
		Assert.assertTrue(productCount>0);
	}
	
	
	
	@Test(dataProvider = "productDataWithName", dataProviderClass= ProductDataProvider.class)
	public void selectProductVerification(String searchKey, String productName) throws InterruptedException
	{
		resPage = ap.doSearch("MacBook");
		resPage = ap.doSearch(searchKey);
		Thread.sleep(10000);
//		productinfPage = resPage.selectProduct("MacBook Pro");
		productinfPage = resPage.selectProduct(productName);
		Thread.sleep(10000);
		String actProductHeaderName = productinfPage.getProductHeaderName();
		Assert.assertEquals(actProductHeaderName, productName);
	}
	
	
	@Test(dataProvider = "productDataWithImages", dataProviderClass = ProductDataProvider.class)
	public void productImagesCountTest(String searchKey, String productName, int imageCount) throws InterruptedException
	{
		resPage = ap.doSearch(searchKey);
		Thread.sleep(10000);
		productinfPage = resPage.selectProduct(productName);
		Thread.sleep(10000);
		int actProductImgCount = productinfPage.getProductImagesCount();
		Assert.assertEquals(actProductImgCount, imageCount);
	}
}
