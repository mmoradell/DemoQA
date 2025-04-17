package pageObjects.interactions;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SortablePO extends DemoQASetup {
    Actions accion;
    public SortablePO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irASortable(){
        driver.get("https://demoqa.com/sortable");
    }
    @FindBy(xpath = "//*[@id=\"demo-tabpane-list\"]/div/div[1]")
    protected WebElement uno;
    @FindBy(xpath = "//*[@id=\"demo-tabpane-list\"]/div/div[5]")
    protected WebElement cinco;
    @FindBy(id = "demo-tab-grid")
    protected WebElement grid;
    @FindBy(xpath = "//*[@id=\"demo-tabpane-grid\"]/div/div/div[2]")
    protected WebElement dosGrid;
    @FindBy(xpath = "//*[@id=\"demo-tabpane-grid\"]/div/div/div[9]")
    protected WebElement nueveGrid;
    public void intercambiarOrden(){
        accion = new Actions(driver);
        accion.dragAndDrop(uno, cinco).perform();
    }
    public void clicarBotonGrid(){
        grid.click();
    }
    public void intercambiarOrdenGrid(){
        accion = new Actions(driver);
        accion.dragAndDrop(dosGrid, nueveGrid).perform();
    }
}
