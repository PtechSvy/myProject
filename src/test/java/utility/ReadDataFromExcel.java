/**
 * 
 */
package utility;

import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

/**
 * @author PIYALI PODDER
 *
 */
public class ReadDataFromExcel {
	
	public static Map<String,String> getTestDatainMap(String testDataFile,String SheetName ,String testName) throws Exception
	{
		Map<String,String> TestData = new TreeMap<String,String>();
		String query = null;
		query = String.format("Select * from %s where TestSl='%s'", SheetName,testName);
		Fillo fillo = new Fillo();
		Connection conn = null;
		Recordset recordset = null;
		try
		{
			conn=fillo.getConnection(testDataFile);
			recordset = conn.executeQuery(query);
			while(recordset.next())
			{
				for(String field:recordset.getFieldNames()){
					TestData.put(field, recordset.getField(field));
				}
			}
		}catch(FilloException e){
			e.printStackTrace();
			throw new Exception("Test Data cannot find..");
		}
		conn.close();
		return TestData;
		
	}

}
