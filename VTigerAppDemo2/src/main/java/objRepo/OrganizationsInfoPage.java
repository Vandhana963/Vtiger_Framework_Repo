package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage 
{
	WebDriver driver;
	public OrganizationsInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgtitleinfo;
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement delbtn;
	
	public WebElement getOrgtitleinfo() {
		return orgtitleinfo;
	}

	public WebElement getDelbtn() {
		return delbtn;
	}
	
	
}
