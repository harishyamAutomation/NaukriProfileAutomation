package util;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import core.OutputLog;

public class ExtentReport {

	private static ExtentReport instance = null;
	private static ExtentReports extentReport;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static ExtentReport getInstance() {
		if (instance == null) {
			instance = new ExtentReport();
		}
		return instance;
	}

	public synchronized void initialize(String extentReportFilePath) {
		OutputLog.info(">>> Report Initialization");

		extentReport = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFilePath);

		OutputLog.info(">>> Report Initialized");

		try {
			sparkReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/" + "src/test/resources/extent-config.xml"));
			OutputLog.info("XML Config loaded");

			extentReport.attachReporter(sparkReporter);
			OutputLog.info("Reporter Attached");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			String osInfo = System.getProperty("os.name");
			String screenInfo = "(headless)";

			// If running in a graphical environment, try to get screen size. In headless CI
			// environments (like GitHub Actions) this will be skipped to avoid HeadlessException.
			if (!GraphicsEnvironment.isHeadless()) {
				GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
				DisplayMode mode = gd.getDisplayMode();
				int screenWidth = mode.getWidth();
				int screenHeight = mode.getHeight();
				screenInfo = screenWidth + "x" + screenHeight;
			}

			extentReport.setSystemInfo("Product", "Naukri Profile WebAPI");
			extentReport.setSystemInfo("Host", "Harishyam Sharma");
			extentReport.setSystemInfo("Environment", "QA");
			extentReport.setSystemInfo("OS", osInfo + ", " + screenInfo);
			extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		} catch (Throwable t) {
			// Defensive: in case any unexpected error occurs while collecting system info
			OutputLog.warn("Could not determine screen size or system info: " + t.getMessage());
			extentReport.setSystemInfo("Product", "Naukri Profile WebAPI");
			extentReport.setSystemInfo("Host", "Harishyam Sharma");
			extentReport.setSystemInfo("Environment", "QA");
			extentReport.setSystemInfo("OS", System.getProperty("os.name"));
			extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		}

		OutputLog.info("Initialization Successful");
	}

	public static void startTest(String testName, String testDescription) {
		if (extentReport != null) {
			ExtentTest test = extentReport.createTest(testName, testDescription);
			extentTest.set(test);
		} else {
			throw new IllegalStateException("ExtentReports is not initialized. Call initialize() first.");
		}
	}

	public static ExtentTest getTest() {
		ExtentTest test = extentTest.get();
		if (test == null) {
			throw new IllegalStateException("No test started. Call startTest() before logging.");
		}
		return test;
	}

	public void flush() {
		if (extentReport != null) {
			extentReport.flush();
		}
	}
}
