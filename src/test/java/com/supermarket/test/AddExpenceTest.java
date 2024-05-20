package com.supermarket.test;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddExpenceTest extends BaseTest{
	
	//@Test
	public void verifyUserIsAbleToCreateExpence() throws InterruptedException, AWTException, IOException {
		lp.login();
		hp.navigateToManageExpence();
		lep.moveToAddExpence();
		String actualExpenecMessage= lep.addExpence();
		assertEquals(actualExpenecMessage, "Expense Record Created Successfully");
		
		//hp.navigateToManageExpence();
		Assert.assertTrue(lep.verifyPhotoUploaded(),"Photo is not Dispalyed");
		
		
	}

}
