package com.supermarket.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.Utils.PageActions;

public class ExpenceCategoryPage extends PageActions{
	
	
	public ExpenceCategoryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	WebDriver driver;
	
	@FindBy(css = ".btn.btn-rounded.btn-danger")
	WebElement newCreate;
	
	@FindBy(css = "#name")
	WebElement title;
	
	@FindBy(css = ".fa.fa-save")
	WebElement save;
	
	@FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	
	@FindBy(xpath = "(//*[@class='fas fa-trash-alt'])[1]")
	WebElement deleteButton;
	
	public String createExpence(String uniqueExpence) {
		
		clickElement(newCreate);
		setText(title, uniqueExpence);
		clickElement(save);
		String alertmessage=alertText.getText();
		return splitStringMsg(alertmessage);
	}
	
	public String deleteExpence() {
		clickElement(deleteButton);
		assertHandle();
		String alertMessage=alertText.getText();
		return splitStringMsg(alertMessage);
	}

}
