package tests.widgets;

import org.testng.annotations.Test;
import pageObjects.widgets.MenuPO;

public class TestMenu {
    @Test
    public void testMenu(){
        MenuPO menu = new MenuPO();
        menu.setup();
        menu.irAMenu();

        menu.recorrerMenuCompleto();

        menu.captura("Test_Menu");

        menu.cerrarDriver();
    }
}
