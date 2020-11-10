package resources;

import java.io.File;

import org.apache.commons.io.FileUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\csethi\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		System.out.println(browserName);
		if(browserName.equals("chrome")) {
			//code to execute in chrome
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\csethi\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			//code to execute in Firefox
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\csethi\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE")) {
			//code to execute in IE
			System.setProperty("", "");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
}
