package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.TestUtils;

public class TestBase {
	
	public static WebDriver d;
	public static Properties prop;
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream f = new FileInputStream("C:\\Users\\Soumya\\maven\\MyMavenProject\\src\\main\\java\\com\\crm\\qa\\properties\\configuration.properties");
			prop.load(f);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void initialization() {
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\selenium_softwares_latest\\chromedriver_win32\\chromedriver.exe");
			d = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\selenium_softwares_latest\\IEDriverServer_x64_3.13.0\\IEDriverServer.exe");
			d = new InternetExplorerDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "D:\\selenium_softwares_latest\\geckodriver-v0.21.0-win64\\geckodriver.exe");
				d = new FirefoxDriver();
			}
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(TestUtils.IMPILICIT_WAIT, TimeUnit.SECONDS);
		
		d.get(prop.getProperty("url"));
		}
}
