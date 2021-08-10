package testScenarios;

/**
 * @author PIYALI PODDER
 *
 */
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

import objectRepository.loginPage;
import objectRepository.mobileSrchPage;
import utility.LaunchBrowser;

/*Created by Piyali Podder*/
public class Problem1 extends LaunchBrowser{

	public WebDriver driver;
	
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
		public void searchMobile()
		{
		//Search for ‘Mobile Phone’ on the ‘flipkart.com’ homepage
		mobileSrchPage k = PageFactory.initElements(driver, mobileSrchPage.class);
		k.SearchAllMobiles();
		
	}
	
	@Test(priority=4)
	public void fetchallMobileData() throws FilloException
	{
		/*Fetch all the mobile phones listed in the product listing page along with their prices and
output them to an excel file and store them inside folder ‘testresult’ in ‘src/test/resources’*/
		mobileSrchPage l = PageFactory.initElements(driver, mobileSrchPage.class);
		l.fetchMobileData();
	}
}
