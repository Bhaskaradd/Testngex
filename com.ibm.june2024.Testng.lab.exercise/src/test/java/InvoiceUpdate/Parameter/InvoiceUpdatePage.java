package InvoiceUpdate.Parameter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class InvoiceUpdatePage {

	public WebDriver driver;

	public InvoiceUpdatePage(){}
	public InvoiceUpdatePage(WebDriver driver) {
	    this.driver = driver;
	}

	public void setName(String name) {
	    // Using the sendKeys() method, fill WebElement 'Name' with 'name'.
		
		WebElement customerName = driver.findElement(By.id("name"));
		customerName.sendKeys(name);
	}

	public void setInvoiceNumber(String invoiceNumber) {
	   // Using the sendKeys() method, fill WebElement 'Invoice Number' with 'invoiceNumber'.
		WebElement InvoiceNumber = driver.findElement(By.id("number"));
		InvoiceNumber.sendKeys(invoiceNumber);
	}

	public void setUserType(String userType) {
	   // Using the click() method, fill WebElement 'User Type' with 'userType'.
		if(userType.equals("Old User"))
			driver.findElement(By.id("oldUser")).click();
			else if(userType.equals("New User"))
			   driver.findElement(By.id("newUser")).click();
			
		
	}

	public void setStatus(String status) {
	    // Using the click() method, fill WebElement 'Status' with 'status'.
		if(status.equals("Pending"))
		driver.findElement(By.xpath("//input[@name='status']")).click();
		 else if(status.equals("Approved"))
			 driver.findElement(By.xpath("(//input[@name='status'])[2]")); 
		 		else if(status.equals("Rejected"))
		 			driver.findElement(By.xpath("(//input[@name='status'])[3]"));
			
	}

	public void setCategory(String category) {
	    // Using the selectByVisibleText() method, select the drop down box of the 'Category' with 'category'.
		WebElement Category = driver.findElement(By.tagName("select")); 
		new Select(Category).selectByVisibleText(category); 
	
	}

	public void setAmount(String amount) {
	   // Using the sendKeys() method, fill WebElement 'Amount' with 'amount'.
		WebElement Amount = driver.findElement(By.name("amount"));
		Amount.sendKeys(amount);
	}

	public void setMobileNumber(String mobileNumber) {
	    // Using the sendKeys() method, fill WebElement 'Mobile Number' with 'mobileNumber'.
		WebElement num = driver.findElement(By.name("num"));
		num.sendKeys(mobileNumber);
	}

	public void setComment(String comment) {
	   // Using the sendKeys() method, fill WebElement 'Comment' with 'comment'.
		
		WebElement Comment = driver.findElement(By.tagName("textarea"));
		Comment.sendKeys(comment);
	}

	public void clickSubmitButton() {
	   // Click the 'register' button using click() method.
		
		WebElement register = driver.findElement(By.id("submit"));
		register.click();
	}

	public String getResult() {
	   
		String Result = driver.findElement(By.id("result")).getText();
		return Result;
		// Return the 'Result' value after form submit
	    
	    
	}
}
