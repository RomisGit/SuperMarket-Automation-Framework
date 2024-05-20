package com.supermarket.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.Utils.UniqueGenerator;

public class ManageDeliveryBoyTest extends BaseTest{
	
	@Test(groups = "Smoke")
	public void verifyUserCanCreateDeliveryBoy() throws InterruptedException, IOException {
		System.out.println("Getting stuck here");
		lp.login();
		hp.navigateToManageDeliveryBoy();
		String uniqueUsernameName=UniqueGenerator.getUniqueString("Sample UserName");
		String actualmessage=mdb.createDeliveryBoy(uniqueUsernameName);
		Assert.assertEquals(actualmessage, "Delivery Boy Details Created Successfull");
	}
	@Test 
	public void verifyUserCanDeleteDeliveryBoy() throws InterruptedException, IOException {
		lp.login();
		hp.navigateToManageDeliveryBoy();
		String actualalertMessage=mdb.deleteDeliveryBoy();
		Assert.assertEquals(actualalertMessage, "Delivery Boy Informations Deleted Successfully");
	}
	

}
