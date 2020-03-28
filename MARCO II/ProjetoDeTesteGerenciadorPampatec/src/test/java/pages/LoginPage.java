package pages;

import br.edu.unipampa.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends AbstractPageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.pageUrl = PropertyReader.read("url.inicial");
    }

    protected String url() {
        return this.pageUrl;
    }

    public void autenticaNoSistema(String login, String senha) {
        this.driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
        this.driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys(login);
        this.driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
        this.driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys(senha);
        this.driver.findElement(By.xpath("//button[@id='formularioDeLogin:botaoLogin']/span[2]")).click();
    }

}
