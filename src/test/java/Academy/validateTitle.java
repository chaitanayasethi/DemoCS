package Academy;

import java.io.IOException;
//import java.lang.System.Logger;

//import org.apache.logging.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import jdk.internal.org.jline.utils.Log;
import junit.framework.Assert;
import pageObjects.LandingPages;
import pageObjects.LoginPage;
import resources.base;

public class validateTitle extends base{
	public WebDriver driver;
	public static Logger log = Logger.getLogger(validateTitle.class);
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("URL opened successfully");
	}
		
	
	@Test
	public void validateTitle() throws IOException {
		
		LandingPages l = new LandingPages(driver);
		System.out.println(l.getTitle().getText());
		
		Assert.assertEquals("FEATURED COURSES12", l.getTitle().getText());
		log.info("Successfully Validated Text message");
		//lp.getAlertErrorMessage().getText();
		//System.out.println(text);
		//driver.close();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
	
}
