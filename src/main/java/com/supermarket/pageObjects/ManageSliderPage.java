package com.supermarket.pageObjects;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.Utils.PageActions;

import Context.Constants;

public class ManageSliderPage extends PageActions{

	public ManageSliderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);	
	}
	@FindBy(id = "main_img")
	private WebElement imageUpload;
	
	@FindBy(xpath = "(//*[@class='fas fa-edit'])[2]")
	private WebElement editSlider;
	
	@FindBy(xpath = "//*[@class='btn btn-danger']")
	private WebElement updateSlider;
	
    @FindBy(id = "link")
    private WebElement linkTXT;
    

	@FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
    
    public String createSlider() throws AWTException, IOException {
    	clickElement(editSlider);
    	uploadImage(imageUpload,Constants.IMAGEPATH);
    	setText(linkTXT, "www.google.com");
    	clickElement(updateSlider);
    	String alertmessage=alertText.getText();
		return splitStringMsg(alertmessage);
    }

}
