package pageObjects.elements;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constantes;

public class RadioButtonPO extends DemoQASetup {
    public RadioButtonPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/label")
    protected WebElement botonSi;
    @FindBy(className = "mt-3")
    protected WebElement textoConfirmacionSeleccionRadioButton;
    @FindBy(className = "text-success")
    protected WebElement textoConfirmacionRadioButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/label")
    protected WebElement botonImpressive;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[4]/label")
    protected WebElement botonNo;
    public void irARadioButton(){
        driver.get("https://demoqa.com/radio-button");
    }
    public void seleccionarRadioButtonSi(){
        botonSi.click();
    }
    public void seleccionarRadioButtonImpressive(){
        botonImpressive.click();
    }
    public void seleccionarBotonNo(){
        try{
            botonNo.click();
            System.out.println("El boton 'No' está deshabilitado");
        }catch (Exception e){
            System.out.println("El boton 'No' no puede ser seleccionado" + e.getMessage());
        }

    }
    public boolean verificarTextoRadioButtonSi(){
        return textoConfirmacionSeleccionRadioButton.getText().equalsIgnoreCase(Constantes.SELECCIONADO)
                && textoConfirmacionRadioButton.getText().equalsIgnoreCase(Constantes.SI);
    }
    public boolean verificarTextoRadioButtonImpressive(){
        return textoConfirmacionSeleccionRadioButton.getText().equalsIgnoreCase(Constantes.SELECCIONADO)
                && textoConfirmacionRadioButton.getText().equalsIgnoreCase(Constantes.IMPRESIONANTE);
    }

}
