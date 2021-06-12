package testcases.conta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcases.BaseObject;

public class ContaPage extends BaseObject {
    public static final String URL_ADD_CONTA = "https://seubarriga.wcaquino.me/addConta";
    private static final String URL_LISTAR_CONTAS = "https://seubarriga.wcaquino.me/contas";

    public ContaPage(WebDriver browser) {
        super(browser);
    }

    public CadastroContaPage carregarFormulario() {
        this.browser.navigate().to(URL_ADD_CONTA);
        return new CadastroContaPage(browser);
    }

    public boolean isContaCadastrada(String nome) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabelaContas tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));

        return colunaNome.getText().equals(nome);
    }

    public boolean isPaginaListaContas() {
        return this.browser.getCurrentUrl().equals(URL_LISTAR_CONTAS);
    }
}
