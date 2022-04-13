package com.testngworks;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AnotherTestCase {

	@Test
	@Parameters({"URL"})
	public void thirdTest(String urlName) {
		System.out.println("Third from AnotherTestCase");
		System.out.println(urlName);
	}
	
	@Test(groups= {"smoke"})
	public void fourthTest() {
		System.out.println("Fourth from AnotherTestCase");
	}
	
	@BeforeTest
	public void dataRefresh() {
		System.out.println("I first before test");
	}
	
	@Test(dependsOnMethods = {"thirdTest"})
	public void day1() {
		System.out.println("Day Match");
	}
	
	@Test(dataProvider = "getData")
	public void login(String username, String password) {
		System.out.println("Login Details: ");
		System.out.println(username);
		System.out.println(password);
		
	}
	
	@Test(dependsOnMethods = {"thirdTest","day1"})
	public void night1() {
		System.out.println("Pink ball test");
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "User1";
		data[0][1] = "Password1";
		
		data[1][0] = "User1";
		data[1][1] = "Password1";
		
		data[2][0] = "User1";
		data[2][1] = "Password1";
		
		return data;
		
	}
}
