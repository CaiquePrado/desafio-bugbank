package org.dbserver.desafiobugbank.report;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUse {

  public static final String PATH_REPORT = System.getProperty("user.dir") + File.separator + "Report" + File.separator
      + "Report";

  public static ExtentSparkReporter extentSparkReporter;
  public static ExtentReports extentReports;

  public static void createFolderReport(String path) {
    File pathReport = new File(path);
    if (!pathReport.exists()) {
      pathReport.mkdir();
    }
  }

  protected synchronized static ExtentReports getInstance() {
    if (extentReports == null) {
      configReportExtent();
    }
    return extentReports;
  }

  public static void configReportExtent() {
    createFolderReport(PATH_REPORT);
    extentSparkReporter = new ExtentSparkReporter(
        PATH_REPORT + File.separator + "Report_" + ".html");
    extentSparkReporter.config().setDocumentTitle("Relatório de Execução Automação Capacitação");
    extentSparkReporter.config().setReportName("Relatório de Execução de Testes");
    extentSparkReporter.config().setTheme(Theme.DARK);
    extentSparkReporter.config().setEncoding("UTF-8");
    extentSparkReporter.config().setTimeStampFormat(" EEEE , MMMM dd, yyyy , hh:mm a '('zzz')' ");
    extentSparkReporter.config().setCss(
        ".nav-wrapper { background-color: #4B0082 !important; } .nav-logo{margin-top: 10px;}.brand-logo { background-color: #4B0082 !important; padding: 0 10px 0 0 !important; margin: 0 !important; position: absolute !important } .report-name { margin-left: 80px !important } .blue.darken-3 { background-color:#4B0082 !important; color: #FFF !important;}");
    ;
    extentReports = new ExtentReports();
    extentReports.attachReporter(extentSparkReporter);
  }
}
