package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendAppPage extends BasePage {

    @FindBy(xpath = "//*[text() = 'Выбор полиса']")
    public WebElement title11;

    @FindBy(name = "insured0_surname")
    WebElement insured_surname;

    @FindBy(name = "insured0_name")
    WebElement insured_name;

    @FindBy(name = "surname")
    WebElement lastname;

    @FindBy(name = "name")
    WebElement firstName;

    @FindBy(name = "middlename")
    WebElement middleName;

    @FindBy(xpath = "//span[text()='Оформить']")
    public WebElement sendButton2;

    @FindBy(xpath = "//span[text()='Продолжить']")
    public WebElement sendButton3;

    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(title11));
        this.driver = driver;
    }
    public void Click2 (){
        sendButton2.findElement(By.xpath("//span[text()='Оформить']")).click();
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия /Surname":
                fillField(insured_surname, value);
                break;
            case  "Имя / Given names":
                fillField(insured_name, value);
                break;
            case  "Фамилия":
                fillField(lastname, value);
                break;
            case  "Имя":
                fillField(firstName, value);
                break;
            case  "Отчество":
                fillField(middleName, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public void Click3 (){
        sendButton3.findElement(By.xpath("//span[text()='Продолжить']")).click();
    }
    public void checkFieldErrorMessage(String errorMessage){
        String xpath = "//DIV[@ng-show='tryNext && myForm.$invalid']";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }
}
