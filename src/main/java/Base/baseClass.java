//package Base;
//
//import org.testng.annotations.BeforeTest;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import java.time.Duration;
//
//public class baseClass {
//    protected static WebDriver driver;
//
//    @BeforeMethod
//    public void setup(){
//        // Update the chromedriver path for your system
//        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://example.com");
//    }
//}