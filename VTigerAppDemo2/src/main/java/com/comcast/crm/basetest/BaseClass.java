package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import genericUtility.DatabaseUtility;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.UtilityClassObject;
import genericUtility.WebdriverUtility;
import objRepo.HomePage;
import objRepo.LoginPage;

public class BaseClass {
	public DatabaseUtility db = new DatabaseUtility();
	public WebdriverUtility wu = new WebdriverUtility();
	public PropertyUtility pu = new PropertyUtility();
	public ExcelUtility eu = new ExcelUtility();
	public JavaUtility ju = new JavaUtility();
	public WebDriver driver;
	public String parent; 
	public static WebDriver sdriver;

	@BeforeSuite(groups = { "SmokeTest", "RegressionTest" })
	public void configBS() throws Exception {
    		System.out.println("BS----");
		System.out.println("===Connect to DB,Roeport config===");
		db.getDbConnection();

	}

	//@Parameters("BROWSER")
	@BeforeClass(groups = { "SmokeTest", "RegressionTest" })
	public void configBC() throws Exception {
		System.out.println("====launch the browser====");
		//String BROWSER=browser;
		String browser =System.getProperty("browser", pu.readDataFromPropertyFile("Browser"));
		driver = wu.launchBrowser(browser);
		wu.maximizeBrowser(driver);
		wu.implicitlyWaitMethod(driver);
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "SmokeTest", "RegressionTest" })
	public void configBM() throws Exception {
		System.out.println("====login to applocation===");
		String url = pu.readDataFromPropertyFile("Url");
		String un = pu.readDataFromPropertyFile("Username");
		String pwd = pu.readDataFromPropertyFile("Password");
		driver.get(url);
		parent = driver.getWindowHandle();
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pwd);
	}

	@AfterMethod(groups = { "SmokeTest", "RegressionTest" })
	public void configAM() throws Exception {
		System.out.println("===logout===");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "SmokeTest", "RegressionTest" })
	public void configAC() {
		System.out.println("===close the browser====");
		driver.quit();
	}

	@AfterSuite(groups = { "SmokeTest", "RegressionTest" })
	public void configAS() throws Exception {
		System.out.println("AS");
		System.out.println("=====CloseDb,ReportBackup===");
		db.closConnection();
		
	}

}
