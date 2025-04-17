package pageObjects.widgets;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBarPO extends DemoQASetup {
    public ProgressBarPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irAProgressBar(){
        driver.get("https://demoqa.com/progress-bar");
    }
    @FindBy(id = "startStopButton")
    protected WebElement botonProgressBar;
    @FindBy(xpath = "//*[@id=\"progressBar\"]/div")
    protected WebElement progressBarCompleta;
    public void rellenarProgressBar(){
        botonProgressBar.click();
    }
    public void esperarProgressBarLlena(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        if(wait.until(ExpectedConditions.attributeToBe(progressBarCompleta, "aria-valuenow", "100"))){
            System.out.println("La barra de progreso ha llegado al 100%.");
        }

    }
}
