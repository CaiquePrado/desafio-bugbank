package org.dbserver.desafiobugbank.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.dbserver.desafiobugbank.config.TypeBrowser;
import org.dbserver.desafiobugbank.models.User;
import org.dbserver.desafiobugbank.pages.LoginPage;
import org.dbserver.desafiobugbank.stubs.UserStubs;
import org.dbserver.desafiobugbank.utils.RegistrarConta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

  RegistrarConta registrarConta = new RegistrarConta();

  @DisplayName("CT002.001 - Deve realizar login com sucesso")
  @Test
  void DeveRealizarLoginComSucesso() {
    registrarConta.registrarConta();

    LoginPage loginPage = new LoginPage(getDriver(TypeBrowser.CHROME));
    User randomUser = UserStubs.validUserStub();

    loginPage.getUserNameTextField().sendKeys(randomUser.getEmail());
    loginPage.getPasswordTextField().sendKeys(randomUser.getPassword());
    loginPage.getLoginButton().click();
  }

  @DisplayName("CT002.002 - Tentativa de login com email e senha vazios")
  @Test
  void TentativaLoginComEmailSenhaVazios() {
    LoginPage loginPage = new LoginPage(getDriver(TypeBrowser.CHROME));

    loginPage.getUserNameTextField().sendKeys("");
    loginPage.getPasswordTextField().sendKeys("");
    loginPage.getLoginButton().click();

    String errorMessage = loginPage.getErrorMessage();
    assertTrue(errorMessage.contains("É campo obrigatório"));
  }

  @DisplayName("CT002.003 - Tentativa de login com usuário não registrado")
  @Test
  void TentativaLoginComUsuarioNaoRegistrado() {
    LoginPage loginPage = new LoginPage(getDriver(TypeBrowser.CHROME));
    User unregisteredUser = UserStubs.validUserStub();

    loginPage.getUserNameTextField().sendKeys(unregisteredUser.getEmail());
    loginPage.getPasswordTextField().sendKeys(unregisteredUser.getPassword());
    loginPage.getLoginButton().click();

    WebElement modalText = loginPage.getModalText();
    assertTrue(modalText.isDisplayed());
  }

  @DisplayName("CT003.001 - Tentativa de realizar login")
  @Test
  void DeveRealizarLogout() {
    registrarConta.registrarContaComSucesso();

    LoginPage loginPage = new LoginPage(getDriver(TypeBrowser.CHROME));
    User randomUser = UserStubs.validUserStub();

    loginPage.getUserNameTextField().sendKeys(randomUser.getEmail());
    loginPage.getPasswordTextField().sendKeys(randomUser.getPassword());
    loginPage.getLoginButton().click();
  }
}
