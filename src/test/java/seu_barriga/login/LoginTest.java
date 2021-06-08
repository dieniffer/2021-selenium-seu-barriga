package seu_barriga.login;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class LoginTest {
    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach(){
        paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach(){
        paginaDeLogin.fechar();
    }

    @Test
    public void efetuarLoginComSucesso(){
        paginaDeLogin.efetuarLogin("testeautom@gmail.com","testeautom");
        Assert.assertTrue(paginaDeLogin.isPaginaAtual());
        Assert.assertTrue(paginaDeLogin.isMensagemDeLoginComSucesso("testeautom"));


    }

}
