package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        //creating a driver to interact with browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();

        //finding,clicking and printing the text from button
        WebElement element = driver.findElement(By.tagName("button"));
        element.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']")));
        WebElement element1 = driver.findElement(By.id("finish"));
        System.out.println(element1.getText());

        //getting another URL and getting the text when text changes
        WebDriver driver2 = new ChromeDriver();
        driver2.get("https://demoqa.com/dynamic-properties");
        driver2.manage().window().maximize();
        WebDriverWait wait2 = new WebDriverWait(driver2, Duration.ofSeconds(5));
        WebElement element2 = driver2.findElement(By.xpath("//button[@id='colorChange']"));
        System.out.println(element2.getText());


        //finding a button,clicking it, waiting to be visible again, clicking it again,clicking on checkbox and printing the text from both buttons
        WebDriver driver3 = new ChromeDriver();
        driver3.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver3.manage().window().maximize();
        WebElement element3 = driver3.findElement(By.xpath("//button[@type='button' and @onclick='swapCheckbox()']"));
        element3.click();
        WebDriverWait wait3 = new WebDriverWait(driver3,Duration.ofSeconds(5));
        element3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]")));
        System.out.println(element3.getText());
        element3.findElement(By.xpath("//button[@type='button' and @onclick='swapCheckbox()']"));
        element3.click();
        element3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkbox")));
        element3.click();
        element3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Remove')]")));
        System.out.println(element3.getText());


    }
}