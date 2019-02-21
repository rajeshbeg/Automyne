package com.mastek.monark.hybrid.GridSetup;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.mastek.monark.hybrid.Core.Paths;

public class Test {

	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String... args) throws URISyntaxException, IOException {
		
		String message;
		JSONObject json = new JSONObject();
//		json.put("name", "student");

		JSONArray capabilities = new JSONArray();
		
		JSONObject firefox = new JSONObject();
		firefox.put("browserName", "firefox");
		firefox.put("marionette", true);
		firefox.put("maxInstances", 10);
		firefox.put("seleniumProtocol", "WebDriver");
		capabilities.add(firefox);

		JSONObject chrome = new JSONObject();
		chrome.put("browserName", "chrome");
		chrome.put("maxInstances", 10);
		chrome.put("seleniumProtocol", "WebDriver");
		capabilities.add(chrome);

		JSONObject ie = new JSONObject();
		ie.put("browserName", "internet explorer");
		ie.put("maxInstances", 10);
		ie.put("seleniumProtocol", "WebDriver");
		capabilities.add(ie);
		
		JSONObject safari = new JSONObject();
		safari.put("browserName", "safari");
		safari.put("technologyPreview", false);
		safari.put("platform", "MAC");
		safari.put("maxInstances", 10);
		safari.put("seleniumProtocol", "WebDriver");
		capabilities.add(safari);
		
		json.put("capabilities", capabilities);
				
		String url = "http://localhost:4444".replaceAll("(?<!http:)\\/\\/", "/");
		
		System.out.println("" + url + "");
		
		json.put("proxy", "org.openqa.grid.selenium.proxy.DefaultRemoteProxy");
		json.put("maxSession", 10);
		json.put("port", -1);
		json.put("register", true);
		json.put("registerCycle", 5000);
//		json.put("hub", "" + url.toString() + "");
		json.put("nodeStatusCheckTimeout", 5000);
		json.put("nodePolling", 5000);
		json.put("role", "node");
		json.put("unregisterIfStillDownAfter", 60000);
		json.put("downPollingLimit", 2);
		json.put("debug", false);
	
		message = json.toJSONString();
		
		FileWriter file = new FileWriter(Paths.drivers+"node.json");
		
		file.write(message);
		file.flush();
		
		System.out.println(message);
	}
	
}
