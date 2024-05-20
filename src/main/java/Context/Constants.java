package Context;

import com.supermarket.Utils.UniqueGenerator;

public class Constants {
	
	public static final String WORKINGDIRECTORY=System.getProperty("user.dir");
	public static final String IMAGEPATH=WORKINGDIRECTORY+"\\src\\test\\resources\\testData\\sampleimage.jpg";
	public static final String PROPERTYPATH=WORKINGDIRECTORY+"\\src\\main\\resources\\Configuration\\config.properties";
	public static final String REPORTPATH=WORKINGDIRECTORY+"//Reports//AutomationReport.html";
	public static final String  SCREENSHOTPATH= WORKINGDIRECTORY+"//Reports//"+UniqueGenerator.getCurrentDateTime()+".png";
}
