package seu_barriga.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class LoginPage{
    public static final String URL_LOGIN = "https://seubarriga.wcaquino.me/login";
    private static final String URL_LOGAR = "http://localhost:8080/logar";
    private WebDriver browser;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LOGIN);
    }

    public void fechar() {
        this.browser.quit();
    }

    public void carregarFormulario() {
        browser.navigate().to(URL_LOGIN);
    }

    public void efetuarLogin(String email, String senha) {
        browser.findElement(By.id("email")).sendKeys(email);
        browser.findElement(By.id("senha")).sendKeys(senha);
        browser.findElement(By.className("btn-primary")).submit();

    }

    public boolean isPaginaLogar() {
        return browser.getCurrentUrl().contains(URL_LOGAR);
    }

    public boolean isMensagemDeLoginComSucesso(String usuario) {
        return browser.getPageSource().contains("Bem vindo, " + usuario + "!");
    }
}
