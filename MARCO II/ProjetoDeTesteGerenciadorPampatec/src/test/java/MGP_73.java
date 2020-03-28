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
import static org.openqa.selenium.By.partialLinkText;

public class MGP_73 {

        private static WebDriver driver1;
        private static WebDriver driver2;

        private static String url = "http://ggirardon.com:8080/GerenciadorPampatec/";

        @BeforeClass
        public static void setupClass() {
            ChromeDriverManager.getInstance().setup();
        }

        @Before
        public void openBrowser() {
            this.driver1 = new ChromeDriver();
            this.driver1.manage().deleteAllCookies();
            this.driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);        }

        // Identificar os processos preciso passar para incubar minha empresa..

        @After
        public void fecharPagina() throws InterruptedException {

          Thread.sleep(10000);

            this.driver1.quit();
        }

        @Test
        public void confirmaEmailValido() throws TestLinkAPIException, InterruptedException {
            this.driver2 = new ChromeDriver();
            this.driver2.manage().deleteAllCookies();
            this.driver2.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            this.driver2.manage().window().maximize();

            String senha = "teste";
            String senhaConfirmacao = "teste";

            this.driver2.get("https://www.moakt.com/");
            this.driver2.findElement(By.className("mail_butt")).click();
            WebElement Emmail = this.driver2.findElement(By.id("email-address"));
            String capturandoEmail = Emmail.getText();

            //================================ GERAR CPF VALIDO ===========================//
            String end = "https://www.geradordecpf.org";
            this.driver1.get(end);
            this.driver1.findElement(By.id("btn-gerar-cpf")).click();
            String capturandoCPF = this.driver1.findElement(By.id("numero")).getAttribute("value");

            // =========== PAGINA INICIAL ================//

            this.driver1.get(this.url);
            WebElement campoCadastro = this.driver1.findElement(By.id("formularioDeCadastro:botaoContinuaCadastro"));
            campoCadastro.click();


            // ========== PAGINA DE CADASTRO =========//

            WebElement campoNome = this.driver1.findElement(By.id("formularioCadastro:nome"));
            campoNome.sendKeys("Igor Oliveira");

            WebElement campoCpf = this.driver1.findElement(By.id("formularioCadastro:cpf"));
            campoCpf.sendKeys(capturandoCPF);

            WebElement campoTelefone = this.driver1.findElement(By.id("formularioCadastro:telefone"));
            campoTelefone.sendKeys("9999999999");

            WebElement campoRua = this.driver1.findElement(By.id("formularioCadastro:rua"));
            campoRua.sendKeys("Av Tia Maria");

            WebElement campoNumero = this.driver1.findElement(By.id("formularioCadastro:numero"));
            campoNumero.sendKeys("123");

            WebElement campoBairro = this.driver1.findElement(By.id("formularioCadastro:bairro"));
            campoBairro.sendKeys("Alegrete");

            WebElement campoComplemento = this.driver1.findElement(By.id("formularioCadastro:j_idt33"));
            campoComplemento.sendKeys("Atp 2");

            WebElement campoEmail = this.driver1.findElement(By.id("formularioCadastro:email"));
            campoEmail.sendKeys(capturandoEmail);

            WebElement senhaW = this.driver1.findElement(By.id("formularioCadastro:senha"));
            senhaW.sendKeys(senha);

            WebElement senhaConfirmacaoW = this.driver1.findElement(By.id("formularioCadastro:senhaConfig"));
            senhaConfirmacaoW.sendKeys(senhaConfirmacao);

            WebElement confirma = this.driver1.findElement(By.id("formularioCadastro:botaoEnviar"));
            confirma.click();

            Thread.sleep(2000);

            this.driver2.findElement(By.className("text-blue")).click();

            String AssertEquals1 = this.driver2.getWindowHandle();

            WebElement abriEmail = this.driver2.findElement(partialLinkText("Gerenciador Pampatec - Confirmação de E-mail"));
            abriEmail.click();

            String AssertEquals2 = this.driver2.getWindowHandle();

            //========================== Testa a abertura do email =================//

            Assert.assertTrue(AssertEquals1.toString() != AssertEquals2.toString());

            Thread.sleep(10000);

            //Necessário confirmar manualmente o email...

            this.driver1.get("http://ggirardon.com:8080/GerenciadorPampatec/");

            WebElement emailL = this.driver1.findElement(By.id("formularioDeLogin:emailInput"));
            emailL.sendKeys(capturandoEmail);

            WebElement senhaL = this.driver1.findElement(By.id("formularioDeLogin:senhaInput"));
            senhaL.sendKeys(senha);

            WebElement loginDep = this.driver1.findElement(By.id("formularioDeLogin:botaoLogin"));

            loginDep.click();

            Thread.sleep(5000);

            TestLinkIntegration.updateResults("Confirmar um e-mail válido", null, TestLinkAPIResults.TEST_PASSED);

        }

        @Test
        public void emailDigitadoIncorretamente() throws TestLinkAPIException {

            String senha = "teste";
            String senhaConfirmacao = "teste";

            //================================ GERAR CPF VALIDO ===========================//
            //String end = "https://www.geradordecpf.org";
            //this.driver1.get(end);
            //this.driver1.findElement(By.id("btn-gerar-cpf")).click();
            //String capturandoCPF = this.driver1.findElement(By.id("numero")).getAttribute("value");

            // =========== PAGINA INICIAL ================//

            this.driver1.get(this.url);
            WebElement campoCadastro = this.driver1.findElement(By.id("formularioDeCadastro:botaoContinuaCadastro"));
            campoCadastro.click();

            WebElement campoNome = this.driver1.findElement(By.id("formularioCadastro:nome"));
            campoNome.sendKeys("Igor Oliveira");

            WebElement campoCpf = this.driver1.findElement(By.id("formularioCadastro:cpf"));
            campoCpf.sendKeys("000");

            WebElement campoTelefone = this.driver1.findElement(By.id("formularioCadastro:telefone"));
            campoTelefone.sendKeys("9999999999");

            WebElement campoRua = this.driver1.findElement(By.id("formularioCadastro:rua"));
            campoRua.sendKeys("Av Tia Maria");

            WebElement campoNumero = this.driver1.findElement(By.id("formularioCadastro:numero"));
            campoNumero.sendKeys("123");

            WebElement campoBairro = this.driver1.findElement(By.id("formularioCadastro:bairro"));
            campoBairro.sendKeys("Alegrete");

            WebElement campoComplemento = this.driver1.findElement(By.id("formularioCadastro:j_idt33"));
            campoComplemento.sendKeys("Atp 2");

            //========///////////// EMAIL /////////////======//

            WebElement campoEmail = this.driver1.findElement(By.id("formularioCadastro:email"));
            campoEmail.sendKeys("0000000000000@00000");

            WebElement senhaW = this.driver1.findElement(By.id("formularioCadastro:senha"));
            senhaW.sendKeys(senha);

            WebElement senhaConfirmacaoW = this.driver1.findElement(By.id("formularioCadastro:senhaConfig"));
            senhaConfirmacaoW.sendKeys(senhaConfirmacao);

            WebElement confirma = this.driver1.findElement(By.id("formularioCadastro:botaoEnviar"));
            confirma.click();

            // ==================== TESTE ========================================//

            Assert.assertTrue("Não encontrou aviso de que o email é obrigatório", driver1.getPageSource().contains("E-mail inválido"));

            TestLinkIntegration.updateResults("Informar um e-mail inválido", null, TestLinkAPIResults.TEST_PASSED);

        }

        @Test
        public void campoDeEmailVazio() throws TestLinkAPIException {

            String senha = "teste";
            String senhaConfirmacao = "teste";

            //================================ GERAR CPF VALIDO ===========================//
            //String end = "https://www.geradordecpf.org";
            //this.driver1.get(end);
            //this.driver1.findElement(By.id("btn-gerar-cpf")).click();
            //String capturandoCPF = this.driver1.findElement(By.id("numero")).getAttribute("value");

            // =========== PAGINA INICIAL ================//

            this.driver1.get(this.url);
            WebElement campoCadastro = this.driver1.findElement(By.id("formularioDeCadastro:botaoContinuaCadastro"));
            campoCadastro.click();

            WebElement campoNome = this.driver1.findElement(By.id("formularioCadastro:nome"));
            campoNome.sendKeys("Igor Oliveira");

            WebElement campoCpf = this.driver1.findElement(By.id("formularioCadastro:cpf"));
            campoCpf.sendKeys("000");

            WebElement campoTelefone = this.driver1.findElement(By.id("formularioCadastro:telefone"));
            campoTelefone.sendKeys("9999999999");

            WebElement campoRua = this.driver1.findElement(By.id("formularioCadastro:rua"));
            campoRua.sendKeys("Av Tia Maria");

            WebElement campoNumero = this.driver1.findElement(By.id("formularioCadastro:numero"));
            campoNumero.sendKeys("123");

            WebElement campoBairro = this.driver1.findElement(By.id("formularioCadastro:bairro"));
            campoBairro.sendKeys("Alegrete");

            WebElement campoComplemento = this.driver1.findElement(By.id("formularioCadastro:j_idt33"));
            campoComplemento.sendKeys("Atp 2");

            //========///////////// EMAIL /////////////======//

            WebElement senhaW = this.driver1.findElement(By.id("formularioCadastro:senha"));
            senhaW.sendKeys(senha);

            WebElement senhaConfirmacaoW = this.driver1.findElement(By.id("formularioCadastro:senhaConfig"));
            senhaConfirmacaoW.sendKeys(senhaConfirmacao);

            WebElement confirma = this.driver1.findElement(By.id("formularioCadastro:botaoEnviar"));
            confirma.click();

            // ==================== TESTE ========================================//

            Assert.assertTrue("Não encontrou aviso de que o email está vazio", driver1.getPageSource().contains("Insira o seu E-mail antes de enviar"));

            TestLinkIntegration.updateResults("Campo de e-mail vazio", null, TestLinkAPIResults.TEST_PASSED);


        }





    }



