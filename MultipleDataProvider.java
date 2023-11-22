package TestNG;

//Multi DataProvider annotations

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleDataProvider 
{
    @DataProvider(name="data1")                                      //data 1 is not called by @Test so not executed
	public Object[][] method1()
	{
		return new Object[][] {{50},{40},{100}};                    //single set of data , single field
	}
    @DataProvider(name="data2")
   public Object[][] method2()
    {
    	return new Object[][] {{"Ram"},{"Vishnu"},{"Sita"}};
    	
    }
    @Test(dataProvider="data2")                                     //Calling only data2 so it will get executed      
    public void testcase1(String value)                            //One dimensional so one parameter only
    {
     String value1 = value.concat(" Works at Tech Mahindra ");
     System.out.println(value1);	
     Reporter.log("News " +value1);
    }
}
