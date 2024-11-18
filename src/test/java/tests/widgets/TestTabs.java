package tests.widgets;

import org.testng.annotations.Test;
import pageObjects.widgets.TabsPO;

public class TestTabs {
    @Test
    public void testTabs(){
        TabsPO pestanas = new TabsPO();
        pestanas.setup();
        pestanas.irATabs();

        pestanas.comprobarPrimeraPestana();
        pestanas.comprobarSegundaPestana();
        pestanas.comprobarTerceraPestana();

        pestanas.captura("Test_Tabs");

        pestanas.cerrarDriver();
    }
}
