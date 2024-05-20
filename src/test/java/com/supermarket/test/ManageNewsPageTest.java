package com.supermarket.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageNewsPageTest extends BaseTest{
	@Test
	public void verifyUserCanCreateNews() throws InterruptedException, IOException {
		lp.login();
		hp.navigateToNews();
		String actualAlertMessage= msp.createNews();
		Assert.assertEquals(actualAlertMessage, "News Created Successfully");
	
		
	}
	
	@Test 
	public void verifyUserCanDeleteNews() throws InterruptedException, IOException {
		lp.login();
		hp.navigateToNews();
		String actualalertMessage=msp.deleteNews();
		Assert.assertEquals(actualalertMessage, "News Deleted Successfully");
	}

}
