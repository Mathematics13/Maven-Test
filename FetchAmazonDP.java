package TestNG;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//Assignment 137
//Fetch Username , Password in Amazon login using Data Provider annotation

public class FetchAmazonDP 
{
	@DataProvider(name="Login Credentials")
	public Object [][]loginData()
	{
		//return new Object[3][2];                          //2 fields username and password which is column
	                                                            
		//Rows as per your wish
		Object[][] credentials = new Object[3][2];         //3 rows so 3 times execution
		credentials[0][0] = "grass@gmail.com";
		credentials[0][1] = "hello123";
		credentials[1][0] = "grass2@gmail.com";
		credentials[1][1] = "hi456";
		credentials[2][0] = "grass4@gmail.com";
		credentials[2][1] = "come123";
		return credentials;
	}
	@Test(dataProvider="Login Credentials")
	public void testCase(String username, String password) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		Thread.sleep(3000);
		
		WebElement email= driver.findElement(By.xpath("//input[@id='ap_email']"));
		email.sendKeys(username);                             //Give the above parameters inside sendKeys
		Thread.sleep(3000);
		
		WebElement cont= driver.findElement(By.xpath("//input[@type='submit']"));
		cont.click();
		Thread.sleep(3000);
		
		WebElement pwd= driver.findElement(By.id("ap_password"));
		pwd.sendKeys(password);                               //Give the above parameters inside sendKeys
		Thread.sleep(3000);
		
		WebElement signInButton= driver.findElement(By.id("signInSubmit"));
		signInButton.click();
		Thread.sleep(3000);
		
		driver.quit();
		
	}
}
