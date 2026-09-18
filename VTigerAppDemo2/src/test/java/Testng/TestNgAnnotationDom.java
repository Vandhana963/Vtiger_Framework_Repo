package Testng;

import org.testng.annotations.Test;

public class TestNgAnnotationDom 
{
	@Test(enabled = true, priority = 1)
	public void createContactTest()
	{
		System.out.println("contact created test");
	}
	@Test(dependsOnMethods ="createContactTest" ,priority = 2)
	public void createContactTest1()
	{
		System.out.println("contact created test1");
	}

}
