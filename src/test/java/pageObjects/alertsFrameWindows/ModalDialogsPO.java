package pageObjects.alertsFrameWindows;

import base.DemoQASetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constantes;

public class ModalDialogsPO extends DemoQASetup {
    public ModalDialogsPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irAModalDialogs(){
        driver.get("https://demoqa.com/modal-dialogs");
    }
    @FindBy(id = "showSmallModal")
    protected WebElement modalPequeno;
    @FindBy(id = "showLargeModal")
    protected WebElement modalGrande;
    @FindBy(className = "modal-body")
    protected WebElement textoModal;
    @FindBy(id = "closeSmallModal")
    protected WebElement cerrarModal;
    public void clicarModalPequeno(){
        modalPequeno.click();
        if(textoModal.getText().equalsIgnoreCase(Constantes.MODAL_PEQUENO)){
            System.out.println("Se ha accedido al modal pequeño correctamente");
        }
    }
    public void cerrarModal(){
        cerrarModal.click();
    }
    public void clicarModalGrande(){
        modalGrande.click();
        if(driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/p")).getText().equalsIgnoreCase(
                Constantes.LORE_IPSUM)){
            System.out.println("Se ha accedido al modal grande correctamente");
        }
    }
}
