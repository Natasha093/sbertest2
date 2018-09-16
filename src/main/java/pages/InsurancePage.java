package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsurancePage extends BasePage {

    @FindBy(xpath = "//h3[text()='Страхование путешественников']")
    public WebElement title;

    @FindBy(xpath = "//P[@class='kit-button kit-button_color_green kit-button_size_m']")
    public WebElement sendButton;

    public InsurancePage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void Click (){
            sendButton.findElement(By.xpath("//P[@class='kit-button kit-button_color_green kit-button_size_m']")).click();
        }
}
