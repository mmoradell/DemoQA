package tests.elements;

import org.testng.annotations.Test;
import pageObjects.elements.ButtonsPO;

public class TestButtons {
    @Test
    public void testButtons() {
        ButtonsPO botones = new ButtonsPO();
        botones.setup();
        botones.irAButtons();

        botones.dobleClic();
        botones.clicDerecho();
        botones.clicame();

        botones.captura("Test_Buttons");

        botones.cerrarDriver();
    }
}
