package commonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class BaseClass {
	
WebDriver driver = new ChromeDriver();



	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutil = new JavaUtil();



			
	
	  @BeforeSuite
		public void BS() {
		  System.out.println("connect to data base");
			
		
	  }
	  @BeforeClass
	  public void BC() throws IOException {
		  
		  //@Before class annotation is used to launch application 
		  String URL = putil.getDataFromPropertyFile("Url");
			

			
		
		  WebDriver driver = new ChromeDriver();
			//To maximise window
	        wutil.maximize(driver);
	        //to apply wait
	        wutil.implicitwait(driver);
	        
	        driver.get(URL);
		  
	  }
	  
	  @BeforeMethod
	  public void BM() throws IOException {
		  
		  //@Before method is used to login to application
		  
		  //to read property file 
	
			
		  String USERNAME = putil.getDataFromPropertyFile("Username");
			
			//to fill pass
			String PASSWORD = putil.getDataFromPropertyFile("Password");
			
			//to fill username tf
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			
	        //to send data inside pass
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			
			//submit
			driver.findElement(By.id("submitButton")).click();
			
			
			
		  
	  }
	  
	  @AfterMethod
	  public void AM() throws InterruptedException{
		  // after method is used to signout from application
		  
			WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		  Thread.sleep(3000);
		  
		  wutil.mousehover(driver, image);
			
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
		    Thread.sleep(3000);
		  
	  }
	  @AfterClass
	  public void AC() {
		  
		 // @After class is used to close the browser
		  
		  driver.quit();
		  
	  }
	  
	  @AfterSuite
			public void AS() {
		  
		  System.out.println("disconnect to data base");

			  }
	  
	  
	

}
