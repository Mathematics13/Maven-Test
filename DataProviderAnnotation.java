package TestNG;

//Single Set of data 
//Single field

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//Data Provider Annotation

public class DataProviderAnnotation                                  //Data Provider is an annotation
{
	@DataProvider(name="data1")                                    //same test cases multiple times
	public Object[][] method1()                                   //Object class Caps two dimensional array
	{
		return new Object[][] {{10},{20},{30}};                 //Insertion order not preserved in emailable report
	}
	@Test(dataProvider="data1")                               //Test is used to fetch data from DataProvider
	public void testcase1(int value)                         //Test is used to consume data from DataProvider of data1
	{
		int sum = 100+value;
		System.out.println(sum);                         //Parameter is single irrespective of values present
		Reporter.log("My Result " + sum);               //Use concatenation mandatory
	}                                                  //As many DataProviders can be there in a program
	                                                  //@Test executed thrice depending on the number of values
}
