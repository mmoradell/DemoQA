package tests.alertsFrameWindows;

import org.testng.annotations.Test;
import pageObjects.alertsFrameWindows.NestedFramesPO;

public class TestNestedFrames {
    @Test
    public void testIframesAnidados(){
        NestedFramesPO iFrames = new NestedFramesPO();
        iFrames.setup();
        iFrames.irANestedFrames();

        iFrames.comprobarIframesAnidados();

        iFrames.captura("Test_IframesAnidados");

        iFrames.cerrarDriver();
    }
}
