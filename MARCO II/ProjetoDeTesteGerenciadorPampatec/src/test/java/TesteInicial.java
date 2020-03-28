import br.edu.unipampa.PropertyReader;
import br.edu.unipampa.TestLinkIntegration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import testlink.api.java.client.TestLinkAPIResults;

import java.util.concurrent.TimeUnit;

public class TesteInicial {

    private static WebDriver driver;
    private static String url = "http://ggirardon.com:8080/GerenciadorPampatec/";

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void openBrowser() {
        this.driver = new ChromeDriver();
        this.driver.manage().deleteAllCookies();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
    }

    @Test
    public void test() {
        System.out.println(PropertyReader.read("url.inicial"));
    }

    @Test
    public void testeInicial() {
        try {
            this.driver.get(this.url);
            WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys("pedrosebastian90@hotmail.com");

            WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys("12345678");

            campoDeSenha.sendKeys(Keys.ENTER);

            TestLinkIntegration.updateResults("testenovo", null, TestLinkAPIResults.TEST_FAILED);
        } catch (Exception exception) {

        }
    }

}
