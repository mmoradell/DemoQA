package pageObjects.widgets;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPO extends DemoQASetup {
    public MenuPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irAMenu(){
        driver.get("https://demoqa.com/menu#");
    }
    @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/a")
    protected WebElement mainItem2;
    @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/ul/li[3]/a")
    protected WebElement subsubList;
    @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/ul/li[3]/ul/li[1]/a")
    protected WebElement subsubItem;
    public void recorrerMenuCompleto(){
        Actions accion = new Actions(driver);
        accion.moveToElement(mainItem2).perform();

        accion.moveToElement(subsubList).perform();
        accion.moveToElement(subsubItem).perform();
    }
}
