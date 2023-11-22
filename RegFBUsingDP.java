package TestNG;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//Assignment 141
// Use Data Provider annotation for the first four fields of the Facebook page

public class RegFBUsingDP 
{
	@DataProvider(name="registrationdetails")
	public Object[][]registration()
	{
		Object[][] reg = new Object[3][4];           //Array declaration and initialization 
		reg[0][0]= "Anamica";                       //Rows 0,1,2   Columns 0,1,2,3  
		reg[0][1]= "Mohan";                        //four fields so fix number of columns as 4
		reg[0][2]= "9894707654";                  //Rows decide anything and total 3*4=12
		reg[0][3]= "Anamo123";
		reg[1][0]= "Teddy";
		reg[1][1]= "Bear";
		reg[1][2]= "9894723456";
		reg[1][3]= "TedBe456";
		reg[2][0]= "Tom";
		reg[2][1]= "Jerry";
		reg[2][2]= "9894034987";
		reg[2][3]= "TomJe987";
		return reg;
	}
	@DataProvider(name="login details")           //2 DataProvider annotations
	public Object[][]login()
	{
		Object[][] data = new Object[2][2];      //email and password 2 fields
		data[0][0]="John@gmail.com";
		data[0][1]="John123";
		data[1][0]="Mag@gmail.com";
		data[1][1]="Mag456";
		return data;
	}
	@Test(dataProvider="registrationdetails")   //calling or consuming only registration details
	public void facebook(String firstName,String lastName,String mobileNumber, String password)throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/signup");
		
		WebElement firstField = driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
		firstField.sendKeys(firstName);
		Thread.sleep(3000);
		
		WebElement secondField = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		secondField.sendKeys(lastName);
		Thread.sleep(3000);
		
		WebElement thirdField = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		thirdField.sendKeys(mobileNumber);
		Thread.sleep(3000);
		
		WebElement fourthField = driver.findElement(By.xpath("//input[@autocomplete='new-password']"));
		fourthField.sendKeys(password);
		Thread.sleep(3000);
		
		driver.quit();
	}
}

//3 times execution as 3 rows
//PASSED: TestNG.RegFBUsingDP.facebook("Anamica", "Mohan", "9894707654", "Anamo123")
//PASSED: TestNG.RegFBUsingDP.facebook("Tom", "Jerry", "9894034987", "TomJe987")
//PASSED: TestNG.RegFBUsingDP.facebook("Teddy", "Bear", "9894723456", "TedBe456")
