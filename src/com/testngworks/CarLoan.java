package com.testngworks;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CarLoan {

	@Test
	public void webLogin() {
		System.out.println("CarLoan - web login");
	}
	
	@Test
	public void mobileLogin() {
		System.out.println("CarLoan - mobile login");
	}
	
	@Test
	public void mobileSignIn() {
		System.out.println("CarLoan - mobile signin");
	}
	
	@Test
	public void mobileSignOut() {
		System.out.println("CarLoan - mobile signout");
	}
	
	@Test(groups= {"smoke"})
	public void apiLogin() {
		
		System.out.println("CarLoan - api login");
	}
	
	@BeforeSuite
	public void bfSuite() {
		System.out.println("I am the first");
	}
	
}
