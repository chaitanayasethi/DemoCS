package Academy;

import java.io.IOException;

//import org.apache.logging.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPages;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public static Logger log = Logger.getLogger(HomePage.class);
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		
		
	}
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username, String Password, String text) throws IOException {
		
		driver.get(prop.getProperty("url"));
		LandingPages l = new LandingPages(driver);
		l.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		log.info("logged in");
		lp.getLogin().click();
		//lp.getAlertErrorMessage().getText();
		//System.out.println(text);
		//driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0]="nonrestrict@gmail.com";
		data[0][1]="unpass";
		data[0][2]="restricted";
		
		data[1][0]="abc@xyz.com";
		data[1][1]="pass";
		data[1][2]="not";
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
}
