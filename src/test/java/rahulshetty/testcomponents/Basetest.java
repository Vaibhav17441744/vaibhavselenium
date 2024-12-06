package rahulshetty.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import rahulshetty.pageobject.Landingpage;

public class Basetest {
	public Landingpage l;
	public WebDriver driver;
	public WebDriver initializerdemo() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Vaibhav\\eclipse-workspace\\Z_Seleniumframelatest\\src\\main\\java\\rahulshetty\\resources\\global.properties");  // convert file into file inputstream
		prop.load(fis); //load method expecting file in inputstream
		String browsername=prop.getProperty("browser");
	
	if(browsername.equalsIgnoreCase("chrome")) {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Vaibhav\\Downloads\\chromedriver-win64 (4)\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
	
	
	}
	
	else if(browsername.equalsIgnoreCase("firefox")) {
		//
	}
     else if(browsername.equalsIgnoreCase("gecko")) {
		
		//
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	driver.manage().window().maximize();
	return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage launchapplicvation() throws IOException {
		driver=initializerdemo();
		 l=new Landingpage(driver);
		l.goTo();
		return l;
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		driver.close();
	}
	
	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
   	 TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir")+"//reports//"+testcasename+".png";
    }
	

}
