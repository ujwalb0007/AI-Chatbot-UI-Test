package com.chatgpt.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
public class ChatbotTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverSetup.initDriver();
        driver.get("https://chat.openai.com");

        // Wait to log in manually (or automate login if cookie/session available)
        Thread.sleep(20000); // You manually log in here

        // Locate input box
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.tagName("textarea")));

        // Send prompt
        inputBox.sendKeys("Tell me a joke");
        inputBox.submit();

        // Wait and capture output
        Thread.sleep(5000);
        WebElement response = driver.findElement(By.cssSelector("div.markdown"));

        System.out.println("Response: " + response.getText());

        driver.quit();
    }


}
