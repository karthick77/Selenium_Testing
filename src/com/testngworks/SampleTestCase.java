package com.testngworks;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SampleTestCase {

	@AfterSuite
	public void afSuite() {
		System.out.println("I am first from the last");
	}
	@AfterTest
	public void closeApp() {
		System.out.println("Close all app instance");
	}
	@Test(groups= {"smoke"})
	public void firstTest() {
		System.out.println("First from SampleTestCase");
	}
	
	@Test
	public void secondTest() {
		System.out.println("Second from SampleTestCase");

	}
	
}
