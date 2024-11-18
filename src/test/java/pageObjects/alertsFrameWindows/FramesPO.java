package pageObjects.alertsFrameWindows;

import base.DemoQASetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPO extends DemoQASetup {
    public FramesPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "sampleHeading")
    protected WebElement headingInferior;
    @FindBy(id = "frame1")
    protected WebElement iframe1;
    @FindBy(id = "frame2")
    protected WebElement iframe2;
    public void irAFrames(){
        driver.get("https://demoqa.com/frames");
    }
    public void desplazarHeadingInferior(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.switchTo().frame(iframe2);
        js.executeScript("arguments[0].scrollIntoView(true);", headingInferior);
        driver.switchTo().defaultContent();
    }
    public void headingIframe1(){
        driver.switchTo().frame(iframe1);
        if(headingInferior.getText().equalsIgnoreCase("This is a sample page")){
            System.out.println("Se ha accedido correctamente al primer iframe");
        }
        driver.switchTo().defaultContent();
    }
    public void headingIframe2(){
        driver.switchTo().frame(iframe2);
        if(headingInferior.getText().equalsIgnoreCase("This is a sample page")){
            System.out.println("Se ha accedido correctamente al segundo iframe");
        }
        driver.switchTo().defaultContent();
    }
}
