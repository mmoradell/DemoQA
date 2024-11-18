package pageObjects.widgets;

import base.DemoQASetup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoCompletePO extends DemoQASetup {
    public AutoCompletePO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irAAutoComplete(){
        driver.get("https://demoqa.com/auto-complete");
    }
    @FindBy(id = "autoCompleteMultipleInput")
    protected WebElement multiplesColores;
    @FindBy(id = "autoCompleteSingleInput")
    protected WebElement color;
    public void rellenarMultiplesColores(){
        multiplesColores.sendKeys("Blue");
        multiplesColores.sendKeys(Keys.ENTER);

        multiplesColores.sendKeys("Red");
        multiplesColores.sendKeys(Keys.ENTER);

        multiplesColores.sendKeys("Green");
        multiplesColores.sendKeys(Keys.ENTER);
    }
    public void rellenarUnColor(){
        color.sendKeys("Blue");
        color.sendKeys(Keys.ENTER);
    }
}
