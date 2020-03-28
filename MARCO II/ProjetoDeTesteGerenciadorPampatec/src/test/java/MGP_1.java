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
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import testlink.api.java.client.TestLinkAPIResults;

import java.util.concurrent.TimeUnit;

public class MGP_1 {

    private static WebDriver driver;
    private static String url = "http://ggirardon.com:8080/GerenciadorPampatec/view/empreendedor/enviarProjeto.jsf";

    @FindBy(name = "formulario_cadastro_projeto:j_idt61")
    @CacheLookup
    private WebElement submeterProjeto;

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
    TESTE PARA CONSULTAR PLANO DE NEGÓCIO ATRAVÉS DA DATA DE CRIAÇÃO
     */
    @Test
    public void consultaPlanoPelaDataDeCriacaoTest() {
        try {
            this.driver.get(PropertyReader.read("url.inicial"));
            WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys(PropertyReader.read("emailValido"));

            WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys(PropertyReader.read("senhaValida"));

            campoDeSenha.sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//a[contains(.,'Planos de Negócio')]")).click();

            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt28")).click();

            WebElement campoProcura = this.driver.findElement(By.id("lista_planos:singleDT:globalFilter"));
            campoProcura.sendKeys(PropertyReader.read("data.criacao"));




            TestLinkIntegration.updateResults("Consultar um plano negócio através da data de criação", null, TestLinkAPIResults.TEST_FAILED);
        } catch (Exception exception) {

        }
    }

    /*
    TESTE PARA INSERIR UM EMPREENDEDOR NO PLANO DE NEGÓCIO COM EMAIL INVÁLIDO
     */

    @Test
    public void adicionarEmailInvalidoNoPlanoTest() {
        try {
            this.driver.get(PropertyReader.read("url.inicial"));
            WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys(PropertyReader.read("emailValido"));

            WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys(PropertyReader.read("senhaValida"));

            campoDeSenha.sendKeys(Keys.ENTER);

            this.driver.get(PropertyReader.read("url.plano"));

            driver.findElement(By.xpath("//a[contains(.,'Criar novo plano de negócio')]")).click();

            WebElement element = driver.findElement(By.name("formEquipe:autocomplete_input"));

            element.sendKeys(PropertyReader.read("emailInvalido"));

            driver.findElement(By.id("formEquipe:j_idt203")).click();

            TestLinkIntegration.updateResults("Adicionar na equipe um empreendedor com e-mail inválido", null, TestLinkAPIResults.TEST_PASSED);
        } catch (Exception exception) {

        }
    }

    /*
    TESTE PARA CONSULTAR O PLANO DE NEGÓCIO ATRAVÉS DA DATA DE ENVIO
     */

    @Test
    public void testeConsultaPlanoPelaDataDeEnvio(){
        try {
            this.driver.get(PropertyReader.read("url.inicial"));
            WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys(PropertyReader.read("emailValido"));

            WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys(PropertyReader.read("senhaValida"));

            campoDeSenha.sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//a[contains(.,'Planos de Negócio')]")).click();

            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt28")).click();

            WebElement campoProcura = this.driver.findElement(By.id("lista_planos:singleDT:globalFilter"));
            campoProcura.sendKeys(PropertyReader.read("data.envio"));


            TestLinkIntegration.updateResults("Consultar um plano negócio através da data de envio", null, TestLinkAPIResults.TEST_FAILED);
        } catch (Exception exception) {

        }
    }

    /*
    TESTA SE É POSSÍVEL SALVAR PLANO COM CAMPOS VAZIOS
     */
    @Test
    public void salvarPlanoComCamposVaziosTest() {

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

            driver.findElement(By.xpath("//*[@id=\"formulario_cadastro_projeto:botaoSalvar2\"]")).click();

            driver.findElement(By.xpath("//*[@id=\"modalInfoSalvar\"]/div/div/div[3]/input")).submit();


            TestLinkIntegration.updateResults("Salvar plano de negócio com campos vazios", null, TestLinkAPIResults.TEST_FAILED);
        } catch (Exception exception) {

        }

    }

}


