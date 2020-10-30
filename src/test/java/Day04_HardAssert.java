import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day04_HardAssert {

    static WebDriver driver;

    @BeforeClass
    public static void setup() { // Junit 4.13  version'dan sonra beforeClass ve afterClass methodlar static olmak zorunda
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void test() {

        driver.get("https://www.amazon.com");
        String baslik = driver.getTitle();
        if (baslik.contains("Auto")) {
            System.out.println("icerir :" + baslik);

        } else {
            System.out.println("icermiyor :" + baslik);
        }
        boolean iceriyorMU = baslik.contains("Auto");
        Assert.assertTrue(iceriyorMU);
    }

    @Test
    public void test2() {
        driver.get("https://www.amazon.com");
        String baslik = driver.getTitle();

        boolean iceriyorMu = baslik.contains("Google");
        Assert.assertFalse(iceriyorMu);

    }

    @Test
    public void test3() {
        driver.get("https://www.amazon.com");
        String baslik = driver.getTitle();

        Assert.assertEquals("Amazon.com",baslik);


    }
}