package utility;

import java.util.Map;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
/*Created by Piyali Podder*/
public class WriteIntoExcel {

	public void writeOutputExcel(String OutputExcelPath,String productnm ,int productprice) throws FilloException
	{
		Fillo fillo = new Fillo();
		Connection connection=fillo.getConnection(OutputExcelPath);
		String strQuery= null;
		strQuery = String.format("INSERT INTO Sheet1(Name,Price) VALUES('%s','%s')",productnm,productprice);
		connection.executeUpdate(strQuery);
		 
		connection.close();
		
		
		
		
				
	}
}
