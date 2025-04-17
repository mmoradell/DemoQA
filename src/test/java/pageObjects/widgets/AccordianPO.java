package pageObjects.widgets;

import base.DemoQASetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constantes;

import java.time.Duration;

public class AccordianPO extends DemoQASetup {
    public AccordianPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irAAccordian(){
        driver.get("https://demoqa.com/accordian");
    }
    @FindBy(id = "section1Heading")
    protected WebElement primerHeader;
    @FindBy(id = "section2Heading")
    protected WebElement segundoHeader;
    @FindBy(id = "section3Heading")
    protected WebElement tercerHeader;
    @FindBy(xpath = "//*[@id=\"section1Content\"]/p")
    protected WebElement textoPrimerHeader;
    @FindBy(xpath = "//*[@id=\"section2Content\"]/p[1]")
    protected WebElement textoSegundoHeader;
    @FindBy(xpath = "//*[@id=\"section3Content\"]/p")
    protected WebElement textoTercerHeader;
    public void primerHeader(){
        if(primerHeader.getText().equalsIgnoreCase("What is Lorem Ipsum?")){
            System.out.println("El primer header es correcto");
        }
    }
    public void segundoHeader() throws InterruptedException {
        if(segundoHeader.getText().equalsIgnoreCase("Where does it come from?")){
            System.out.println("El segundo header es correcto");
            segundoHeader.click();
            Thread.sleep(Duration.ofSeconds(4));
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", tercerHeader);
    }
    public void tercerHeader() throws InterruptedException {
        if(tercerHeader.getText().equalsIgnoreCase("Why do we use it?")){
            System.out.println("El tercer header es correcto");
            tercerHeader.click();
            Thread.sleep(Duration.ofSeconds(4));
        }
    }
    public boolean comprobarTextoPrimerHeader(){
        return textoPrimerHeader.getText().equalsIgnoreCase(Constantes.LORE_IPSUM);
    }
    public void comprobarTextoSegundoHeader(){
        if(textoSegundoHeader.getText().equalsIgnoreCase(Constantes.TEXTO_HEADER_2)){
            System.out.println("El texto del segundo header es correcto");
        }
    }
    public void comprobarTextoTercerHeader(){
        if(textoTercerHeader.getText().equalsIgnoreCase(Constantes.TEXTO_HEADER_3)){
            System.out.println("El texto del tercer header es correcto");
        }
    }
}
