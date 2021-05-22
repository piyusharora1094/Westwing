package Tests;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Config.Configuration;

public class TestBase {
	public static  WebDriver driver;
	
	@BeforeTest
	public static void launchChrome()
	{
		
		System.setProperty(Configuration.chromedriverSetup, Configuration.driverPath);
		driver =  new ChromeDriver();
		 driver.get(Configuration.Url);
		 driver.manage().window().maximize();
	}
	@AfterTest
	public static void tearDown() {
		driver.quit();
	}
	
	public static void wait(int time) 
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void ScreenCapture() throws IOException
	{
        String path = (System.getProperty("user.dir"))+"//Screenshot//"+getCurrenttime()+".png";
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		File DestFile=new File(path);
		FileUtils.copyFile(SrcFile, DestFile);
				
	}
	
	public static String getCurrenttime()
	  {
		  DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate =new Date();
		
		  return customFormat.format(currentDate);
	  }
	
}
