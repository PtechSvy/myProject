/**
 * 
 */
package testScenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectRepository.checkout;
import objectRepository.loginPage;
import objectRepository.mobileSrchPage;
import utility.LaunchBrowser;
import utility.ReadDataFromExcel;

import java.util.Map;

/**
 * @author PIYALI PODDER
 *
 */
public class Problem2 extends LaunchBrowser{
    
	public WebDriver driver;
	public Map<String,String> testData;
	public ReadDataFromExcel ExcelReader;
	
	
	
	@BeforeClass
	public void before()
	{
		try
		{
			testData = ExcelReader.getTestDatainMap(".\\src\\test\\resources\\MobileData.xlsx", "Sheet2", "TC_01");
			
		}catch(Exception e)
		{
			System.out.println("Test Data Sheet Not Found");
			
		}
	}
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver = initializeDriver();
	}

	@Test(priority=1)
	public void Login() throws IOException, InterruptedException 
	{
		
		loginPage p = PageFactory.initElements(driver, loginPage.class);
		p.loginFlipKart();
		
	}
	
	@Test(priority=2)
	public void loginandVerify()
	{
		loginPage d = PageFactory.initElements(driver, loginPage.class);
		d.verifyLogin();
	}
	
	@Test(priority=3)
		public void iPhone()
		{
		mobileSrchPage d = PageFactory.initElements(driver, mobileSrchPage.class);
		d.searchIPhone();
	
		}
	@Test(priority=4)
	public void seliPhone()
	{
	mobileSrchPage o = PageFactory.initElements(driver, mobileSrchPage.class);
	o.selectph();
	}
	
	@Test(priority=5)
	public void addProduct() throws InterruptedException
	{
		mobileSrchPage t = PageFactory.initElements(driver, mobileSrchPage.class);
		t.addAddress();
	}
	
	@Test(priority=6)
	public void product_checkout() throws InterruptedException
	{
		checkout n = PageFactory.initElements(driver, checkout.class);
		n.confirm();
		n.newAddress();
		n.addAddress(testData);
		n.verifyPage();
		driver.quit();
	}
}
