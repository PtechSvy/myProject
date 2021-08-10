package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties prop;
	private final String propertyFilePath = ".//src//test//java//utility//config.properties";
	
	public ConfigFileReader(){
		 BufferedReader reader;
		 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 prop = new Properties();
		 try {
		 prop.load(reader);
		 reader.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		 } 
		 }
	public String getbrowsername(){
		 String browsernm = prop.getProperty("browser");
		 if(browsernm!= null) return browsernm;
		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
		 }
	public String getApplicationUrl() {
		 String url = prop.getProperty("url");
		 if(url != null) return url;
		 else throw new RuntimeException("url not specified in the Configuration.properties file.");
		 }
	public String enterDetails()
	{
		String mblno = prop.getProperty("mobile");
		if(mblno!=null) return mblno;
		else throw new RuntimeException("MobileNumber not specified in the Configuration.properties file.");
	}
	public String passwordDetails()
	{
		String pswd = prop.getProperty("password");
		if(pswd!=null) return pswd;
		else throw new RuntimeException("User Password not specified in the Configuration.properties file.");
	}
}
