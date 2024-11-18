package pageObjects.elements;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class WebTablesPO extends DemoQASetup {
    public WebTablesPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "addNewRecordButton")
    protected WebElement anadir;
    @FindBy(id = "firstName")
    protected WebElement nombre;
    @FindBy(id = "lastName")
    protected WebElement apellido;
    @FindBy(id = "userEmail")
    protected WebElement email;
    @FindBy(id = "age")
    protected WebElement edad;
    @FindBy(id = "salary")
    protected WebElement salario;
    @FindBy(id = "department")
    protected WebElement departamento;
    @FindBy(id = "submit")
    protected WebElement confirmar;
    public void irAWebtables(){
        driver.get("https://demoqa.com/webtables");
    }
    public void botonAnadir(){
        anadir.click();
    }
    public void rellenarDatosFormularioTabla() {
        nombre.sendKeys("Marcos");
        apellido.sendKeys("Moradell");
        email.sendKeys("marcosmoradell@gmail.com");
        edad.sendKeys("24");
        salario.sendKeys("1000");
        departamento.sendKeys("Informatica");

        confirmar.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


}
