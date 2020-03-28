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

public class MGP_02 {

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

    @After
    public void fecharPagina() throws InterruptedException {

        Thread.sleep(10000);

        this.driver.quit();
    }

    @Test
    public void realizarCadastroDoEmpreendedor() throws TestLinkAPIException {

        //================================ GERAR CPF VALIDO ===========================//
        String end = "https://www.geradordecpf.org";
        this.driver.get(end);
        this.driver.findElement(By.id("btn-gerar-cpf")).click();
        String capturandoCPF = this.driver.findElement(By.id("numero")).getAttribute("value");

        //=================== GERAR UM EMAIL VALIDO ==========================//
        this.driver.get("https://www.mohmal.com/pt");
        this.driver.findElement(By.id("rand")).click();
        String capturandoEmail = this.driver.findElement(By.className("email")).getAttribute("data-email");


            // =========== PAGINA INICIAL ================//

            this.driver.get(this.url);
            WebElement campoCadastro = this.driver.findElement(By.id("formularioDeCadastro:botaoContinuaCadastro"));
            campoCadastro.click();

            // ========== PAGINA DE CADASTRO =========//

            WebElement campoNome = this.driver.findElement(By.id("formularioCadastro:nome"));
            campoNome.sendKeys("Igor Oliveira");

            WebElement campoCpf = this.driver.findElement(By.id("formularioCadastro:cpf"));
            campoCpf.sendKeys(capturandoCPF);

            WebElement campoTelefone = this.driver.findElement(By.id("formularioCadastro:telefone"));
            campoTelefone.sendKeys("9999999999");

            WebElement campoRua = this.driver.findElement(By.id("formularioCadastro:rua"));
            campoRua.sendKeys("Av Tia Maria");

            WebElement campoNumero = this.driver.findElement(By.id("formularioCadastro:numero"));
            campoNumero.sendKeys("123");

            WebElement campoBairro = this.driver.findElement(By.id("formularioCadastro:bairro"));
            campoBairro.sendKeys("Alegrete");

            WebElement campoComplemento = this.driver.findElement(By.id("formularioCadastro:j_idt33"));
            campoComplemento.sendKeys("Atp 2");

            WebElement campoEmail = this.driver.findElement(By.id("formularioCadastro:email"));
            campoEmail.sendKeys(capturandoEmail);

            WebElement senha = this.driver.findElement(By.id("formularioCadastro:senha"));
            senha.sendKeys("teste");

            WebElement senhaConfirmacao = this.driver.findElement(By.id("formularioCadastro:senhaConfig"));
            senhaConfirmacao.sendKeys("teste");

            WebElement confirma = this.driver.findElement(By.id("formularioCadastro:botaoEnviar"));
            confirma.click();

            TestLinkIntegration.updateResults("Cadastrar um empreendedor", null, TestLinkAPIResults.TEST_PASSED);
    }



    @Test
    public void editarCadastroDoEmpreendedor() throws InterruptedException, TestLinkAPIException {
        //================== CAPTURANDO NOVOS DADOS =================// //
        this.driver.get("https://www.4devs.com.br/gerador_de_pessoas");
        this.driver.findElement(By.id("bt_gerar_pessoa")).click();

        String nomeGerado = this.driver.findElement(By.id("nome")).getAttribute("value");
        String enderecoGerado = this.driver.findElement(By.id("endereco")).getAttribute("value");
        String bairroGerado = this.driver.findElement(By.id("bairro")).getAttribute("value");
        String numeroGerado = this.driver.findElement(By.id("numero")).getAttribute("value");
        String senhaAtual = "unipampa";


        // ================= REALIZANDO O LOGIN ====================== //

        this.driver.get(this.url);

        WebElement email = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
        email.sendKeys("igornnt@gmail.com");

        WebElement senha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
        senha.sendKeys("unipampa");

        this.driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

        // ================ PAGINA DO USUÁRIO ==========================//

        this.driver.findElement(By.cssSelector("#menuSuperior nav.navbar.navbar-default div.container-fluid div:nth-of-type(2) ul.nav.navbar-nav.navbar-right li:nth-of-type(3) a.aComoBotaoMenu")).click();

        this.driver.findElement(By.name("menuSuperior:menuSuperior:j_idt30")).click();

        // ================== PAGINA DE ALTERAÇÃO ========================//

        this.driver.findElement(By.id("formularioCadastro:nome")).clear();
        WebElement nomeAlteracao = this.driver.findElement(By.id("formularioCadastro:nome"));
        nomeAlteracao.sendKeys(nomeGerado);

        this.driver.findElement(By.id("formularioCadastro:rua")).clear();
        WebElement enderecoAlteracao = this.driver.findElement(By.id("formularioCadastro:rua"));
        enderecoAlteracao.sendKeys(enderecoGerado);

        this.driver.findElement(By.id("formularioCadastro:numero")).clear();
        WebElement numeroAlteracao = this.driver.findElement(By.id("formularioCadastro:numero"));
        numeroAlteracao.sendKeys(numeroGerado);

        this.driver.findElement(By.id("formularioCadastro:bairro")).clear();
        WebElement bairroAlteracao = this.driver.findElement(By.id("formularioCadastro:bairro"));
        bairroAlteracao.sendKeys(bairroGerado);

        WebElement senhaConfirma = this.driver.findElement(By.id("formularioCadastro:senhaAtual"));
        senhaConfirma.sendKeys(senhaAtual);

        this.driver.findElement(By.id("formularioCadastro:botaoFinalizarEdicao")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.driver.findElement(By.id("formularioCadastro:botaoConfirmar")).click();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TestLinkIntegration.updateResults("Editar cadastro de um empreendedor", null, TestLinkAPIResults.TEST_PASSED);
    }


}