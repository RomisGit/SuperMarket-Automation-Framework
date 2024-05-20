package com.supermarket.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.Utils.PageActions;
import com.supermarket.Utils.UniqueGenerator;

public class ManageLocationPage extends PageActions {

	public ManageLocationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id = "location")
	private WebElement locTXT;
	
	@FindBy(id = "delivery")
	private WebElement deliveryChargeTXT;
	
	
	public String createManageLocation() {
	clickElement(newCreate);
	setText(locTXT,"Crossgates");
	setText(deliveryChargeTXT, UniqueGenerator.getRandomNumber());
	clickElement(save);
	String assertTXT= alertText.getText();
	return splitStringMsg(assertTXT);
	}
	
	public String deleteLocation() {
		clickElement(deleteButton);
		assertHandle();
		String alertMessage=alertText.getText();
		return splitStringMsg(alertMessage);
	}
	

}
