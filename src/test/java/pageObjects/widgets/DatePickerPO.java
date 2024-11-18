package pageObjects.widgets;

import base.DemoQASetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePickerPO extends DemoQASetup {
    public DatePickerPO(){
        super();
        PageFactory.initElements(driver, this);
    }
    public void irADatePicker(){
        driver.get("https://demoqa.com/date-picker");
    }
    @FindBy(id = "datePickerMonthYearInput")
    protected WebElement datePicker;
    @FindBy(xpath = "//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[4]")
    protected WebElement dia;
    @FindBy(id = "dateAndTimePickerInput")
    protected WebElement datePickerAndTimer;
    @FindBy(xpath = "//*[@id=\"dateAndTimePicker\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[4]")
    protected WebElement diaDatePicker;
    @FindBy(xpath = "//*[@id=\"dateAndTimePicker\"]/div[2]/div[2]/div/div/div[3]/div[2]/div/ul/li[3]")
    protected WebElement horaDatePicker;
    public void rellenarFecha(){
        datePicker.click();
        dia.click();
    }
    public void rellenarFechaYHora(){
        datePickerAndTimer.click();
        diaDatePicker.click();
        horaDatePicker.click();
    }
}
