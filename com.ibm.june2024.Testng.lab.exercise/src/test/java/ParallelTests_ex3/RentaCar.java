package ParallelTests_ex3;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.Lists;

public class RentaCar {
    /* Use the below declared variable */
	public static WebDriver driver;
	String baseUrl = "https://webapps.tekstac.com/RentaCar/";
	static String verifytitle;

	public RentaCar(WebDriver driver) { //DO NOT change the Constructor
		this.driver = driver;
	}

	public RentaCar() {
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

