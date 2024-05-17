package org.dbserver.desafiobugbank.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Report {
  private static final ExtentReports extent = ReportUse.getInstance();
  private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
  private static final ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();

  public static void createTest(String testName, ReportType type) {
    ExtentTest extentTest = extent.createTest(testName);
    if (type.equals(ReportType.SINGLE)) {
      test.set(extentTest);
    } else {
      parentTest.set(extentTest);
    }
  }
}
