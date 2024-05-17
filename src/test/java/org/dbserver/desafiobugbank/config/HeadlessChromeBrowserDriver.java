package org.dbserver.desafiobugbank.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeBrowserDriver implements BrowserDriver {
  @Override
  public WebDriver createDriver() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions optionsHeadless = new ChromeOptions();
    optionsHeadless.addArguments("--headless");
    optionsHeadless.addArguments("--window-size=1366,768");
    return new ChromeDriver(optionsHeadless);
  }
}
