package Testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class TestngAnnotations 

{
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before suite block");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before class block");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before method block");
	}
	@Test
	public void createContactTest1()
	{
		System.out.println("contact created test1");
	}
	@Test
	public void createContactTest()
	{
		System.out.println("contact created test");
	}
	
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("After method block");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After class block");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After suite block");
	}
	

}
