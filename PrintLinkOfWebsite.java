package TestNG;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//Assignment 146
//WAP to print the link of any website

public class PrintLinkOfWebsite 
{
	 @Test
	 public void linksOfAmazonWebsite() throws InterruptedException
	 {
		 System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.manage().window().maximize();
		 driver.get("https://www.amazon.in/");
		 Thread.sleep(2000);
		 
		 List<WebElement> links =  driver.findElements(By.tagName("a"));    //with tagname a not //a is for xpath
		 int count = links.size();
		 System.out.println("Total number of links present in the website : " +count);
		 
		 WebElement  url = links.get(2);
		 System.out.println("The url of given index position 5 is : " +url );
		 
		 for(int i=0;i<=count-1;i++)                                        //Total , How many is the count
		 {
		 WebElement linkUrl = links.get(i);
		 String allUrls = linkUrl.getAttribute("href");
		 System.out.println("List of all Urls in Amazon website : " +allUrls);
		 }
	 }
}
