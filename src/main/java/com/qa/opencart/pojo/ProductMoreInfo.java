package com.qa.opencart.pojo;

public class ProductMoreInfo {

	private String searchKey;
	private String productName;
	private int productImages;
	private String productBrandName;
	private String productCode;
	private String productExtTaxPrice;
	private String productAvailabilty;
	private String productPrice;
	private String productRewardPoints;
	

	public ProductMoreInfo(String searchKey, String productName, int productImages, String productBrandName,
			String productCode, String productExtTaxPrice, String productAvailabilty, String productPrice,
			String productRewardPoints) {
		super();
		this.searchKey = searchKey;
		this.productName = productName;
		this.productImages = productImages;
		this.productBrandName = productBrandName;
		this.productCode = productCode;
		this.productExtTaxPrice = productExtTaxPrice;
		this.productAvailabilty = productAvailabilty;
		this.productPrice = productPrice;
		this.productRewardPoints = productRewardPoints;
	}

//	public ProductMoreInfo(String searcKey, String productName, int productImages) {
//		this.searchKey = searcKey;
//		this.productName = productName;
//		this.productImages = productImages;
//	}

	public String getSearchKey() {
		return searchKey;
	}

	public String getProductBrandName() {
		return productBrandName;
	}

	public void setProductBrandName(String productBrandName) {
		this.productBrandName = productBrandName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductExtTaxPrice() {
		return productExtTaxPrice;
	}

	public void setProductExtTaxPrice(String productExtTaxPrice) {
		this.productExtTaxPrice = productExtTaxPrice;
	}

	public String getProductAvailabilty() {
		return productAvailabilty;
	}

	public void setProductAvailabilty(String productAvailabilty) {
		this.productAvailabilty = productAvailabilty;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductRewardPoints() {
		return productRewardPoints;
	}

	public void setProductRewardPoints(String productRewardPoints) {
		this.productRewardPoints = productRewardPoints;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductImages() {
		return productImages;
	}
	
	public void setProductImages(int productImages)
	{
		this.productImages = productImages;
	}

	@Override
	public String toString() {
		return "ProductMoreInfo [searchKey=" + searchKey + ", productName=" + productName + ", productImages="
				+ productImages + ", productBrandName=" + productBrandName + ", productCode=" + productCode
				+ ", productExtTaxPrice=" + productExtTaxPrice + ", productAvailabilty=" + productAvailabilty
				+ ", productPrice=" + productPrice + ", productRewardPoints=" + productRewardPoints + "]";
	}
	
	
}
