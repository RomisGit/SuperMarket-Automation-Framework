package com.supermarket.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.supermarket.Utils.PageActions;

public class ManageSettingsPage extends PageActions {
	
	WebDriver driver;
	public ManageSettingsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//*[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(name = "name")
	private WebElement name;
	@FindBy(xpath = "//*[@id='menu_id']")
	private WebElement parentMenu;
	
	@FindBy(xpath = "//*[@id='menu_order']")
	private WebElement menuOrder;
	@FindBy(xpath = "//*[@name='create']")
	private WebElement save;
	@FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	@FindBy(xpath = "(//*[@class='fas fa-trash-alt fa-sm'])[1]")
	WebElement deleteButton;
	
	
	public String createManageMenu() throws InterruptedException {
	
		clickElement(newbutton);
		setText(name, "Test name");
		Select staticdropDownlist =new Select(parentMenu);
		Thread.sleep(1000);
		staticdropDownlist.selectByIndex(1);
		setText(menuOrder, "12");
		scrollmethod(save);
		Thread.sleep(1000);
		clickElement(save);
		String alertmessage=alertText.getText();
		return splitStringMsg(alertmessage);
		
		
	}
	public String deleteMenu() {
		clickElement(deleteButton);
		assertHandle();
		String alertMessage=alertText.getText();
		return splitStringMsg(alertMessage);
	}
	
	

}
