package pageObjects.interactions;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResizablePO extends DemoQASetup {
    Actions accion;
    public ResizablePO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irAResizable(){
        driver.get("https://demoqa.com/resizable");
    }
    @FindBy(id = "resizableBoxWithRestriction")
    protected WebElement caja;
    @FindBy(xpath = "//*[@id=\"resizableBoxWithRestriction\"]/span")
    protected WebElement flecha;
    @FindBy(xpath = "//*[@id=\"resizable\"]/span")
    protected WebElement flechaInferior;
    public void expandirCaja(){
        accion = new Actions(driver);
        accion.clickAndHold(flecha).moveByOffset(500, 300).release().perform();
    }
    public void contraerCajaInferior(){
        accion = new Actions(driver);
        accion.clickAndHold(flechaInferior).moveByOffset(-10, -50).release().perform();
    }
}
