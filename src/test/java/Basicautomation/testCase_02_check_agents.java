package Basicautomation;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

public class testCase_02_check_agents {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://dev.olivebranchtech.ai/login");
            driver.manage().window().maximize();
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
            WebElement footertext = driver.findElement(By.xpath("//span[text()='© 2026 Powered by Olive Branch. All rights reserved.']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footertext);
            Thread.sleep(2000);
            System.out.println("This is actual  " + footertext.getText());
            // Code to scroll the page
            WebElement footer = driver.findElement(By.xpath("//span[contains(text(), 'Powered ')]"));
            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);",footer);
            WebElement agent = driver.findElement(By.xpath("(//span[contains(@class,'transition')])[2]"));
            agent.click();
                Thread.sleep(3000);
//            driver.findElement(By.xpath("(//span[contains(@class,'transition')])[3]")).click();
//            Thread.sleep(5000);
//            driver.findElement(By.xpath("(//span[contains(@class,'transition')])[4]")).click();
//            Thread.sleep(8000);
//             driver.findElement(By.xpath("(//span[contains(@class,'transition')])[5]")).click();
//             Thread.sleep(5000);
//             driver.findElement(By.xpath("(//span[contains(@class,'transition')])[6]")).click();
//             Thread.sleep(5000);
//             driver.findElement(By.xpath("(//span[contains(@class,'transition')])[7]")).click();
//             Thread.sleep(5000);
             driver.findElement(By.xpath("(//span[contains(@class,'transition')])[8]")).click();
             Thread.sleep(5000);
             driver.findElement(By.xpath("//img[@src='assets/images/icons/plus-white.svg']")).click();
            Random rand = new Random();
            int randomNum = rand.nextInt(1000);
             driver.findElement(By.cssSelector("input[id='quizTitle']")).sendKeys("Quiz-"+ randomNum);
             driver.findElement(By.xpath("(//input[@autocomplete='off'])[1]")).click();
             // Wait for the dropdown options to be visible and click on the desired option
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ant-select-item-option-content'])[7]")));
             WebElement cat= driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'])[7]"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", cat);
            Thread.sleep(3000);
             driver.findElement(By.xpath("(//input[@autocomplete='off'])[2]")).click();
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'ant-select-item-option-content')])[5]")));
            System.out.println("Dropdown options are visible");
             WebElement time=driver.findElement(By.xpath("(//div[contains(@class, 'ant-select-item-option-content')])[5]"));
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", time);
                driver.findElement(By.id("quizInstructions")).sendKeys("This is quiz 1 instructions");
                Thread.sleep(3000);
                driver.findElement(By.xpath("//button[contains(@class,'px-3')]")).click();
                driver.findElement(By.xpath("//input[@placeholder='Enter your question...']")).sendKeys("what is the capital of Belguim: ?");
                driver.findElement(By.xpath("//input[@placeholder='Option A']")).sendKeys("Bruselles");
                driver.findElement(By.xpath("//input[@placeholder='Option B']")).sendKeys("Budapest");
                driver.findElement(By.xpath("(//button[text()=' Add Quiz '])[2]")).click();
                Thread.sleep(5000);
                driver.findElement(By.xpath("(//button[text()=' Assign to Agent '])[1]")).click();
                Thread.sleep(3000);
                driver.findElement((By.xpath("(//input[@placeholder='Search by agent, team leader'])[1]"))).sendKeys("Armando Portin");
            Thread.sleep(3000);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='checkbox'])[2]")));
                driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("(//button[contains(@class,'px-6')])[2]")).click();
                Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
