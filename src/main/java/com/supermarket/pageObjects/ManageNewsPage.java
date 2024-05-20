package com.supermarket.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.Utils.PageActions;
import com.supermarket.Utils.UniqueGenerator;

public class ManageNewsPage extends PageActions{
	
WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}
	
	@FindBy(xpath = "//*[@class='btn btn-rounded btn-danger']")
	private WebElement newNewsButton;
	@FindBy(css = "#news")
	private WebElement newsTxtBox;
	@FindBy(xpath = "//*[@name='create']")
	private WebElement saveNewsBtn;
	@FindBy(xpath = "(//*[@class='btn btn-sm btn btn-danger btncss'])[1]")
	private WebElement deleteButton;
	@FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	
	public String createNews() {
		clickElement(newNewsButton);
		setText(newsTxtBox,UniqueGenerator.getCurrentDateTime().toString());
		clickElement(saveNewsBtn);
		String alertMessage=alertMsg.getText();
		return splitStringMsg(alertMessage);
	}

	public String deleteNews() {
		clickElement(deleteButton);
		assertHandle();
		String alertMessage=alertText.getText();
		return splitStringMsg(alertMessage);
	}
}
