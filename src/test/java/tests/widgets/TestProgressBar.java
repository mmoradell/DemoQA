package tests.widgets;

import org.testng.annotations.Test;
import pageObjects.widgets.ProgressBarPO;

public class TestProgressBar {
    @Test
    public void testProgressBar(){
        ProgressBarPO progressBar = new ProgressBarPO();
        progressBar.setup();
        progressBar.irAProgressBar();

        progressBar.rellenarProgressBar();
        progressBar.esperarProgressBarLlena();

        progressBar.captura("Test_ProgressBar");

        progressBar.cerrarDriver();
    }
}
