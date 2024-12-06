package rahulshetty.test;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshetty.pageobject.Cartpage;
import rahulshetty.pageobject.Checkoutpage;
import rahulshetty.pageobject.Confirmationpage;
import rahulshetty.pageobject.Landingpage;
import rahulshetty.pageobject.Productcataloge;
import rahulshetty.testcomponents.Basetest;


public class StandaloneTest2 extends Basetest {

	@Test
	public void submitorder() throws IOException, InterruptedException {
		String productname="ZARA COAT 3";
		Productcataloge p=l.loginApplication("vaibhavsyadav1101@gmail.com","Nita@1902");
		List<WebElement> products=p.getproductlist();
		p.addprodtocart(productname);
		Cartpage c=p.gotocartpage();                         //click on cart
	                                                           // we have to verify items added into cart
		boolean b2=c.verifyproductdisplay(productname);
	    Assert.assertTrue(b2);                                // putting validation to verify product added in cart
	    Checkoutpage checkout=c.gotocheckoutpage();
	    checkout.selectCountry("india");
	    Confirmationpage confirm=checkout.submitorder();
	     String message=confirm.verifyconfirmationmessage();
	     boolean b1=message.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
	     Assert.assertTrue(b1);
	     
	}

	

}
