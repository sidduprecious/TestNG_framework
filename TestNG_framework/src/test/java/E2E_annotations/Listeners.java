package E2E_annotations;

import org.testng.ITestResult;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listeners extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onTestStart(ITestResult tr)
	{
		System.out.println("test execution is started");
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/myReport.html");//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Siddu");
		extent.setSystemInfo("browser","Chrome");
		extent.setSystemInfo("os","Windows");
		
		
		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr) {
        System.out.println("onTestSuccess Method" +tr.getName());
        logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
        }
	
	
	  public void onTestFailure(ITestResult tr) {
	         System.out.println("onTestFailure Method" +tr.getName());
	         logger=extent.createTest(tr.getName()); // create new entry in the report
	 		 logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with Red color highlighted
	 	
	 		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	 		try {
	 			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
	 		} catch (IOException e) {
	 				e.printStackTrace();
	 		} 
	 		
	 	
	  }
	 		public void onTestSkipped(ITestResult tr)
	 		{
	 			logger=extent.createTest(tr.getName()); // create new entry in the report
	 			logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE)); // send the passed information to the report with Orange color highlighted
	 		
	 		}

	 		public void onFinish(ITestContext tr)
	 		{
	 			extent.flush();
	 		}
	         

}