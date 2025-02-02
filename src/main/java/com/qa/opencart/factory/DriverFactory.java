package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.frameworkexception.FrameException;

public class DriverFactory {

	WebDriver driver;
	OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop) {

		optionsManager = new OptionsManager(prop);

		String browserName = prop.getProperty("browser").trim();
		System.out.println("browser name is : " + browserName);

		switch (browserName.toLowerCase()) {
		case "chrome":
//			driver = new ChromeDriver();
//			driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			break;

		case "edge":
//			driver = new EdgeDriver();
//			driver = new EdgeDriver(optionsManager.getEdgeOptions());
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			break;

		case "safari":
//			driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
			break;

		case "firefox":
//			driver = new FirefoxDriver();
//			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;

		default:
			System.out.println("Please provide correct browser");
			throw new FrameException("NoBrowserFoundException");
//			break;
		}

//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//		driver.get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));


		return getDriver();
	}
	
	public static WebDriver getDriver()
	{
		return tlDriver.get();
	}

	public Properties initProp() {
		Properties prop = new Properties();

		// mvn clean install -Denv="qa"
		String envName = System.getProperty("env");
		System.out.println("Env name is : " + envName);
		FileInputStream fis = null;
		try {
			if (envName == null) {
				System.out.println("no env is given...hence running it on QA env...");
				fis = new FileInputStream("./src/main/resources/config/qa.config.properties");
			} else {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					fis = new FileInputStream("./src/main/resources/config/qa.config.properties");
					break;

				case "dev":
					fis = new FileInputStream("./src/main/resources/config/dev.config.properties");
					break;

				case "uat":
					fis = new FileInputStream("./src/main/resources/config/uat.config.properties");
					break;

				case "stage":
					fis = new FileInputStream("./src/main/resources/config/stage.config.properties");
					break;

				default:
					System.out.println("Please pass the rigth env name: " + envName);
				}
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			FileInputStream fis = new FileInputStream("./src/main/resources/config/config.properties");
//			prop.load(fis);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		return prop;
	}
	
	public static String getScreenshot()
	{
		File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}
}
