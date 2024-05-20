package com.supermarket.test;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageSliderTest extends BaseTest{
	
	@Test
public void VerifyUserCanEditSlider() throws IOException, AWTException {
	lp.login();
	hp.navigatetoSlider();
	
	String actualmessage=msl.createSlider();
	Assert.assertEquals(actualmessage, "Slider Updated Successfully");
	
	
}

}
