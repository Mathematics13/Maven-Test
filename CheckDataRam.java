package TestNG;

//Assignment 136
//Test a particular test case with 10 different data using Data Provider concept where all data has to be String
//Check if the given input is present in any data provider input.

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckDataRam 
{
	@DataProvider(name="Actors")
	public Object[][]names()
	{
		return new Object[][] {{"Abbas"},{"Kamal"},{"Karthick"},{"Rajni"},{"Dhanush"},
			                   {"Simbu"},{"Madhavan"},{"Vijay"},{"Ajith"},{"Ravi"}};
		
	}
	@DataProvider(name="Actress")
	public Object[][]leads()
	{
		return new Object[][] {{"Sridevi"},{"Kushboo"}};
	}
	
	@Test(dataProvider="Actors")                                                 //Calling only Actors
	public void film(String actorName)
	{
		if(actorName=="Simbu")                                                 //From 1st data till last it will check
		{
			System.out.println("Simbu is one of the actors");                 //Accordingly it prints the report
			Reporter.log("Simbu available");
		}
		else
		{
			System.out.println("Simbu is not one of the actors listed");
		}
	}
}
