package com.mastek.monark.hybrid.TestsWeb;


import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mastek.monark.hybrid.BaseSetup.BaseClass;
import com.mastek.monark.hybrid.PageObjectsWeb.HomePage;

public class Scenario2 extends BaseClass{
		
	
	@Test
	@Parameters({"NewField" })
	public void TC001(String NewField) throws IOException {		
		
		//searching a text on homepage of wiki
		
		
		HomePage home = new HomePage();
		
		home.searchForContent(NewField);
		
	}
	
	@Test
	@Parameters({"SearchText" })
	public void TC002(String SearchText) throws IOException {		
		
		
		//searching a text on homepage of wiki
		HomePage home = new HomePage();
		
		home.searchForContent(SearchText);
	}

}
