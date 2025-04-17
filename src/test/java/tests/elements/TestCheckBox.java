package tests.elements;

import org.testng.annotations.Test;
import pageObjects.elements.CheckBoxPO;

public class TestCheckBox {
    @Test
    public void testCheckBox() {
        CheckBoxPO checkBox = new CheckBoxPO();
        checkBox.setup();
        checkBox.irACheckBox();

        checkBox.desplegarHome();
        checkBox.desplegarDesktop();
        checkBox.desplegarDocuments();
        checkBox.desplegarWorkSpace();
        checkBox.desplegarOffice();
        checkBox.desplegarDownloads();

        checkBox.checkearHome();
        checkBox.captura("Test_CheckBox");

        checkBox.cerrarDriver();
    }
}
