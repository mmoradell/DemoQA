package pageObjects.alertsFrameWindows;

import base.DemoQASetup;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constantes;

import java.time.Duration;

public class AlertsPO extends DemoQASetup {
    protected Alert alerta;
    public AlertsPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "alertButton")
    protected WebElement botonAlerta;
    @FindBy(id = "timerAlertButton")
    protected WebElement botonAlertaCincoSegundos;
    @FindBy(id = "confirmButton")
    protected WebElement botonConfirmar;
    @FindBy(id = "confirmResult")
    protected WebElement textoConfirmacion;
    @FindBy(id = "promtButton")
    protected WebElement botonPrompt;
    @FindBy(id = "promptResult")
    protected WebElement resultadoPrompt;
    public void irAAlertas(){
        driver.get("https://demoqa.com/alerts");
    }
    public void clicarBotonAlerta(){
        botonAlerta.click();
        alerta = driver.switchTo().alert();
        if(alerta.getText().equalsIgnoreCase(Constantes.BOTON_CLICADO)){
            System.out.println("El boton se ha cerrado correctamente");
        }
        alerta.accept();
    }
    public void clicarBotonCincoSegundos() throws InterruptedException {
        botonAlertaCincoSegundos.click();
        Thread.sleep(Duration.ofSeconds(6));

        alerta = driver.switchTo().alert();
        if(alerta.getText().equalsIgnoreCase(Constantes.ALERTA_CINCO_SEGUNDOS)){
            System.out.println("El boton se ha cerrado correctamente tras 5 segundos de espera");
        }
        alerta.accept();
    }
    public void clicarBotonConfirmar(){
        botonConfirmar.click();

        alerta = driver.switchTo().alert();
        alerta.accept();
        if(textoConfirmacion.getText().equalsIgnoreCase(Constantes.BOTON_CANCELAR)){
            System.out.println("El boton se ha cancelado correctamente");
        }

    }
    public void clicarBotonCancelar(){
        botonConfirmar.click();
        alerta = driver.switchTo().alert();
        alerta.dismiss();
        if(textoConfirmacion.getText().equalsIgnoreCase(Constantes.BOTON_CONFIRMAR)){
            System.out.println("El boton se ha confirmado correctamente");
        }
    }
    public void clicarBotonPrompt(){
        botonPrompt.click();

        String textoPrompt = "Prueba";
        alerta = driver.switchTo().alert();
        alerta.sendKeys(textoPrompt);
        alerta.accept();
        if(resultadoPrompt.getText().equalsIgnoreCase(Constantes.TEXTO_INTRODUCIDO + textoPrompt)){
            System.out.println("El boton prompt ha funcionado correctamente");
        }
    }
}
