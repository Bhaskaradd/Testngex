package ParallelTests_ex3;


//===========================Problem statement================================================
/*
Objective:

To understand the basic TestNG concepts, execute parallel tests, and run multiple test classes using a TestNG XML file.
Description:

Two web pages, 'Rent a Car' and 'Cosmo Bank' application, will be used. Invoke two browsers using the "Parallel tests" concept in the testng.xml file and verify that the page titles are the same.

Testing url:

https://webapps.tekstac.com/RentaCar/

https://webapps.tekstac.com/COSMOBank/Cosmo.html

Test Procedure:

1. 'DriverSetup.java' is completely implemented. Use the method 'getDriver' wherever required. 

2. "RentaCar.java" Fill the following methods with the required code. 


Method Name 

 Description

public WebDriver setupDriver() 	 
Add 'BeforeClass' annotation
Method to invoke the driver. The driver object should be stored in the static variable 'driver' and return it
 public void getPageTitle()	 
Add 'Test' annotation.
Get the page title of the Web page and store it into the 'verifytitle'

2. "CosmoBank.java" Fill the following methods with the required code.


Method Name 

 Description

 public WebDriver setupDriver() 	
Add 'BeforeClass' annotation
 Method to invoke the driver. The driver object should be stored in the static variable 'driver' and return it
  public void getPageTitle()	
Add 'Test' annotation. 
Get the page title of the Web page and store it into the 'verifytitle'


3. TestNG.xml

In the testng.xml file, add the required class names and the parallel attribute to run the test cases.

*/
//================================================================================================



import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.Lists;

public class CosmoBank {
        /* Use the below declared variable */
	public static WebDriver driver;
	String baseUrl = "https://webapps.tekstac.com/COSMOBank/Cosmo.html";
	static String verifytitle;

	public CosmoBank(WebDriver driver) { //DO NOT change the Constructor
		this.driver = driver;
	}

	public CosmoBank() {
	}
	
	public static String getverifytitle() {
    return verifytitle;

	}

	//Add required annotation
	@BeforeClass
	public WebDriver setupDriver() {
    // Call the getDriver() Method to invoke the driver. 
    // The driver object should be stored in the static variable and Navigate to URL and return it.	
		driver=	DriverSetup.getDriver();
		driver.get(baseUrl);	
	    return driver;
	}
	

    //Add required annotation
	@Test
	public void getPageTitle() {
	 //Get the page title of the Web page and store it into the 'verifytitle'
		verifytitle=driver.getTitle();
	
	}

	public static void main(String[] args) {  // Do not change/Modify the Method Signature.
		try {
			TestNG testng = new TestNG();
			List<String> suites = Lists.newArrayList();
			suites.add("testng.xml");

			testng.setTestSuites(suites);
			testng.run();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

