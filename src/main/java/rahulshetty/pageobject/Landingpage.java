package rahulshetty.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshetty.abstractcomponent.Abstractcomponent;

public class Landingpage extends Abstractcomponent {
public WebDriver driver;
	public Landingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    @FindBy(id="userEmail")
    WebElement UserEmail;
    
    @FindBy(id="userPassword")
    WebElement  UserPassword;
    
    @FindBy(id="login")
    WebElement login;
    
    @FindBy(css="[class*='flyInOut']")
	 WebElement errormessage;
    
    public Productcataloge loginApplication(String email,String pass) {
    	
    	UserEmail.sendKeys(email);
    	UserPassword.sendKeys(pass);
    	login.click();
    	Productcataloge p=new Productcataloge(driver);
    	return p;
    }
	
    public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
    public String getErrorMessage() throws InterruptedException {
    	waitForwebElementToAppear(errormessage);
		return errormessage.getText();
	}
    
   
	

}
