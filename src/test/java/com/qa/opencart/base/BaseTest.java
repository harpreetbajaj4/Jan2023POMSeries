package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {

	WebDriver driver;
	protected LoginPage lp;
	protected AccountsPage ap;	
	protected ResultsPage resPage;
	protected ProductInfoPage productinfPage;
	protected DriverFactory df;
	protected Properties prop;
	protected SoftAssert softAssert;
	protected RegisterPage regPage;

	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserName) {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		df = new DriverFactory();
		prop = df.initProp();
		if(browserName!=null) {
		prop.setProperty("browser", browserName); //it will update the browsername in config at the runtime.
		}
		driver = df.initDriver(prop);
		
		lp = new LoginPage(driver);
		softAssert = new SoftAssert();

	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
