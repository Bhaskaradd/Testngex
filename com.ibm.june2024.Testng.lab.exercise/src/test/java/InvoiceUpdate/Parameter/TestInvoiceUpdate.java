package InvoiceUpdate.Parameter;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


public class TestInvoiceUpdate extends DriverSetup {

    public static WebDriver driver;
    private static InvoiceUpdatePage formObj;
    private static String resultTxt;
    
    public static String baseUrl = "https://webapps.tekstac.com/InvoiceUpdates/";

    public static String getResultTxt() {
        return resultTxt;
    }

    public static void setResultTxt(String resultTxt) {
        TestInvoiceUpdate.resultTxt = resultTxt;
    }

    // Apply the required annotation
    @BeforeClass
	public WebDriver setUp() {
         // Invoke the getDriver() method from the DriverSetup File
        // Store it in static variable 'driver', navigate to the base url using get method
        
    	driver = DriverSetup.getDriver();
//    	driver = new ChromeDriver();
        driver.get(baseUrl);
        //DO NO CHANGE THE BELOW OBJECT CREATION LINE
        formObj = new InvoiceUpdatePage(driver);
        return driver;
    }

    // Apply the required annotation
    @Test
    @Parameters({"customerName","invoiceNumber","userType","status","category","amount","mobileNumber","comments"})
	public void testInvoiceUpdateDetails( String customerName, String invoiceNumber, String userType, String status,
    		 String category, String amount, String mobileNumber, String comments) throws Exception {

        //Using 'formObj' call the method 'setName' and pass the 'customerName' value read from the Parameters annotation
		//Using 'formObj' call the method 'setInvoiceNumber' and pass the 'invoiceNumber' value read from the Parameters annotation
		//Using 'formObj' call the method 'setUserType' and pass the 'userType' value read from the Parameters annotation
		//Using 'formObj' call the method 'setStatus' and pass the 'status' value read from the Parameters annotation
		//Using 'formObj' call the method 'setCategory' and pass the 'category' value read from the Parameters annotation
		//Using 'formObj' call the method 'setAmount' and pass the 'amount' value read from the Parameters annotation
		//Using 'formObj' call the method 'setMobileNumber' and pass the 'mobileNumber' value read from the Parameters annotation
		//Using 'formObj' call the method 'setComment' and pass the 'comments' value read from the Parameters annotation
		//Using 'formObj' call the method 'clickSubmitButton' and store the result in the static variable 'resultTxt'
    	formObj.setName(customerName);
    	formObj.setInvoiceNumber(invoiceNumber);
    	formObj.setUserType(userType);
    	formObj.setStatus(status);
    	formObj.setCategory(category);
    	formObj.setAmount(amount);
    	formObj.setMobileNumber(mobileNumber);
    	formObj.setComment(comments);
    	formObj.clickSubmitButton();
    	resultTxt =formObj.getResult();

    }

    // Apply the required annotation
    @Test(enabled = false)
    public void closeBrowser() {
        // close the driver
        
    }
}