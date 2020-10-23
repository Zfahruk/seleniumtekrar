import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01DriverKomutlari {

    @Test
    public  void test01(){

        WebDriverManager.chromedriver().setup();

        //Driver nesnesi olusturduk
        WebDriver driver = new ChromeDriver();

        //istedigimiz web sayfasi
        driver.get("https://google.com");

        //websayfasini tam ekran yapmak icin
        driver.manage().window().maximize();

        //web sayfasina yonlendirme
        driver.navigate().to("https://amazon.com");

        //geri gider
        driver.navigate().back();

        //ileri gitmek icin
        driver.navigate().forward();

        //sayfayi yenilemek icin
        driver.navigate().refresh();

        //locate de bekleme yapmasi icin
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }


}
