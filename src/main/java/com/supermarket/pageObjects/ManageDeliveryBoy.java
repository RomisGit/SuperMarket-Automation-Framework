package com.supermarket.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.Utils.PageActions;

public class ManageDeliveryBoy extends PageActions{

	public ManageDeliveryBoy(WebDriver driver) {
		super(driver);
		//this.driver=driver;
		//super(driver);
		PageFactory.initElements(driver,this);
		
	}
	

	@FindBy(css = ".btn.btn-rounded.btn-danger")
	WebElement newCreate;
	
	@FindBy(id = "name")
	WebElement name1;
	
	@FindBy(id = "username")
	WebElement username1;
	
	@FindBy(id = "password")
	WebElement password1;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement save;
	
	@FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	
	@FindBy(xpath = "(//*[@class='btn btn-sm btn btn-danger btncss'])[1]")
	WebElement deleteButton;
	
	public String createDeliveryBoy(String uniqueUserName) throws InterruptedException {
		
		clickElement(newCreate);
		setText(name1, "Romi");
		setText(username1, uniqueUserName);
		setText(password1, "Testing123!");
		scrollToBottomofPage();
		Thread.sleep(1000);
		clickElement(save);
		String alertmessage=alertText.getText();
		return splitStringMsg(alertmessage);
	}
	
	public String deleteDeliveryBoy() {
		clickElement(deleteButton);
		assertHandle();
		String alertMessage=alertText.getText();
		return splitStringMsg(alertMessage);
	}

}
