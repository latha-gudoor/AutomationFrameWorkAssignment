package com.wbl.HelperPackage;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class LoggerListener extends TestListenerAdapter {

	Logger logger = LogManager.getLogger(LoggerListener.class);

	@Override
	public void onTestStart(ITestResult tr) {
		log("Test Started....");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {

		log("Test '" + tr.getName() + "' PASSED");

		// This will print the class name in which the method is present
		log(tr.getTestClass());

		// This will print the priority of the method.
		log("Priority of this method is " + tr.getMethod().getPriority());
		logger.info(".....");
	}

	@Override
	public void onTestFailure(ITestResult tr) {

		log("Test '" + tr.getName() + "' FAILED");
		log("Priority of this method is " + tr.getMethod().getPriority());
		logger.info("failed.....");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		log("Test '" + tr.getName() + "' SKIPPED");
		logger.info("skipped.....");
	}

	private void log(String methodName) {
		logger.info(methodName);
	}

	private void log(IClass testClass) {
		logger.info(testClass);
	}
}




