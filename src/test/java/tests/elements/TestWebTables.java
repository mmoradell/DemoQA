package tests.elements;

import org.testng.annotations.Test;
import pageObjects.elements.WebTablesPO;

public class TestWebTables {
    @Test
    public void testWebTables() {
        WebTablesPO tabla = new WebTablesPO();
        tabla.setup();
        tabla.irAWebtables();

        tabla.botonAnadir();
        tabla.rellenarDatosFormularioTabla();

        tabla.captura("Test_Webtables");

        tabla.cerrarDriver();
    }
}
