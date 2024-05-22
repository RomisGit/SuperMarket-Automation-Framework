package com.supermarket.Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Context.Constants;
import Context.DriverManager;

public class PageActions {
	
	 WebDriver driver;
	//this.driver=driver;
	WebDriverWait wait;
	
	JavascriptExecutor js=(JavascriptExecutor)driver;	
	
	public PageActions(WebDriver driver) {
		this.driver=driver;
	  wait=new WebDriverWait(driver,Duration.ofSeconds(8));
		
	}
	
	@FindBy(css = ".alert-success.alert-dismissible")
	protected WebElement alertMsg;
	
	@FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")
	protected WebElement alertText;
	
	@FindBy(xpath = "(//*[@class='btn btn-sm btn btn-danger btncss'])[1]")
	protected WebElement deleteButton;
	
	
	public void clickElement(WebElement element) {
		waitUntilclickable(element);
		waitUntilVisible(element);
		element.click();
	}
	
	public void waitUntilVisible(WebElement element)
	{
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitUntilclickable(WebElement element)
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	@FindBy(css = ".btn.btn-rounded.btn-danger")
	protected WebElement newCreate;
	
	@FindBy(xpath = "//*[@name='create']")
	protected WebElement save;
	
	public void setText(WebElement element, String value) {
		
		waitUntilVisible(element);
		element.clear();
		element.sendKeys(value);
	}
	
	public String splitStringMsg(String alertTExt) {
		return alertTExt.split("Alert!")[1].trim();
	}
	
	public void assertHandle() {
		Alert alert= driver.switchTo().alert();
		alert.accept();
	}
	public void scrollToBottomofPage() {
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public boolean isElementPresent(WebElement element) {
		return element.isDisplayed();
	}
	
	public void javaScriptClickelement(WebElement element) {
		waitUntilclickable(element);
		waitUntilVisible(element);
		JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element);	
	}
	
	public void scrollmethod(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;	 
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void handleStaticDrp(WebElement element, String visibleText) {
		Select staticdropDownlist =new Select(element);
		staticdropDownlist.selectByVisibleText(visibleText);
		
	}
	public void uploadImage(WebElement chooseFile ,String fileToUpload ) throws AWTException {
		javaScriptClickelement(chooseFile);
		StringSelection ss = new StringSelection(fileToUpload);
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	     //imitate mouse events like ENTER, CTRL+C, CTRL+V
	     Robot robot = new Robot();
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.delay(90);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static String getScreenShot(String testName) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)DriverManager.getDriver();
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
		String path=Constants.WORKINGDIRECTORY+"\\Reports\\"+testName+UniqueGenerator.getCurrentDateTime()+".png";
		File desFile=new File(path);
		
		FileUtils.moveFile(srcFile, desFile);
		return path;
		}

}
