package seu_barriga.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Assert.assertTrue(paginaDeLogin.isPaginaLogar());
        Assert.assertTrue(paginaDeLogin.isMensagemDeLoginComSucesso("testeautom"));
    }

    @Test
    public void efetuarLoginInvalido(){
        paginaDeLogin.efetuarLogin("testeautom2@gmail.com","testeautom2");
        Assert.assertTrue(paginaDeLogin.isPaginaLogar());
        Assert.assertTrue(paginaDeLogin.isMensagemDeLoginInvalido());
    }

}
