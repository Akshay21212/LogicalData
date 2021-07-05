package com.cjc;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.XMLLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MercuryTours {
	static Logger log=Logger.getLogger(MercuryTours.class.getName());
	
	WebDriver driver;
	@BeforeSuite
	public void m1() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@BeforeTest
	public void m2() {
		  driver.get("http://demo.guru99.com/test/newtours/index.php");
	}
	@BeforeClass
	public void m3() {
		  driver.manage().window().maximize();

	}
	@BeforeMethod
	public void m4() throws IOException {
		Set<Cookie> cookies=driver.manage().getCookies();
        int count=cookies.size();
        BasicConfigurator.configure();
    	Layout la=new XMLLayout(); 
    	Appender ap=new FileAppender(la,"ABC.txt");
    	
    	
        
log.info("Total no of cookies"+count);
for(Cookie cookie:cookies) {
  String name=cookie.getName();
  log.info("Name of the cookie "+name);       
  String domain=cookie.getDomain();
  log.info("Domain of the cookie "+domain);
  System.out.println(cookie.getClass());
  String value=cookie.getValue();
  log.info("value of the cookie"+value);
  String path=cookie.getPath();
  log.info("path of the cookie"+path);
  log.info(cookie.getExpiry());
  boolean ss=cookie.isHttpOnly();
  log.info("http of the cookie"+ss);
  boolean sss=cookie.isSecure();
 log.info ("securety of the cookie"+sss);
  log.info("======================================");
		
	}
	}	
	@Test(dataProvider="getdata")
	public void m5(String username, String pass) throws IOException {
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")).sendKeys(username);
driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")).sendKeys(pass);	

File source1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFileToDirectory(source1, new File("C:\\Users\\LENOVO\\Akshay_Tidke\\DemoTestng\\takescreenshot2"));
driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input")).click();
	}
	@DataProvider
	public Object[][] getdata(){
		Object data[][]=new Object[1][2];
		data [0][0]="Akshay@12";
		data [0][1]="Akshay@123";
		return data;
		
		
	}
	@AfterClass
	public void m7() {
		 driver.manage().deleteCookieNamed("__utmt");
		  Set<Cookie> cookies1=driver.manage().getCookies();
         int count1=cookies1.size();
log.info("Total no of cooklog.cookies"+count1);
		
	
	}
	@AfterTest
	public void m8() {
log.info("close");
	}
	@AfterSuite
	public void m9() {
 log.info("succes");		
	}
	}


	

	
