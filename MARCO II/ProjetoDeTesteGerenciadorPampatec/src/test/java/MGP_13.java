import br.edu.unipampa.TestLinkIntegration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import java.util.concurrent.TimeUnit;

public class MGP_13 {

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
    // Identificar os processos preciso passar para incubar minha empresa..

    @After
    public void fecharPagina() throws InterruptedException {

        Thread.sleep(10000);

        this.driver.quit();
    }

    @Test
    public void navegaçãoEntreLinksNoWorkflow() throws TestLinkAPIException {


        this.driver.get(this.url);

        WebElement email = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
        email.sendKeys("igornnt@gmail.com");

        WebElement senha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
        senha.sendKeys("unipampa");

        this.driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

        this.driver.findElement(By.cssSelector("a[title='Meus planos de negócio']")).click();

        this.driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();

        this.driver.findElement(By.id("menuSuperior:botao_resultado_preavaliacao")).isDisplayed();

        TestLinkIntegration.updateResults("Navegar dentre as fases do projeto", null, TestLinkAPIResults.TEST_PASSED);

    }

    @Test
    public void verficaSeAsEtapasWorkflowEstaoVisiveis() throws TestLinkAPIException {

        this.driver.get(this.url);

        WebElement email = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
        email.sendKeys("igornnt@gmail.com");

        WebElement senha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
        senha.sendKeys("unipampa");

        this.driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

        this.driver.findElement(By.cssSelector("a[title='Meus planos de negócio']")).click();

        this.driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();

        Assert.assertTrue(this.driver.findElement(By.id("etapa1")).isDisplayed());

        Assert.assertTrue(this.driver.findElement(By.id("etapa2")).isDisplayed());

        Assert.assertTrue(this.driver.findElement(By.id("etapa3")).isDisplayed());

        Assert.assertTrue(this.driver.findElement(By.id("etapa4")).isDisplayed());

        Assert.assertTrue(this.driver.findElement(By.id("etapa5")).isDisplayed());

        TestLinkIntegration.updateResults("Verificar se o Workflow é visível aos usuários", null, TestLinkAPIResults.TEST_PASSED);

    }

}
