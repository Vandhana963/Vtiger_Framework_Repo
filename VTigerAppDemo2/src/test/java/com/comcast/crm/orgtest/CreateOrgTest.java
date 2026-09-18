package com.comcast.crm.orgtest;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.comcast.crm.ListenerUtility.ListenerImpClass;
import com.comcast.crm.basetest.BaseClass;

import genericUtility.UtilityClassObject;
import objRepo.CreatingNewOrganizationPage;
import objRepo.HomePage;
import objRepo.OrganizationsInfoPage;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImpClass.class)
public class CreateOrgTest extends BaseClass
{
	
	@Test(groups = "SmokeTest")
	public void CreateOrganization() throws Exception {
		
		
		// click on organizations in homepage
		UtilityClassObject.getTest().log(Status.INFO,"navigate to homepage");
		HomePage hp = new HomePage(driver); 
		hp.getOrganizationslink().click();

		// click on create organizations img
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		CreatingNewOrganizationPage co = new CreatingNewOrganizationPage(driver);
		int num = ju.genRandomNumber();
		String orgname = eu.readDataFromExcel("Organizations", 1, 2) + num;

		co.createorg(orgname);

		// verify header name with actual orgname
		OrganizationsInfoPage oi = new OrganizationsInfoPage(driver);
		String actTitle = oi.getOrgtitleinfo().getText();
		System.out.println(actTitle);

		if (actTitle.contains(orgname))
			System.out.println(orgname + " ======test is passed");
		else
			System.out.println(orgname + "  ======test is failed");
	}

	@Test(groups = "RegressionTest")
	public void CreateOrganizationWithIndustry() throws Exception {
		// click on organizations in homepage
		UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationslink().click();

		// click on create organizations img
		UtilityClassObject.getTest().log(Status.INFO,"create new org page");
		CreatingNewOrganizationPage co = new CreatingNewOrganizationPage(driver);

		int num = ju.genRandomNumber();
		String orgName = eu.readDataFromExcel("Organizations", 1, 2) + num;
		String industryName = eu.readDataFromExcel("Organizations", 4, 3);
		co.createOrgWitInd(orgName, industryName);
		String actindustry=driver.findElement(By.id("dtlview_Industry")).getText();
		if(actindustry.trim().equals(industryName))
			System.out.println(industryName+ "info verified ====passed");
		else
			System.out.println(industryName +"info not verified===fail");
	}
	
	@Test(groups = "RegressionTest")
	public void CreateOrganizationWithPhonenumber() throws Exception 
	{
		//click on organizations in homepage
				HomePage hp=new HomePage(driver);
				hp.getOrganizationslink().click();
				
				//click on create organizations img
				CreatingNewOrganizationPage co=new CreatingNewOrganizationPage(driver);
				int num = ju.genRandomNumber();
				String SheetName="Organizations";
				String orgName=eu.readDataFromExcel(SheetName, 1, 2)+num;
				String industryName=eu.readDataFromExcel(SheetName, 4, 3);
				String phoneNumber=eu.readDataFromExcel(SheetName, 7, 4);
				co.createOrgWitPhne(orgName, industryName, phoneNumber);
				
				String actPhonenumber=driver.findElement(By.id("dtlview_Phone")).getText();
				if(actPhonenumber.trim().equals(phoneNumber))
					System.out.println(phoneNumber +"info verified===passed");
				else
					System.out.println(phoneNumber+"info not verified====failed");
	}
	
	
	

}
