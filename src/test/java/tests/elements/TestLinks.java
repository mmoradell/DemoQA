package tests.elements;

import org.testng.annotations.Test;
import pageObjects.elements.LinksPO;

public class TestLinks {
    @Test
    public void testLinks() throws InterruptedException {
        LinksPO links = new LinksPO();
        links.setup();
        links.irALinks();

        links.abrirLinkSimple();
      //links.captura("Test_LinkSimple");    //Al hacer una captura vuelve a la pantalla principal sin saber por que
        links.volverPestanaPrincipal();

        links.abrirLinkDinamico();
        links.volverPestanaPrincipal();

        links.desplazarseAlFinalDeLaPantalla();

        links.comprobarLinkCreated();
        links.captura("Link_Created");

        links.comprobarLinkNoContent();
        links.captura("Link_NoContent");

        links.comprobarLinkMoved();
        links.captura("Link_Moved");

        links.comprobarLinkBadRequest();
        links.captura("Link_BadRequest");

        links.comprobarLinkUnauthorized();
        links.captura("Link_Unauthorized");

        links.comprobarLinkForbidden();
        links.captura("Link_Forbidden");

        links.comprobarLinkNotFound();
        links.captura("Link_NotFound");

        links.cerrarDriver();
    }
}
