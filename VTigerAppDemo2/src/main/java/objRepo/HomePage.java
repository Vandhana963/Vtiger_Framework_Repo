package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationslink;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactslink;
	
	@FindBy(xpath="//a[text()='Calendar']")
	private WebElement calenderlink;
	
   @FindBy(xpath="//a[text()='Opportunities']")
   private WebElement opportunitieslink;
   
   @FindBy(xpath="//a[text()='Products']")
   private WebElement productslink;
   
   @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
   private WebElement adminimg;
   
   @FindBy(linkText = "Sign Out")
  private  WebElement signoutbtn;
   
   public WebElement getOrganizationslink() {
	return organizationslink;
   }

   public WebElement getAdminimg() {
	return adminimg;
}

   public WebElement getSignoutbtn() {
	return signoutbtn;
   }

   public WebElement getOpportunitieslink() {
	return opportunitieslink;
   }


   public WebElement getProductslink() {
	return productslink;
   }


   public WebElement getContactslink() {
	return contactslink;
   }
   
   public void logout() throws Exception
   {
	   Actions a=new Actions(driver);
	   a.moveToElement(adminimg).perform();
	   Thread.sleep(4000);
	   signoutbtn.click();
	   
   }
   
   
   

}
