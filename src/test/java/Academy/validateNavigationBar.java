package Academy;

import java.io.IOException;

//import org.apache.logging.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import jdk.internal.org.jline.utils.Log;
import junit.framework.Assert;
import pageObjects.LandingPages;
import pageObjects.LoginPage;
import resources.base;

public class validateNavigationBar extends base{
	public static Logger log = Logger.getLogger(validateNavigationBar.class);
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		
		driver.get(prop.getProperty("url"));
	}
		
	@Test
	public void validateNavBar() throws IOException {
		
		LandingPages l = new LandingPages(driver);
		Assert.assertTrue(l.getNavigationbar().isDisplayed());
		log.info("Navigation bar is displayed");
		
		
		//lp.getAlertErrorMessage().getText();
		//System.out.println(text);
		//driver.close();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
}
