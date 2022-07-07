package Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class basicTestNG
{
	@Test
	public void testcase1()
	{
		System.out.println("This is testcase 1");
	}
	
	
	@Test
	public void testcase2()
	{
		System.out.println("this is testcase 2");
	}
	
	
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("this is before method-runs everytime");
	}
	
	
	@AfterMethod
		public void aftermethod()
		{
			System.out.println("this is after method-runs everytime");
		}
			
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("this is before class- runs only once");
	}
	
	
@AfterClass
public void afterclass()
{
	System.out.println("this is after class- runs only once");
}
	
	
}