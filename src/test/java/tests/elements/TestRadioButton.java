package tests.elements;

import org.testng.annotations.Test;
import pageObjects.elements.RadioButtonPO;

public class TestRadioButton {
    @Test
    public void testRadioButton() {
        RadioButtonPO radioButton = new RadioButtonPO();
        radioButton.setup();
        radioButton.irARadioButton();

        radioButton.seleccionarRadioButtonSi();
        radioButton.verificarTextoRadioButtonSi();

        radioButton.seleccionarRadioButtonImpressive();
        radioButton.verificarTextoRadioButtonImpressive();

        radioButton.seleccionarBotonNo();

        radioButton.captura("Test_RadioButton");

        radioButton.cerrarDriver();
    }
}
