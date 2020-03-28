import br.edu.unipampa.PropertyReader;
import br.edu.unipampa.TestLinkIntegration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.
        selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import java.util.concurrent.TimeUnit;

public class TestesMgp3 {

    static WebDriver driver;

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

        this.driver.get(PropertyReader.read("url.inicial"));
        WebElement campoDeEmail = driver.findElement(By.id("formularioDeLogin:emailInput"));
        campoDeEmail.sendKeys("matheusleao80@gmail.com");

        WebElement campoDeSenha = driver.findElement(By.id("formularioDeLogin:senhaInput"));
        campoDeSenha.sendKeys("84233915");

        WebElement acessar = driver.findElement(By.xpath(".//*[@id='formularioDeLogin:botaoLogin']"));
        acessar.click();
    }

    @Test
    public void testeStatus() throws TestLinkAPIException {

        try {

            driver.findElement(By.xpath(".//*[@id='menuSuperior']/nav/div/div[2]/ul/li[2]/a")).click();
            driver.findElement(By.xpath(".//*[@id='menuSuperior']/nav/div/div[2]/ul/li[2]/ul/li[2]/input")).click();

            TestLinkIntegration.updateResults("Visualizar status dos meus planos de negócio", null, TestLinkAPIResults.TEST_PASSED);

        } catch (Exception e) {
            TestLinkIntegration.updateResults("Visualizar status dos meus planos de negócio", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
        }
    }

    @Test
    public void testeStatusPrincipal() throws TestLinkAPIException {

        try {

            driver.findElement(By.xpath("html/body/div[1]/div[2]/a/label/i")).click();

            TestLinkIntegration.updateResults("teste Status Principal", null, TestLinkAPIResults.TEST_PASSED);

        } catch (Exception e) {
            TestLinkIntegration.updateResults("teste Status Principal", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
        }

    }

    @Test
    public void testeBuscaStatus() throws TestLinkAPIException {

        try {

            driver.findElement(By.xpath(".//*[@id='menuSuperior']/nav/div/div[2]/ul/li[2]/a")).click();
            driver.findElement(By.xpath(".//*[@id='menuSuperior']/nav/div/div[2]/ul/li[2]/ul/li[2]/input")).click();

            WebElement campoBusca = driver.findElement(By.xpath(".//*[@id='lista_planos:singleDT:globalFilter']"));
            campoBusca.sendKeys("Pré");

            TestLinkIntegration.updateResults("testeBuscaStatus", null, TestLinkAPIResults.TEST_FAILED);

        } catch (Exception e) {
            TestLinkIntegration.updateResults("testeBuscaStatus", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
        }

    }

    @Test
    public void testeBuscaStatusNaoCadastrado() throws TestLinkAPIException {

        try {

            driver.findElement(By.xpath(".//*[@id='menuSuperior']/nav/div/div[2]/ul/li[2]/a")).click();
            driver.findElement(By.xpath(".//*[@id='menuSuperior']/nav/div/div[2]/ul/li[2]/ul/li[2]/input")).click();

            WebElement campoBusca = driver.findElement(By.xpath(".//*[@id='lista_planos:singleDT:globalFilter']"));
            campoBusca.sendKeys("incubação");

            TestLinkIntegration.updateResults("BuscaStatusNaoCadastrado", null, TestLinkAPIResults.TEST_PASSED);

        } catch (Exception e) {
            TestLinkIntegration.updateResults("BuscaStatusNaoCadastrado", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
        }

    }

    @After
    public void tearDown() throws Exception {
        this.driver.quit();
    }

}
