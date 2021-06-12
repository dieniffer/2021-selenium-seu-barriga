package testcases.login;

import org.openqa.selenium.By;
import testcases.BaseObject;
import testcases.conta.ContaPage;

public class LoginPage extends BaseObject {
    public static final String URL_LOGIN = "https://seubarriga.wcaquino.me/login";
    private static final String URL_LOGAR = "https://seubarriga.wcaquino.me/logar";

    public LoginPage() {
        super(null);
        this.browser.navigate().to(URL_LOGIN);
    }

    public void fechar() {
        this.browser.quit();
    }

    public void carregarFormulario() {
        this.browser.navigate().to(URL_LOGIN);
    }

    public ContaPage efetuarLogin(String email, String senha) {
        browser.findElement(By.id("email")).sendKeys(email);
        browser.findElement(By.id("senha")).sendKeys(senha);
        browser.findElement(By.className("btn-primary")).submit();

        return new ContaPage(browser);
    }

    public boolean isPaginaLogar() {
        return browser.getCurrentUrl().contains(URL_LOGAR);
    }

    public boolean isMensagemDeLoginComSucesso(String usuario) {
        return browser.getPageSource().contains("Bem vindo, " + usuario + "!");
    }

    public boolean isMensagemDeLoginInvalido() {
        return browser.getPageSource().contains("Problemas com o login do usuário");
    }
}
