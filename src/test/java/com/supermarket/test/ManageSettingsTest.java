package com.supermarket.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageSettingsTest extends BaseTest {
	
	@Test
	public void createManageMenu() throws InterruptedException, IOException {
		lp.login();
		hp.navigatetomanagemenu();
		String actualTest= msj.createManageMenu();
		Assert.assertEquals(actualTest, "Menu Created Successfully");
	}
	@Test 
	public void verifyUserCanDeleteMenu() throws InterruptedException, IOException {
		lp.login();
		hp.navigatetomanagemenu();
		String actualalertMessage=msj.deleteMenu();
		Assert.assertEquals(actualalertMessage, "Menu Deleted Successfully");
	}
	
}
