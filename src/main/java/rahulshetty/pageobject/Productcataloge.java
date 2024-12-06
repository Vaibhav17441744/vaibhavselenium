package rahulshetty.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshetty.abstractcomponent.Abstractcomponent;

public class Productcataloge extends Abstractcomponent{

	WebDriver driver;
	public Productcataloge(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	 By findby=By.cssSelector(".mb-3");
	 By addtocart=By.cssSelector(".card-body button:last-of-type");
	 By toastmessage=By.cssSelector("#toast-container");
	   
	public List<WebElement> getproductlist() throws InterruptedException
	{
		
		waitforElementToAppear(findby);
		return products;
	}
	
	public WebElement getproductbyname(String productname) throws InterruptedException {
		 WebElement prod=getproductlist().stream().filter(product-> 
		    product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null); 
		 return prod;
		
	}
	
	public void addprodtocart(String pname) throws InterruptedException {
		
		WebElement product1=getproductbyname(pname);
		product1.findElement(addtocart).click();
		waitforElementToAppear(toastmessage);
		
	}
	
	
	 
   
	
	
}
