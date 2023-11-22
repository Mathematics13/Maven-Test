package TestNG;

//Assignment 133
//Use @DataProvider annotation for single dimensional

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SingleDimDataProvider 
{
	@DataProvider(name="Facebook")
	public Object[]launch()
	{
		//return new Object[] {10,22};
		Object[] data = new Object[2];                       //Same Array declaration
		data[0]=10;                                         //Giving values individually
		data[1]=22;                                        //Initialising values
		return data;
	}
	@Test(dataProvider="Facebook")
	public void browser(int value)
	{
		int sub = 100-value;
		System.out.println("Data details:");
		System.out.println(sub);
	}
}
