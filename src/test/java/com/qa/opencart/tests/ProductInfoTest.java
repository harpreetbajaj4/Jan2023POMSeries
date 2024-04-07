package com.qa.opencart.tests;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataprovider.ProductDataProvider;
import com.qa.opencart.pojo.ProductMoreInfo;

public class ProductInfoTest extends BaseTest {

	
	@BeforeClass
	public void productInfoSetup()
	{
		ap = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@Test(dataProvider="productDataInfo", dataProviderClass = ProductDataProvider.class)
	public void productInfoVerification(ProductMoreInfo productMoreInfo)
	{
//		resPage= ap.doSearch("Macbook");
//		productinfPage = resPage.selectProduct("MacBook Pro");
//		Map<String,String> productInfo =  productinfPage.getProductInfo();
//		System.out.println(productInfo);
		//HashMap: doesn't maintain order in which we store the data
		//{Brand=Apple, Availability=In Stock, Ex Tax=$2,000.00, Product Code=Product 18, 
		//productname=MacBook Pro, Reward Points=800, productprice=$2,000.00}
		
		//LinkedHashMap:maints the order, the order in which we store the data
		//{Brand=Apple, Product Code=Product 18, Reward Points=800, Availability=In Stock, 
		//productprice=$2,000.00, Ex Tax=$2,000.00, productname=MacBook Pro}
		
		//TreeMap: stores data in sorted manner, it will sort first uppercase keys then lower case keys and then numeric keys
		//{Availability=In Stock, Brand=Apple, Ex Tax=$2,000.00, Product Code=Product 18,
		//Reward Points=800, productname=MacBook Pro, productprice=$2,000.00}
		
//		softAssert.assertEquals(productInfo.get("Brand"), "Apple11");
//		softAssert.assertEquals(productInfo.get("Ex Tax"), "$2,000.00");
//		softAssert.assertEquals(productInfo.get("productname"), "MacBook Pro");
//		softAssert.assertEquals(productInfo.get("Product Code"), "Product 188");
		
		resPage= ap.doSearch(productMoreInfo.getSearchKey());
		productinfPage = resPage.selectProduct(productMoreInfo.getProductName());
		Map<String,String> productInfo =  productinfPage.getProductInfo();
		System.out.println(productInfo);
		
		softAssert.assertEquals(productInfo.get("Brand"), productMoreInfo.getProductBrandName());
		softAssert.assertEquals(productInfo.get("Ex Tax"), productMoreInfo.getProductExtTaxPrice());
		softAssert.assertEquals(productInfo.get("productname"), productMoreInfo.getProductName());
		softAssert.assertEquals(productInfo.get("Product Code"), productMoreInfo.getProductCode());
		softAssert.assertEquals(productInfo.get("Availability"), productMoreInfo.getProductAvailabilty());
		softAssert.assertEquals(productInfo.get("Reward Points"), productMoreInfo.getProductRewardPoints());
		
		softAssert.assertAll();
		
		
		
		
		
	}
}
