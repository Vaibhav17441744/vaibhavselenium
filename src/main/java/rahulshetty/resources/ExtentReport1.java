package rahulshetty.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ExtentReports getreport() {
		String path=System.getProperty("user.dir")+"//reprts//new.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setDocumentTitle("Testng");
		report.config().setReportName("Testngautomation");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester name", "vaibhav");
		return extent;
	}

}
