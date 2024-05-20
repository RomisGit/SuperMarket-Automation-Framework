package Context;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	private static ThreadLocal<WebDriver> driverInstance= new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		if(driverInstance.get()==null) {
		throw new IllegalArgumentException("Webdriver is null");
		}
		else { 
			return  driverInstance.get();
		}
	
	}
	
	public static void setDriver(WebDriver driver) {
		driverInstance.set(driver);
	}
}
