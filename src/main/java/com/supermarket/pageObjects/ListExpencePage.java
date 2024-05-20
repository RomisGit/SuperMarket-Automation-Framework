package com.supermarket.pageObjects;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.Utils.PageActions;
import com.supermarket.Utils.UniqueGenerator;

import Context.Constants;

public class ListExpencePage extends PageActions{
	
	WebDriver driver;
	public ListExpencePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id = "user_id")
	private WebElement stDrpDwn;
	
	@FindBy(id = "ex_type")
	private WebElement expenceType;
	
	@FindBy(id = "amount")
	private WebElement amount;
	
	@FindBy(xpath = "//*[@type='file']")
	private WebElement chooseFile;
	
	@FindBy(xpath = "//*[@name='create']")
	private WebElement save;
	
    String visibleTxt="Test(DB)";
	
	@FindBy(xpath = "//*[@class='detail-row open']//*[@class='profile-info-name']")
	private WebElement uploadedimage;
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[8]//a")
	private WebElement downArrowinTable;
	
	@FindBy(xpath = "(//*[contains(text(),'Manage Expense')])[2]")
	WebElement manageExpenceBtn;
	
	public void moveToAddExpence() {
		clickElement(newCreate);
		}
	
	public String addExpence() throws InterruptedException, AWTException {
		handleStaticDrp(stDrpDwn, visibleTxt);
		handleStaticDrp(expenceType, "Debit Bank");
		setText(amount, UniqueGenerator.getRandomNumber());
		scrollToBottomofPage();
		
		uploadImage(chooseFile, Constants.IMAGEPATH);
		clickElement(save);
		String alertMessage=alertMsg.getText();
		return splitStringMsg(alertMessage);
		
	}
	
	//(//*[@class="green bigger-140 show-details-btn"]//*[@class="fa fa-angle-double-down"])[1]
	
	public boolean verifyPhotoUploaded() throws InterruptedException {
		clickElement(manageExpenceBtn);
		 waitUntilVisible(downArrowinTable);
		clickElement(downArrowinTable);
	    waitUntilVisible(uploadedimage);
		return isElementPresent(uploadedimage);
		
	}
	

}
