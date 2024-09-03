package CustomerRegistration_PrioritywithGroup;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestCustomerRegistration extends DriverSetup{

    public static WebDriver driver;
    public static String baseUrl = "https://webapps.tekstac.com/CustomerRegistration_4284/";
    public static CustomerRegistrationPage customer;
    private static String resultTxt;
    
    public static String getResultTxt() {
		return resultTxt;
	}

	public static void setResultTxt(String resultTxt) {
		TestCustomerRegistration.resultTxt = resultTxt;
	}
	
    //Apply the required annotation
    @BeforeClass
	public WebDriver setUp() {
        // Invoke the getDriver() method from the DriverSetup File
    	
        // Store it in static variable 'driver', navigate to the base url using get method
//    	driver =DriverSetup.getDriver();
    	driver = new ChromeDriver();
    	driver.get(baseUrl);
        
        //DO NO CHANGE THE BELOW OBJECT CREATION LINE	
        customer = new CustomerRegistrationPage(driver);
		return driver;
    }

     //Apply the required annotation
    @DataProvider(name = "testNGData")
	public Object[][] testNGData() {
        // Do not change the values
        return new Object[][] { { "Jeny Doe", "8544338974", "20-07-1998", "Female", "London" } };
    }

    //Apply the required annotation
    @Test(dataProvider = "testNGData",groups = "Registration",priority = 1)
    public void enterData(String name, String mobileNo, String dob, String gender, String address) throws InterruptedException {
        
    	//Using 'customer' call the method 'setName' and pass the 'name' value read 
		//Using 'customer' call the method 'setMobileNumber' and pass the 'mobileNo' value 
		//Using 'customer' call the method 'setDOB' and pass the 'dob' value 
		//Using 'customer' call the method 'setGender' and pass the 'gender' value 
		//Using 'customer' call the method 'setAddress' and pass the 'address' value 
		//Using 'customer' call the method 'clickSubmitButton' 
    	customer.setName(name);
    	customer.setMobileNumber(mobileNo);
    	customer.setDOB(dob);
    	customer.setGender(gender);
    	customer.setAddress(address);
    	customer.clickSubmitButton();    	
    	
    }
    
    @Test(groups = "Validation",priority =2,dependsOnGroups = "Registration")
   //Apply the required annotation
    public void formValidationTest() {
        // Using 'customer' invoke the method 'getResult' and get the registration message. 
	    // Store it in the static variable 'resultTxt' 
    	
    	resultTxt =customer.getResult();
    	System.out.println(resultTxt);
	
    }

     //Apply the required annotation
    @Test(enabled = false)
    public void cleanup() {
        // Close the browser here
    	driver.close();
        
    	
    }

}