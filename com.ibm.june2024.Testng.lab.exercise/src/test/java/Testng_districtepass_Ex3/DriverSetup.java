package Testng_districtepass_Ex3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverSetup {  // DO NOT CHANGE THE CLASS NAME
    
    private static WebDriver driver;
    
    public static WebDriver getWebDriver() {    // DO NOT CHANGE THE METHOD SIGNATURE
	
	    System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		driver = new FirefoxDriver();
	    return driver;

	}
}
