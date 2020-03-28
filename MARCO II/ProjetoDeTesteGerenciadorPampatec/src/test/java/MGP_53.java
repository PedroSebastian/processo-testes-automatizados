/**
 * Created by Esther Favero on 07/11/2017.
 */
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

public class MGP_53 {

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

    /*
    TESTE PARA LOGAR COM CPF INVÁLIDO
     */
    @Test
    public void testaCPFInvalido() {
        try {
            this.driver.get(this.url);
            WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys(PropertyReader.read("cpf"));

            WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys(PropertyReader.read("senhaValida"));

            campoDeSenha.sendKeys(Keys.ENTER);

            TestLinkIntegration.updateResults("Autenticar com CPF inválido", null, TestLinkAPIResults.TEST_PASSED);
        } catch (Exception exception) {

        }
    }

    /*
    TESTE PARA LOGAR COM SENHA INVÁLIDA
     */
    @Test
    public void testaSenhaInvalida(){
        try {
            this.driver.get(this.url);
            WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys(PropertyReader.read("emailValido"));

            WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys(PropertyReader.read("senhaInvalida"));

            campoDeSenha.sendKeys(Keys.ENTER);

            TestLinkIntegration.updateResults("Autenticar com senha inválida", null, TestLinkAPIResults.TEST_PASSED);
        } catch (Exception exception) {

        }
    }

}

