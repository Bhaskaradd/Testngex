package TestNGAnnotationWithPriority;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

//===========================Problem statement================================================
/*

Objective:
To understand the basic selenium TestNG related annotations and concepts. The purpose of this exercise is to add required annotations and execute the test sequence using TestNG. So we are not focusing on any real data testing.

Test Procedure:

Use the template code.

Don't make any changes in DriverSetup file.

Only in the suggested section add the code to,

1) Using the method 'setupDriver'   => create an instance of the driver using getWebDriver() method defined in DriverSetup. Annotate this with an annotation related to 'suite' so that this method gets executed first.

2) Method, 'pageNavigation' MUST be getting executed before first @Test method execution. Apply the required annotation.

3) For methods 'setLogin' and 'addPayee' specify the 'priority' in the 'Test' annotation.
    'setLogin'    => priority '-1'

    'addPayee'  => priority '0'

4) Method 'setFundTransfer' must be executed ONLY if the methods 'setLogin' and 'addPayee' are executed. Apply the required annotation.

5) Method, 'setLogout' MUST be getting executed after all test methods in the current class have been run. Apply the required annotation.

6) Method 'closeBrowser' MUST be executed last. Apply the  required 'suite' related annotation. In this method, close the driver.

7) IMPORTANT : Using the method 'invokeTest', invoke the test using 'TestNG'. If 'TestNG is NOT applied, your submission will get '0'. Add test  class entry in testng.xml file.



*/
//ADD the required TestNG annotations on respective methods

//@Listeners(FeatureTest.class)  // Do not change or remove this line
public class Ex2TestNG {
	
	//Use the below declared variables
	public static WebDriver driver;
	String username, password; 
	String payeeName, payeeAccount;
	String amount;
	
	//Apply the required annotation
	public WebDriver createDriver() {
	    
		// Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver' 
	    
		driver = DriverSetup.getWebDriver();
	    return driver;
	}
	
	//Apply the required annotation
	@BeforeClass
	public void pageNavigation(){
	    System.out.println("pageNavigation");
	    
	}
	
	//Apply the required annotation
	@Test(priority=-1)
	public void setLogin(){
	    System.out.println("setLogin");
	    username="admin";
	    password="admin";
	}
	
	//Apply the required annotation 
	@Test(priority=0)
	public void addPayee() {
		System.out.println("addPayee");
		payeeName="John";
		payeeAccount="01001234";
	}
	
	//Apply the required annotation 
	@Test(dependsOnMethods= {"setLogin","addPayee"})
	public void setFundTransfer() {
		System.out.println("setFundTransfer");
		amount="2000";
	}
	
    //Apply the required annotation 
	@AfterClass
	public void setLogout(){
	    System.out.println("setLogout");
	    
	}
	
	//Apply the required annotation 
	@AfterSuite
	public void closeBrowser(){
	    System.out.println("closeBrowser");
	}
	
	public void invokeTest() {
		//code to invoke test using TestNG
		
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
	    
	    Ex2TestNG ex2=new Ex2TestNG();
	    // Add Required Code 
	    ex2.invokeTest();
	}

}

