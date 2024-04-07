package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataprovider.ProductDataProvider;
import com.qa.opencart.pojo.Product;

public class SearchDataTest extends BaseTest{

	
	@BeforeClass
	public void searchSetup()
	{
		ap = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	@Test(dataProvider= "productdata", dataProviderClass =ProductDataProvider.class)
	public void productResultsCountVerification(Product product)
	{
//		resPage = ap.doSearch("MacBook");
//		resPage = ap.doSearch(searchKey);
		resPage = ap.doSearch(product.getSearchKey());
		int productCount = resPage.getProductResultsCount();
		System.out.println("Total product result count is:  " + productCount);
		Assert.assertTrue(productCount>0);
	}
	
	
	
	
	@Test(dataProvider = "productdata", dataProviderClass = ProductDataProvider.class)
	public void selectProductVerification(Product product) throws InterruptedException
	{
//		resPage = ap.doSearch("MacBook");
//		resPage = ap.doSearch(searchKey);
		resPage = ap.doSearch(product.getSearchKey());
		Thread.sleep(10000);
//		productinfPage = resPage.selectProduct("MacBook Pro");
		productinfPage = resPage.selectProduct(product.getProductName());
		Thread.sleep(10000);
		String actProductHeaderName = productinfPage.getProductHeaderName();
		Assert.assertEquals(actProductHeaderName, product.getProductName());
	}
	

	
	@Test(dataProvider = "productdata", dataProviderClass = ProductDataProvider.class)
	public void productImagesCountTest(Product product) throws InterruptedException
	{
		resPage = ap.doSearch(product.getSearchKey());
		Thread.sleep(10000);
		productinfPage = resPage.selectProduct(product.getProductName());
		Thread.sleep(10000);
		int actProductImgCount = productinfPage.getProductImagesCount();
		Assert.assertEquals(actProductImgCount, product.getProductImages());
	}
}
