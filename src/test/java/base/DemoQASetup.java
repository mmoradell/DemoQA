package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import utils.Constantes;

public class DemoQASetup {
    protected WebDriver driver;

    public DemoQASetup(){
        driver = new ChromeDriver();
    }
    public void setup(){
        driver.manage().window().maximize();
    }
    public void setupParaDescargas(){
        String ruta = Constantes.RUTA_CAPTURAS;

        HashMap<String, Object> preferencias = new HashMap<>();
        preferencias.put(Constantes.POPUPS, 0);
        preferencias.put(Constantes.DIRECTORIO, ruta);
        preferencias.put(Constantes.PROMPT_DESCARGA, false);
        preferencias.put(Constantes.DIRECTORIO_UPGRADE, true);
        preferencias.put(Constantes.SAFEBROWSE, true);

        ChromeOptions opciones = new ChromeOptions();
        opciones.setExperimentalOption(Constantes.PREFS, preferencias);

        WebDriver driver = new ChromeDriver(opciones);

        driver.manage().window().maximize();

    }
    public void cerrarDriver(){
        if(driver != null){
            driver.quit();
        }
    }
    public void captura(String nombreFichero){
        TakesScreenshot capturaPantalla = (TakesScreenshot) driver;

        File archivo = capturaPantalla.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat(Constantes.FORMATO_FECHA).format(new Date());
        String rutaArchivo = Constantes.CAPTURA + nombreFichero + "_" + timeStamp + Constantes.PNG;

        try{
            FileHandler.copy(archivo, new File(rutaArchivo));
            System.out.println("Captura guardada en: " + rutaArchivo);
        }catch (IOException e){
            System.out.println("Error al guardar la captura de pantalla: " + e.getMessage());
        }
    }
    public void volverPestanaPrincipal(){
        Set<String> pestanas = driver.getWindowHandles();
        for(int i=0; i<pestanas.size(); i++){
            String pestana = driver.getWindowHandle();
            pestanas.add(pestana);
            if(i == 1){
                driver.switchTo().window(pestana);
                break;
            }
        }
    }
}
