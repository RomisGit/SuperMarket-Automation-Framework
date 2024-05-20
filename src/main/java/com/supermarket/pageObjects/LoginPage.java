package com.supermarket.pageObjects;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.Utils.PageActions;
import com.supermarket.Utils.TestProperties;


public class LoginPage extends PageActions {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}
	
	
	@FindBy(xpath="//*[@name='username']")
	WebElement userName;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement password;
	
	@FindBy(css = ".btn.btn-dark.btn-block")
	WebElement signin;
	
	
	public void login() throws IOException {
		System.out.println("Stuck here inside login");
		Properties prop=TestProperties.getProperties();
		setText(userName, prop.getProperty("username"));	
		setText(password,  prop.getProperty("password"));
		clickElement(signin);
	}

}
