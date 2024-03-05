package commonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {

	ExtentReports report;
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
	//	System.out.println("TestScript excecution is started");
		
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript excecution is started");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		//String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
	//	Reporter.log(methodName+"TestScript excecution is passed"+message);
	Test.class
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript excecution is failed"+message);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		String message = result.getThrowable().toString();

		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript excecution is started"+message);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		String message = result.getThrowable().toString();

		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript excecution is started"+message);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
		String message = result.getThrowable().toString();

		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript excecution is started"+message);
	}
	
		@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
		//String methodName = context.getMethod().getMethodName();
		//Reporter.log(methodName+"TestScript excecution is started");
			
			//use  extentsparkreporter class just  to configure extent report 
			
		     ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jUtil.getRandomNumber()+".html");
		     reporter.config().setDocumentTitle("INDRA THE TIGER");
		     reporter.config().setTheme(Theme.DARK);
		    
		     //set name to extentreport
		     reporter.config().setReportName("rocky");
		     
		     //use Extent reports to generate extentreports 
		     
		    // use- it will attach configuration of above
		      report = new ExtentReports();
		     report.attachReporter(reporter);
		     report.setSystemInfo("OS", "wINDOWS");
		     report.setSystemInfo("BROWSER", "Chrome");
		     report.setSystemInfo("Chromeversion", "121");
		     report.setSystemInfo("AUTHOR", "BHAI BHAI");
		     

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	//	String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"TestScript excecution is started");
		report.flush();
		
	}

}
