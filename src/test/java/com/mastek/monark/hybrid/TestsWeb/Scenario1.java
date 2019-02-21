package com.mastek.monark.hybrid.TestsWeb;


import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mastek.monark.hybrid.BaseSetup.BaseClass;
import com.mastek.monark.hybrid.PageObjectsWeb.HomePage;

public class Scenario1 extends BaseClass{
	

	
	@Test
	@Parameters({"SearchText" })
	public void TC001(String SearchText) throws IOException {		
		
		//searching a text on homepage of wiki
		
		HomePage home = new HomePage();
		
		home.searchForContent(SearchText);
		
	}
	
	@Test
	@Parameters({ "NewField" })
	public void TC002(String NewField) throws IOException {		
		
		
		//searching a text on homepage of wiki
		HomePage home = new HomePage();
		
		home.searchForContent(NewField);
	}
	
	

}
