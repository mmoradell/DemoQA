package tests.elements;

import org.testng.annotations.Test;
import pageObjects.elements.UploadAndDownloadPO;

public class TestUploadAndDownload {
    @Test
    public void testUploadAndDownload() throws InterruptedException {
        UploadAndDownloadPO ficheros = new UploadAndDownloadPO();
        ficheros.setupParaDescargas();
        ficheros.irAUploadAndDownload();

        ficheros.descargarFichero();
        ficheros.subirFichero();
        ficheros.captura("Test_ArchivoSubido");

        ficheros.cerrarDriver();
    }
}
