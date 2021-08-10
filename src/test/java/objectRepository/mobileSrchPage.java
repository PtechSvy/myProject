package objectRepository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;

import utility.ConfigFileReader;
import utility.WriteIntoExcel;
/*Created by Piyali Podder*/
public class mobileSrchPage {

	private WebDriver driver;
	public ConfigFileReader m =new ConfigFileReader();
	public JavascriptExecutor js;
	public Actions action;
	public String OutputExcelpath = ".//src//test//resources//MobileData.xlsx";
	public WriteIntoExcel e = new WriteIntoExcel();
	public Iterator<String> iterator;
	public WebDriverWait p;
	
	public mobileSrchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how=How.XPATH,using="//div[@class='CXW8mj']")
	WebElement mob;
	
	@FindBy(how=How.XPATH,using="//div[@id='container']/div/div/div/div[2]/div[2]/form/div/div/input")
	WebElement searchTab;
	
	@FindBy(how=How.XPATH,using="//div[@class='col col-7-12']/div[@class='_4rR01T']")
	List<WebElement> list_of_products;
	
	@FindBy(how=How.XPATH,using="//div[@class='col col-5-12 nlI3QM']/div/div/div[@class='_30jeq3 _1_WHN1']")
	List<WebElement> list_of_products_price;
	
	@FindBy(how=How.XPATH,using="//div[@class='_2kHMtA']/a/div[2]/div/div[@class='_4rR01T']")
	List<WebElement> list_of_iphone;
	
	@FindBy(how=How.XPATH,using="//div[@class='fMghEO']/ul/li[1]")
	List<WebElement> list_of_memory;
	
	@FindBy(how=How.XPATH,using="//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")
	WebElement iph;
	
	//@FindBy(how=How.XPATH,using="//*[text()='GO TO CART']")
	@FindBy(how=How.XPATH,using="//*[@id='container']/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
	WebElement addcart;
	
	@FindBy(how=How.XPATH,using="//div[@class='_26HdzL']/input")
	WebElement vrfyelmnt;
	
	@FindBy(how=How.XPATH,using="//*[text()='APPLE iPhone 12 (Blue, 128 GB)']")
	WebElement confirmationproduct;
	
	@FindBy(how=How.XPATH,using="//img[@class='xhPPpX']")
	WebElement drpdn;
	
	@FindBy(how=How.XPATH,using="//input[@class='cfnctZ']")
	WebElement addresscheck;
	
	@FindBy(how=How.XPATH,using="//span[text()='Check']")
	WebElement chck1;
	
	public void SearchAllMobiles()
	{
		 //action.moveToElement(mob).click().build().perform();
		searchTab.sendKeys("Mobile Phone");
		searchTab.sendKeys(Keys.ENTER);
	}
	
	public void fetchMobileData() throws FilloException
	
	{
		String product_name;
		String product_price;
		int product_prices;
		HashMap<String, Integer> map_final_products = new HashMap<String,Integer>();
		for(int i=0;i<list_of_products.size();i++) {
			product_name = list_of_products.get(i).getText();
			product_price = list_of_products_price.get(i).getText();
    		product_price = product_price.replaceAll("[^0-9]", "");
		    product_prices = Integer.parseInt(product_price);//Convert to Integer
		    e.writeOutputExcel(OutputExcelpath, product_name, product_prices);
		//	map_final_products.put(product_name, product_prices);
	}
		//System.out.println(map_final_products);
		//e.writeOutputExcel(OutputExcelpath, map_final_products);
	}
	
	public void searchIPhone()
	{
		//searchTab.sendKeys("iPhone 6s plus");
		searchTab.sendKeys("iphone 12");
		searchTab.sendKeys(Keys.ENTER);
	}
	
	public void selectIphone()
	{
		String iphone_type;
		int no_ofphone = list_of_products.size();
		System.out.println(no_ofphone);
		String phntobeSelected = "APPLE iPhone 12 (Blue, 128 GB)";
		for(int i = 0;i<no_ofphone;i++)
		{
			iphone_type = list_of_products.get(i).getText();
			System.out.println(iphone_type);
			if(iphone_type.contains(phntobeSelected))
			{
				
				list_of_products.get(i).click();
				
				
			}
			
		}
	}
//		String parentWindow = driver.getWindowHandle();
//		Set<String> allWindowhandle = driver.getWindowHandles();
//		Iterator<String> iterator = allWindowhandle.iterator();
//		  while (iterator.hasNext()) {
//	            String ChildWindow = iterator.next();
//	                if (!parentWindow.equalsIgnoreCase(ChildWindow)) {
//	                driver.switchTo().window(ChildWindow);
//	                System.out.println(driver.getTitle());
		
		
			
	//	}
		
		
		
	
	
	public void selectph()
	{
		
//		js = (JavascriptExecutor) driver;  
//		js.executeScript("arguments[0].click();", iph);
		WebDriverWait  wait = new WebDriverWait(driver,10);
		wait.until( ExpectedConditions.elementToBeClickable(iph));
		iph.click();
		String parentWindow = driver.getWindowHandle();
	//	action.moveToElement(iph).click().build().perform();
		Set<String> allWindowhandle = driver.getWindowHandles();
		Iterator<String> iterator = allWindowhandle.iterator();
		  while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!parentWindow.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                System.out.println(driver.getTitle());
	                p = new WebDriverWait(driver,10);
	        		p.until(ExpectedConditions.elementToBeClickable(addcart));
	        		addcart.click();
	        		String actualTitle = driver.getTitle();
	        		System.out.println(actualTitle);
	        		String cnfpro = confirmationproduct.getText();
	        		if(cnfpro.contains("APPLE iPhone 12 (Blue, 128 GB)"))
	        		{
	        			   System.out.println("Order Completed: Test Case Passed");
	        			  }
	        			  else {
	        			   System.out.println("Order Not Successfull: Test Case Failed");
	        			  }
	        		
	}
	                
	                
	
}
	}
	
	public void addAddress() throws InterruptedException
	{
		Thread.sleep(5000);
		drpdn.click();
		////new WebDriverWait(driver,10);
		//p.until(ExpectedConditions.elementToBeSelected(addresscheck));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		addresscheck.sendKeys("734001");
		chck1.click();
		
	}
}
	
