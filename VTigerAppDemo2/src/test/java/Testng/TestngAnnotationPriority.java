package Testng;

import org.testng.annotations.Test;

public class TestngAnnotationPriority 
{
	@Test(priority=3)
	public void createContactTest()
	{
		System.out.println("contact created test");
	}
	@Test(priority=-1)
	public void createContactTest1()
	{
		System.out.println("contact created test1");
	}
	
	@Test(priority=0)
	public void createContactTest2()
	{
		System.out.println("contact created test2");
	}
	@Test(priority=2)
	public void createContactTest3()
	{
		System.out.println("contact created test3");
	}

}
