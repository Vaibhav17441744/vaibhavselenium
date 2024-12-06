package rahulshetty.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenReports {

	
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Webautomationresults");
		reporter.config().setDocumentTitle("Automation Testing Report");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "vaibhav");
		return extent;
	}
}
