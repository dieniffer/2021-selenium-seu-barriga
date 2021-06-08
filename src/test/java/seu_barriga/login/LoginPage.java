package seu_barriga.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage{
    public static final String URL_LOGIN = "https://seubarriga.wcaquino.me/login";

    private WebDriver browser;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LOGIN);
    }

    public void fechar() {
        this.browser.quit();
    }
}
