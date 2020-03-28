package pages;

import br.edu.unipampa.PropertyReader;
import org.openqa.selenium.WebDriver;

public class BuscarPlanoDeNegocioPage extends AbstractPageObject {

    public BuscarPlanoDeNegocioPage(WebDriver driver) {
        super(driver);
        this.pageUrl = PropertyReader.read("url.buscar-plano");
    }

    protected String url() {
        return this.pageUrl;
    }
}
