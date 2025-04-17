package tests.alertsFrameWindows;

import org.testng.annotations.Test;
import pageObjects.alertsFrameWindows.ModalDialogsPO;

public class TestModelDialogs {
    @Test
    public void testModalDialogs(){
        ModalDialogsPO modales = new ModalDialogsPO();
        modales.setup();
        modales.irAModalDialogs();

        modales.clicarModalPequeno();
        modales.cerrarModal();

        modales.clicarModalGrande();

        modales.captura("Test_Modales");

        modales.cerrarDriver();
    }
}
