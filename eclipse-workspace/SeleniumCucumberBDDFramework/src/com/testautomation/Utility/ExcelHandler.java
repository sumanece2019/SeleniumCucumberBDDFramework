package com.testautomation.Utility;

import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelHandler {

	//https://codoid.com/fillo/
	//Fillo is an Excel API for Java and you can query xls & xlsx files. 
	//Now, it supports SELECT, UPDATE & INSERT queries with or without WHERE clause.
	
	public static Map<String,String> getTestDataInMap(String testDataFile,String sheetName,String testCaseId) throws Exception
	{
		//System.out.println("testDataFile:"+testDataFile);
		//System.out.println("sheetName:"+sheetName);
		//System.out.println("testCaseId:"+testCaseId);
		Map<String,String> TestDataInMap=new TreeMap<String,String>();		
		String query=null;
		query=String.format("SELECT * FROM %s WHERE Run='Yes' and TestCaseId='%s'",sheetName,testCaseId);
		
		System.out.println("query:"+query);
		
		Fillo fillo=new Fillo();
		Connection conn=null;
		Recordset recordset=null;
		try
		{
			conn=fillo.getConnection(testDataFile);
			recordset=conn.executeQuery(query);
			//recordset=((com.codoid.products.fillo.Connection) conn).executeQuery(query);
			
			//System.out.println("recordset:"+recordset);
			
			while(recordset.next())
			{
				for(String field:recordset.getFieldNames())
				{
					TestDataInMap.put(field, recordset.getField(field));
				}
			}
		}
		catch(FilloException e)
		{
			e.printStackTrace();
			throw new Exception("Test data cannot find . . .");			
		}
		conn.close();
		return TestDataInMap;		
	}
}
