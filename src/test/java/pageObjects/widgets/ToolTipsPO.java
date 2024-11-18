package pageObjects.widgets;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ToolTipsPO extends DemoQASetup {
    protected Actions accion;
    protected WebDriverWait wait;
    public ToolTipsPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irAToolTips(){
        driver.get("https://demoqa.com/tool-tips");
    }
    @FindBy(id = "toolTipButton")
    protected WebElement botonToolTip;
    @FindBy(id = "toolTipTextField")
    protected WebElement textoToolTip;
    public void colocarRatonSobreHover(){
        accion = new Actions(driver);
        accion.moveToElement(botonToolTip).perform();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(botonToolTip, "aria-describedby"));
    }
    public void colorRatonSobreHover2(){
        accion = new Actions(driver);
        accion.moveToElement(textoToolTip).perform();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(textoToolTip, "aria-describedby"));
    }
}
