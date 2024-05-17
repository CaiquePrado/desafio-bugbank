package org.dbserver.desafiobugbank.tests;

import org.dbserver.desafiobugbank.DriverManager;
import org.dbserver.desafiobugbank.config.TypeBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest extends DriverManager {

  private String url = "https://bugbank.netlify.app/#";

  private final WebDriver driver = initDriver();

  private WebDriver initDriver() {
    return getDriver(TypeBrowser.CHROME);
  }

  public WebDriver getDriver() {
    return driver;
  }

  @BeforeEach
  public void setUp() {
    getDriver().get(url);
  }

  @AfterEach
  public void tearDown() {
    quitDriver();
  }
}
