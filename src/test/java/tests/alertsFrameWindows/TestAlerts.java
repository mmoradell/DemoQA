package tests.alertsFrameWindows;

import org.testng.annotations.Test;
import pageObjects.alertsFrameWindows.AlertsPO;

public class TestAlerts{
    @Test
    public void testAlerts() throws InterruptedException {
        AlertsPO alertas = new AlertsPO();
        alertas.setup();
        alertas.irAAlertas();

        alertas.clicarBotonAlerta();
        alertas.clicarBotonCincoSegundos();

        alertas.clicarBotonConfirmar();
        alertas.captura("Test_Alertas_Boton_Confirmar");

        alertas.clicarBotonCancelar();
        alertas.captura("Test_Alertas_Boton_Cancelar");

        alertas.clicarBotonPrompt();

        alertas.captura("Test_Alertas");

        alertas.cerrarDriver();
    }
}
