package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TriangleTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Создание экземпляра драйвера Safari
        driver = new SafariDriver();
        // Максимизация окна браузера
        driver.manage().window().maximize();
    }

    @Test
    public void testTrianglePage() {

        driver.get("https://playground.learnqa.ru/puzzle/triangle");


        WebElement giveUpButton = driver.findElement(By.xpath("//button[text()='Я сдаюсь']"));
        Assert.assertTrue(giveUpButton.isDisplayed(), "Кнопка 'Я сдаюсь' не найдена на странице");


        giveUpButton.click();


        WebElement answerLink = driver.findElement(By.xpath("//a[text()='Ссылка на ответы']"));
        Assert.assertTrue(answerLink.isDisplayed(), "Ссылка на ответы не найдена на странице");


        WebElement hideAnswersButton = driver.findElement(By.xpath("//button[text()='Спрятать ответы']"));
        Assert.assertTrue(hideAnswersButton.isDisplayed(), "Кнопка 'Спрятать ответы' не найдена на странице");
    }

    @AfterTest
    public void tearDown() {
        // Закрытие браузера
        if (driver != null) {
            driver.quit();
        }
    }
}
