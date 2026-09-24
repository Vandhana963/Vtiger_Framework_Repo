package objRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.JavaUtility;
import genericUtility.WebdriverUtility;

public class CreatingNewContactPage 
{
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='lastname' and @class='detailedViewTextBox']")
	private WebElement lastnametxt;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img[@title='Select']")
	private WebElement OrgNamebtn;
	
	@FindBy(id="search_txt")
	private WebElement Seachtxt;
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchnowwbtn;
	
	@FindBy(xpath="//input[@name='support_start_date']")
	private WebElement startsuppdate;
	
	@FindBy(xpath="//input[@name='support_end_date']")
	private WebElement endsupportdate;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public WebElement getLastnametxt() {
		return lastnametxt;
	}

	public WebElement getOrgNamebtn() {
		return OrgNamebtn;
	}
	

	public WebElement getStartsuppdate() {
		return startsuppdate;
	}

	public WebElement getEndsupportdate() {
		return endsupportdate;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}

	public void setSavebtn(WebElement savebtn) {
		this.savebtn = savebtn;
	}

	public void createContact(String Lastname)
	{
		
		lastnametxt.sendKeys(Lastname);
		savebtn.click();
	}
	public void createContact(WebDriver driver,String Lastname,String OrgName,String targetUrl) throws InterruptedException
	{
		
		lastnametxt.sendKeys(Lastname);
		OrgNamebtn.click();
		WebdriverUtility wb=new WebdriverUtility();
		wb.handlingWindows(driver, targetUrl);
		Thread.sleep(5000);
		Seachtxt.sendKeys(OrgName);
		searchnowwbtn.click();
		
		
	}
	
	

}
