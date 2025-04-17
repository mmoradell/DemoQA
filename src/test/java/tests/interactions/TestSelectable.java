package tests.interactions;

import org.testng.annotations.Test;
import pageObjects.interactions.SelectablePO;

public class TestSelectable {
    @Test
    public void testSelectable(){
        SelectablePO selectable = new SelectablePO();
        selectable.setup();
        selectable.irASelectablePO();

        selectable.seleccionMultiple();

        selectable.captura("Test_Selectable");

        selectable.cerrarDriver();
    }
}
