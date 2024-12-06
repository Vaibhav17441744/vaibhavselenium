package rahulshetty.abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshetty.pageobject.Cartpage;

public class Abstractcomponent {
	
	public WebDriver driver;
	  @FindBy(css="button[routerlink*='cart']")
	    WebElement  Cartheader;
	public Abstractcomponent(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);	}
	

	  
	  public void waitforElementToAppear(By findby) throws InterruptedException {
		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		  Thread.sleep(2000);
	  }
	  
	  public void waitForwebElementToAppear(WebElement findBy) throws InterruptedException {
			 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		     wait.until(ExpectedConditions.visibilityOf(findBy));
		    // Thread.sleep(2000);
			}
			

	//  driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();   //click on cart
	  
	  public Cartpage gotocartpage() {
		  Cartheader.click();
		  Cartpage c=new Cartpage(driver); 
		  return c;
	  }

}
