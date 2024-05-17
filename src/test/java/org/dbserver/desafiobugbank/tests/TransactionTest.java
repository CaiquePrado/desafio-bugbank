package org.dbserver.desafiobugbank.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.dbserver.desafiobugbank.config.TypeBrowser;
import org.dbserver.desafiobugbank.pages.HomePage;
import org.dbserver.desafiobugbank.pages.RegisterPage;
import org.dbserver.desafiobugbank.pages.TransactionPage;
import org.dbserver.desafiobugbank.utils.RegistrarConta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class TransactionTest extends BaseTest {

  LoginTest loginTest = new LoginTest();
  RegisterTest registerTest = new RegisterTest();
  RegistrarConta registrarConta;

  @DisplayName("CT004.001 - Deve realizar transação com sucesso")
  @Test
  void DeveRealizarTransacaoComSucesso() throws InterruptedException {
    RegistrarConta registrarConta = new RegistrarConta();

    String[] accountDetailsFirst = registrarConta.registrarContaComSucesso();

    RegisterPage registerPage = new RegisterPage(getDriver(TypeBrowser.CHROME));
    registerPage.clearFields();

    HomePage homePage = new HomePage(getDriver(TypeBrowser.CHROME));

    LoginTest loginTest = new LoginTest();
    loginTest.DeveRealizarLoginComSucesso();

    homePage = new HomePage(getDriver(TypeBrowser.CHROME));
    TransactionPage transactionPage = new TransactionPage(getDriver(TypeBrowser.CHROME));

    homePage.getTransferButton().click();
    transactionPage.getNumberAccountTextField().sendKeys(accountDetailsFirst[0]);
    transactionPage.getDigitAccountTextField().sendKeys(accountDetailsFirst[1]);
    transactionPage.getTransferValueTextField().sendKeys("1000");
    transactionPage.getTransferDescriptionTextField().sendKeys("Transferência de teste");
    transactionPage.getTransferSubmitButton().click();
  }

  @DisplayName("CT004.002 - Tentativa de transferir para a mesma conta")
  @Test
  void TentativaTransferirParaMesmaConta() {

    loginTest.DeveRealizarLoginComSucesso();

    HomePage homePage = new HomePage(getDriver(TypeBrowser.CHROME));
    TransactionPage transactionPage = new TransactionPage(getDriver(TypeBrowser.CHROME));

    String[] accountDetails = homePage.getBankAccountNumberAndDigit();

    homePage.getTransferButton().click();

    transactionPage.getNumberAccountTextField().sendKeys(accountDetails[0]);
    transactionPage.getDigitAccountTextField().sendKeys(accountDetails[1]);
    transactionPage.getTransferValueTextField().sendKeys("1000");
    transactionPage.getTransferDescriptionTextField().sendKeys("Transferência de teste");

    transactionPage.getTransferSubmitButton().click();

    WebElement modalText = transactionPage.getModalText();
    assertTrue(modalText.isDisplayed());
    transactionPage.getCloseModalButton().click();
  }

  @DisplayName("CT004.003 - Tentativa de transferir com campos vazios")
  @Test
  void TentativaTransferirComCamposVazios() {

    loginTest.DeveRealizarLoginComSucesso();

    HomePage homePage = new HomePage(getDriver(TypeBrowser.CHROME));
    TransactionPage transactionPage = new TransactionPage(getDriver(TypeBrowser.CHROME));

    homePage.getTransferButton().click();

    transactionPage.getNumberAccountTextField().sendKeys("");
    transactionPage.getDigitAccountTextField().sendKeys("");
    transactionPage.getTransferValueTextField().sendKeys("");
    transactionPage.getTransferDescriptionTextField().sendKeys("");

    transactionPage.getTransferSubmitButton().click();

    String errorMessage = transactionPage.getErrorMessage();
    assertTrue(errorMessage.contains("transferValue must be a `number` type"));
  }

  @DisplayName("CT004.004 - Tentativa de transferir com valor de transferência menor que zero")
  @Test
  void TentativaTransferirComValorMenorQueZero() {

    loginTest.DeveRealizarLoginComSucesso();

    HomePage homePage = new HomePage(getDriver(TypeBrowser.CHROME));
    TransactionPage transactionPage = new TransactionPage(getDriver(TypeBrowser.CHROME));

    homePage.getTransferButton().click();

    transactionPage.getNumberAccountTextField().sendKeys("123456");
    transactionPage.getDigitAccountTextField().sendKeys("7");
    transactionPage.getTransferValueTextField().sendKeys("-1000");
    transactionPage.getTransferDescriptionTextField().sendKeys("Transferência de teste");

    transactionPage.getTransferSubmitButton().click();

    WebElement modalText = transactionPage.getModalText();
    assertTrue(modalText.isDisplayed());
    transactionPage.getCloseModalButton().click();
  }

  @DisplayName("CT004.005 - Tentativa de transferir para conta inválida ou inexistente")
  @Test
  void TentativaTransferirParaContainvalidaOuInexistente() {

    loginTest.DeveRealizarLoginComSucesso();

    HomePage homePage = new HomePage(getDriver(TypeBrowser.CHROME));
    TransactionPage transactionPage = new TransactionPage(getDriver(TypeBrowser.CHROME));

    homePage.getTransferButton().click();

    transactionPage.getNumberAccountTextField().sendKeys("999999");
    transactionPage.getDigitAccountTextField().sendKeys("9");
    transactionPage.getTransferValueTextField().sendKeys("1000");
    transactionPage.getTransferDescriptionTextField().sendKeys("Transferência de teste");

    transactionPage.getTransferSubmitButton().click();

    WebElement modalText = transactionPage.getModalText();
    assertTrue(modalText.isDisplayed());
    transactionPage.getCloseModalButton().click();
  }
}
