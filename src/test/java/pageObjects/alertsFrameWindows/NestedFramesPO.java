package pageObjects.alertsFrameWindows;

import base.DemoQASetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramesPO extends DemoQASetup {
    public NestedFramesPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irANestedFrames(){
        driver.get("https://demoqa.com/nestedframes");
    }
    @FindBy(id = "frame1")
    protected WebElement primerIframe;
    public void comprobarIframesAnidados(){
        driver.switchTo().frame(primerIframe);
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")));
    }
}
