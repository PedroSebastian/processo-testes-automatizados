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

public class MGP_07 {

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
    public void salvarPlanoDeNegocios() throws InterruptedException, TestLinkAPIException {

        this.driver.get(url);

        WebElement email = this.driver.findElement(By.id("formularioDeLogin:emailInput"));

        email.sendKeys("igornnt@gmail.com");

        this.driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("unipampa");

        this.driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

        this.driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();

        this.driver.findElement(By.xpath("//*[@id=\"lista_planos\"]/div/div[1]/div[3]/a/label")).click();

        this.driver.findElement(By.xpath("//*[@id=\"formEquipe:botaoSalvar1\"]/span[2]")).click();

        Thread.sleep(3000);

        this.driver.findElement(By.xpath("//*[@id='modalInfoSalvarEquipe']/div/div/div[3]/input")).click();

        WebElement nomeProjeto = this.driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto"));

        nomeProjeto.clear();

        nomeProjeto.sendKeys("Projeto de Resolução de problemas");

        WebElement segmentoClientes = this.driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:segmentoDeClientes\']"));
        segmentoClientes.sendKeys("Alunos");

        WebElement propostaDeValor = this.driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor"));
        propostaDeValor.sendKeys("Teste de Software");

        WebElement atividadesChave = this.driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave"));
        atividadesChave.sendKeys("Automação");

        this.driver.findElement(By.xpath("//*[@id=\'tabAnaliseMercado\']")).click();

        this.driver.findElement(By.id("tabAnaliseMercado")).click();

        this.driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).sendKeys("Excelente");

        this.driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).sendKeys("teste");

        this.driver.findElement(By.id("formulario_cadastro_projeto:canais")).sendKeys("Teste");

        this.driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).sendKeys("Teste");

        this.driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).sendKeys("Teste");

        this.driver.findElement(By.id("tabProdutoServico")).click();

        this.driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).sendKeys("Teste");

        this.driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).sendKeys("Teste");

        this.driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).sendKeys("Teste");

        this.driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).sendKeys("Teste");

        this.driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).sendKeys("Teste");

        this.driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).sendKeys("Teste");

        this.driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).sendKeys("Teste");

        this.driver.findElement(By.id("tabGestaoPessoas")).click();

        this.driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).sendKeys("Teste");

        this.driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).sendKeys("Teste");

        this.driver.findElement(By.id("tabPlanoFinanceiro")).click();

        this.driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).sendKeys("Teste");

        this.driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).sendKeys("Teste");

        this.driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).sendKeys("Teste");

        this.driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar6")).click();

        Thread.sleep(3000);

        this.driver.findElement(By.name("formulario_cadastro_projeto:j_idt57")).click();
        TestLinkIntegration.updateResults("Salvar plano de negócios para editar mais tarde", null, TestLinkAPIResults.TEST_PASSED);


    }

    @Test
    public void editarPlanoDeNegocios() throws InterruptedException, TestLinkAPIException {

        this.driver.get(url);

        WebElement email = this.driver.findElement(By.id("formularioDeLogin:emailInput"));

        email.sendKeys("igornnt@gmail.com");

        this.driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("unipampa");

        this.driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

        this.driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();

        this.driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();

        Thread.sleep(3000);

        WebElement nomeProjeto = this.driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto"));

        nomeProjeto.clear();

        nomeProjeto.sendKeys("Projeto de Resolução de problemas");

        WebElement segmentoClientes = this.driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:segmentoDeClientes\']"));
        segmentoClientes.sendKeys("AlunosEditado");

        WebElement propostaDeValor = this.driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor"));
        propostaDeValor.sendKeys("Teste de SoftwareEditado");

        WebElement atividadesChave = this.driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave"));
        atividadesChave.sendKeys("AutomaçãoEditado");

        this.driver.findElement(By.xpath("//*[@id=\'tabAnaliseMercado\']")).click();

        this.driver.findElement(By.id("tabAnaliseMercado")).click();

        this.driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).sendKeys("ExcelenteEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).sendKeys("testeEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:canais")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("tabProdutoServico")).click();

        this.driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("tabGestaoPessoas")).click();

        //this.driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("tabPlanoFinanceiro")).click();

        this.driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).sendKeys("TesteEditado");

        this.driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar6")).click();

        Thread.sleep(3000);

        this.driver.findElement(By.name("formulario_cadastro_projeto:j_idt57")).click();

        TestLinkIntegration.updateResults("Editar um plano de negócios", null, TestLinkAPIResults.TEST_PASSED);


    }

    @Test
    public void salvarAutomaticamenteQuandoAlterarCampo() throws InterruptedException, TestLinkAPIException {

        this.driver.get(url);

        WebElement email = this.driver.findElement(By.id("formularioDeLogin:emailInput"));

        email.sendKeys("igornnt@gmail.com");

        this.driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("unipampa");

        this.driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

        this.driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();

        this.driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();

        Thread.sleep(3000);

        WebElement nomeProjeto = this.driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto"));

        nomeProjeto.clear();

        nomeProjeto.sendKeys("Projeto de Resolução de problemas");

        WebElement segmentoClientes = this.driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:segmentoDeClientes\']"));
        segmentoClientes.sendKeys("AlunosEditado");

        WebElement propostaDeValor = this.driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor"));
        propostaDeValor.sendKeys("Teste de SoftwareEditado");

        Assert.assertTrue("Suas informações foram salvas com sucesso!", driver.getPageSource().contains("Suas informações foram salvas com sucesso!"));

        WebElement atividadesChave = this.driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave"));
        atividadesChave.sendKeys("AutomaçãoEditado");

        Assert.assertTrue("Suas informações foram salvas com sucesso!", driver.getPageSource().contains("Suas informações foram salvas com sucesso!"));

        TestLinkIntegration.updateResults("Salvar automaticamente quando um campo for alterado", null, TestLinkAPIResults.TEST_PASSED);

    }
}
