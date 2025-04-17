package tests.widgets;

import org.testng.annotations.Test;
import pageObjects.widgets.AccordianPO;

public class TestAccordian {
    @Test
    public void testAccordian() throws InterruptedException {
        AccordianPO accordian = new AccordianPO();
        accordian.setup();
        accordian.irAAccordian();

        accordian.primerHeader();
        accordian.comprobarTextoPrimerHeader();
        accordian.captura("Test_Accodian_Primer_Header");

        accordian.segundoHeader();
        accordian.comprobarTextoSegundoHeader();
        accordian.captura("Test_Accodian_Segundo_Header");

        accordian.tercerHeader();
        accordian.comprobarTextoTercerHeader();
        accordian.captura("Test_Accodian_Tercer_Header");

        accordian.cerrarDriver();

    }

}
