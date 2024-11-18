package tests.alertsFrameWindows;

import org.testng.annotations.Test;
import pageObjects.alertsFrameWindows.BrowserWindowsPO;

public class TestBrowserWindows {
    @Test
    public void testBroserWindows(){
        BrowserWindowsPO navegador = new BrowserWindowsPO();
        navegador.setup();
        navegador.iraBrowserWindows();

        navegador.clicarNuevaPestana();
        navegador.isPestanaNuevaOK();
        navegador.captura("Test_BrowserWindows");

        navegador.volverPestanaPrincipal();
        navegador.clicarNuevaVentana();

        navegador.cerrarDriver();
    }
}
