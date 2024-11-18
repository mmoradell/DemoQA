package pageObjects.widgets;

import base.DemoQASetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    public void comprobarTextoPrimerHeader(){
        if(textoPrimerHeader.getText().equalsIgnoreCase("Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
                " It has survived not only five centuries, but also the leap into electronic typesetting," +
                " remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages," +
                " and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")){
            System.out.println("El texto del primer header es correcto");
        }
    }
    public void comprobarTextoSegundoHeader(){
        if(textoSegundoHeader.getText().equalsIgnoreCase("Contrary to popular belief, Lorem Ipsum is not simply random text." +
                " It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old." +
                " Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words," +
                " consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature," +
                " discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of" +
                " \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC." +
                " This book is a treatise on the theory of ethics, very popular during the Renaissance." +
                " The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.")){
            System.out.println("El texto del segundo header es correcto");
        }
    }
    public void comprobarTextoTercerHeader(){
        if(textoTercerHeader.getText().equalsIgnoreCase("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout." +
                " The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here," +
                " content here', making it look like readable English." +
                " Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text," +
                " and a search for 'lorem ipsum' will uncover many web sites still in their infancy." +
                " Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).")){
            System.out.println("El texto del tercer header es correcto");
        }
    }
}
