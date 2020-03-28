import br.edu.unipampa.TestLinkIntegration;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.
selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import testlink.api.java.client.TestLinkAPIResults;

public class TestesMgp6 {

	static WebDriver driver;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
		driver = new FirefoxDriver();

		driver.get("http://ggirardon.com:8080/GerenciadorPampatec/");
		WebElement campoDeEmail = driver.findElement(By.id("formularioDeLogin:emailInput"));
		campoDeEmail.sendKeys("matheusleao80@gmail.com");

		WebElement campoDeSenha = driver.findElement(By.id("formularioDeLogin:senhaInput"));
		campoDeSenha.sendKeys("84233915");

		WebElement acessar = driver.findElement(By.xpath(".//*[@id='formularioDeLogin:botaoLogin']"));
		acessar.click();

	}

	@Test
	public void testeStatus() {

		try {

			driver.findElement(By.xpath(".//*[@id='menuSuperior']/nav/div/div[2]/ul/li[2]/a")).click();
			driver.findElement(By.xpath(".//*[@id='menuSuperior']/nav/div/div[2]/ul/li[2]/ul/li[2]/input")).click();

			TestLinkIntegration.updateResults("Visualizar status dos meus planos de neg�cio", null, TestLinkAPIResults.TEST_PASSED);

		} catch (Exception e) {

		}
	}

	@Test
	public void testeStatusPrincipal() {

		try {

			driver.findElement(By.xpath("html/body/div[1]/div[2]/a/label/i")).click();

			TestLinkIntegration.updateResults("teste Status Principal", null, TestLinkAPIResults.TEST_PASSED);

		} catch (Exception e) {

		}

	}

	@Test
	public void testeBuscaStatus() {

		try {

			driver.findElement(By.xpath(".//*[@id='menuSuperior']/nav/div/div[2]/ul/li[2]/a")).click();
			driver.findElement(By.xpath(".//*[@id='menuSuperior']/nav/div/div[2]/ul/li[2]/ul/li[2]/input")).click();
		
			WebElement campoBusca = driver.findElement(By.xpath(".//*[@id='lista_planos:singleDT:globalFilter']"));
			campoBusca.sendKeys("Pr�");
			
			TestLinkIntegration.updateResults("testeBuscaStatus", null, TestLinkAPIResults.TEST_FAILED);

		} catch (Exception e) {

		}

	}
	
	@Test
	public void testeBuscaStatusNaoCadastrado() {

		try {

			driver.findElement(By.xpath(".//*[@id='menuSuperior']/nav/div/div[2]/ul/li[2]/a")).click();
			driver.findElement(By.xpath(".//*[@id='menuSuperior']/nav/div/div[2]/ul/li[2]/ul/li[2]/input")).click();
		
			WebElement campoBusca = driver.findElement(By.xpath(".//*[@id='lista_planos:singleDT:globalFilter']"));
			campoBusca.sendKeys("incuba��o");
			
			TestLinkIntegration.updateResults("BuscaStatusNaoCadastrado", null, TestLinkAPIResults.TEST_PASSED);

		} catch (Exception e) {

		}

	}

}
