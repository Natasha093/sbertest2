package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    /**
     * @author Наталья Ежова
     */
    public class MainPage extends BasePage{

        @FindBy(xpath = "//UL[@class='lg-menu__list']")
        WebElement menuItems;

        @FindBy(xpath = "(//UL[@class='lg-menu__sub-list'])[6]")
        WebElement menuInsurance;

        public MainPage(WebDriver driver){
            PageFactory.initElements(driver, this);
            this.driver = driver;
        }

        public void selectMenuItem(String itemName){
            menuItems.findElement(By.xpath(".//span[@class='lg-menu__text'][contains(text(),'"+itemName+"')]")).click();
        }

        public void selectInsuranceItem(String itemName){
            menuInsurance.findElement(By.xpath(".//*[contains(text(),'"+itemName+"')]")).click();
        }

    }

