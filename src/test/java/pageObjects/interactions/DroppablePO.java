package pageObjects.interactions;

import base.DemoQASetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DroppablePO extends DemoQASetup {
    Actions accion;
    WebDriverWait wait;
    public DroppablePO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irADRoppable(){
        driver.get("https://demoqa.com/droppable");
    }
    @FindBy(id = "draggable")
    protected WebElement drag;
    @FindBy(id = "dragBox")
    protected WebElement dragBox;
    @FindBy(id = "droppable")
    protected WebElement drop;
    @FindBy(id = "droppableExample-tab-accept")
    protected WebElement acceptTab;
    @FindBy(id = "droppableExample-tab-preventPropogation")
    protected WebElement preventPropogationTab;
    @FindBy(id = "droppableExample-tab-revertable")
    protected WebElement revertDraggableTab;
    @FindBy(id = "notAcceptable")
    protected WebElement noAceptable;
    @FindBy(id = "acceptable")
    protected WebElement aceptable;
    @FindBy(id = "greedyDropBox")
    protected WebElement greedyBox;
    @FindBy(id = "greedyDropBoxInner")
    protected WebElement greedyInnerBox;
    @FindBy(id = "notGreedyInnerDropBox")
    protected WebElement notGreedyInnerBox;
    @FindBy(id = "revertable")
    protected WebElement revertable;
    @FindBy(id = "notRevertable")
    protected WebElement notRevertable;
    public void arrastrarYsoltar(){
        accion = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(drag));
        accion.dragAndDrop(drag, drop).release().perform();

        wait.until(ExpectedConditions.textToBe(By.id("droppable"), "Dropped!"));
    }
    public void tabAccept(){
        acceptTab.click();
    }
    public void tabPreventPropagation(){
        preventPropogationTab.click();
    }
    public void tabRevertDraggable(){
        revertDraggableTab.click();
    }
    public void arrastrarYSoltarEnAccept(){
        accion = new Actions(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(noAceptable));
        accion.dragAndDrop(noAceptable, drop).release().perform();

        if(drop.getText().equalsIgnoreCase("Drop here")){
            System.out.println("La tarjeta 'Not Acceptable' se ha soltado correctamente y no ha modificado el drop");
        }

        accion.dragAndDrop(aceptable, drop).release().perform();
        wait.until(ExpectedConditions.textToBe(By.id("droppable"), "Dropped!"));
    }
    public void arrastrarYsoltarInnerNotGreedy(){
        accion = new Actions(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(dragBox));

        accion.dragAndDrop(dragBox, notGreedyInnerBox).release().perform();
        wait.until(ExpectedConditions.textToBe(By.id("notGreedyInnerDropBox"), "Dropped!"));
    }
    public void arrastrarYsoltarInnerGreedy(){
        accion = new Actions(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(dragBox));

        accion.scrollToElement(greedyInnerBox).perform();
        accion.dragAndDrop(dragBox, greedyBox).release().perform();
        wait.until(ExpectedConditions.textToBe(By.id("greedyDropBoxInner"), "Dropped!"));
    }
    public void arrastrarYsoltarOuterGreedy(){
        accion = new Actions(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(dragBox));

        accion.dragAndDrop(dragBox, greedyBox).release().perform();
        wait.until(ExpectedConditions.textToBe(By.id("greedyDropBox"), "Dropped!"));
    }
    public void dragWillRevert(){
        accion = new Actions(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(revertable));

        Point posicionInicial = revertable.getLocation();
        accion.clickAndHold(revertable).moveToElement(drop).release().perform();

        if(revertable.getLocation().equals(posicionInicial)){
            System.out.println("El card ha vuelto a su posicion correctamente");
        }
    }
    public void dragNotRevert(){
        accion = new Actions(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(notRevertable));

        Point posicionInicial = notRevertable.getLocation();
        accion.dragAndDrop(notRevertable, drop).release().perform();

        if(!notRevertable.getLocation().equals(posicionInicial)){
            System.out.println("El ha cambiado de posicion correctamente");
        }
    }
}
