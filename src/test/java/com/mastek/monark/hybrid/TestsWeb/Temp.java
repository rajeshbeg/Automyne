package com.mastek.monark.hybrid.TestsWeb;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Temp {

	public static void main(String[] args) {


		String str = "com.mastek.monark.hybrid.TestsWeb.Scenario1";
		
		String[] s = str.split("hybrid.");
		
		int cut = s[s.length-1].toString().indexOf(".");
		
		System.out.println(s[s.length-1].toString().substring(cut+1, s[s.length-1].length()));
		
		System.out.println();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  

	}

}
