package test.usuario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroUsuarioPage {
    public static final String URL_CADASTRO_USUARIO = "https://seubarriga.wcaquino.me/cadastro";
    private WebDriver browser;

    public CadastroUsuarioPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_CADASTRO_USUARIO);
    }

    public void carregarFormulario() {
        browser.navigate().to(URL_CADASTRO_USUARIO);
    }

    public void cadastrarUsuario(String nome, String email, String senha) {
        browser.findElement(By.id("nome")).sendKeys(nome);
        browser.findElement(By.id("email")).sendKeys(email);
        browser.findElement(By.id("senha")).sendKeys(senha);
        browser.findElement(By.className("btn-primary")).submit();

    }

    public boolean isMensagemSucesso(){
        String pageSource = browser.getPageSource();
        return pageSource.contains("Usuário inserido com sucesso");
    }

    public boolean isMensagemNulo(){
        String pageSource = browser.getPageSource();
        return pageSource.contains("Nome é um campo obrigatório")
                && pageSource.contains("Email é um campo obrigatório")
                && pageSource.contains("Senha é um campo obrigatório");
    }

    public void fechar() {
        this.browser.quit();
    }
}
