package org.dbserver.desafiobugbank.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.dbserver.desafiobugbank.config.TypeBrowser;
import org.dbserver.desafiobugbank.models.User;
import org.dbserver.desafiobugbank.pages.RegisterPage;
import org.dbserver.desafiobugbank.stubs.UserStubs;
import org.dbserver.desafiobugbank.tests.BaseTest;
import org.openqa.selenium.WebElement;

public class RegistrarConta extends BaseTest {

  public String[] registrarContaComSucesso() {
    RegisterPage registerPage = new RegisterPage(getDriver(TypeBrowser.CHROME));
    User randomUser = UserStubs.validUserStub();

    registerPage.getRegisterButton().click();
    registerPage.getEmailTextField().sendKeys(randomUser.getEmail());
    registerPage.getUserNameTextField().sendKeys(randomUser.getName());
    registerPage.getPasswordTextField().sendKeys(randomUser.getPassword());
    registerPage.getPasswordValidationTextField().sendKeys(randomUser.getPassword());
    registerPage.getBalanceStatusToggle().click();
    registerPage.getSubmitButton().click();

    WebElement modalText = registerPage.getModalText();
    assertTrue(modalText.isDisplayed());

    String modalTextValue = registerPage.getModalTextValue();
    String contaInfo = modalTextValue.replaceAll("[^0-9\\-]", "");

    String[] contaParts = contaInfo.split("-");
    String numeroConta = contaParts[0];
    String numeroSufixo = contaParts[1];

    registerPage.getCloseButtonModal().click();

    return new String[] { numeroConta, numeroSufixo };
  }

  public void registrarConta() {
    RegisterPage registerPage = new RegisterPage(getDriver(TypeBrowser.CHROME));
    User randomUser = UserStubs.validUserStub();

    registerPage.getRegisterButton().click();
    registerPage.getEmailTextField().sendKeys(randomUser.getEmail());
    registerPage.getUserNameTextField().sendKeys(randomUser.getName());
    registerPage.getPasswordTextField().sendKeys(randomUser.getPassword());
    registerPage.getPasswordValidationTextField().sendKeys(randomUser.getPassword());
    registerPage.getBalanceStatusToggle().click();
    registerPage.getSubmitButton().click();

    WebElement modalText = registerPage.getModalText();
    assertTrue(modalText.isDisplayed());
    String modalTextValue = registerPage.getModalTextValue();
    registerPage.getCloseButtonModal().click();

  }
}
