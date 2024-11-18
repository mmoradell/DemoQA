package pageObjects.alertsFrameWindows;

import base.DemoQASetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        if(textoModal.getText().equalsIgnoreCase("This is a small modal. It has very less content")){
            System.out.println("Se ha accedido al modal pequeño correctamente");
        }
    }
    public void cerrarModal(){
        cerrarModal.click();
    }
    public void clicarModalGrande(){
        modalGrande.click();
        if(driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/p")).getText().equalsIgnoreCase(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                        " when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
                        " It has survived not only five centuries, but also the leap into electronic typesetting," +
                        " remaining essentially unchanged. " +
                        "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages," +
                        " and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")){
            System.out.println("Se ha accedido al modal grande correctamente");
        }
    }
}
