package org.dbserver.desafiobugbank.config;

import java.util.HashMap;
import java.util.Map;

public class BrowserDriverFactory {
  private static final Map<TypeBrowser, BrowserDriver> drivers = new HashMap<>();

  static {
    drivers.put(TypeBrowser.CHROME, new ChromeBrowserDriver());
    drivers.put(TypeBrowser.FIREFOX, new FirefoxBrowserDriver());
    drivers.put(TypeBrowser.EDGE, new EdgeBrowserDriver());
    drivers.put(TypeBrowser.HEADLESS, new HeadlessChromeBrowserDriver());
  }

  public static BrowserDriver getDriver(TypeBrowser type) {
    return drivers.get(type);
  }
}
