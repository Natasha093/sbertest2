import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InsurancePage;
import pages.MainPage;
import pages.SendAppPage;

import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * @author Ежова Наталья
 */

public class MyRefactoringTest extends BaseTest {

    @Test
    public void newInsuranceTest (){
       MainPage mainPage = new MainPage(driver);
       mainPage.selectMenuItem("Страхование");
       mainPage.selectInsuranceItem("Путешествия и покупки");

       Set<String> oldWindowsSet = driver.getWindowHandles();

        InsurancePage insPage = new InsurancePage(driver);
        String actualTitle = insPage.title.getText();
        String expectedTitle = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
        insPage.Click();

        Set<String> newWindowsSet = driver.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        driver.switchTo().window(newWindowHandle);

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        WebElement title = driver.findElement(By.xpath("//*[text() = 'Выбор полиса']"));
        wait.until(ExpectedConditions.visibilityOf(title));

        SendAppPage sendapppage = new SendAppPage(driver);

        String ActualTitle = sendapppage.title11.getText();
        String ExpectedTitle = "Выбор полиса";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), ActualTitle.contains(ExpectedTitle));
        sendapppage.Click2();


        sendapppage.fillField("Фамилия /Surname", "IVANOV");
        sendapppage.fillField("Имя / Given names", "IVAN");
        sendapppage.fillField("Фамилия", "Иванов");
        sendapppage.fillField("Имя", "Иван");
        sendapppage.fillField("Отчество", "Иванович");

        sendapppage.Click3();

        sendapppage.checkFieldErrorMessage("Заполнены не все обязательные поля");

    }
}

