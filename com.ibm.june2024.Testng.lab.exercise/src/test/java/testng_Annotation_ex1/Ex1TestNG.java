package testng_Annotation_ex1;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.collections.Lists;


//===========================Problem statement================================================
/*

Description
Objective:

To understand the basic selenium TestNG related annotations.

Test Procedure:
Use the template code.
Don't make any changes in DriverSetup file.
Only in the suggested section add the code to,

1) Create an instance of the driver using getWebDriver() method defined in DriverSetup . Use appropriate annotation to invoke this method before the test method execution starts.

2) Add the methods, 'testInsert' and 'testUpdate' to 'database' groups using annotation.

3)  Method 'groupDependent' must be executed ONLY if all the methods of database group ('testInsert' and 'testUpdate') are executed. Apply the required annotation.

4) Method 'closeBrowser' MUST be executed at the last step of test method execution. Apply the  appropriate annotation. In this method, close the driver.





*/
//=============================================================================================
//ADD the required TestNG annotations on respective methods
public class Ex1TestNG {         //DO NOT Change the class Name
	
	//Do NOT change these below declarations.
	public static WebDriver driver; 

	
	// Apply the required annotation
	@BeforeMethod
	public WebDriver createDriver() {         //DO NOT change the method signature
		
		// Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver'
	    
	    driver = DriverSetup.getWebDriver();
	    
	    return driver;
		
    }
	
	// Apply the required annotation
	@Test(groups=("database"))
	public void testInsert() {         //DO NOT change the method signature
		System.out.println("testInsert");
	}
	
	// Apply the required annotation
	@Test(groups=("database"))
	public void testUpdate() {    //DO NOT change the method signature      
		System.out.println("testUpdate");
	}
	
	// Apply the required annotation
	 @Test(dependsOnGroups = { "database" })
	public void groupDependent() {               //DO NOT change the method signature
		System.out.println("groupDependent");
	}
	
	// Apply the required annotation
	@AfterMethod
	public void closeBrowser() {         //DO NOT change the method signature
		System.out.println("closeBrowser");
	}
	
	public static void main(String[] args) {          //DO NOT change the method signature
	
		Ex1TestNG page=new Ex1TestNG();
	    
	    //Implement the required code
	    
	}
}
