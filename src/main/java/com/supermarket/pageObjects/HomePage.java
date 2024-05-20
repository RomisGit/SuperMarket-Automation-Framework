package com.supermarket.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.Utils.PageActions;


public class HomePage extends PageActions {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	
		PageFactory.initElements(driver,this);		
	}
	
	@FindBy(css = ".brand-text.font-weight-light")
	WebElement brandName;
	
	
	@FindBy(xpath = "(//*[contains(text(),'Manage Expense')])[1]")
	WebElement manageExpence;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	WebElement expenceCategory;
	
	@FindBy(css = ".nav-icon.fas.fa-user-plus")
	WebElement manageDeliveryBoy;
	
	@FindBy(xpath = "//*[contains(text(),'Settings')]")
	WebElement settings;
	
	@FindBy(xpath = "//*[contains(text(),'Manage Content')]")
	WebElement managemenu;
	
	@FindBy(xpath = "//*[contains(text(),'Manage News')]")
	WebElement manageNews;
	
	
	@FindBy(xpath = "(//*[contains(text(),'Manage Expense')])[2]")
	WebElement manageExpenceBtn;
	
	public String getbrandName() {
		return brandName.getText();
	}

	@FindBy(xpath = "//*[@class=' nav-link']//*[@class='far fa-circle nav-icon']")
	WebElement settingsManagemenu;
	
	
	
	public void navigateToExpenceCategory(){
		clickElement(manageExpence);
		clickElement(expenceCategory);
	}
	
	public void navigateToManageExpence() {
		clickElement(manageExpence);
		clickElement(manageExpenceBtn);
	}
	public void navigateToNews() {
		clickElement(managemenu);
		clickElement(manageNews);
	}
	
	
	public void navigateToManageDeliveryBoy(){
		clickElement(manageDeliveryBoy);
	}
	
	
	public void navigatetomanagemenu() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;	 
		
		js.executeScript("arguments[0].scrollIntoView(true);", settings);
		clickElement(settings);
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", settingsManagemenu);
	    clickElement(settingsManagemenu);
	}
	

}
