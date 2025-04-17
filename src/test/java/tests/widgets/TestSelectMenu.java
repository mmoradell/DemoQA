package tests.widgets;

import org.testng.annotations.Test;
import pageObjects.widgets.SelectMenuPO;

public class TestSelectMenu {
    @Test
    public void testSelectMenu(){
        SelectMenuPO select = new SelectMenuPO();
        select.setup();
        select.irASelectMenu();

        select.seleccionarPrimerComboBox();
        select.seleccionarSegundoComboBox();
        select.seleccionarTercerComboBox();

        select.seleccionarMultiSelectDropDown();

        select.selectStandarMultiSelect();

        select.captura("Test_SelectMenu");

        select.cerrarDriver();
    }
}
