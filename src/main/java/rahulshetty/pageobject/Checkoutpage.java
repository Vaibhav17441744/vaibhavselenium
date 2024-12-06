package rahulshetty.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshetty.abstractcomponent.Abstractcomponent;

public class Checkoutpage extends Abstractcomponent {
	WebDriver driver;
	public Checkoutpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".action__submit")
	WebElement submit;
	
	@FindBy(css = "input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectindia;	
	
	
	

     
     public void selectCountry(String countryn) throws InterruptedException {
    	 
    	 Actions a=new Actions(driver);
    	 a.sendKeys(country,countryn).build().perform();
    	 waitforElementToAppear(By.cssSelector(".ta-results"));
    	selectindia.click();
    
     }
     
     public Confirmationpage submitorder() {
             submit.click();
             return new Confirmationpage(driver);
     }
    
}
