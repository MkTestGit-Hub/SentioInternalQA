package Basicautomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class testCase_02_check_agents {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://dev.olivebranchtech.ai/login");
            driver.manage().window().maximize();

            // Find the email input field using its ID and enter the email address
            WebElement email = driver.findElement(By.id("emailInput"));
            email.sendKeys("pchawla@intelegencia.com");

            // Find Xpath for password\
            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys("Intel@01");

            // View password element
            WebElement viewpasswordicon = driver.findElement(By.className("password-icon"));
            viewpasswordicon.click();

            Thread.sleep(2000);


            // Find element using CSS selector
            WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
            submit.click();
            Thread.sleep(5000);


            // Find element using Xpath for last 6 months
            WebElement last6months = driver.findElement(By.xpath("(//div/ul/li)[6]"));
            last6months.click();
            Thread.sleep(5000);
            WebElement view = driver.findElement(By.xpath("(//span[text()='vs last 6 months'])[1]"));
            Thread.sleep(5000);
            System.out.println("This is actual  "+view.getText());
            Thread.sleep(5000);


            WebElement footertext = driver.findElement(By.xpath("//span[text()='© 2026 Powered by Olive Branch. All rights reserved.']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footertext);
            Thread.sleep(2000);
            System.out.println("This is actual  " + footertext.getText());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
