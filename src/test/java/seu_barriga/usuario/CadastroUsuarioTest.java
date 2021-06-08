package seu_barriga.usuario;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import java.util.Random;

public class CadastroUsuarioTest{
    private CadastroUsuarioPage paginaDeCadastroDeUsuarios;
    Random gerador = new Random();

    @BeforeEach
    public void beforeEach() {
        this.paginaDeCadastroDeUsuarios = new CadastroUsuarioPage();
    }

    @AfterEach
    public void afterEach() {
        this.paginaDeCadastroDeUsuarios.fechar();
    }


    @Test
    public void cadastrarUsuarioComSucesso(){
        String aleatorio = String.valueOf(gerador.nextInt());
        String nome = "Teste" + aleatorio;
        String email = "teste" + aleatorio + "@teste.com.br";
        String senha = "teste123";

        paginaDeCadastroDeUsuarios.cadastrarUsuario(nome, email,senha);

        Assert.assertTrue(paginaDeCadastroDeUsuarios.isMensagemSucesso());
    }

}
