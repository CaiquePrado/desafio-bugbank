package org.dbserver.desafiobugbank.pages;

import org.dbserver.desafiobugbank.utils.WaitingTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

  private final WebDriver driver;
  private final WaitingTime wait;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WaitingTime(driver);
  }

  public WebElement getUserNameTextField() {
    return wait.waitForVisibility(By.xpath("//input[@name='email']"));
  }

  public WebElement getPasswordTextField() {
    return wait.waitForVisibility(By.xpath("//input[@name='password']"));
  }

  public WebElement getLoginButton() {
    return wait.waitForVisibility(By.cssSelector(".otUnI"));
  }

  public WebElement getRegisterButton() {
    return wait.waitForVisibility(By.xpath("//*[text()='Registrar']"));
  }

  public String getErrorMessage() {
    WebElement errorMessageElement = wait.waitForVisibility(By.xpath("//p[contains(text(), 'É campo obrigatório')]"));
    return errorMessageElement.getText();
  }

  public WebElement getModalText() {
    return wait.waitForVisibility(By.id("modalText"));
  }
}
