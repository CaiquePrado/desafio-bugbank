package org.dbserver.desafiobugbank;

import org.dbserver.desafiobugbank.config.BrowserDriver;
import org.dbserver.desafiobugbank.config.BrowserDriverFactory;
import org.dbserver.desafiobugbank.config.TypeBrowser;
import org.openqa.selenium.WebDriver;

public class DriverManager {

  private static WebDriver driver;

  public static WebDriver getDriver(TypeBrowser type) {
    if (driver == null) {
      BrowserDriver browserDriver = BrowserDriverFactory.getDriver(type);
      if (browserDriver != null) {
        driver = browserDriver.createDriver();
      } else {
        throw new IllegalArgumentException("No such browser: " + type);
      }
    }
    return driver;
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
