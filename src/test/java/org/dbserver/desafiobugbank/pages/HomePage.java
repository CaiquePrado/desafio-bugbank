package org.dbserver.desafiobugbank.pages;

import org.dbserver.desafiobugbank.utils.WaitingTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

  private final WebDriver driver;
  private final WaitingTime wait;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WaitingTime(driver);
  }

  public WebElement getSaldoTextField() {
    return wait.waitForVisibility(By.id("textBalance"));
  }

  public String[] getBankAccountNumberAndDigit() {
    String accountText = wait.waitForVisibility(By.cssSelector("#textAccountNumber span")).getText();
    return accountText.split("-");
  }

  public WebElement getTransferButton() {
    return wait.waitForVisibility(By.id("btn-TRANSFERÊNCIA"));
  }

  public WebElement getSignOutButton() {
    return wait.waitForVisibility(By.id("btnExit"));
  }

  public WebElement getExtractButton() {
    return wait.waitForVisibility(By.id("btn-EXTRATO"));
  }

  public WebElement getWelcomeText() {
    return wait.waitForVisibility(By.cssSelector("p.jjmPHj:nth-of-type(2)"));
  }
}
