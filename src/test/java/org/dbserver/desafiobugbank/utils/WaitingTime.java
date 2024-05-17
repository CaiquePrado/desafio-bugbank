package org.dbserver.desafiobugbank.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitingTime {

  private static final Duration TIMEOUT = Duration.ofSeconds(30);
  private final WebDriver driver;

  public WaitingTime(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement waitForVisibility(By by) {
    WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
    return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public WebElement waitForVisibility(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
    try {
      return wait.until(ExpectedConditions.visibilityOf(element));
    } catch (Exception e) {
      return element;
    }
  }

  public WebElement waitForPresence(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
  }
}
