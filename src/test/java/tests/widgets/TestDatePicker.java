package tests.widgets;

import org.testng.annotations.Test;
import pageObjects.widgets.DatePickerPO;

public class TestDatePicker {
    @Test
    public void testDatePicker(){
        DatePickerPO fechas = new DatePickerPO();
        fechas.setup();
        fechas.irADatePicker();

        fechas.rellenarFecha();
        fechas.rellenarFechaYHora();

        fechas.captura("Test_DatePicker");

        fechas.cerrarDriver();
    }
}
