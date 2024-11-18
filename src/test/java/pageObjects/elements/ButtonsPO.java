package pageObjects.elements;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ButtonsPO extends DemoQASetup {
    Actions accion;
    public ButtonsPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "doubleClickBtn")
    protected WebElement dobleClic;
    @FindBy(id = "rightClickBtn")
    protected WebElement clicDerecho;
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/button")
    protected WebElement clicame;
    @FindBy(id = "doubleClickMessage")
    protected WebElement dobleClicOk;
    @FindBy(id = "rightClickMessage")
    protected WebElement clicDerechoOk;
    @FindBy(id = "dynamicClickMessage")
    protected WebElement clicDinamico;
    public void irAButtons(){
        driver.get("https://demoqa.com/buttons");
    }
    public void dobleClic(){
        accion = new Actions(driver);
        accion.doubleClick(dobleClic);
        accion.perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assert dobleClicOk.getText().equalsIgnoreCase("You have done a double click");
    }
    public void clicDerecho(){
        accion = new Actions(driver);
        accion.contextClick(clicDerecho);
        accion.perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assert clicDerechoOk.getText().equalsIgnoreCase("You have done a right click");
    }
    public void clicame(){
        clicame.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assert clicDinamico.getText().equalsIgnoreCase("You have done a dynamic click");
    }
}
