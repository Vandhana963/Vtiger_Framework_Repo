package Testng;

import org.testng.annotations.Test;

public class TestngAnnotationEna 
{
	
	@Test(enabled=false)
	public void createContactTest()
	{
		System.out.println("contact created test");
	}
	@Test(priority=-1)
	public void createContactTest1()
	{
		System.out.println("contact created test1");
	}

}
