package rahulshetty.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshetty.abstractcomponent.Abstractcomponent;

public class Confirmationpage extends Abstractcomponent {
	WebDriver driver;
	public Confirmationpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".hero-primary")
	WebElement confirmedmessage;
	
	// String confirmedmessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
    // boolean b1=confirmedmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
	
	public String verifyconfirmationmessage() {
		
		String confirmmessage=confirmedmessage.getText();
		return confirmmessage;
		
	}
}
