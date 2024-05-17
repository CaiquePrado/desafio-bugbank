package org.dbserver.desafiobugbank.pages;

import org.dbserver.desafiobugbank.utils.WaitingTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionPage {

  private final WebDriver driver;
  private final WaitingTime wait;

  public TransactionPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WaitingTime(driver);
  }

  public WebElement getNumberAccountTextField() {
    return wait.waitForPresence(By.xpath("//input[@name='accountNumber']"));
  }

  public WebElement getDigitAccountTextField() {
    return wait.waitForVisibility(By.xpath("//input[@name='digit']"));
  }

  public WebElement getTransferValueTextField() {
    return wait.waitForVisibility(By.xpath("//input[@name='transferValue']"));
  }

  public WebElement getTransferDescriptionTextField() {
    return wait.waitForVisibility(By.xpath("//input[@name='description']"));
  }

  public WebElement getTransferSubmitButton() {
    return wait.waitForVisibility(By.cssSelector(".CMabB"));
  }

  public WebElement getModalTextConfirmation() {
    return wait.waitForVisibility(By.id("modalText"));
  }

  public WebElement getCloseModalButton() {
    return wait.waitForVisibility(By.id("btnCloseModal"));
  }

  public WebElement getBackButton() {
    return wait.waitForVisibility(By.id("btnBack"));
  }

  public String getErrorMessage() {
    WebElement errorMessageElement = wait.waitForVisibility(By.xpath(
        "//p[contains(text(), 'transferValue must be a `number` type, but the final value was: `NaN` (cast from the value `\"\"`).')]"));
    return errorMessageElement.getText();
  }

  public WebElement getModalText() {
    return wait.waitForVisibility(By.id("modalText"));
  }
}
