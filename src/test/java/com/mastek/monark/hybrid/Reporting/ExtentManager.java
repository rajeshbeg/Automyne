package com.mastek.monark.hybrid.Reporting;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.mastek.monark.hybrid.Core.Paths;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	static DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
    static Date date = new Date();
    static String d=dateFormat.format(date);
    static String filename="Summary"+d+".html";
	 
 	public synchronized static ExtentReports getReporter(){
 		
        if(extent == null){
        	
//          Set HTML reporting file location
//            String workingDir = System.getProperty("user.dir");
        	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
 		   LocalDateTime now = LocalDateTime.now();  
// 		   System.out.println(dtf.format(now)); 
        	
 		   String finalFolderName = dtf.format(now).toString().replaceAll("/", "-");
 		   
 		   File f = new File(Paths.testReportsHTML+finalFolderName);
 		   
 		   if(!(f.exists())) {
 			   
 			   f.mkdir();
 		   }
 		   
 		   
 		   
//        	File f = new File();
//        	System.out.println(Paths.testReportsHTML);
            
            extent = new ExtentReports(f+"/"+filename, true);
            
        }
        
        return extent;
    }

}
