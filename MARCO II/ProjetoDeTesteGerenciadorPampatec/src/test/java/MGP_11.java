import br.edu.unipampa.PropertyReader;
import br.edu.unipampa.TestLinkIntegration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Esther Favero on 09/11/2017.
 */
public class MGP_11 {

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
    TESTA ADICIONAR UM EMPREENDEDOR NO PLANO
     */
    @Test
    public void adicionaEmpreendendorNoPlanoTest() throws TestLinkAPIException {
        try {
            this.driver.get(PropertyReader.read("url.inicial"));
            WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys(PropertyReader.read("emailValido"));

            WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys(PropertyReader.read("senhaValida"));

            campoDeSenha.sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//a[contains(.,'Planos de Negócio')]")).click();

            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();

            WebElement element = driver.findElement(By.name("formEquipe:autocomplete_input"));

            element.sendKeys(PropertyReader.read("email1"));

            driver.findElement(By.id("formEquipe:j_idt203")).click();

            TestLinkIntegration.updateResults("Adicionar um empreendedor no plano de negócio", null, TestLinkAPIResults.TEST_PASSED);
        } catch (Exception exception) {
            TestLinkIntegration.updateResults("Adicionar um empreendedor no plano de negócio", exception.getMessage(), TestLinkAPIResults.TEST_FAILED);
        }
    }

    /*
    TESTA REMOVER UM EMPREENDEDOR DO PLANO
     */
    @Test
    public void removeEmpreendedorDoPlanoTest() throws TestLinkAPIException {
        try {
            this.driver.get(PropertyReader.read("url.inicial"));
            WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys(PropertyReader.read("emailValido"));

            WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys(PropertyReader.read("senhaValida"));

            campoDeSenha.sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//a[contains(.,'Planos de Negócio')]")).click();

            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();

            WebElement element = driver.findElement(By.name("formEquipe:autocomplete_input"));

            element.sendKeys(PropertyReader.read("email1"));

            driver.findElement(By.id("formEquipe:j_idt203")).click();

            driver.findElement(By.id("formEquipe:tabelaEmpreendedores:1:botaoExcluirEmpreendedor")).click();

            TestLinkIntegration.updateResults("Remover um empreendedor do plano de negócio", null, TestLinkAPIResults.TEST_PASSED);
        } catch (Exception exception) {
            TestLinkIntegration.updateResults("Adicionar um empreendedor no plano de negócio", exception.getMessage(), TestLinkAPIResults.TEST_FAILED);
        }
    }

    /*
    TESTA SE O SISTEMA INFORMA UMA MENSAGEM QUANDO JÁ EXISTE UM EMPREENDEDOR ADICIONADO
     */
    @Test
    public void adicionaMesmoEmpreendendorTest() throws TestLinkAPIException {
        try {
            this.driver.get(PropertyReader.read("url.inicial"));
            WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys(PropertyReader.read("emailValido"));

            WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys(PropertyReader.read("senhaValida"));

            campoDeSenha.sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//a[contains(.,'Planos de Negócio')]")).click();

            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();

            WebElement element = driver.findElement(By.name("formEquipe:autocomplete_input"));

            element.sendKeys(PropertyReader.read("email1"));

            driver.findElement(By.id("formEquipe:j_idt203")).click();

            WebElement element1 = driver.findElement(By.name("formEquipe:autocomplete_input"));

            element1.sendKeys(PropertyReader.read("email2"));

            driver.findElement(By.id("formEquipe:j_idt203")).click();

            WebElement element2 = driver.findElement(By.name("formEquipe:autocomplete_input"));

            element2.sendKeys(PropertyReader.read("email1"));

            driver.findElement(By.id("formEquipe:j_idt203")).click();

            TestLinkIntegration.updateResults("Adicionar empreendedor já existente no plano de negócio", null, TestLinkAPIResults.TEST_PASSED);
        } catch (Exception exception) {
            TestLinkIntegration.updateResults("Adicionar um empreendedor no plano de negócio", exception.getMessage(), TestLinkAPIResults.TEST_FAILED);
        }
    }

    /*
    TESTA SE É POSSÍVEL ADICIONAR MAIS DE 3 EMPREENDEDORES NO PLANO DE NEGÓCIO
     */
    @Test
    public void adicionaEmpreendedoresAlemDoLimiteTest() throws TestLinkAPIException {
        try {
            this.driver.get(PropertyReader.read("url.inicial"));
            WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys(PropertyReader.read("emailValido"));

            WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys(PropertyReader.read("senhaValida"));

            campoDeSenha.sendKeys(Keys.ENTER);


            driver.findElement(By.xpath("//a[contains(.,'Planos de Negócio')]")).click();

            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();

            Thread.sleep(3000);

            driver.findElement(By.name("formEquipe:autocomplete_input")).sendKeys(PropertyReader.read("email3"));

            driver.findElement(By.id("formEquipe:j_idt203")).click();

            Thread.sleep(3000);

            driver.findElement(By.name("formEquipe:autocomplete_input")).sendKeys(PropertyReader.read("email4"));

            driver.findElement(By.id("formEquipe:j_idt203")).click();

            Thread.sleep(3000);

            driver.findElement(By.name("formEquipe:autocomplete_input")).sendKeys(PropertyReader.read("email2"));

            driver.findElement(By.id("formEquipe:j_idt203")).click();

            Thread.sleep(3000);

            driver.findElement(By.name("formEquipe:autocomplete_input")).sendKeys(PropertyReader.read("email5"));

            driver.findElement(By.id("formEquipe:j_idt203")).click();



            TestLinkIntegration.updateResults("Adicionar mais de três empreendedores no plano de negócio", null, TestLinkAPIResults.TEST_FAILED);
        } catch (Exception exception) {
            TestLinkIntegration.updateResults("Adicionar um empreendedor no plano de negócio", exception.getMessage(), TestLinkAPIResults.TEST_FAILED);
        }
    }

    @Test
    public void testModalMensagemConfirmaEquipe() throws Exception {
        this.driver.get(PropertyReader.read("url.inicial"));
        WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
        campoDeEmail.sendKeys(PropertyReader.read("emailValido"));

        WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
        campoDeSenha.sendKeys(PropertyReader.read("senhaValida"));

        campoDeSenha.sendKeys(Keys.ENTER);

        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("http://ggirardon.com:8080/GerenciadorPampatec/view/empreendedor/homeEmpreendedor.jsf");
        driver.findElement(By.linkText("Planos de Negócio")).click();
        driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();
        driver.findElement(By.id("formEquipe:autocomplete_input")).click();
        driver.findElement(By.id("formEquipe:autocomplete_input")).clear();
        driver.findElement(By.id("formEquipe:autocomplete_input")).sendKeys("pedro@email.com");
        driver.findElement(By.id("formEquipe:j_idt203")).click();
        driver.findElement(By.xpath("//button[@id='formEquipe:botaoSalvar1']/span[2]")).click();

        List<WebElement> modal = driver.findElements(By.xpath("//div[@id='modalInfoSalvarEquipe']/div/div/div[2]"));

        Assert.assertTrue(!modal.isEmpty());

        if (!modal.isEmpty()) {
            TestLinkIntegration.updateResults("Mensagem de confirmação ao adicionar equipe", null, TestLinkAPIResults.TEST_PASSED, PropertyReader.read("testlink-key.pedro"));
        } else {
            TestLinkIntegration.updateResults("Mensagem de confirmação ao adicionar equipe",
                    "Aparentemente o modal com a mensagem de confirmação não foi apresentado ao usuário.", TestLinkAPIResults.TEST_PASSED, PropertyReader.read("testlink-key.pedro"));
        }
    }

    @Test
    public void testOperadorCorrespondenteNaoPodeSerRemovido() throws Exception {
        this.driver.get(PropertyReader.read("url.inicial"));
        WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
        campoDeEmail.sendKeys(PropertyReader.read("emailValido"));

        WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
        campoDeSenha.sendKeys(PropertyReader.read("senhaValida"));

        campoDeSenha.sendKeys(Keys.ENTER);

        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("http://ggirardon.com:8080/GerenciadorPampatec/view/empreendedor/homeEmpreendedor.jsf");
        driver.findElement(By.linkText("Planos de Negócio")).click();
        driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();
        driver.findElement(By.id("formEquipe:autocomplete_input")).click();
        driver.findElement(By.id("formEquipe:autocomplete_input")).clear();
        driver.findElement(By.id("formEquipe:autocomplete_input")).sendKeys("pedrosebastian90@gmail.com");
        driver.findElement(By.xpath("//button[@id='formEquipe:j_idt203']/span[2]")).click();
        driver.findElement(By.xpath("//button[@id='formEquipe:tabelaEmpreendedores:1:botaoExcluirEmpreendedor']/span[2]")).click();

        List<WebElement> empreendedor = driver.findElements(By.xpath("//tbody[@id='formEquipe:tabelaEmpreendedores_data']/tr[2]/td"));

        Assert.assertTrue(!empreendedor.isEmpty());

        if (!empreendedor.isEmpty()) {
            TestLinkIntegration.updateResults("Operador correspondente não pode ser removido do plano", null, TestLinkAPIResults.TEST_PASSED, PropertyReader.read("testlink-key.pedro"));
        } else {
            TestLinkIntegration.updateResults("Operador correspondente não pode ser removido do plano",
                    "Aparentemente o empreendedor correspondente não encontra-se na lista de empreendedores.", TestLinkAPIResults.TEST_PASSED, PropertyReader.read("testlink-key.pedro"));
        }
    }

    @After
    public void tearDown() throws Exception {
        this.driver.quit();
    }
}
