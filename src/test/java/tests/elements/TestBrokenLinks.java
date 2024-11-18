package tests.elements;

import org.testng.annotations.Test;
import pageObjects.elements.BrokenLinksPO;

public class TestBrokenLinks {
    @Test
    public void testBrokenLinks(){
        BrokenLinksPO imagenes = new BrokenLinksPO();
        imagenes.setup();
        imagenes.irABrokenLinks();

        imagenes.comprobarImagen1Valida();
        imagenes.comprobarImagen2Valida();

        imagenes.comprobarLinkValido();
        imagenes.captura("Test_BrokenLinks_LinkValido");

        imagenes.comprobarLinkRoto();
        imagenes.captura("Test_BrokenLinks_LinkRoto");

        imagenes.cerrarDriver();
    }
}
