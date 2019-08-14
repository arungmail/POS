package BasePackage;

import java.io.File;
/**
* Choose the Browser 
*
* @author Arun PV
* @module Driver class
* @version 1.0
* @since February 2015
* @licence MultiApps Technologies Pvt Ltd.,
*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Pages.ExcelReader;
import Pages.POScons;

public class DriverClass {
	protected static WebDriver driver;
	

	
	/**
	 * To read the value from property file 
	 * @param string key = Property value 
	 * 
	 */
	protected static String getValuesFromPropertiesFile(String key) throws IOException
	{
		String  filepath = System.getProperty("user.dir")+"\\src\\main\\java\\Config\\DVR.properties";
	    Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream (filepath);
	    prop.load(fis);
	    return prop.getProperty(key);	
	}	
	/**
	 * To select browser 
	 * @param string browserName = Browser name 
	 * 
	 */
	public final void launchBrowser(String browserName) throws IOException
	{
		switch (browserName)
		{
		case "FF":
			/*//driver = new FirefoxDriver();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setBinaryPath("C:\\Program Files\\Firefox Developer Edition\\firefox.exe");
			break;*/
			/*File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Downloads\\selenium-java-3.0.1\\geckodriver.exe");       
			WebDriver driver = new FirefoxDriver();
			break;*/
			/*File pathToBinary = new File("C:\\Program Files\\Firefox Developer Edition\\firefox.exe");
			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			WebDriver driver = new FirefoxDriver();*/
			File pathToBinary = new File("C:\\Program Files\\Firefox Developer Edition\\firefox.exe");
			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setBinary(ffBinary);
			driver = new FirefoxDriver(firefoxOptions);
			break;
			//driver = new FirefoxDriver();
		case "Chrome":
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--incognito");
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "Opera":
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\operadriver.exe");
			driver = new OperaDriver();
			break;						
		}
		
		driver.get(POScons.POS_URL);
		driver.manage().window().maximize();	
	}
}
