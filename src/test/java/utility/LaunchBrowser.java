package utility;

import java.io.IOException;

import org.openqa.selenium.By;

//import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*Created by Piyali Podder*/
public class LaunchBrowser {

	public  WebDriver driver;
    public ConfigFileReader p;
	
    public WebDriver initializeDriver() throws IOException{
		
		p = new ConfigFileReader();
		String browserName = p.getbrowsername(); 
		if(browserName.equals("chrome"))
		{
	      System.setProperty("webdriver.chrome.driver",".\\browsers\\chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().deleteAllCookies();
	}
		else{
			System.out.println("Browser not found");
		}
		return driver;
	
	
}
}
