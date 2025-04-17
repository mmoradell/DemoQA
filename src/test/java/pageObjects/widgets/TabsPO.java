package pageObjects.widgets;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constantes;

public class TabsPO extends DemoQASetup {
    public TabsPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irATabs(){
        driver.get("https://demoqa.com/tabs");
    }
    @FindBy(id = "demo-tab-origin")
    protected WebElement pestana2;
    @FindBy(id = "demo-tab-use")
    protected WebElement pestana3;
    @FindBy(xpath = "//*[@id=\"demo-tabpane-what\"]/p")
    protected WebElement textoPestana1;
    @FindBy(xpath = "//*[@id=\"demo-tabpane-origin\"]/p[1]")
    protected WebElement textoPestana2;
    @FindBy(xpath = "//*[@id=\"demo-tabpane-use\"]/p")
    protected WebElement textoPestana3;
    public boolean comprobarPrimeraPestana(){
        return textoPestana1.getText().equalsIgnoreCase(Constantes.LORE_IPSUM);
    }
    public boolean comprobarSegundaPestana(){
        pestana2.click();
        return textoPestana2.getText().equalsIgnoreCase(Constantes.TEXTO_HEADER_2);
    }
    public boolean comprobarTerceraPestana(){
        pestana3.click();
        return textoPestana3.getText().equalsIgnoreCase(Constantes.TEXTO_HEADER_3);
    }
}
