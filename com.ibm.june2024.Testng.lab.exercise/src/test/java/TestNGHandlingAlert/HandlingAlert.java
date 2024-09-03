package TestNGHandlingAlert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

public class HandlingAlert { //DO NOT change the class name
        //Use the below declared variable
    public static WebDriver driver;
    public static String baseUrl = "https://webapps.tekstac.com/FormRegistration/EMICalculator.html";
    public static String nameResult;
    
     public static String getNameResult() {
		return nameResult;
	}

	public static void setNameResult(String nameResult) {
		HandlingAlert.nameResult = nameResult;
	}

	// Apply the required annotation
	@BeforeClass
    public WebDriver createDriver() {
    	
//    	driver = DriverSetup.getDriver();
    	driver = new ChromeDriver();
    	driver.get(baseUrl);
   
        //Create driver,store it in static variable driver, navigate to baseUrl and return it
        
        return driver;
    }

     // Apply the required annotations
	@Test
	@Parameters("name")
    public Alert invokePromptAccept(String name)  {
    	// Click on the element to trigger the alert prompt
        // Switch to the alert context
        // Send the provided name to the alert input field
        // Accept the alert to confirm the name input
        // Store the name result in the static variable 'nameResult'
        // Return the alert element
    	
		WebElement ele = driver.findElement(By.cssSelector("p#demo"));
		ele.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();
		
		String nameResult = ele.getText();
		setNameResult(nameResult);
        return alert;
    }

     // Apply the required annotation
	@Test
    public Alert invokePromptDismiss()  {
    	// Click on the element to trigger the alert prompt
        // Switch to the alert context
    	// Cancel the alert
    	// Store the name result in the static variable 'nameResult'
    	// Return the alert element
		
		driver.findElement(By.cssSelector("p#demo")).click();
		Alert alert= driver.switchTo().alert();
		alert.dismiss();
		String nameResult = driver.findElement(By.cssSelector("p#demo")).getText();
		setNameResult(nameResult);
		
		return alert;
    	
    }  
    
    public static void main(String[] args) {
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
 