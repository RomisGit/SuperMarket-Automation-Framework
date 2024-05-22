package com.supermarket.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageListLocationsTest extends BaseTest {
	//@Test
	public void verifyUserCanCreateListLocation() throws IOException {
	lp.login();
	hp.navigateToManageLocation();
	String actualLocationmessage=mlp.createManageLocation();
	Assert.assertEquals(actualLocationmessage, "Location Created Successfully");

	}
	//@Test 
	public void verifyUserCanDeleteListLocation() throws InterruptedException, IOException {
		lp.login();
		hp.navigateToManageLocation();
		String actualalertMessage=mlp.deleteLocation();
		Assert.assertEquals(actualalertMessage, "Location Deleted Successfully");
	}

}
