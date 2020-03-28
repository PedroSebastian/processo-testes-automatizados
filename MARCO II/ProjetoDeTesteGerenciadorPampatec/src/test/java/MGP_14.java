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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testlink.api.java.client.TestLinkAPIResults;

import java.util.concurrent.TimeUnit;

/**
 * Created by Esther Favero on 13/11/2017.
 */
public class MGP_14 {

    private static WebDriver driver;
    private static String url = "http://ggirardon.com:8080/GerenciadorPampatec/view/empreendedor/enviarProjeto.jsf";

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
    TESTA SE OS DADOS DO PLANO DE NEGÓCIO FORAM SALVOS CORRETAMENTE
     */
    @Test
    public void revisaDadosDoPlanoDeNegocioTest(){
        try {
            this.driver.get(PropertyReader.read("url.inicial"));
            WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys(PropertyReader.read("emailValido"));

            WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys(PropertyReader.read("senhaValida"));

            campoDeSenha.sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();

            Thread.sleep(1000);

            driver.findElement(By.id("lista_planos:singleDT:1:visualizar")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("botao_revisar"))).click();

            TestLinkIntegration.updateResults("Revisar os dados do plano de negócio", null, TestLinkAPIResults.TEST_PASSED);
        }
        catch (Exception exception){

        }
    }

    /*
    TESTA SE É POSSÍVEL IMPRIMIR O PLANO DE NEGÓCIO
     */
    @Test
    public void imprimirPlanoTest(){
        try {
            this.driver.get(PropertyReader.read("url.inicial"));
            WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys(PropertyReader.read("emailValido"));

            WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys(PropertyReader.read("senhaValida"));

            campoDeSenha.sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();

            Thread.sleep(1000);

            driver.findElement(By.id("lista_planos:singleDT:1:visualizar")).click();
//
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("botao_revisar"))).click();

            driver.findElement(By.id("form_revisao:j_idt283")).click();

            TestLinkIntegration.updateResults("Imprimir plano de negócio", null, TestLinkAPIResults.TEST_PASSED);
        }
        catch (Exception exception){

        }
    }
}
