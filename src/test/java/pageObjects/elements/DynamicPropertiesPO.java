package pageObjects.elements;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicPropertiesPO extends DemoQASetup {
    WebDriverWait wait;
    public DynamicPropertiesPO(){
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/p")
    protected WebElement textoIdRandom;
    @FindBy(id = "enableAfter")
    protected WebElement botonActivable5Segundos;
    @FindBy(id = "colorChange")
    protected WebElement botonCambiaColor;
    public void textoConIdRandom() throws InterruptedException {
        String idInicial = textoIdRandom.getAttribute("id");

        driver.navigate().refresh();

        Thread.sleep(Duration.ofSeconds(2));

        String nuevoId = textoIdRandom.getAttribute("id");
        if(!idInicial.equals(nuevoId)){
            System.out.println("El ID ha cambiado como se esperaba");
        }else{
            System.out.println("El ID no ha cambiado");
        }
    }
    public void irADynamicProperties() {
        driver.get("https://demoqa.com/dynamic-properties");
    }
    public void botonActivableEn5Segundos(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(botonActivable5Segundos));
        try{
            botonActivable5Segundos.click();
            System.out.println("Se ha podido clicar el boton correctamente");
        }catch (Exception e){
            System.out.println("El boton no estaba activado aún " + e.getMessage());
        }
    }
    public void botonCambiaColor(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String colorInicial = botonCambiaColor.getCssValue("background-color");

        wait.until(ExpectedConditions.attributeToBeNotEmpty(botonCambiaColor, "background-color"));
        String colorNuevo = botonCambiaColor.getCssValue("background-color");

        if(!colorNuevo.equals(colorInicial)){
            System.out.println("El color ha cambiado correctamente");
        }else{
            System.out.println("El color no ha cambiado");
        }
    }
}
