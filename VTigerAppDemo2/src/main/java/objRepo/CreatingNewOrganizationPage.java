package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage 
{
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorgbtn;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchforbtn;
	
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement searchinbtn;
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgnametxtbox;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industrytxt;
	
	@FindBy(id="phone")
	private WebElement phnenumtxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	
	
	public WebElement getCreateorgbtn() {
		return createorgbtn;
	}

	public WebElement getSearchforbtn() {
		return searchforbtn;
	}

	public WebElement getSearchinbtn() {
		return searchinbtn;
	}

	public WebElement getOrgnametxtbox() {
		return orgnametxtbox;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void createorg(String OrgName)
	{
		createorgbtn.click();
		orgnametxtbox.sendKeys(OrgName);
		savebtn.click();
	}
	public void createOrgWitInd(String OrgName,String Industry)
	{
		createorgbtn.click();
		orgnametxtbox.sendKeys(OrgName);
		Select s=new Select(industrytxt);
		s.selectByVisibleText(Industry);
		savebtn.click();
	}
	public void createOrgWitPhne(String OrgName,String Industry,String PhNumber)
	{
		createorgbtn.click();
		orgnametxtbox.sendKeys(OrgName);
		Select s=new Select(industrytxt);
		s.selectByVisibleText(Industry);
		phnenumtxt.sendKeys(PhNumber);
		savebtn.click();
	}
	
	

	
}
