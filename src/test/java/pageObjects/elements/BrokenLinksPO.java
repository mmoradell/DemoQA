package pageObjects.elements;

import base.DemoQASetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.net.HttpURLConnection;
import java.net.URI;

public class BrokenLinksPO extends DemoQASetup {
    public BrokenLinksPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/img[1]")
    protected WebElement imagen;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/img[2]")
    protected WebElement imagen2;
    @FindBy(linkText = "Click Here for Valid Link")
    protected WebElement linkValido;
    @FindBy(linkText = "Click Here for Broken Link")
    protected WebElement linkRoto;
    public void irABrokenLinks(){
        driver.get("https://demoqa.com/broken");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top " +
                        "+ window.pageYOffset - (window.innerHeight / 2));",
                linkRoto);
    }
    public void comprobarImagen1Valida(){
        String imagenValida = imagen.getAttribute("src");
        isImagenValida(imagenValida);
    }
    public void comprobarImagen2Valida(){
        String imagenValida = imagen2.getAttribute("src");
        isImagenValida(imagenValida);
    }
    public void isImagenValida(String imagenValida) {
        try{
            HttpURLConnection conexion = (HttpURLConnection) new URI(imagenValida).toURL().openConnection();
            conexion.setRequestMethod("GET");
            conexion.setRequestProperty("User-Agent", "Mozilla/5.0");
            conexion.connect();

            int responseCode = conexion.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                System.out.println("La imagen está OK");
            }else{
                System.out.println("La imagen está rota");
            }
        }catch (Exception e){
            System.out.println("La imagen está rota");
        }
    }
    public void comprobarLinkValido(){
        linkValido.click();
    }

    public void comprobarLinkRoto() {
        driver.navigate().back();
        linkRoto.click();

        driver.switchTo().window(driver.getWindowHandle());

        if(driver.findElement(By.xpath
                ("//*[@id=\"content\"]/div/p")).getText().equalsIgnoreCase
                ("This page returned a 500 status code.")){
            System.out.println("El link roto es correcto");
        }else{
            System.out.println("No se ha podido acceder correctamente al link roto");
        }
    }
}
