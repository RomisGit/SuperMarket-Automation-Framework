package com.supermarket.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.supermarket.pageObjects.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(groups = "Smoke")
	public void verifyUserIsAbleToLoginCredentials() throws IOException {
		System.out.println("Stuck here");
        lp.login();
		String actualText=hp.getbrandName();
		assertEquals(actualText, "7rmart supermarket");
		
	}

}
