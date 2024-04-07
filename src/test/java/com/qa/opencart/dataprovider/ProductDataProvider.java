package com.qa.opencart.dataprovider;

import org.testng.annotations.DataProvider;

import com.qa.opencart.pojo.Product;
import com.qa.opencart.pojo.ProductMoreInfo;

public class ProductDataProvider {
	
	//DataProviders Using POJO class
	
	@DataProvider(name="productDataInfo")
	public Object[][] getProductDataInfo()
	{
		return new Object[][] {
			{new ProductMoreInfo("Macbook", "MacBook Pro", 4, "Apple", "Product 18", "$2,000.00", "In Stock",
					"$2,000.00", "800")},
			{new ProductMoreInfo("iMac", "iMac", 3, "Apple", "Product 14", "$100.00", "Out Of Stock",
					"$122.00", null)}
		};
	}
	
	@DataProvider(name="productdata")
	public Object[][] getProductDetails()
	{
		return new Object[][] {
			{new Product("MacBook","MacBook Pro",4)},
			{new Product("iMac","iMac",3)},
			{new Product("Samsung","Samsung SyncMaster 941BW",1)}
		};
	}

	
	//Individual DataProviders
	
	@DataProvider(name = "productDataWithSearchKey")
	public Object[][] getProductSearchKey()
	{
		return new Object[][] {{"Macbook"},
				{"iMac"},
				{"Samsung"}};
	}
	
	

	@DataProvider(name = "productDataWithName")
	public Object[][] getProductData()
	{
		return new Object[][] {{"MacBook","MacBook Pro"},
			{"iMac", "iMac"},
			{"Samsung", "Samsung SyncMaster 941BW"}			
		};
	}
	
	
	@DataProvider(name = "productDataWithImages")
	public Object[][] getProductIamgesTestData()
	{
		return new Object[][] {
			{"MacBook","MacBook Pro",4},
			{"iMac","iMac",3},
			{"Samsung","Samsung SyncMaster 941BW",1}
		};
	}
	
}
