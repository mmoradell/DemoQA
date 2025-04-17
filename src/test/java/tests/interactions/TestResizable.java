package tests.interactions;

import org.testng.annotations.Test;
import pageObjects.interactions.ResizablePO;

public class TestResizable {
    @Test
    public void testResizable(){
        ResizablePO redimensionar = new ResizablePO();
        redimensionar.setup();
        redimensionar.irAResizable();

        redimensionar.expandirCaja();
        redimensionar.contraerCajaInferior();

        redimensionar.captura("Test_Resizable");

        redimensionar.cerrarDriver();
    }
}
