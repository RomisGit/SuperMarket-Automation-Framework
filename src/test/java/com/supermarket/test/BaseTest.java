package com.supermarket.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.supermarket.Utils.TestProperties;
import com.supermarket.pageObjects.ExpenceCategoryPage;
import com.supermarket.pageObjects.HomePage;
import com.supermarket.pageObjects.ListExpencePage;
import com.supermarket.pageObjects.LoginPage;
import com.supermarket.pageObjects.ManageDeliveryBoy;
import com.supermarket.pageObjects.ManageNewsPage;
import com.supermarket.pageObjects.ManageSettingsPage;

import Context.Constants;
import Context.DriverManager;

public class BaseTest {
	
	WebDriver driver;
	@BeforeMethod(alwaysRun = true)
	@Parameters({"browserName"})
	public  void initialiseDriver(@Optional String browserName) throws IOException  {
		
		//String browser;
		
		Properties prop=TestProperties.getProperties();
		
		if(browserName==null||browserName.isEmpty())
		{
			browserName= prop.getProperty("browserName");
		}
		
		String env= prop.getProperty("Environment");
		System.out.println(env);
	    String URL=	prop.getProperty(env);
	    System.out.println(URL);
		
		if (browserName.equalsIgnoreCase("Chrome"))
		{
			 driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			 driver=new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			 driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Not a valid browser");
			
		}
		DriverManager.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(URL);
		initPages();
		
	}
	

	public LoginPage lp;
	public HomePage hp;
	public ExpenceCategoryPage ecp;
	public ManageDeliveryBoy mdb;
	public ManageSettingsPage msj;
	public ManageNewsPage msp;
	public ListExpencePage lep;

	public void initPages() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		ecp= new ExpenceCategoryPage(driver);
		mdb= new ManageDeliveryBoy(driver);
		msj=new ManageSettingsPage(driver);
		msp=new ManageNewsPage(driver);
		lep=new ListExpencePage(driver);
	}
	@AfterMethod(alwaysRun = true)
	public void tearDOwn() {
		driver.quit();
	}
	

}
