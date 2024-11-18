package pageObjects.widgets;

import base.DemoQASetup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectMenuPO extends DemoQASetup {
    public SelectMenuPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irASelectMenu(){
        driver.get("https://demoqa.com/select-menu");
    }
    @FindBy(id = "react-select-2-input")
    protected WebElement selectValue;
    @FindBy(id = "react-select-3-input")
    protected WebElement selectOne;
    @FindBy(id = "oldSelectMenu")
    protected WebElement oldMenu;
    @FindBy(id = "react-select-4-input")
    protected WebElement multiSelect;
    @FindBy(xpath = "//*[@id=\"cars\"]/option[1]")
    protected WebElement selectVolvo;
    public void seleccionarPrimerComboBox(){
        selectValue.sendKeys("Group 2, option 1");
        selectValue.sendKeys(Keys.ENTER);
    }
    public void seleccionarSegundoComboBox(){
        selectOne.sendKeys("Dr.");
        selectOne.sendKeys(Keys.ENTER);
    }
    public void seleccionarTercerComboBox(){
        oldMenu.sendKeys("Blue");
    }
    public void seleccionarMultiSelectDropDown(){
        multiSelect.sendKeys("Green");
        multiSelect.sendKeys(Keys.ENTER);
        multiSelect.sendKeys("Black");
        multiSelect.sendKeys(Keys.ENTER);
    }
    public void selectStandarMultiSelect(){
        selectVolvo.click();
    }
}
