/**
 * 
 */
package objectRepository;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ConfigFileReader;

/**
 * @author PIYALI PODDER
 *
 */
public class checkout {

	
	private WebDriver driver;
	public WebDriverWait p;
	public Select select;
	
	public checkout(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how=How.XPATH,using="//span[text()='Place Order']")
	WebElement sellchck;
	
	@FindBy(how=How.XPATH,using="//*[text()='Add a new address']")
	WebElement addAddress;
	

	@FindBy(how=How.XPATH,using="//input[@name='name']")
	WebElement custName;

	@FindBy(how=How.XPATH,using="//input[@name='phone']")
	WebElement custphn;
	
	@FindBy(how=How.XPATH,using="//input[@name='pincode']")
	WebElement custpin;
	
	@FindBy(how=How.XPATH,using="//input[@name='addressLine2']")
	WebElement add1;
	@FindBy(how=How.XPATH,using="//*[@name='addressLine1']")
	WebElement custAdd;
	@FindBy(how=How.XPATH,using="//input[@name='city']")
	WebElement custCity;
	@FindBy(how=How.XPATH,using="//select[@name='state']")
	WebElement custState;
	@FindBy(how=How.XPATH,using="//input[@name='locationTypeTag']")
	WebElement custhm;
	@FindBy(how=How.XPATH,using="//button[text()='Save and Deliver Here']")
	WebElement custSbmt;
	
	@FindBy(how=How.XPATH,using="//button[text()='CONTINUE']")
	WebElement sbmt;
	
	@FindBy(how=How.XPATH,using="//button[text()='Accept & Continue']")
	WebElement accptAlert;
	
	@FindBy(how=How.XPATH,using="//span[text()='Payment Options']")
	WebElement validatePaymentCheckout;
	
	
		
	public void confirm() throws InterruptedException
	{
		p = new WebDriverWait(driver,10);
		p.until(ExpectedConditions.elementToBeClickable(sellchck));
		sellchck.click();
		
	}
	
	public  void newAddress()
	{
		
		p = new WebDriverWait(driver,10);
		p.until(ExpectedConditions.elementToBeClickable(addAddress));
		addAddress.click();
	}
	
	public void addAddress(Map<String,String>testData) throws InterruptedException
	{
		Thread.sleep(5000);
		custName.sendKeys(testData.get("Name"));
		Thread.sleep(2000);
		custphn.sendKeys(testData.get("PhoneNumber"));
		Thread.sleep(2000);
		custpin.sendKeys(testData.get("PinCode"));
		Thread.sleep(2000);
		add1.sendKeys(testData.get("Locality"));
		Thread.sleep(2000);
		custAdd.sendKeys(testData.get("Address"));
//		custCity.sendKeys(testData.get("City"));
//		
//		Thread.sleep(5000);
//		select = new Select(custState);
//		select.selectByValue(testData.get("State"));
		Thread.sleep(5000);
		custhm.isSelected();
		Thread.sleep(5000);
		custSbmt.click();
		Thread.sleep(5000);
		sbmt.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		accptAlert.click();
		
	
	}
	
	public void verifyPage()
	{
		String paytext = validatePaymentCheckout.getText();
		if(paytext.contains("Payment Options"))
		{
			System.out.println("Test Pass");
		}
		else
		{
			System.out.println("Test Fail");
		}
	}
	
	
}
