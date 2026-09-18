package practice.OrgTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.WebdriverUtility;
import objRepo.CreatingNewOrganizationPage;
import objRepo.HomePage;
import objRepo.LoginPage;
import objRepo.OrganizationsInfoPage;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void CreateOrganization() throws Exception {
		// click on organizations in homepage
		HomePage hp = new HomePage(driver);
		hp.getOrganizationslink().click();

		// click on create organizations img
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

	@Test
	public void CreateOrganizationWithIndustry() throws Exception {
		// click on organizations in homepage
		HomePage hp = new HomePage(driver);
		hp.getOrganizationslink().click();

		// click on create organizations img
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
	
	@Test
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
	
	


