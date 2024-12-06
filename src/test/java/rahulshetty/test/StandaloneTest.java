package rahulshetty.test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import rahulshetty.pageobject.Landingpage;


public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		String productname="ZARA COAT 3";
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Vaibhav\\Downloads\\chromedriver-win64 (4)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		Landingpage l=new Landingpage(driver);
		driver.get("https://rahulshettyacademy.com/client");
	       driver.findElement(By.id("userEmail")).sendKeys("vaibhavsyadav1101@gmail.com");
	       driver.findElement(By.id("userPassword")).sendKeys("Nita@1902");
	       driver.findElement(By.id("login")).click();
	       WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3"))); // explicit wait to validate all elements loaded
	       List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
	      WebElement prod=products.stream().filter(product-> 
	      product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);   // stram section  // store produvt habing zara code
	      prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();    //adding to cart product
	     
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))); //message added to cart is displayed  toast is displayed
	      wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	      Thread.sleep(3000);
	      driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();   //click on cart
	      // we have to verify items added into cart
	      List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
	      boolean b=cartproducts.stream().anyMatch(cartprod->  cartprod.getText().equalsIgnoreCase(productname));
	      Assert.assertTrue(b);                                // putting validation to verify product added in cart
	      
	      driver.findElement(By.cssSelector(".totalRow button")).click();  //checkout button
	      
	      Actions a=new Actions(driver);
	      a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	      driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	      driver.findElement(By.cssSelector(".action__submit")).click();            //place order
	      String confirmedmessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	      boolean b1=confirmedmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
	     Assert.assertTrue(b1);
	     driver.close();
	}

}
