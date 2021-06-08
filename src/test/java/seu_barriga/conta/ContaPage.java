package seu_barriga.conta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import seu_barriga.BaseObject;

public class ContaPage extends BaseObject {
    public static final String URL_ADD_CONTA = "https://seubarriga.wcaquino.me/addConta";
    private static final String URL_LISTAR_CONTAS = "https://seubarriga.wcaquino.me/contas";
    private static final String URL_SALVAR_CONTA = "https://seubarriga.wcaquino.me/salvarConta";

    public ContaPage(WebDriver browser) {
        super(browser);
    }

    public CadastroContaPage carregarFormulario() {
        this.browser.navigate().to(URL_ADD_CONTA);
        return new CadastroContaPage(browser);
    }

    public boolean isLeilaoCadastrado(String nome, String valorInicial, String dataAbertura) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));

        return colunaNome.getText().equals(nome) && colunaDataAbertura.getText().equals(dataAbertura) && colunaValorInicial.getText().equals(valorInicial);
    }

    public boolean isPaginaListaContas() {
        return this.browser.getCurrentUrl().equals(URL_LISTAR_CONTAS);
    }
}
