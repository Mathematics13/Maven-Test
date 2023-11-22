package TestNG;

//Assignment 135
//Use as many @DataProvider and one @Test calling one single dataProvider

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OneDimDP 
{
	@DataProvider(name="data1")
	public Object[] method1()
	{
		return new Object[] {100,300,500,700,900};                             //Single dimensional
	}
	@DataProvider(name="data2")
	public Object[] method2()
	{
		return new Object[] {"Hi","Hello","Come","Go"};                       //Object creation for Object Class
	}
	@Test(dataProvider="data1")
	public void add(int value)
	{
		int sum = 50+value;
		System.out.println("All integer values");
		System.out.println(sum);
	}
}
