package pageObjects.elements;

import base.DemoQASetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPO extends DemoQASetup {
    public TextBoxPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "userName")
    WebElement nombreCompleto;
    @FindBy(id = "userEmail")
    WebElement email;
    @FindBy(id = "currentAddress")
    WebElement direccionActual;
    @FindBy(id = "permanentAddress")
    WebElement direccionPermanente;
    @FindBy(id = "submit")
    WebElement submit;
    @FindBy(id = "output")
    WebElement salida;
    public void irATextBox(){
        driver.get("https://demoqa.com/text-box");
    }
    public void rellenarDatos(){
        nombreCompleto.sendKeys("Marcos Moradell Alegre");
        email.sendKeys("marcosmoradell@gmail.com");
        direccionActual.sendKeys("Avenida de Navarra");
        direccionPermanente.sendKeys("Avenida de Navarra");
    }
    public void botonSubmit(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //window.scrollTo() -> Desplaza la página hacia esa posición, centrando el elemento en la pantalla.
        //getBoundingClientRect().top -> Obtiene la posición del elemento desde la parte superior de la ventana.
        //window.innerHeight / 2 -> Asegura que el elemento esté centrado verticalmente en la pantalla.
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top " +
                "+ window.pageYOffset - (window.innerHeight / 2));",
                submit);
        submit.click();
    }
    public boolean datosRellenadosOk(){
        return salida.getText().contains(nombreCompleto.getText())
                && salida.getText().contains(email.getText())
                && salida.getText().contains(direccionActual.getText())
                && salida.getText().contains(direccionPermanente.getText());
    }
}
