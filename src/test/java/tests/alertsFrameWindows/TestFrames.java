package tests.alertsFrameWindows;

import org.testng.annotations.Test;
import pageObjects.alertsFrameWindows.FramesPO;

public class TestFrames {
    @Test
    public void testIframes(){
        FramesPO iframes = new FramesPO();
        iframes.setup();
        iframes.irAFrames();

        iframes.desplazarHeadingInferior();

        iframes.headingIframe1();
        iframes.headingIframe2();

        iframes.captura("Test_Frames");

        iframes.cerrarDriver();
    }
}
