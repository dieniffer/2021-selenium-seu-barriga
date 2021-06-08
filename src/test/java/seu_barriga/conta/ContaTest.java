package seu_barriga.conta;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seu_barriga.login.LoginPage;

import java.util.Random;

public class ContaTest {
    private CadastroContaPage paginaCadastroDeContas;
    private ContaPage paginaContas;
    Random gerador = new Random();

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        this.paginaContas = paginaDeLogin.efetuarLogin("testeautom@gmail.com","testeautom");

    }

    @AfterEach
    public void afterEach(){
        paginaCadastroDeContas.fechar();
        paginaContas.fechar();
    }

    @Test
    public void cadastrarContaComSucesso(){
        String aleatorio = String.valueOf(gerador.nextInt());
        String nome = "Conta " + aleatorio +" testeautom";
        this.paginaCadastroDeContas = paginaContas.carregarFormulario();
        this.paginaContas = paginaCadastroDeContas.cadastrarConta(nome);
        Assert.assertTrue(paginaCadastroDeContas.isPaginaSalvarConta());
        Assert.assertTrue(paginaCadastroDeContas.isMensagemDeCadastroComSucesso());
        Assert.assertTrue(paginaContas.isContaCadastrada(nome));
    }

    @Test
    public void cadastrarContaNula(){
        this.paginaCadastroDeContas = paginaContas.carregarFormulario();
        this.paginaContas = paginaCadastroDeContas.cadastrarConta("");
        Assert.assertTrue(paginaCadastroDeContas.isPaginaSalvarConta());
        Assert.assertTrue(paginaCadastroDeContas.isMensagemDeCadastroNulo());
    }
}
