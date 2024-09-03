package CustomerRegistration_PrioritywithGroup;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CustomerRegistrationPage {
	public WebDriver driver;

	//Constructors are already given. If required, you can add more code into it but do NOT remove the existing code.

	public CustomerRegistrationPage(WebDriver driver){
		this.driver= driver;
		
	}      
    public void setName(String name) {
    	// Locate the WebElement corresponding to 'Name' using specific locators.                                                    
        // Using sendKeys() method, fill WebElement 'Name' with 'name'
    	
    	WebElement Name = driver.findElement(By.id("name"));
    	Name.sendKeys(name);
    	
    }
    
    public void setMobileNumber(String mobileNumber) {
    	// Locate the WebElement corresponding to 'Mobile No' using specific locators.                                                    
        // Using sendKeys() method, fill WebElement 'Mobile No' with 'mobile'
    	
    	
    	WebElement MobileNo = driver.findElement(By.id("mobile"));
    	MobileNo.sendKeys(mobileNumber);
    	
    	
    }
    
    public void setDOB(String dob) {
    	// Locate the WebElement corresponding to 'DOB' using specific locators.                                                    
        // Using sendKeys() method, fill WebElement 'DOB' with 'dob'
    	WebElement DOB = driver.findElement(By.cssSelector("input#dob"));
    	DOB.sendKeys(dob);
    	
    	
    }
    
    public void setGender(String gender) {
    	// Locate the WebElement radio button corresponding to 'Gender' using specific locators.
    	// If the gender is "Male", it clicks on the corresponding radio button. If the gender is "Female", it clicks on the female radio button.
        
    	if(gender.equals("Male"))
    		driver.findElement(By.cssSelector("input#male")).click();
    	else if(gender.equals("Female"))
    	    driver.findElement(By.cssSelector("input#female")).click();
    	
    	
    }

    public void setAddress(String address) {
    	// Locate the WebElement corresponding to 'Address' using specific locators.                                                    
        // Using sendKeys() method, fill WebElement 'Address' with 'address'
    	
    	WebElement Address = driver.findElement(By.cssSelector("textarea#address"));
    	Address.sendKeys(address);
    }
     
    public void clickSubmitButton() {
    	// Locate the Web Element corresponding to the 'Register' (Button) using specific locators.
        // Click the 'Register' button
    	WebElement Register = driver.findElement(By.cssSelector("button#register"));
    	Register.click();
    }

	public String getResult() {
		// Locate the WebElement displaying the resultant message after registration and return it
		// use getText() to get the registration message
		String errorMessage = driver.findElement(By.id("errorMessage")).getText();
		return errorMessage;		 		 
	}

}
