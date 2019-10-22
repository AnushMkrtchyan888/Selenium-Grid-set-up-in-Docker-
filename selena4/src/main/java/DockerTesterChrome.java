import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DockerTesterChrome {
    static RemoteWebDriver driver;


    @BeforeClass
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setPlatform(Platform.LINUX);
        cap.setVersion("");
        driver = new RemoteWebDriver(new URL("http://172.17.0.2:4444/wd/hub"), cap);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(description = "Searching in youtube")
    public void googleSearch() throws InterruptedException {
        driver.navigate().to("https://www.youtube.com/");
        driver.findElement(By.xpath("//input[@type='text' and @id = 'search']")).sendKeys("Hello");
        driver.findElement(By.xpath("//*[@id='search-icon-legacy']")).click();
        Thread.sleep(5000);
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            System.out.println("Complated Test in Docker Container <<Chrome>>");
            driver.quit();
        }
    }
}


