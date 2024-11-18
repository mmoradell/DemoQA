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

public class DemoQASetup {
    protected WebDriver driver;

    public DemoQASetup(){
        driver = new ChromeDriver();
    }
    public void setup(){
        driver.manage().window().maximize();
    }
    public void setupParaDescargas(){
        String ruta = "C:\\Users\\Marcos\\Downloads";

        HashMap<String, Object> preferencias = new HashMap<>();
        preferencias.put("profile.default_content_settings.popups", 0);
        preferencias.put("download.default_directory", ruta);
        preferencias.put("download.prompt_for_download", false);
        preferencias.put("directory_upgrade", true);
        preferencias.put("safebrowsing.enabled", true);

        ChromeOptions opciones = new ChromeOptions();
        opciones.setExperimentalOption("prefs", preferencias);

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

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String rutaArchivo = "src/screenshots/" + nombreFichero + "_" + timeStamp + ".png";

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
