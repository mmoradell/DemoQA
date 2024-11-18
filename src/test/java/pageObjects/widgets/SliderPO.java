package pageObjects.widgets;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPO extends DemoQASetup {
    public SliderPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irASlider(){
        driver.get("https://demoqa.com/slider");
    }
    @FindBy(xpath = "//*[@id=\"sliderContainer\"]/div[1]/span/input")
    protected WebElement slider;
    public void moverSlider(){
        int tamanoSlider = slider.getSize().width;

        Actions accion = new Actions(driver);
        accion.clickAndHold(slider).moveByOffset(tamanoSlider / 3, 0).release().perform();
    }
}
