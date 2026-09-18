package practice.hometest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class InvoiceTest1 extends BaseClass
{
	@Test(retryAnalyzer = com.comcast.crm.ListenerUtility.RetryListenerImp.class)
	public void activateSim()
	{
		System.out.println("Execute Invoice Test");
		Assert.assertEquals("", "login");
		System.out.println("Step-1");
		System.out.println("Step-2");
	}

}
