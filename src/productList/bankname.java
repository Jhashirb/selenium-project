package productList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class bankname {
	public static WebDriver driver = null;
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	    //Launch the Online Store Website
		launchsite();
	    //Get bank names displayed on the page   
		getbanknames(); 

	}

	public static void launchsite() 
	{
	driver = new FirefoxDriver();
    driver.get("https://www.theswiftcodes.com/malaysia/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void getbanknames() 
	{
    	// Get the table 
    	WebElement table = driver.findElement(By.xpath(".//*[@class='swift']")); 

    	// Get all the TR elements from the table 
    	List<WebElement> allRows = table.findElements(By.tagName("tr"));
    	 
    	System.out.println(allRows.size());
    	// And iterate over rows, getting the bank names
		for(int i=1;i<=allRows.size();i++) 
		 {
			try
		    {
				List<WebElement> allColumnsInRow = allRows.get(i).findElements(By.tagName("td"));			  
				int columns_count = allColumnsInRow.size();
				String celtext = allColumnsInRow.get(1).getText();
				//System.out.println("Bank Name :" +celtext);
				String swiftcode = allColumnsInRow.get(4).getText();
				System.out.println("Bank Name :" +celtext+ "Swift Code :"+swiftcode);
		    }
		    catch(Exception e)
		    {

		    }
		 }
	}
	
	
}
