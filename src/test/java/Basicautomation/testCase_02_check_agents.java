package Basicautomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class testCase_02_check_agents {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://dev.olivebranchtech.ai/login");
            driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

            // Find the element using Xpath for "vs last 6 months"
//            WebElement view = driver.findElement(By.xpath("(//span[text()='vs last 6 months'])[1]"));
//            Thread.sleep(5000);
//            System.out.println("This is actual  "+view.getText());
//            Thread.sleep(5000);


            WebElement footertext = driver.findElement(By.xpath("//span[text()='© 2026 Powered by Olive Branch. All rights reserved.']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footertext);
            Thread.sleep(2000);
            System.out.println("This is actual  " + footertext.getText());
            // Code to scroll the page
            WebElement footer = driver.findElement(By.xpath("//span[contains(text(), 'Powered ')]"));
            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);",footer);
//            long scrollHeight = (long) js.executeScript("return document.body.scrollHeight");
//            for( int i=0; i<scrollHeight; i+=200)
//            {
//                js.executeScript("window.sctollBy(0,"+i+")");
//                try{
//                    Thread.sleep(100);
//                }catch(InterruptedException e){
//                    throw new RuntimeException(e);
//                }
//            }

            WebElement agent = driver.findElement(By.xpath("(//span[contains(@class,'transition')])[2]"));
            agent.click();
                Thread.sleep(3000);
//                WebElement agentaction = driver.findElement(By.xpath("(//img[@class='cursor-pointer'])[1]"));
//                agentaction.click();
//                Thread.sleep(3000);

            driver.findElement(By.xpath("(//span[contains(@class,'transition')])[3]")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//span[contains(@class,'transition')])[4]")).click();
            Thread.sleep(8000);
             driver.findElement(By.xpath("(//span[contains(@class,'transition')])[5]")).click();
             Thread.sleep(5000);
             driver.findElement(By.xpath("(//span[contains(@class,'transition')])[6]")).click();
             Thread.sleep(5000);
             driver.findElement(By.xpath("(//span[contains(@class,'transition')])[7]")).click();
             Thread.sleep(5000);
             driver.findElement(By.xpath("(//span[contains(@class,'transition')])[8]")).click();
             Thread.sleep(5000);

             driver.findElement(By.xpath("//img[@src='assets/images/icons/plus-white.svg']")).click();
             driver.findElement(By.cssSelector("input[id='quizTitle']")).sendKeys("Quiz 1");
             driver.findElement(By.xpath("(//input[@autocomplete='off'])[1]")).click();
             // Wait for the dropdown options to be visible and click on the desired option
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ant-select-item-option-content'])[7]")));
             WebElement cat= driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'])[7]"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", cat);
            Thread.sleep(5000);

             driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input ng-pristine ng-valid ng-touched'])[2]")).click();
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'ant-select-item-option-content')])[5]")));

             WebElement time=driver.findElement(By.xpath("(//div[contains(@class, 'ant-select-item-option-content')])[5]"));
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", time);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
