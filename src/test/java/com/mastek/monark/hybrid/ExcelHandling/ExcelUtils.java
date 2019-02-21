package com.mastek.monark.hybrid.ExcelHandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.mastek.monark.hybrid.Core.Paths;

public class ExcelUtils {
	
	Fillo fillo;
	Connection connection;
	int rowCount;
	int columnCount;
	
	Map<String, String> configurations = new HashMap<String, String>();
	
	public ExcelUtils() throws FilloException {
		
		fillo = new Fillo();
		
		connection = fillo.getConnection(Paths.config);
	}
	
	
	public String getConfigurationsData(String key) throws FilloException {
		
		return (getDataCore("Configurations", key));
		
	}
	
	
	public String getWebData(String key) throws FilloException {
		
		return (getDataCore("Web", key));
		
	}
	
	public String getMobileData(String key) throws FilloException {
		
		return (getDataCore("MobileAndroid", key));
		
	}
	
//	public List<String> getControlData(String key) throws FilloException {
//		
////		return (getDataControlSheet());
//		
//	}
	
	//to get data from config, web and mobile
	public String getDataCore(String sheetName, String key) throws FilloException {
		
		String query = "Select * from " + sheetName +" where Key= '"+key+"'";
		Recordset recordset = connection.executeQuery(query);
		
		String value=null;
		while(recordset.next()) {
			value = recordset.getField("Value").toString();
		}
		
		return value;
	}

	//to get all yes data from control sheet
	@SuppressWarnings("null")
	public List<String> getDataFromScenarioSheet(String key, String sheetName) throws FilloException {
		
		String query = "Select * from "+ sheetName + " where Flag='Yes'";
		Recordset recordset = connection.executeQuery(query);
		
		List<String> value = new ArrayList<String>();
		
		while(recordset.next()) {
			value.add(recordset.getField(key).trim());
		}
		
		return value;
	}
	

	public String getColumnDataFromScenarioSheet(String tcId, String columnName, String sheetName) throws FilloException {
		
		String query = "Select * from "+ sheetName + " where TC_ID=" + "'" + tcId + "'";
		Recordset recordset = connection.executeQuery(query);
		
		String value = null;
		while(recordset.next()) {
			value = recordset.getField(columnName).toString().trim();
		}
		
		return value;
	}
	

	
	public String getData(String TC_ID, String columnName) {
		
		
		
		return columnName;
		
	}
	

}
