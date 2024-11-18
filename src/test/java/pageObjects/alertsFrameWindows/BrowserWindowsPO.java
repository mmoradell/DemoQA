package pageObjects.alertsFrameWindows;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class BrowserWindowsPO extends DemoQASetup {
    public BrowserWindowsPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void iraBrowserWindows(){
        driver.get("https://demoqa.com/browser-windows");
    }
    @FindBy(id = "tabButton")
    protected WebElement nuevaPestana;
    @FindBy(id = "windowButton")
    protected WebElement nuevaVentana;
    @FindBy(id = "messageWindowButton")
    protected WebElement mensajeVentana;
    @FindBy(id = "sampleHeading")
    protected WebElement comprobacionNuevaPestana;
    public void clicarNuevaPestana(){
        String pestanaInicial = driver.getWindowHandle();
        nuevaPestana.click();

        Set<String> pestanas = driver.getWindowHandles();
        for(String pestana : pestanas){
            if(!pestana.equals(pestanaInicial)){
                driver.switchTo().window(pestana);
                break;
            }
        }
    }
    public boolean isPestanaNuevaOK(){
        return comprobacionNuevaPestana.getText().equalsIgnoreCase("This is a sample page");
    }
    public void clicarNuevaVentana(){
        nuevaVentana.click();
    }
}
