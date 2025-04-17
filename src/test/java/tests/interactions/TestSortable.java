package tests.interactions;

import org.testng.annotations.Test;
import pageObjects.interactions.SortablePO;

public class TestSortable {
    @Test
    public void testSortable(){
        SortablePO orden = new SortablePO();
        orden.setup();
        orden.irASortable();

        orden.intercambiarOrden();
        orden.captura("Test_Sortable");

        orden.clicarBotonGrid();
        orden.intercambiarOrdenGrid();
        orden.captura("Test_Sortable_Grid");

        orden.cerrarDriver();
    }
}
