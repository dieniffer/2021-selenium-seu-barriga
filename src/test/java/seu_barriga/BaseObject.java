package seu_barriga;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseObject {

    protected WebDriver browser;

    public BaseObject(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        if (browser != null) {
            this.browser = browser;
        } else {
            this.browser = new ChromeDriver();
        }

    }

    public void fechar() {
        this.browser.quit();
    }

}
