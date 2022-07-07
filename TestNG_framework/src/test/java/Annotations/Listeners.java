package Annotations;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {

	
	public void onTestStart(ITestResult tr)
	{
		System.out.println("test execution is started");
	}
	
	public void onTestSuccess(ITestResult tr) {
        System.out.println("onTestSuccess Method" +tr.getName());
        }
	
	
	  public void onTestFailure(ITestResult tr) {
	         System.out.println("onTestFailure Method" +tr.getName());
	         
}
}