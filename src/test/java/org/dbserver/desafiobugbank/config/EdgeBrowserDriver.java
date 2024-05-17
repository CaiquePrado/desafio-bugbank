package org.dbserver.desafiobugbank.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeBrowserDriver implements BrowserDriver {
  @Override
  public WebDriver createDriver() {
    WebDriverManager.edgedriver().setup();
    EdgeOptions optionsEdge = new EdgeOptions();
    optionsEdge.addArguments("--start-maximized");
    optionsEdge.addArguments("--incognito");
    return new EdgeDriver(optionsEdge);
  }
}
