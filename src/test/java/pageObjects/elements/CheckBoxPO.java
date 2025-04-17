package pageObjects.elements;

import base.DemoQASetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPO extends DemoQASetup {
    public CheckBoxPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "rct-checkbox")
    protected WebElement checkBoxHome;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/button")
    protected WebElement desplegableHome;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button")
    protected WebElement desplegableDesktop;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")
    protected WebElement desplegableDocuments;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button")
    protected WebElement desplegableDownloads;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button")
    protected WebElement desplegableWorkSpace;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button")
    protected WebElement desplegableOffice;

    public void irACheckBox(){
        driver.get("https://demoqa.com/checkbox");
    }
    public void checkearHome(){
        checkBoxHome.click();
    }
    public void desplegarHome(){
        desplegableHome.click();
    }
    public void desplegarDesktop(){
        desplegableDesktop.click();
    }
    public void desplegarDocuments(){
        desplegableDocuments.click();
    }
    public void desplegarDownloads(){
        desplegableDownloads.click();
    }
    public void desplegarWorkSpace(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top " +
                        "+ window.pageYOffset - (window.innerHeight / 2));",
                desplegableWorkSpace);
        desplegableWorkSpace.click();
    }
    public void desplegarOffice(){
        desplegableOffice.click();
    }
}
