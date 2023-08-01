package automationFrameWork;

import org.testng.annotations.Test;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class NewTest {
	public String baseUrl = "https://devwcs.ballarddesigns.com/ ";
    String driverPath = "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe";
    public WebDriver driver ; 
    @Test 
  public void  isLogoDisplayed() {
  	  System.out.println("launching chrome browser"); 
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        if (!isDisplay(By.xpath("//*[@id=\"logo1\"]/a"))){
      	  System.out.println("Image not displayed.");
        }
        else
        {
        System.out.println("Image displayed.");
        }
        
        
    }
    public boolean isDisplay(By by){
  	  try{
  	  System.out.print("test" + driver.findElement(by).isDisplayed());
  	  WebElement elementDisply= driver.findElement(by);
  	  
  	  return true;
  	  }
  	  catch(Exception e){
  	  System.out.print("element not displayed");
  	  return false;
  	  }

  	  }
    @Test
   public void signIn()
    {
    	
	  System.out.println("Sign In chrome browser"); 
      System.setProperty("webdriver.chrome.driver",driverPath);
      driver = new ChromeDriver();
      driver.get(baseUrl);
      driver.findElement(By.id("details-button")).click();
      driver.findElement(By.id("proceed-link")).click();
      driver.findElement(By.xpath("//*[@id=\"loginMyAccount\"]/span")).click();
      boolean element = driver.findElement(By.cssSelector("#BDLoginMessageNormal")).isDisplayed();
      if(element){
      System.out.print("displayed successfully");
      }
      else {
          System.out.print("not displayed successfully");

      }
      driver.findElement(By.cssSelector("#logonId")).sendKeys("test@live.com");
      driver.findElement(By.cssSelector("#logonPassword")).sendKeys("Test@123");
      driver.findElement(By.id("logonButton")).click();
      boolean MyAccount = driver.findElement(By.xpath("//*[@id=\"myAccount\"]/a/span")).isDisplayed();
      if(MyAccount){
    	  System.out.print("Logged in successfully");
      }
      else {
          System.out.print("not Logged in successfully");

      }
      String expected = "test";
      String currentUser = driver.findElement(By.id("welcome")).getText().split(",")[1].replace("!", "").trim();
      System.out.print(expected +" " +  currentUser.equals(expected));
      Assert.assertEquals(currentUser, expected,"Actual:"  +currentUser);
    	  
   }
 
    
  @BeforeMethod
  public void beforeMethod() {
  }

}
