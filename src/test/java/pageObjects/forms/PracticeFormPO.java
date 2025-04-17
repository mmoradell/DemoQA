package pageObjects.forms;

import base.DemoQASetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constantes;

import java.time.Duration;

public class PracticeFormPO extends DemoQASetup {
    public PracticeFormPO(){
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "firstName")
    protected WebElement nombre;
    @FindBy(id = "lastName")
    protected WebElement apellido;
    @FindBy(id = "userEmail")
    protected WebElement email;
    @FindBy(id = "gender-radio-1")
    protected WebElement genero;
    @FindBy(id = "userNumber")
    protected WebElement numeroTelefono;
    @FindBy(id = "dateOfBirthInput")
    protected WebElement fechaNacimiento;
    @FindBy(id = "subjectsInput")
    protected WebElement asignaturas;
    @FindBy(id = "hobbies-checkbox-1")
    protected WebElement hobbies;
    @FindBy(id = "uploadPicture")
    protected WebElement subirFoto;
    @FindBy(id = "currentAddress")
    protected WebElement direccion;
    @FindBy(id = "closeLargeModal")
    protected WebElement cerrar;
    @FindBy(id = "submit")
    protected WebElement confirmar;
    public void irAPracticeForm(){
        driver.get("https://demoqa.com/automation-practice-form");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(Constantes.SCROLL, confirmar);
    }
    public void rellenarFormulario() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        nombre.sendKeys(Constantes.NOMBRE);
        apellido.sendKeys(Constantes.APELLIDO);
        email.sendKeys(Constantes.EMAIL);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", genero);  //Utilizo js porque el clic normal no lo reconoce

        numeroTelefono.sendKeys(Constantes.TELEFONO);

//      fechaNacimiento.clear();
//      fechaNacimiento.sendKeys("18/11/1999");  //Esta bugeado el datePicker de esta pagina

        //No se puede localizar los items ocultos asi que no es posible seleccionarlos
//       asignaturas.sendKeys("M");
//       List<WebElement> sugerencias = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".autocomplete-suggestion")));
//       for(WebElement sugerencia : sugerencias){
//           if(sugerencia.getText().equalsIgnoreCase("Option 1")){
//               sugerencia.click();
//               break;
//           }
//       }
        js.executeScript("arguments[0].click();", hobbies);

        String ruta = Constantes.RUTA_SUBIR_FICHERO;
        subirFoto.sendKeys(ruta);
        Thread.sleep(Duration.ofSeconds(4));

        direccion.sendKeys(Constantes.DIRECCION_ACTUAL);

        confirmar.click();
        Thread.sleep(Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(cerrar));
        cerrar.click();
    }
}
