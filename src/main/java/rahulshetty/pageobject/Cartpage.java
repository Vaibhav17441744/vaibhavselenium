package rahulshetty.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshetty.abstractcomponent.Abstractcomponent;

public class Cartpage extends Abstractcomponent {
	
	
	WebDriver driver;
	public Cartpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(css = ".totalRow button")
	WebElement checkout;
     
	//List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
	public boolean verifyproductdisplay(String productname ) { 
	
    boolean b=cartproducts.stream().anyMatch(cartprod->  cartprod.getText().equalsIgnoreCase(productname));
    return b;
	}
	
	public Checkoutpage gotocheckoutpage() {
		checkout.click();
		return new Checkoutpage(driver);  
		
		
	}
                                
    
    
    
}
