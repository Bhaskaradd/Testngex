package Testng_districtepass_Ex3;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

//ADD the required TestNG annotations on respective methods

//@Listeners(FeatureTest.class)   // Do not change or remove this line
public class Ex3TestNG {
	
	//Use the below declared variable
    public static WebDriver driver;
    String baseUrl = "https://webapps.tekstac.com/SeleniumApp2/Pandemic/DistrictPass.html";
	
	//Apply the required annotation
	public void setUpDriver() {           //DO NOT change the method signature
		
		// Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate 
	    
	    driver = DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
		
    }
	
	//Add data provider annotation with name 'testNGData'
	@Test
	@DataProvider(name="testNGData")
	public Object[][] testNGData() {         //DO NOT change the method signature

	    //Do not change the values
	    return new Object[][] { { "Suresh", "suresh@123.com","122","532","2345", "Chennai", "Male", "123456789123", "Wedding"}};
	    
	}

	//Add data provider annotation with name 'testNGData'
	@Test(dataProvider = "testNGData")
	public void testValidData(String name,String email,String mobile1,String mobile2,String mobile3, 
	            String district, String gender, String aadhaarNo, String reason) throws InterruptedException {
		
		// Apply the array values to the respective form element
		// Test the tabled data against the data specified in the array
		
		
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.cssSelector("input#email")).sendKeys(email);
		driver.findElement(By.id("mobile1")).sendKeys(mobile1);
		driver.findElement(By.id("mobile2")).sendKeys(mobile2);
		driver.findElement(By.id("mobile3")).sendKeys(mobile3);
		
		Select obSelect =new Select(driver.findElement(By.id("district")));
		obSelect.selectByVisibleText(district);
		
		driver.findElement(By.xpath("//*[@value="+gender+"]")).sendKeys(gender);
		driver.findElement(By.id("aadhaar")).sendKeys(aadhaarNo);
		
		Select objSelect =new Select(driver.findElement(By.id("reason")));
		objSelect.selectByVisibleText(reason);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String Name = driver.findElement(By.id("nameDisplay")).getText();
		Assert.assertEquals(name,Name);		
		
		String Email = driver.findElement(By.id("emailDisplay")).getText();		
		Assert.assertEquals(email,Email);
		
//		String svf = driver.findElement(By.id("mobileDisplay")).getText();
//		Assert.assertEquals(email,Email);
		
		
		String District = driver.findElement(By.id("districtDisplay")).getText();
		Assert.assertEquals(district,District);
		String Gender = driver.findElement(By.id("genderDisplay")).getText();
		Assert.assertEquals(gender,Gender);
		String  aad= driver.findElement(By.id("aadhaarDisplay")).getText();
		Assert.assertEquals(aadhaarNo,aad);
		String Reason = driver.findElement(By.id("reasonDisplay")).getText();
		Assert.assertEquals(reason,Reason);
		
	}
	
    //PLEASE DO NOT MODIFY THE CODE IN 	invokeTest() METHOD 
	public void invokeTest() {
	    
	    try {
			TestNG testng = new TestNG();
			List<String> suites = Lists.newArrayList();
			suites.add("testng.xml");
			
			testng.setTestSuites(suites);
			testng.run();		
		
		} catch (Exception e) {
			
		} 
	    
	}
	
	public static void main(String[] args) {
		Ex3TestNG test=new Ex3TestNG();
		// Add Required Code
		test.invokeTest();
	}

}
