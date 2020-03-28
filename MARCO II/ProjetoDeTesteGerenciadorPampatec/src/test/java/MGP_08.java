import br.edu.unipampa.PropertyReader;
import br.edu.unipampa.TestLinkIntegration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPageObject;
import pages.LoginPage;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pedro Sebastian on 10/11/2017.
 */
public class MGP_08 {

    private WebDriver driver;
    private String baseUrl = "http://ggirardon.com:8080/GerenciadorPampatec/";
    ;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private String testLinkKey = PropertyReader.read("testlink-key.pedro");

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void openBrowser() {
        this.driver = new ChromeDriver();
        this.driver.manage().deleteAllCookies();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
    }

    @Test
    public void submeterPlanoDeNegocioComsucesso() throws TestLinkAPIException {
        try {
            driver.get("http://ggirardon.com:8080/GerenciadorPampatec/");
            driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("esther_msf@hotmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("esther@123");
            driver.findElement(By.xpath("//button[@id='formularioDeLogin:botaoLogin']/span[2]")).click();
            driver.findElement(By.linkText("Planos de Negócio")).click();
            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();
            driver.findElement(By.xpath("//button[@id='formEquipe:botaoSalvar1']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt65"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).sendKeys("Plano de Negócio");
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).sendKeys("Segmento de Clientes");
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).sendKeys("Proposta de Valor");
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).sendKeys("Atividades Chave");
            driver.findElement(By.xpath("//div[@id='div_apresentacao_formulario']/div")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabAnaliseMercado"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:relacoComClientes"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).sendKeys("Relações com clientes");
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).sendKeys("Parcerias chave");
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).sendKeys("Canais");
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).sendKeys("Recursos principais");
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).sendKeys("Concorrentes");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabProdutoServico"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:estagioDeEvolucao"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao")).click();
            new Select(driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao"))).selectByVisibleText("Clientes Pagando");
            driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).sendKeys("Tecnologia e processos");
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).sendKeys("Potencial de inovação tecnológica");
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).sendKeys("Aplicações");
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).sendKeys("Dificuldade esperadas");
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).sendKeys("Interação entre empresa e Universidade");
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).sendKeys("Interação entre empresa, comunidade e governo");
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).sendKeys("Infra-estrutura");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabGestaoPessoas"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:participacaoAcionaria"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).sendKeys("Haverão sócios");
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).sendKeys("Potencial de geração de empregos");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabPlanoFinanceiro"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:fontesDeReceita"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).sendKeys("Fontes de receita");
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).sendKeys("Estrutura de custos");
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).sendKeys("Investimento inicial");
            driver.findElement(By.xpath("//button[@id='formulario_cadastro_projeto:botao_adicionar_nova_linhaVariavel']/span[2]")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:panel_custo_variavel")).click();
            driver.findElement(By.xpath("//button[@id='formulario_cadastro_projeto:botaoSalvar6']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt57"))).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("botao_submeter"))).click();

            driver.findElement(By.xpath("//button[@id='form_enviar_projeto:j_idt221']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt61"))).click();

            TestLinkIntegration.updateResults("Submeter Plano de Negócio com Sucesso", null, TestLinkAPIResults.TEST_PASSED, this.testLinkKey);
        } catch (Exception exception) {
            exception.printStackTrace();

            Assert.fail();

            TestLinkIntegration.updateResults("Submeter Plano de Negócio com Sucesso", exception.getMessage(), TestLinkAPIResults.TEST_FAILED, this.testLinkKey);
        }
    }

    @Test
    public void naoDevePermitirSubmeterPlanoSemInformarNegocio() throws TestLinkAPIException {
        try {
            driver.get("http://ggirardon.com:8080/GerenciadorPampatec/");
            driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("esther_msf@hotmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("esther@123");
            driver.findElement(By.xpath("//button[@id='formularioDeLogin:botaoLogin']/span[2]")).click();
            driver.findElement(By.linkText("Planos de Negócio")).click();
            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();
            driver.findElement(By.xpath("//button[@id='formEquipe:botaoSalvar1']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt65"))).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabAnaliseMercado"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:relacoComClientes"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).sendKeys("Análise de Mercado");
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).sendKeys("Parcerias chave");
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).sendKeys("Canais");
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).sendKeys("Recursos principais");
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).sendKeys("Concorrentes");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabProdutoServico"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:estagioDeEvolucao"))).click();

            new Select(driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao"))).selectByVisibleText("Projeto Detalhado");
            driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).sendKeys("Tecnologia");
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).sendKeys("Potencial");
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).sendKeys("Aplicações");
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).sendKeys("Dificuldades esperadas");
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).sendKeys("Interação entre empresa e Universidade");
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).sendKeys("Interação entre empresa, comunidade e governo");
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).sendKeys("Quanto de espaço será necessário?");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabGestaoPessoas"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:participacaoAcionaria"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).sendKeys("Haverão sócios");
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).sendKeys("Potencial");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabPlanoFinanceiro"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:fontesDeReceita"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).sendKeys("Fontes de receita");
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).sendKeys("Estrutura de custos");
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).sendKeys("Investimento inicial");
            driver.findElement(By.xpath("//button[@id='formulario_cadastro_projeto:botao_adicionar_nova_linhaVariavel']/span[2]")).click();
            driver.findElement(By.xpath("//button[@id='formulario_cadastro_projeto:botaoSalvar6']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt57"))).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("botao_submeter"))).click();

            driver.findElement(By.xpath("//div[@id='vertical_etapa_elaboracao']/div")).click();
            driver.findElement(By.id("botao_submeter")).click();
            driver.findElement(By.xpath("//button[@id='form_enviar_projeto:j_idt221']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt61"))).click();

            TestLinkIntegration.updateResults("Não deve permitir submeter modelo de negócios sem informar a seção Negócio", null, TestLinkAPIResults.TEST_PASSED);
        } catch (Exception exception) {
            exception.printStackTrace();

            Assert.fail();

            TestLinkIntegration.updateResults("Não deve permitir submeter modelo de negócios sem informar a seção Negócio", exception.getMessage(), TestLinkAPIResults.TEST_FAILED);
        }
    }

    @Test
    public void naoDevePermitirSubmeterPlanoSemInformarAnaliseDeMercado() throws TestLinkAPIException {
        try {
            driver.get("http://ggirardon.com:8080/GerenciadorPampatec/");
            driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("esther_msf@hotmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("esther@123");
            driver.findElement(By.xpath("//button[@id='formularioDeLogin:botaoLogin']/span[2]")).click();
            driver.findElement(By.linkText("Planos de Negócio")).click();
            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();
            driver.findElement(By.xpath("//button[@id='formEquipe:botaoSalvar1']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt65"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).sendKeys("Plano de Negócio");
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).sendKeys("Segmento de Clientes");
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).sendKeys("Proposta de Valor");
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).sendKeys("Atividades Chave");
            driver.findElement(By.xpath("//div[@id='div_apresentacao_formulario']/div")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabProdutoServico"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:estagioDeEvolucao"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao")).click();
            new Select(driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao"))).selectByVisibleText("Clientes Pagando");
            driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).sendKeys("Tecnologia e processos");
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).sendKeys("Potencial de inovação tecnológica");
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).sendKeys("Aplicações");
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).sendKeys("Dificuldade esperadas");
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).sendKeys("Interação entre empresa e Universidade");
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).sendKeys("Interação entre empresa, comunidade e governo");
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).sendKeys("Infra-estrutura");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabGestaoPessoas"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:participacaoAcionaria"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).sendKeys("Haverão sócios");
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).sendKeys("Potencial de geração de empregos");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabPlanoFinanceiro"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:fontesDeReceita"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).sendKeys("Fontes de receita");
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).sendKeys("Estrutura de custos");
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).sendKeys("Investimento inicial");
            driver.findElement(By.xpath("//button[@id='formulario_cadastro_projeto:botao_adicionar_nova_linhaVariavel']/span[2]")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:panel_custo_variavel")).click();
            driver.findElement(By.xpath("//button[@id='formulario_cadastro_projeto:botaoSalvar6']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt57"))).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("botao_submeter"))).click();

            driver.findElement(By.xpath("//button[@id='form_enviar_projeto:j_idt221']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt61"))).click();

            TestLinkIntegration.updateResults("Não deve permitir submeter plano de negócios sem informar Análise de Mercado", null, TestLinkAPIResults.TEST_PASSED);
        } catch (Exception exception) {
            exception.printStackTrace();

            Assert.fail();

            TestLinkIntegration.updateResults("Não deve permitir submeter plano de negócios sem informar Análise de Mercado", exception.getMessage(), TestLinkAPIResults.TEST_FAILED);
        }
    }

    @Test
    public void naoDevePermitirSubmeterPlanoSemInformarProdutoOuServico() throws TestLinkAPIException {
        try {
            driver.get("http://ggirardon.com:8080/GerenciadorPampatec/");
            driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("esther_msf@hotmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("esther@123");
            driver.findElement(By.xpath("//button[@id='formularioDeLogin:botaoLogin']/span[2]")).click();
            driver.findElement(By.linkText("Planos de Negócio")).click();
            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();
            driver.findElement(By.xpath("//button[@id='formEquipe:botaoSalvar1']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt65"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).sendKeys("Plano de Negócio");
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).sendKeys("Segmento de Clientes");
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).sendKeys("Proposta de Valor");
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).sendKeys("Atividades Chave");
            driver.findElement(By.xpath("//div[@id='div_apresentacao_formulario']/div")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabAnaliseMercado"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:relacoComClientes"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).sendKeys("Relações com clientes");
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).sendKeys("Parcerias chave");
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).sendKeys("Canais");
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).sendKeys("Recursos principais");
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).sendKeys("Concorrentes");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabGestaoPessoas"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:participacaoAcionaria"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).sendKeys("Haverão sócios");
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).sendKeys("Potencial de geração de empregos");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabPlanoFinanceiro"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:fontesDeReceita"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).sendKeys("Fontes de receita");
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).sendKeys("Estrutura de custos");
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).sendKeys("Investimento inicial");
            driver.findElement(By.xpath("//button[@id='formulario_cadastro_projeto:botao_adicionar_nova_linhaVariavel']/span[2]")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:panel_custo_variavel")).click();
            driver.findElement(By.xpath("//button[@id='formulario_cadastro_projeto:botaoSalvar6']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt57"))).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("botao_submeter"))).click();

            driver.findElement(By.xpath("//button[@id='form_enviar_projeto:j_idt221']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt61"))).click();

            TestLinkIntegration.updateResults("Não deve permitir submeter modelo de negócios sem informar a seção Produto ou Serviço", null, TestLinkAPIResults.TEST_PASSED, this.testLinkKey);
        } catch (Exception exception) {
            exception.printStackTrace();

            Assert.fail();

            TestLinkIntegration.updateResults("Não deve permitir submeter modelo de negócios sem informar a seção Produto ou Serviço", exception.getMessage(), TestLinkAPIResults.TEST_FAILED, this.testLinkKey);
        }
    }

    @Test
    public void naoDevePermitirSubmeterPlanoSemInformarGestaoDePessoas() throws TestLinkAPIException {
        try {
            driver.get("http://ggirardon.com:8080/GerenciadorPampatec/");
            driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("esther_msf@hotmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("esther@123");
            driver.findElement(By.xpath("//button[@id='formularioDeLogin:botaoLogin']/span[2]")).click();
            driver.findElement(By.linkText("Planos de Negócio")).click();
            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();
            driver.findElement(By.xpath("//button[@id='formEquipe:botaoSalvar1']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt65"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).sendKeys("Plano de Negócio");
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).sendKeys("Segmento de Clientes");
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).sendKeys("Proposta de Valor");
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).sendKeys("Atividades Chave");
            driver.findElement(By.xpath("//div[@id='div_apresentacao_formulario']/div")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabAnaliseMercado"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:relacoComClientes"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).sendKeys("Relações com clientes");
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).sendKeys("Parcerias chave");
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).sendKeys("Canais");
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).sendKeys("Recursos principais");
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).sendKeys("Concorrentes");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabProdutoServico"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:estagioDeEvolucao"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao")).click();
            new Select(driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao"))).selectByVisibleText("Clientes Pagando");
            driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).sendKeys("Tecnologia e processos");
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).sendKeys("Potencial de inovação tecnológica");
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).sendKeys("Aplicações");
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).sendKeys("Dificuldade esperadas");
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).sendKeys("Interação entre empresa e Universidade");
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).sendKeys("Interação entre empresa, comunidade e governo");
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).sendKeys("Infra-estrutura");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabPlanoFinanceiro"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:fontesDeReceita"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).sendKeys("Fontes de receita");
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).sendKeys("Estrutura de custos");
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).sendKeys("Investimento inicial");
            driver.findElement(By.xpath("//button[@id='formulario_cadastro_projeto:botao_adicionar_nova_linhaVariavel']/span[2]")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:panel_custo_variavel")).click();
            driver.findElement(By.xpath("//button[@id='formulario_cadastro_projeto:botaoSalvar6']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt57"))).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("botao_submeter"))).click();

            driver.findElement(By.xpath("//button[@id='form_enviar_projeto:j_idt221']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt61"))).click();

            TestLinkIntegration.updateResults("Não deve permitir submeter modelo de negócios sem informar a seção Gestão de Pessoas", null, TestLinkAPIResults.TEST_PASSED, this.testLinkKey);
        } catch (Exception exception) {
            exception.printStackTrace();

            Assert.fail();

            TestLinkIntegration.updateResults("Não deve permitir submeter modelo de negócios sem informar a seção Gestão de Pessoas", exception.getMessage(), TestLinkAPIResults.TEST_FAILED, this.testLinkKey);
        }
    }

    @Test
    public void naoDevePermitirSubmeterPlanoSemInformarPlanoFinanceiro() throws TestLinkAPIException {
        try {
            driver.get("http://ggirardon.com:8080/GerenciadorPampatec/");
            driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("esther_msf@hotmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("esther@123");
            driver.findElement(By.xpath("//button[@id='formularioDeLogin:botaoLogin']/span[2]")).click();
            driver.findElement(By.linkText("Planos de Negócio")).click();
            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();

//            driver.findElement(By.xpath("//button[@id='formEquipe:botaoSalvar1']/span[2]")).click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='formEquipe:botaoSalvar1']/span[2]"))).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt65"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).sendKeys("Plano de Negócio");
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).sendKeys("Segmento de Clientes");
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).sendKeys("Proposta de Valor");
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).sendKeys("Atividades Chave");
            driver.findElement(By.xpath("//div[@id='div_apresentacao_formulario']/div")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabAnaliseMercado"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:relacoComClientes"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).sendKeys("Relações com clientes");
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).sendKeys("Parcerias chave");
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).sendKeys("Canais");
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).sendKeys("Recursos principais");
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).sendKeys("Concorrentes");

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("tabProdutoServico"))).click();
            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("tabProdutoServico"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:estagioDeEvolucao"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao")).click();
            new Select(driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao"))).selectByVisibleText("Clientes Pagando");
            driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).sendKeys("Tecnologia e processos");
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).sendKeys("Potencial de inovação tecnológica");
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).sendKeys("Aplicações");
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).sendKeys("Dificuldade esperadas");
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).sendKeys("Interação entre empresa e Universidade");
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).sendKeys("Interação entre empresa, comunidade e governo");
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).sendKeys("Infra-estrutura");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabGestaoPessoas"))).click();

            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:participacaoAcionaria"))).click();

            driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).sendKeys("Haverão sócios");
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).sendKeys("Potencial de geração de empregos");

//            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt57"))).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("botao_submeter"))).click();

            driver.findElement(By.xpath("//button[@id='form_enviar_projeto:j_idt221']/span[2]")).click();

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt61"))).click();

            TestLinkIntegration.updateResults("Não deve permitir submeter modelo de negócios sem informar a seção Plano Financeiro", null, TestLinkAPIResults.TEST_PASSED, this.testLinkKey);
        } catch (Exception exception) {
            exception.printStackTrace();

            Assert.fail();

            TestLinkIntegration.updateResults("Não deve permitir submeter modelo de negócios sem informar a seção Plano Financeiro", exception.getMessage(), TestLinkAPIResults.TEST_FAILED, this.testLinkKey);
        }
    }

    @Test
    public void naoPodeSerSubmetidoUmPlanoSemCustosVariaveis() throws TestLinkAPIException {
        driver.get("http://ggirardon.com:8080/GerenciadorPampatec/");
        driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("esther_msf@hotmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("esther@123");
        driver.findElement(By.xpath("//button[@id='formularioDeLogin:botaoLogin']/span[2]")).click();

        driver.findElement(By.linkText("Planos de Negócio")).click();
        driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();
        driver.findElement(By.xpath("//button[@id='formEquipe:botaoSalvar1']/span[2]")).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt65"))).click();

        driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).sendKeys("Plano de Negócio");
        driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).sendKeys("Segmento de Clientes");
        driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).sendKeys("Proposta de Valor");
        driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).sendKeys("Atividades Chave");
        driver.findElement(By.xpath("//div[@id='div_apresentacao_formulario']/div")).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabAnaliseMercado"))).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabAnaliseMercado"))).click();

        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:relacoComClientes"))).click();

        driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).sendKeys("Relações com clientes");
        driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).sendKeys("Parcerias chave");
        driver.findElement(By.id("formulario_cadastro_projeto:canais")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:canais")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:canais")).sendKeys("Canais");
        driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).sendKeys("Recursos principais");
        driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).sendKeys("Concorrentes");

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabProdutoServico"))).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabProdutoServico"))).click();

        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:estagioDeEvolucao"))).click();

        driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao")).click();
        new Select(driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao"))).selectByVisibleText("Clientes Pagando");
        driver.findElement(By.id("formulario_cadastro_projeto:estagioDeEvolucao")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).sendKeys("Tecnologia e processos");
        driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).sendKeys("Potencial de inovação tecnológica");
        driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).sendKeys("Aplicações");
        driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).sendKeys("Dificuldade esperadas");
        driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).sendKeys("Interação entre empresa e Universidade");
        driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).sendKeys("Interação entre empresa, comunidade e governo");
        driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).sendKeys("Infra-estrutura");

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabGestaoPessoas"))).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabGestaoPessoas"))).click();

        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:participacaoAcionaria"))).click();

        driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).sendKeys("Haverão sócios");
        driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).sendKeys("Potencial de geração de empregos");

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabPlanoFinanceiro"))).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("tabPlanoFinanceiro"))).click();

        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("formulario_cadastro_projeto:fontesDeReceita"))).click();

        driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).sendKeys("Fontes de receita");
        driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).sendKeys("Estrutura de custos");
        driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).sendKeys("Investimento inicial");

        driver.findElement(By.xpath("//button[@id='formulario_cadastro_projeto:botaoSalvar6']/span[2]")).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt57"))).click();

        WebElement custoVariavel = driver.findElement(By.xpath("//tbody[@id='formulario_cadastro_projeto:novaTabelaCustosVariaveis_data']/tr/td"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("botao_submeter"))).click();

        driver.findElement(By.xpath("//button[@id='form_enviar_projeto:j_idt221']/span[2]")).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt61"))).click();

        boolean salvo = this.isElementPresent(By.xpath("//div[@id='formulario_cadastro_projeto:notificacaoSalvo']/div/p"));

        if (salvo == true) {
            TestLinkIntegration.updateResults("Não pode ser submetido um plano sem informar os custos variáveis", "O plano de negócios foi submetido mesmo sem informar os custos variáveis", TestLinkAPIResults.TEST_FAILED, this.testLinkKey);
        } else {
            TestLinkIntegration.updateResults("Não pode ser submetido um plano sem informar os custos variáveis", null, TestLinkAPIResults.TEST_PASSED, this.testLinkKey);
        }
    }

    @Test
    public void testA() {
        String login = PropertyReader.read("login.email");
        String senha = PropertyReader.read("login.senha");

        AbstractPageObject loginPage = new LoginPage(this.driver);
        ((LoginPage) loginPage.visita().verifiqueUrlDaPagina()
                .verifiqueAPaginaCarregada()).autenticaNoSistema(login, senha);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
