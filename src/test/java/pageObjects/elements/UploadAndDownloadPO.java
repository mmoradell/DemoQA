package pageObjects.elements;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constantes;

import java.time.Duration;

public class UploadAndDownloadPO extends DemoQASetup {
    public UploadAndDownloadPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "downloadButton")
    protected WebElement descargar;
    @FindBy(id = "uploadFile")
    protected WebElement subir;
    @FindBy(id = "uploadedFilePath")
    protected WebElement comprobarFicheroSubido;
    public void irAUploadAndDownload() {
        driver.get("https://demoqa.com/upload-download");
    }
    public void descargarFichero(){
        descargar.click();
    }
    public void subirFichero() throws InterruptedException {
        String ruta = Constantes.RUTA_SUBIR_FICHERO;

        subir.sendKeys(ruta);
        Thread.sleep(Duration.ofSeconds(5));

        assert comprobarFicheroSubido.getText().equalsIgnoreCase(Constantes.FAKEPATH);
    }
}
