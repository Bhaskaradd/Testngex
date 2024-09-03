package HighTechService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class ACServiceDetails
{
    /* Use the below declared variable */
    public static WebDriver driver;
    public static WebElement element;
	
	//DO NOT change
    //	public ACServiceDetails(){}
	
	//DO NOT change the constructor
	public ACServiceDetails(WebDriver driver) {
		this.driver= driver;
	}
	
    public void setCustomerName(String customerName) {                                                
        
    // Locate the WebElement corresponding to 'Customer Name' using specific locators.                                                    
    // Using sendKeys() method, fill WebElement 'Customer Name' with 'customerName'
       	
    WebElement CustomerName =	driver.findElement(By.id("customerName"));
    CustomerName.sendKeys(customerName);
    	
	}

	public void setMobileNumber(String mobile) {
     // Locate the WebElement corresponding to 'Mobile Number' using specific locators.                                                    
     // Using sendKeys() method, fill WebElement 'Mobile Number' with 'mobile'
		WebElement MobileNumber = driver.findElement(By.cssSelector("input#mobileNumber"));
		MobileNumber.sendKeys(mobile);
	}	 	  	      		      	   	     	     	 	
	
	public void setEmailId(String emailId) {
	// Locate the WebElement corresponding to 'Email ID'  using specific locators.                                                    
    // Using sendKeys() method, fill WebElement 'Email ID' with 'emailId'
		WebElement EmailID =driver.findElement(By.id("email"));
		EmailID.sendKeys(emailId);
	}
	
	public void setAddress(String address) {
	// Locate the WebElement corresponding to 'Address'  using specific locators.                                                    
    // Using sendKeys() method, fill WebElement 'Address' with 'address'
		
	WebElement Address= driver.findElement(By.id("address"));
	Address.sendKeys(address);
	
	}
	
	public void setACType(String acType) {
	// Locate the WebElement corresponding to 'AC Type' using specific locators.                                                    
    // Using sendKeys() method, fill WebElement 'AC Type' with 'acType'
		
	WebElement ACType =	driver.findElement(By.xpath("//*[@id='acType']"));
	
	ACType.sendKeys(acType);
	
		
	}
	
	public void setServiceType(String serviceType) {
		
	// Locate the Web Element corresponding to the 'Service Type' using specific locators and click 'Cleaning' or 'Repair' or 'Gas Refill' based on the parameter 'serviceType'.
	
		if(serviceType.equals("Cleaning"))

			driver.findElement(By.id("cleaning")).click();

		else if(serviceType.equals("Repair"))

			driver.findElement(By.id("repair")).click();

		else if(serviceType.equals("Gas Refill"))

			driver.findElement(By.id("gas_refill")).click();
	
	}
	
	public void setYearlyMaintenance(String maintenance) {
		
	// Locate the Web Element corresponding to the 'Yearly Maintenance' using specific locators and click 'Yes' or 'No' based on the parameter 'maintenance' .
		if(maintenance.equals("Yes"))

			driver.findElement(By.id("yes")).click();

		if(maintenance.equals("No"))

			driver.findElement(By.id("no")).click();
	}
	
	public void setDuration(String duration)
	{
	// Locate the Web Element corresponding to the 'Duration In Months' using specific locator 
    // Using sendKeys() method, fill WebElement 'Duration In Months' with 'duration'
		
		WebElement	DurationInMonths =driver.findElement(By.id("duration"));
		
		DurationInMonths.sendKeys(duration);
	}
	
	public void submitForm() {
		
    // Locate the Web Element corresponding to the 'SUBMIT' (Button) using specific locators.
    // Click the 'SUBMIT' button
		
		driver.findElement(By.id("submit")).click();
	}
	
	public WebElement getResult() {                                                
		    	
		// Locate the WebElement displaying the success message 'result' after form submit and return it
		
		WebElement result = driver.findElement(By.id("result"));
		
        return result;
	}

	public void setResultText(String resultTxt) {
		// TODO Auto-generated method stub
		System.out.println(resultTxt);
		
	}
}
	 	  	      		      	   	     	     	 	
