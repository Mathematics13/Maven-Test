package TestNG;

//Assignment 134
//Use @DataProvider annotation for two dimensional

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TwoDimDP 
{
	@DataProvider(name="username")
	public Object[][]login()
	{
		//return new Object[3][2];                             //3 rows 2 colums , 2 fields = 2 inputs
		Object[][] data = new Object[3][2];                   //Array declaration
		data[0][0]="ram@gmail.com";
		data[0][1]="sita@gmail.com";
		data[1][0]="vishnu@gmail.com";                      //3*2 =6 values
		data[1][1]="krishna@gmail.com";
		data[2][0]="priya@gmail.com";
		data[2][1]="Hi@gmail.com";
		return data;
	}
	@Test(dataProvider="username")
	public void credentials(String value1, String value2)
	{
		System.out.println("Login Credentials");
		Reporter.log("Credentials");
	}
}
