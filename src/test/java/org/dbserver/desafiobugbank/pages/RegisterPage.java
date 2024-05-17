package org.dbserver.desafiobugbank.pages;

import org.dbserver.desafiobugbank.utils.WaitingTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

  private final WebDriver driver;
  private final WaitingTime wait;

  public RegisterPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WaitingTime(driver);
  }

  public WebElement getEmailTextField() {
    return wait.waitForVisibility(By.xpath("//div[@class='card__register']//input[1]"));
  }

  public WebElement getUserNameTextField() {
    return wait.waitForVisibility(By.xpath("//input[@placeholder='Informe seu Nome']"));
  }

  public WebElement getPasswordTextField() {
    return wait.waitForVisibility(By.cssSelector(".login__password:nth-child(4) .input__default"));
  }

  public WebElement getPasswordValidationTextField() {
    return wait.waitForVisibility(By.cssSelector(".login__password:nth-child(5) .input__default"));
  }

  public WebElement getBalanceStatusToggle() {
    return driver.findElement(By.id("toggleAddBalance"));
  }

  public WebElement getRegisterButton() {
    return wait.waitForVisibility(By.cssSelector("button.style__ContainerButton-sc-1wsixal-0.ihdmxA.button__child"));
  }

  public WebElement getSubmitButton() {
    return wait.waitForVisibility(By.xpath("//button[contains(text(), 'Cadastrar')]"));
  }

  public WebElement getModalText() {
    return wait.waitForVisibility(By.id("modalText"));
  }

  public String getModalTextValue() {
    return getModalText().getText();
  }

  public WebElement getCloseButtonModal() {
    return wait.waitForVisibility(By.id("btnCloseModal"));
  }

  public WebElement getConfirmationPasswordText() {
    return wait.waitForVisibility(By.xpath("//label[text()='Confirmação senha']"));
  }

  public String getEmailError() {
    WebElement errorMessageElement = wait.waitForVisibility(By.xpath("//p[contains(text(), 'Formato inválido')]"));
    return errorMessageElement.getText();
  }

  public String getErrorMessage() {
    WebElement errorMessageElement = wait.waitForVisibility(By.xpath("//p[contains(text(), 'É campo obrigatório')]"));
    return errorMessageElement.getText();
  }

  public void clearFields() {
    getEmailTextField().clear();
    getUserNameTextField().clear();
    getPasswordTextField().clear();
    getPasswordValidationTextField().clear();
  }
}
