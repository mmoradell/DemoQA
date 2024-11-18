package pageObjects.interactions;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectablePO extends DemoQASetup {
    public SelectablePO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irASelectablePO(){
        driver.get("https://demoqa.com/selectable");
    }
    @FindBy(id = "verticalListContainer")
    protected List<WebElement> container;
    @FindBy(className = "mt-2 list-group-item active list-group-item-action")
    protected WebElement elementoContainerActivo;
    @FindBy(className = "mt-2 list-group-item list-group-item-action")
    protected WebElement elementoContainerDesactivado;
    public void seleccionMultiple(){
        for(WebElement element : container){
            element.click();
            if(element.equals(elementoContainerActivo)){
                System.out.println("El elemento se ha marcado correctamente");
            }else if(element.equals(elementoContainerDesactivado)){
                System.out.println("El elemento no ha sido marcado");
            }
        }
    }
}
