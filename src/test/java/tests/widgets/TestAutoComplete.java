package tests.widgets;

import org.testng.annotations.Test;
import pageObjects.widgets.AutoCompletePO;

public class TestAutoComplete {
    @Test
    public void autoComplete(){
        AutoCompletePO autocompletar = new AutoCompletePO();
        autocompletar.setup();
        autocompletar.irAAutoComplete();

        autocompletar.rellenarMultiplesColores();
        autocompletar.rellenarUnColor();

        autocompletar.captura("Test_AutoComplete");

        autocompletar.cerrarDriver();
    }
}
