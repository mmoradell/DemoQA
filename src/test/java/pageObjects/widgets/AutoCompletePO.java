package pageObjects.widgets;

import base.DemoQASetup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constantes;

public class AutoCompletePO extends DemoQASetup {
    public AutoCompletePO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irAAutoComplete(){
        driver.get("https://demoqa.com/auto-complete");
    }
    @FindBy(id = "autoCompleteMultipleInput")
    protected WebElement multiplesColores;
    @FindBy(id = "autoCompleteSingleInput")
    protected WebElement color;
    public void rellenarMultiplesColores(){
        multiplesColores.sendKeys(Constantes.AZUL);
        multiplesColores.sendKeys(Keys.ENTER);

        multiplesColores.sendKeys(Constantes.ROJO);
        multiplesColores.sendKeys(Keys.ENTER);

        multiplesColores.sendKeys(Constantes.VERDE);
        multiplesColores.sendKeys(Keys.ENTER);
    }
    public void rellenarUnColor(){
        color.sendKeys(Constantes.AZUL);
        color.sendKeys(Keys.ENTER);
    }
}
