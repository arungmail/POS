package BasePackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Pages.ExcelReader;
import Pages.JavaMail;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseClass extends DriverClass{
	//InputValues input = new InputValues ();
	JavaMail javamail = new JavaMail();
	DriverClass driverclass = new DriverClass();
	
	ExcelReader excel = new ExcelReader ();
	
	/**
	 * Launch the Application  
	 * @throws InterruptedException 
	 * @Return Return the url from propery file and load the web page 
	 * 
	 */
	@BeforeSuite
	// Launching Application 
	public final void launchAUTApplication () throws IOException, InterruptedException
	{
		
		//driverclass.launchBrowser(DriverClass.getValuesFromPropertiesFile("BrowserName"));	
		driverclass.launchBrowser("Chrome");	
		driver.manage().window().maximize();
		javamail.main(null);
		
	}
	
	
	@AfterSuite
	//Closing Application 
	public void cleanUp()
	{
		
		
		driver.close();	
    }
	
}
