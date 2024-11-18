package tests.widgets;

import org.testng.annotations.Test;
import pageObjects.widgets.ToolTipsPO;

public class TestToolTips {
    @Test
    public void testToolTips(){
        ToolTipsPO tooltips = new ToolTipsPO();
        tooltips.setup();
        tooltips.irAToolTips();

        tooltips.colocarRatonSobreHover();
        tooltips.captura("Test_ToolTips_Hover1");

        tooltips.colorRatonSobreHover2();
        tooltips.captura("Test_ToolTips_Hover2");

        tooltips.cerrarDriver();
    }
}
