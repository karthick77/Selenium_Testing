package com.testngworks;

import org.testng.annotations.Test;

public class HomeLoan {

	@Test
	public void webLogin() {
		System.out.println("Homeloan - web login");
	}
	
	@Test(groups= {"smoke"})
	public void mobileLogin() {
		System.out.println("Homeloan - mobile login");
	}
	
	@Test(enabled = false)
	public void apiLogin() {
		
		System.out.println("Homeloan - api login");
	}
	
}
