package practice.hometest;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest 
{
	@Test
	public void homePageTest(Method mtd)
	{
		
		Reporter.log(mtd.getName() +"  Test start  ");
		SoftAssert sa=new SoftAssert(); 
		Reporter.log("step-1");
		Reporter.log("step-2");
		sa.assertEquals("Home", "Homepage");
		Reporter.log("step-3");
		sa.assertEquals("Home-CRM", "Home-CRM");
		Reporter.log("step-4");
		sa.assertAll();
		Reporter.log(mtd.getName() +"  Test end  ");
		
	}
	@Test
	public void verifyLogoHomePageTest(Method mtd)
	{
		Reporter.log(mtd.getName() +"  Test start  ");
		Reporter.log("step-1");
		Reporter.log("step-2");
		Assert.assertTrue(true);
		Reporter.log("step-3");
		Reporter.log("step-4");
		Reporter.log(mtd.getName() +"  Test end  ");
		

}
}
