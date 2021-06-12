package test.movimentacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import test.BaseObject;

public class CadastroMovimentacaoPage extends BaseObject {
    public static final String URL_ADD_MOVIMENTACAO = "https://seubarriga.wcaquino.me/movimentacao";
    private static final String URL_SALVAR_MOVIMENTACAO = "https://seubarriga.wcaquino.me/salvarMovimentacao";

    public CadastroMovimentacaoPage(WebDriver browser) {
        super(browser);
    }

    public void fechar() {
        this.browser.quit();
    }

    public void carregarFormulario() {
        browser.navigate().to(URL_ADD_MOVIMENTACAO);
    }

    public MovimentacaoPage cadastrarMovimentacao(String tipo, String dataTransacao, String dataPagamento, String descricao, String interessado, String valor, String conta, String status) {
        Select campoTipo = new Select(browser.findElement(By.id("tipo")));
        campoTipo.selectByVisibleText(tipo);
        browser.findElement(By.id("data_transacao")).sendKeys(dataTransacao);
        browser.findElement(By.id("data_pagamento")).sendKeys(dataPagamento);
        browser.findElement(By.id("descricao")).sendKeys(descricao);
        browser.findElement(By.id("interessado")).sendKeys(interessado);
        browser.findElement(By.id("valor")).sendKeys(valor);
        Select campoConta = new Select(browser.findElement(By.id("conta")));
        campoConta.selectByVisibleText(conta);
        WebElement situacao = browser.findElement(By.id(status));
        situacao.click();
        browser.findElement(By.className("btn-primary")).submit();

        return new MovimentacaoPage(browser);
    }

    public boolean isMensagemDeCadastroComSucesso(){
        return browser.getPageSource().contains("Movimentação adicionada com sucesso!");
    }

    public boolean isPaginaSalvarMovimentacao(){
        return browser.getCurrentUrl().contains(URL_SALVAR_MOVIMENTACAO);
    }

    public boolean isMensagemDeCadastroNulo(){
        return browser.getPageSource().contains("Descrição é obrigatório");
    }
}
