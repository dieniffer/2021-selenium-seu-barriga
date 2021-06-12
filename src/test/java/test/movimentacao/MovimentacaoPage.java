package test.movimentacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.BaseObject;

public class MovimentacaoPage extends BaseObject {
    public static final String URL_ADD_MOVIMENTACAO = "https://seubarriga.wcaquino.me/movimentacao";
    private static final String URL_LISTAR_MOVIMENTACOES = "https://seubarriga.wcaquino.me/extrato";

    public MovimentacaoPage(WebDriver browser) {
        super(browser);
    }

    public CadastroMovimentacaoPage carregarFormulario() {
        this.browser.navigate().to(URL_ADD_MOVIMENTACAO);
        return new CadastroMovimentacaoPage(browser);
    }

    public boolean isMovimentacaoCadastrada(String descricao) {
        this.browser.navigate().to(URL_LISTAR_MOVIMENTACOES);
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabelaExtrato tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));

        return colunaNome.getText().equals(descricao);
    }

    public boolean isPaginaListaMovimentacoes() {
        return this.browser.getCurrentUrl().equals(URL_LISTAR_MOVIMENTACOES);
    }
}
