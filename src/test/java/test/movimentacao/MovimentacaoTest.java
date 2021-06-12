package test.movimentacao;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.login.LoginPage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MovimentacaoTest {
    private CadastroMovimentacaoPage paginaCadastroDeMovimentacoes;
    private MovimentacaoPage paginaMovimentacoes;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        this.paginaMovimentacoes = paginaDeLogin.efetuarLoginMov("testeautom@gmail.com","testeautom");
        this.paginaCadastroDeMovimentacoes = paginaMovimentacoes.carregarFormulario();
    }

    @AfterEach
    public void afterEach(){
        paginaCadastroDeMovimentacoes.fechar();
        paginaMovimentacoes.fechar();
    }

    @Test
    public void cadastrarMovimentacaoComSucesso(){
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String descricao = "Movimentacao do dia " + data;
        String valor = "500.00";
        this.paginaMovimentacoes = paginaCadastroDeMovimentacoes.cadastrarMovimentacao("Despesa",
                data,data,descricao, "Testeautom",valor,"Conta 917250264 testeautom",
                "status_pendente");
        Assert.assertTrue(paginaCadastroDeMovimentacoes.isPaginaSalvarMovimentacao());
        Assert.assertTrue(paginaCadastroDeMovimentacoes.isMensagemDeCadastroComSucesso());
        Assert.assertTrue(paginaMovimentacoes.isMovimentacaoCadastrada(descricao));
    }

    @Test
    public void cadastrarMovimentacaoNula(){
        this.paginaMovimentacoes = paginaCadastroDeMovimentacoes.cadastrarMovimentacao("Despesa",
                "","","", "","","Conta 917250264 testeautom", "status_pendente");
        Assert.assertTrue(paginaCadastroDeMovimentacoes.isPaginaSalvarMovimentacao());
        Assert.assertTrue(paginaCadastroDeMovimentacoes.isMensagemDeCadastroNulo());
    }
}
