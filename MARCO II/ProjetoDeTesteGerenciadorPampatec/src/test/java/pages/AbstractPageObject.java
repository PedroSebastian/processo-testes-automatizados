package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Pedro Sebastian on 20/11/2017.
 */
public abstract class AbstractPageObject {

    protected WebDriver driver;
    protected int timeout = 20;

    protected String pageLoadedText = "";
    protected String pageUrl;

    public AbstractPageObject(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract String url();

    public AbstractPageObject visita() {
        this.driver.get(this.url());
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the AbstractPageObject class instance.
     */
    public AbstractPageObject verifiqueAPaginaCarregada() {
        (new WebDriverWait(this.driver, this.timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the AbstractPageObject class instance.
     */
    public AbstractPageObject verifiqueUrlDaPagina() {
        (new WebDriverWait(this.driver, this.timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

}
