package productList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchProduct {
	public static WebDriver driver = null;
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	    //Launch the Online Store Website
		 launchAmazon();
	     //Get href of Products displayed on Home page   
		 getProductNames(); 
	}


	public static void launchAmazon() 
	{
	driver = new FirefoxDriver();
    driver.get("http://www.amazon.in");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void getProductNames() 
	{
	
    List<WebElement> listproduct = driver.findElements(By.xpath(".//*[@class='product-image']/parent::a"));
	    //Iterate through all the products displayed on Home page
    	System.out.println("total: "+ listproduct.size());
	    for (int i=0; i<=listproduct.size()-1; i++)
	    { 
	        String productprop = listproduct.get(i).getAttribute("href");
	        System.out.println("Href value: "+productprop);
	    } 
	}

}
