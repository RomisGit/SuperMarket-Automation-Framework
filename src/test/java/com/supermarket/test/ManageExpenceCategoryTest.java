package com.supermarket.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.Utils.UniqueGenerator;

public class ManageExpenceCategoryTest extends BaseTest {
	//@Test
	public void verifyUserCanCreateNewExpence() throws InterruptedException, IOException {
		
		lp.login();
		hp.navigateToExpenceCategory();
		
		String uniqueName=UniqueGenerator.getUniqueString("Sample Name");
		
		String actualAlertMsg=ecp.createExpence(uniqueName);
		Assert.assertEquals(actualAlertMsg, "Expense Category Created Successfully");
		
	
	}
	
	//@Test 
	public void verifyUserCanDeleteExpence() {
		String actualalertMessage=ecp.deleteExpence();
		Assert.assertEquals(actualalertMessage, "Expense Category Deleted Successfully");
	}
	

}
