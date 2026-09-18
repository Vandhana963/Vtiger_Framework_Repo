package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest 
{
	@Test
	public void homePageTest(Method mtd)
	{
		
		System.out.println(mtd.getName() +"Test start");
		String expectedTitle="Home";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://49.249.29.4:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
//		if(actTitle.trim().equals(expectedTitle))
//			System.out.println(expectedTitle +"page is verified ===pass");
//		else
//			System.out.println(expectedTitle +"page is not verified ===fail");
		
		//HardAssert
		Assert.assertEquals(actTitle, expectedTitle);
		
		System.out.println(mtd.getName() +"Test end");
		driver.close();
	}
	@Test
	public void verifyLogoHomePageTest(Method mtd)
	{
		System.out.println(mtd.getName() +"Test start");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://49.249.29.4:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		
//		if(status)
//			System.out.println("logo is verified ===pass");
//		else
//			System.out.println("logo is not verified ===fail");
//		
		//HardAssert
		Assert.assertTrue(status);
		System.out.println(mtd.getName() +"Test end");
		driver.close();
	}

}
