import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebDriverManagerTests {

    @Test
    public void FillFormTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("[id='firstName']")).sendKeys("Petr");
        driver.findElement(By.cssSelector("[id='lastName']")).sendKeys("Petrov");
        driver.findElement(By.cssSelector("[id='userNumber']")).sendKeys("1234567898");
        driver.findElement(By.cssSelector("[for='gender-radio-1']")).click();
        driver.findElement(By.cssSelector("[id='submit']")).click();

        Assertions.assertTrue(driver.findElement(By.cssSelector("[id='example-modal-sizes-title-lg']")).isDisplayed());

        Thread.sleep(3000);

        driver.quit();

    }
}
