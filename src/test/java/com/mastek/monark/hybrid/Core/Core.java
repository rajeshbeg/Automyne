

package com.mastek.monark.hybrid.Core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import com.mastek.monark.hybrid.ExcelHandling.ExcelHandling;

/*
 * 
 * Developer - Ravi Salunkhe
 * Project - Core Team
 * Date - 15 Oct 2018
 */

public class Core{
	
	@SuppressWarnings("unused")
	private static int flag = 0;
	Process pp, pp1;
	
	public List<XmlInclude> constructIncludes (String... methodNames) {
        List<XmlInclude> includes = new ArrayList<XmlInclude> ();
        for (String eachMethod : methodNames) {
            includes.add (new XmlInclude (eachMethod));
        }
        return includes;
    }


	@SuppressWarnings({ "deprecation", "unused", "rawtypes" })
	@Test     
    public void execute() throws Exception {
		
		
//		Version version = new Version();
	
		final File f1 = new File(Core.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		    
		File f = new File(f1+"/testNG.xml"); 	
		
		if(f.exists()) {
			
			f.delete();
		}	
		
		
		//calling out the excel datasheet instance to get all the "Y" data for setting up the testngxml
    	
    	ExcelHandling excel = new ExcelHandling();
    	
    	excel.excelReader(Paths.datasheet, "Control", Paths.resultsheet, "Control");
    	
    	List<HashMap<String, String>> scenarios = excel.getExcelData("Control");
    	
    	List<String> listenerClasses = new ArrayList<String>();
    	
    	listenerClasses.add("com.mastek.monark.hybrid.Reporting.ReportListener");
    	
    	listenerClasses.add("com.mastek.monark.hybrid.Reporting.AnnotationTransformer");
    	
         
        HashMap<String, String> each = new HashMap<String, String>();
        
		
    	for(int i=0;i<scenarios.size();i++) {
    		
    		if(!scenarios.get(i).isEmpty()) {
    		
	        	TestNG testNg = new TestNG();
	    		XmlSuite suite = new XmlSuite();
	    		XmlTest test = null;
	    		
	    		suite.setName(Constants.sprintDetails);
	         
	         	suite.setListeners(listenerClasses);
	         	
	   		 if(Constants.parallelExecution.equalsIgnoreCase("yes")) {
	           	
	   			suite.setParallel("tests");
	           	suite.setThreadCount(Integer.parseInt(Constants.threadCount));
	           	
	           }
	
	    	    each = scenarios.get(i);
	    		
	    		excel.getExcelDataAll(each.get("Scenario Name"), "Flag", "Yes", "TC_ID");
	    		
	    		@SuppressWarnings({ "static-access" })
	    		Map<String, HashMap> scenarioMap = excel.TestData;
	
	    		
	    		for(String key : scenarioMap.keySet()) {
	    			
	    			test = new XmlTest(suite);    			
	            	test.setName(key);            	
	    	        test.setPreserveOrder(true); 
	    	        
	    	        test.addParameter("browserType", ExcelHandling.Get_Data(key, "Browser Type"));
	    	        test.addParameter("tcID", key);
	    	        test.addParameter("appURL", Constants.appUrl); 
	    	        
	    	        int count = scenarioMap.get(key).size();
	    	        	    	        
	    	        //for columns
	    	       
	    	        Set keys = scenarioMap.get(key).keySet();
	    	        int d = 1;

	    	        for (Iterator j = keys.iterator(); j.hasNext();) {
	    	        	
	    	            String keyParam = (String) j.next();
	    	            if(d>5) {
	    	            	
	    	            	String valueParam = (String) scenarioMap.get(key).get(keyParam);
	    	            	
	    	            	test.addParameter(keyParam, valueParam); 

	    	            }
	    	            d++;
	    	            
	    	        }
	    	   
	    	        		    	        
	    	        XmlClass testClass = new XmlClass();
	        		testClass.setName("com.mastek.monark.hybrid.TestsWeb."+each.get("Scenario Name"));
	        		
	        		List<XmlInclude> methods = new ArrayList<XmlInclude>();
	        		
	        		methods.add(new XmlInclude(ExcelHandling.Get_Data(key, "Method")));
	        		
	        		testClass.setIncludedMethods(methods);
	    	        test.setXmlClasses(Arrays.asList(new XmlClass[] { testClass}));
	    	        
	    			
				}
	    		    		
		        List<String> suites = new ArrayList<String>();
		       
		        f.createNewFile();
		        
		        FileWriter fw = new FileWriter(f.getAbsoluteFile());
		        
		        BufferedWriter bw = new BufferedWriter(fw);
		        bw.write(suite.toXml());
		        
		        bw.close();
		        
		        suites.add(f.getPath());
		        
		        testNg.setTestSuites(suites);
		        
		        testNg.run();
		        
		        f.delete();
			
		        scenarioMap.clear();
	    		
	    	
    	  }
    	}
    			
    }

}