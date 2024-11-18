package tests.widgets;

import org.testng.annotations.Test;
import pageObjects.widgets.SliderPO;

public class TestSlider {
    @Test
    public void testSlider(){
        SliderPO slider = new SliderPO();
        slider.setup();
        slider.irASlider();

        slider.moverSlider();

        slider.captura("Test_Slider");

        slider.cerrarDriver();
    }
}
