package tests.elements;

import org.testng.annotations.Test;
import pageObjects.elements.DynamicPropertiesPO;

public class TestDynamicProperties {
    @Test
    public void testDynamicProperties() throws InterruptedException {
        DynamicPropertiesPO propiedades = new DynamicPropertiesPO();
        propiedades.setup();
        propiedades.irADynamicProperties();

        propiedades.textoConIdRandom();
        propiedades.botonCambiaColor();
        propiedades.botonActivableEn5Segundos();
        propiedades.captura("Test_DynamicProperties");

        propiedades.cerrarDriver();
    }
}
