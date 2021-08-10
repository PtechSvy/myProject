package objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.ConfigFileReader;
import utility.LaunchBrowser;
/*Created by Piyali Podder*/
public class loginPage {

	private WebDriver driver;
	public ConfigFileReader m =new ConfigFileReader();
	public WebDriverWait d;
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(how=How.XPATH,using="//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	WebElement mobile;
	
	@FindBy(how=How.XPATH,using="//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")
	WebElement pswd;
	
	@FindBy(how=How.XPATH,using="//div[@class='_1D1L_j']/button")
	WebElement contn;
	
	//@FindBy(how=How.XPATH,using="//*[text()='My Account']")
	@FindBy(how=How.XPATH,using="//*[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")
	WebElement vrfyAccount;
	

	
	public void loginFlipKart() throws InterruptedException, IOException
	{
		  
		   String urlnm = m.getApplicationUrl();
		      driver.get(urlnm);
		//mobile.click();
		String mobileNumber = m.enterDetails();
		mobile.sendKeys(mobileNumber);
		Thread.sleep(2000);
		String pasword = m.passwordDetails();
		pswd.sendKeys(pasword);
		d = new WebDriverWait(driver,30);
		d.until(ExpectedConditions.elementToBeClickable(contn));
		contn.click();
		
	
	}
	
	public void verifyLogin()
	{
		String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String accounttitle = driver.getTitle();
		System.out.println(accounttitle);
		//Validate if Login is Successful
		Assert.assertEquals(accounttitle, expectedTitle);
	}
	
	
	
}
