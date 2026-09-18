package practice.hometest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImpClass.class)
public class Invoicetest extends BaseClass
{
	@Test
	public void createInvoiceTest()
	{
		System.out.println("Execute create Invoice");
		String acttitle=driver.getTitle();
		Assert.assertEquals(acttitle, "login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
	}
	
	@Test
	public void CreateInvoiceWithContactTest()
	{
		System.out.println("Execute create Invoice wit contact test");
		System.out.println("Step-4");
		System.out.println("Step-5");
		System.out.println("Step-6");
	}
	

}
