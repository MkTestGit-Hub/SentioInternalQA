package Basicautomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Sentiologin {

    public static void main(String[] args) throws InterruptedException {
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

            try {
                // Assertion (manual)
                if ( !view.getText().equals("vs last 6 months") )

                {
                    throw new AssertionError("Text does not match");
                }

                System.out.println("Test Passed");

            } catch (AssertionError e) {
                // Capture screenshot immediately at the assertion failure and rethrow so outer catch handles it as well
                try {
                    saveScreenshot(driver, "assertion_failure");
                } catch (Throwable ignore) {
                    System.out.println("Failed to save screenshot on assertion: " + ignore.getMessage());
                }
                throw e;
            }

        } catch (Throwable t) {
            // Catch AssertionError and any other Throwable (like NoSuchElementException)
            System.out.println("Test failed or error occurred: " + t.getMessage());
            try {
                saveScreenshot(driver, "failure");
            } catch (Exception ex) {
                System.out.println("Failed to capture screenshot: " + ex.getMessage());
                ex.printStackTrace();
            }

            // If it's an AssertionError, print message (already printed) and optionally rethrow
            if (t instanceof AssertionError) {
                System.out.println("AssertionError: " + t.getMessage());
            } else {
                t.printStackTrace();
            }

        } finally {
            if (driver != null) {
                try {
                    driver.quit();
                } catch (Exception ignore) {
                }
            }
        }
    }

    // Helper to save a timestamped screenshot into ./screenshots/
    private static void saveScreenshot(WebDriver driver, String prefix) {
        try {
            if (driver == null) {
                System.out.println("Cannot take screenshot: WebDriver is null");
                return;
            }

            if (!(driver instanceof TakesScreenshot)) {
                System.out.println("Driver does not support taking screenshots");
                return;
            }

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String dir = System.getProperty("user.dir") + File.separator + "screenshots";
            File screenshotsDir = new File(dir);
            if (!screenshotsDir.exists()) {
                boolean ok = screenshotsDir.mkdirs();
                if (!ok) {
                    System.out.println("Warning: could not create screenshots directory: " + screenshotsDir.getAbsolutePath());
                }
            }
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");
            String ts = LocalDateTime.now().format(fmt);
            String filename = prefix + "_" + ts + ".png";
            Path dest = Paths.get(screenshotsDir.getAbsolutePath(), filename);
            // Use NIO copy to avoid depending on commons-io
            Files.copy(src.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved at: " + dest.toAbsolutePath());
        } catch (Throwable e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
