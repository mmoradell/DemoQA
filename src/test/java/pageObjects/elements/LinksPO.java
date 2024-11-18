package pageObjects.elements;

import base.DemoQASetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LinksPO extends DemoQASetup {
    public LinksPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void irALinks(){
        driver.get("https://demoqa.com/links");
    }
    @FindBy(id = "simpleLink")
    protected WebElement linkSimple;
    @FindBy(id = "dynamicLink")
    protected WebElement linkDinamico;
    @FindBy(id = "created")
    protected WebElement created;
    @FindBy(id = "no-content")
    protected WebElement noContent;
    @FindBy(id = "moved")
    protected WebElement moved;
    @FindBy(id = "bad-request")
    protected WebElement badRequest;
    @FindBy(id = "unauthorized")
    protected WebElement unauthorized;
    @FindBy(id = "forbidden")
    protected WebElement forbidden;
    @FindBy(id = "invalid-url")
    protected WebElement notFound;
    @FindBy(id = "linkResponse")
    protected WebElement respuesta;
    public void abrirLinkSimple(){
        linkSimple.click();
    }
    public void desplazarseAlFinalDeLaPantalla(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top " +
                        "+ window.pageYOffset - (window.innerHeight / 2));",
                notFound);
    }
    public void abrirLinkDinamico(){
        linkDinamico.click();
    }
    public void comprobarLinkCreated() throws InterruptedException {
        created.click();
        wait.until(ExpectedConditions.elementToBeClickable(created));
        assert respuesta.getText().equalsIgnoreCase("Link has responded with staus 201 and status text Created");
    }
    public void comprobarLinkNoContent() throws InterruptedException {
        noContent.click();
        wait.until(ExpectedConditions.elementToBeClickable(noContent));
        assert respuesta.getText().equalsIgnoreCase("Link has responded with staus 204 and status text No Content");
    }
    public void comprobarLinkMoved(){
        moved.click();
        wait.until(ExpectedConditions.elementToBeClickable(moved));
        assert respuesta.getText().equalsIgnoreCase("Link has responded with staus 301 and status text Moved Permanently");
    }
    public void comprobarLinkBadRequest(){
        badRequest.click();
        wait.until(ExpectedConditions.elementToBeClickable(badRequest));
        assert respuesta.getText().equalsIgnoreCase("Link has responded with staus 400 and status text Bad Request");
    }
    public void comprobarLinkUnauthorized(){
        unauthorized.click();
        wait.until(ExpectedConditions.elementToBeClickable(unauthorized));
        assert respuesta.getText().equalsIgnoreCase("Link has responded with staus 401 and status text Unauthorized");
    }
    public void comprobarLinkForbidden(){
        forbidden.click();
        wait.until(ExpectedConditions.elementToBeClickable(forbidden));
        assert respuesta.getText().equalsIgnoreCase("Link has responded with staus 403 and status text Forbidden");
    }
    public void comprobarLinkNotFound(){
        notFound.click();
        wait.until(ExpectedConditions.elementToBeClickable(notFound));
        assert respuesta.getText().equalsIgnoreCase("Link has responded with staus 404 and status text Not Found");
    }
}
