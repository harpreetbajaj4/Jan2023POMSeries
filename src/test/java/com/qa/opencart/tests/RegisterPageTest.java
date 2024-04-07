package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void registerSetUp() {
		regPage = lp.navigateToRegisterPage();

	}

	private String randomEmailGenerator() {

		return "testAutomation"+System.currentTimeMillis()+"@xyz.com";
		
	}
	
	@DataProvider(name = "registerTestdata")
	public Object[][] getRegistrationTestData()
	{
		return new Object[][] {
			{"Anjali","Sharma","8900789007","ajalisharma@123","yes"},
			{"Rekha","Sharma","8900899007","rekhasharma@123","no"},
			{"vipul","Bajaj","8678000907","vipul@123","yes"}
		};
	}

	@Test(dataProvider="registerTestdata")
	public void registerUserTest(String firstName, String lastName, String telephone, String password,
			String subscription)
	{
	String expMessgae = "Your Account Has Been Created!";
	String actMessgae = regPage.registeUser(firstName, lastName, randomEmailGenerator(), telephone, password, subscription);
	
	Assert.assertEquals(actMessgae, expMessgae);
	}

}
