import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TestNGTest {
        private WebDriver driver;
        private WebDriver driver2;
        private WebDriver driver3;

        @BeforeClass
        public void setUp() {
            // Set the path to the WebDriver executable

            // Initialize WebDrivers
            driver = new ChromeDriver();
            driver2 = new ChromeDriver();
            driver3 = new ChromeDriver();
        }

        @Test
        public void testButtonText() {
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

            // Find the button and click it
            WebElement button = driver.findElement(By.tagName("button"));
            button.click();

            // Wait for the text to become visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

            // Get the text from the element
            String actualText = textElement.getText();
            String expectedText = "Hello World!";

            // Assert that the actual text matches the expected text
            Assert.assertEquals(actualText, expectedText, "Text not found or incorrect!");
        }

        @Test
        public void testColorChangeButtonText() {
            driver2.manage().window().maximize();
            driver2.get("https://demoqa.com/dynamic-properties");

            // Find the button and print its text
            WebDriverWait wait2 = new WebDriverWait(driver2, Duration.ofSeconds(5));
            WebElement colorChangeButton = driver2.findElement(By.xpath("//button[@id='colorChange']"));
            Assert.assertTrue(colorChangeButton.isDisplayed());
        }

        @Test
        public void testDynamicControls() {
            driver3.manage().window().maximize();
            driver3.get("https://the-internet.herokuapp.com/dynamic_controls");

            // Click the "Add/Remove" button
            WebElement addRemoveButton = driver3.findElement(By.xpath("//button[@type='button' and @onclick='swapCheckbox()']"));
            addRemoveButton.click();

            // Wait for the "Add" button to be visible and print its text
            WebDriverWait wait3 = new WebDriverWait(driver3, Duration.ofSeconds(5));
            WebElement addButton = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]")));
            System.out.println(addButton.getText());

            // Click the "Add/Remove" button again to remove the checkbox
            addRemoveButton = driver3.findElement(By.xpath("//button[@type='button' and @onclick='swapCheckbox()']"));
            addRemoveButton.click();

            // Wait for the checkbox to be visible and click it
            WebElement checkbox = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkbox")));
            checkbox.click();

            // Wait for the "Remove" button to be visible and print its text
            WebElement removeButton = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Remove')]")));
            System.out.println(removeButton.getText());
            Assert.assertTrue(checkbox.isDisplayed());
            String verifiedText = removeButton.getText();
            Assert.assertEquals(verifiedText, "Remove");
        }
    }




