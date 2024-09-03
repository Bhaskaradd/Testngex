package HighTechService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import org.testng.annotations.Listeners;


//@Listeners(FeatureTest.class)
public class TestValidFormValues extends DriverSetup{

	public static WebDriver driver;
	private static ACServiceDetails formObj;
	

	private static String resultTxt;
	public static String[] xmlValidData = null;
	public static String baseUrl="https://webapps.tekstac.com/HighTechServiceCenter/Hightechservice.html";
	

	
	public static String getResultTxt() {
		return resultTxt;
	}

	public static void setResultTxt(String resultTxt) {
		TestValidFormValues.resultTxt = resultTxt;
	}
	
	//Apply the required annotation
	@BeforeClass
	public WebDriver setUp() {	    		
		//create the driver using method 'getDriver' in class DriverSetup.
		//Assign it to the variable 'driver' and navigate to the baseUrl
		driver = new ChromeDriver();
//		driver =DriverSetup.getDriver();
		driver.get(baseUrl);
		//DO NO CHANGE THE BELOW OBJECT CREATION LINE	
	    formObj= new ACServiceDetails(driver);				
		return driver;
	}
	
	
	// Use Data Provider on this method
	@DataProvider(name="getData")
	public static String[][] getXMLData() throws Exception {
	    String fileName = "acService.xml"; // Provide the file name here
	    String[][] xmlValidData = XMLUtils.readFile(fileName);
	    return xmlValidData;
	}
	
	//Apply the required annotation
	@Test(dataProvider="getData")
	public void testValidACServiceDetails(String name, String mobileNo, String emailId, String address, String acType, String serviceType, String maintenance, String duration) throws Exception {		
		
		//Using formObj call the method 'setCustomerName' and pass the 'name' value passed as data provider
		
		formObj.setCustomerName(name);
		formObj.setMobileNumber(mobileNo);
		formObj.setEmailId(emailId);
		formObj.setAddress(address);
		formObj.setACType(acType);
		formObj.setServiceType(serviceType);
		formObj.setYearlyMaintenance(maintenance);
		formObj.setDuration(duration);
		formObj.submitForm();
		//Using formObj call the method 'setMobileNumber' and pass the 'mobileNo' value passed as data provider
		//Using formObj call the method 'setEmailId' and pass the 'emailId' value passed as data provider
		//Using formObj call the method 'setAddress' and pass the 'address' value passed as data provider
		//Using formObj call the method 'setACType' and pass the 'acType' value passed as data provider
		//Using formObj call the method 'setServiceType' and pass the 'serviceType' value passed as data provider
		//Using formObj call the method 'setYearlyMaintenance' and pass the 'maintenance' value passed as data provider
		//Using formObj call the method 'setDuration' and pass the 'duration' value passed as data provider
	
		// Using 'formObj' call the method, 'submitForm' and submit the form
	
	    // Using 'formObj' invoke the method 'getResult' and get the confirmation message. (use getText() to get the confirmation message)
	    // Store it in the static variable 'resultTxt' 
	    // And set the 'resultTxt' value in the method 'setResultText' and print the same here
		
		resultTxt= formObj.getResult().getText();
		
		formObj.setResultText(resultTxt);
		
	
	  		
		
    }	 	  	  		 	     	     	      	 	
    
     //Apply the required annotation
	
	@Test(enabled = false)
	 public void closeBrowser() {
	    
		//close the driver
		driver.quit();
		//For better performance keep the following line commented.
//			driver.close();
	}
}

