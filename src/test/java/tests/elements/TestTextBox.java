package tests.elements;

import org.testng.annotations.Test;
import pageObjects.elements.TextBoxPO;

public class TestTextBox{
    @Test
    public void testTextBox() {
        TextBoxPO textbox = new TextBoxPO();
        textbox.setup();
        textbox.irATextBox();

        textbox.rellenarDatos();
        textbox.botonSubmit();
        textbox.datosRellenadosOk();

        textbox.captura("Test_TextBox");

        textbox.cerrarDriver();
    }
}
