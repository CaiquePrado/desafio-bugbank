package org.dbserver.desafiobugbank.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.dbserver.desafiobugbank.config.TypeBrowser;
import org.dbserver.desafiobugbank.models.User;
import org.dbserver.desafiobugbank.pages.RegisterPage;
import org.dbserver.desafiobugbank.stubs.UserStubs;
import org.dbserver.desafiobugbank.utils.RegistrarConta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

  @DisplayName("CT001.001 - Deve registrar conta com sucesso")
  @Test
  void DeveRegistrarContaComSucesso() {
    RegistrarConta registrarConta = new RegistrarConta();
    registrarConta.registrarContaComSucesso();
  }

  @DisplayName("CT001.002 - Tentativa de criar uma nova conta com um e-mail inválido")
  @Test
  void TentativaCriarContaComEmailInvalido() {
    RegisterPage registerPage = new RegisterPage(getDriver(TypeBrowser.CHROME));
    User invalidEmailUser = UserStubs.invalidEmailUserStub();

    registerPage.getRegisterButton().click();
    registerPage.getEmailTextField().sendKeys(invalidEmailUser.getEmail());
    registerPage.getUserNameTextField().sendKeys(invalidEmailUser.getName());
    registerPage.getPasswordTextField().sendKeys(invalidEmailUser.getPassword());
    registerPage.getPasswordValidationTextField().sendKeys(invalidEmailUser.getPassword());
    registerPage.getSubmitButton().click();

    String errorMessage = registerPage.getEmailError();
    assertTrue(errorMessage.contains("Formato inválido"));
  }

  @DisplayName("CT001.003 - Tentativa de criar uma nova conta com senhas não correspondentes")
  @Test
  void TentativaCriarContaComSenhasNaoCorrespondentes() {
    RegisterPage registerPage = new RegisterPage(getDriver(TypeBrowser.CHROME));
    User mismatchPasswordUser = UserStubs.mismatchPasswordUserStub();

    registerPage.getRegisterButton().click();
    registerPage.getEmailTextField().sendKeys(mismatchPasswordUser.getEmail());
    registerPage.getUserNameTextField().sendKeys(mismatchPasswordUser.getName());
    registerPage.getPasswordTextField().sendKeys(mismatchPasswordUser.getPassword());
    registerPage.getPasswordValidationTextField().sendKeys("senhaDiferente123");
    registerPage.getSubmitButton().click();

    WebElement modalText = registerPage.getModalText();
    assertTrue(modalText.isDisplayed());
    assertTrue(modalText.getText().contains("As senhas não são iguais."));
  }

  @DisplayName("CT001.004 - Tentativa de criar uma nova conta com campos vazios")
  @Test
  void TentativaCriarContaComCamposVazios() {
    RegisterPage registerPage = new RegisterPage(getDriver(TypeBrowser.CHROME));

    registerPage.getRegisterButton().click();
    registerPage.getEmailTextField().sendKeys("");
    registerPage.getUserNameTextField().sendKeys("");
    registerPage.getPasswordTextField().sendKeys("");
    registerPage.getPasswordValidationTextField().sendKeys("");
    registerPage.getSubmitButton().click();

    String errorMessage = registerPage.getErrorMessage();
    assertTrue(errorMessage.contains("É campo obrigatório"));

  }
}
