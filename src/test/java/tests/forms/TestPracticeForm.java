package tests.forms;

import org.testng.annotations.Test;
import pageObjects.forms.PracticeFormPO;

public class TestPracticeForm {
    @Test
    public void testPracticeForm() throws InterruptedException {
        PracticeFormPO formulario = new PracticeFormPO();
        formulario.setup();
        formulario.irAPracticeForm();

        formulario.rellenarFormulario();
        formulario.captura("Test_PracticeForm");

        formulario.cerrarDriver();
    }
}
