package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import objRepo.ContactPage;
import objRepo.CreatingNewContactPage;
import objRepo.CreatingNewOrganizationPage;
import objRepo.HomePage;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImpClass.class)
public class CreateConTest extends BaseClass {
	
	@Test(groups = "SmokeTest")
	public void createContactTest() throws Exception {
		// homepage and create contact
		HomePage hp = new HomePage(driver);
		hp.getContactslink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();

		// creating new contact
		CreatingNewContactPage cc = new CreatingNewContactPage(driver);

		int num = ju.genRandomNumber();
		String SheetName = "Contact";
		String lastName = eu.readDataFromExcel(SheetName, 1, 3) + num;
		cc.createContact(lastName);
		
		
		//verify header
		
//		String actHeader=driver.findElement(By.className("dvHeadertext")).getText();
//		boolean status=actHeader.contains(lastName);
//		Assert.assertEquals(status, true);
		
		
//		if(actHeader.equals(lastName))
//			System.out.println(lastName +"Header is verified==pass");
//		else
//			System.out.println(lastName +"Header is not verified==fail");
		
		// verify phnenumber
		
		String actuallastname = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actuallastname, lastName);
		
//		if (actuallastname.equals(lastName)) {
//			System.out.println(lastName + "info is verified==pass");
//		} else
//			System.out.println(lastName + "info is not verified==fail");
	}

	@Test(groups = "RegressionTest")
	public void createContactWithsupportDate() throws Exception {
		// create contact
		HomePage hp = new HomePage(driver);
		hp.getContactslink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();

		// creating new contact
		int num = ju.genRandomNumber();
		CreatingNewContactPage cc = new CreatingNewContactPage(driver);
		String SheetName = "Contact";
		String lastName = eu.readDataFromExcel(SheetName, 1, 3) + num;

		String suppstartdate = ju.currentDate();
		String suppenddate = ju.getRequiredDate(30);
		System.out.println(suppstartdate);
		System.out.println(suppenddate);
		cc.getLastnametxt().clear();
		cc.getLastnametxt().sendKeys(lastName);
		cc.getStartsuppdate().clear();
		cc.getStartsuppdate().sendKeys(suppstartdate);
		cc.getEndsupportdate().clear();
		cc.getEndsupportdate().sendKeys(suppenddate);

		cc.getSavebtn().click();
		// verify suppstartdate
		String actsuppstartdate = driver.findElement(By.xpath("//span[@id='dtlview_Support Start Date']")).getText();
		System.out.println(actsuppstartdate + "info about actual date");
		if (actsuppstartdate.equals(suppstartdate))
			System.out.println(suppstartdate + "info verified pass");
		else
			System.out.println(suppstartdate + "info not verified fail");

		// verify suppenddate
		String actsuppenddate = driver.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();
		System.out.println(actsuppenddate + "info about actual end date");
		if (actsuppenddate.trim().equals(suppenddate))
			System.out.println(suppenddate + "info verified pass");
		else
			System.out.println(suppenddate + "info verified fail");

	}

	@Test(groups = "RegressionTest")
	public void createContactWithOrgTest() throws Exception {

		// create org
		// click on create organizations img
		HomePage hp = new HomePage(driver);
		hp.getOrganizationslink().click();
		CreatingNewOrganizationPage co = new CreatingNewOrganizationPage(driver);
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		int num = ju.genRandomNumber();
		String orgname = eu.readDataFromExcel("Organizations", 1, 2) + num;

		co.createorg(orgname);
		Thread.sleep(1000);

		hp.getContactslink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();

		// creating new contact
		CreatingNewContactPage cc = new CreatingNewContactPage(driver);

		String SheetName = "Contact";
		String lastName = eu.readDataFromExcel(SheetName, 1, 3) + num;

		String targetUrl = "module=Accounts";

		cc.createContact(driver, lastName, orgname, targetUrl);
		WebElement ele = driver.findElement(By.xpath("//a[text()='" + orgname + "']"));
		ele.click();
		driver.switchTo().window(parent);

		Thread.sleep(3000);
		cc.getSavebtn().click();

		// verify act orgname
		String actorgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(orgname);
		if (actorgname.trim().equals(orgname))
			System.out.println(orgname + "info is verified===passed");
		else
			System.out.println(orgname + "info is not verified====failed");

	}
}
