package com.generic.crm.baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import genericUtility.DatabaseUtility;

public class BaseClassUtil 
{
	@BeforeSuite
	public void configBS()
	{
		System.out.println("BS----");
		System.out.println("===Connect to DB,Roeport config===");
		
	}
	
	@BeforeClass
	public void configBC()
	{
		System.out.println("====launch the browser====");
	}
	
	@BeforeMethod
	public void configBM()
	{
		System.out.println("====login to applocation===");
	}
	
	
	
	@AfterMethod
	public void configAM()
	{
		System.out.println("===logout===");
	}
	
	@AfterClass
	public void configAC()
	{
		System.out.println("===close the browser====");
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("AS");
		System.out.println("=====CloseDb,ReportBackup===");
	}
	

}
