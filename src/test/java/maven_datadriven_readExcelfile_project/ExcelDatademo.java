package maven_datadriven_readExcelfile_project;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ExcelDatademo {
	
  @Test(dataProvider = "getdata")
  public void loginwithdetails(String uname, String password) {
	  
	  driver.findElement(By.name("userName")).sendKeys(uname);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  driver.findElement(By.linkText("SIGN-OFF")).click();
      System.out.println("Login succesfully");  
  }
  

 

  @DataProvider
  public Object[][] getdata() throws IOException {
	
	  ExcelSheetDemo1 config=new ExcelSheetDemo1();
	  config.excelsheet("F:\\cjc_software\\java elipse\\eclips\\maven_datadriven_readExcelfile1\\src\\test\\resources\\Sheet1.xlsx");
	  int rows=config.getRowCount("Sheet1");
	  int columns=config.getcolumnCount("Sheet1");
	  Object[][] userdetails=new Object[rows][columns];
	 
	  for(int i=0;i<rows;i++)
	  {
		  for(int j=0;j<columns;j++)
		  {
			  userdetails[i][j]=config.getdata("Sheet1",i,j);
			  
		  }
	  }
	return userdetails;
   
  }
 
 
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("In getcookies method under beforeMethod");
	  Set<Cookie> cookies= driver.manage().getCookies();
	  System.out.println("get all cookies under beforeMethod");
	  for(Cookie cookie:cookies)
	  {
		  System.out.println(cookie.getName());
		 
	  }
  }

  @AfterMethod
  public void capturescreenshot() throws IOException {
	  
	  System.out.println("In capturescreenshot under AfterMethod");
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src,new File("F:\\16122018\\screenshot\\testng.jpeg"));
	  System.out.println("get screenshot successfully");
  }

  @BeforeClass
  public void browser_maximize() {
	  System.out.println("In browser_maximize method under BeforeClass");
	  driver.manage().window().maximize();
	  System.out.println("maximize window succesfully");
  }

  @AfterClass
  public void DeteleAllCookies() {
	  
	  System.out.println("In DeteleAllCookies under afterClass");
	  driver.manage().deleteAllCookies();
	  System.out.println("Delete allcookies succesfully");
  }

  @BeforeTest
  public void getApplicationurl(){
	  System.out.println("In getApplicationurl method under beforeTest");
	
	 // driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	  driver.get("http://newtours.demoaut.com/");
	  System.out.println("add browser url to open browser successfully");
  }

  @AfterTest
  public void dbconnectionclosed() {
	  System.out.println("In dbconnectionclosed under afterTest");
	  
  }
  @BeforeSuite
  public void open_browser() {
	  System.out.println("In open_browser method under beforeSuite");
	  System.setProperty("webdriver.chrome.driver","F:\\16122018\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
      System.out.println("browser path");
  }

  @AfterSuite
  public void Browser_closed() {
	  System.out.println("In Browser_closed under afterSuite");
	  driver.close();
	  System.out.println("browser closed sucessfully");
	  
  }


}
