package test.conta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.BaseObject;

public class CadastroContaPage extends BaseObject {
    public static final String URL_ADD_CONTA = "https://seubarriga.wcaquino.me/addConta";
    private static final String URL_LISTAR_CONTAS = "https://seubarriga.wcaquino.me/contas";
    private static final String URL_SALVAR_CONTA = "https://seubarriga.wcaquino.me/salvarConta";

    public CadastroContaPage(WebDriver browser) {
        super(browser);
    }

    public void fechar() {
        this.browser.quit();
    }

    public void carregarFormulario() {
        browser.navigate().to(URL_ADD_CONTA);
    }

    public ContaPage cadastrarConta(String nome) {
        browser.findElement(By.id("nome")).sendKeys(nome);
        browser.findElement(By.className("btn-primary")).submit();

        return new ContaPage(browser);
    }

    public boolean isMensagemDeCadastroComSucesso(){
        return browser.getPageSource().contains("Conta adicionada com sucesso!");
    }

    public boolean isPaginaSalvarConta(){
        return browser.getCurrentUrl().contains(URL_SALVAR_CONTA);
    }

    public boolean isMensagemDeCadastroNulo(){
        return browser.getPageSource().contains("Informe o nome da conta");
    }
}
