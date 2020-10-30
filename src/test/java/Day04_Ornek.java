import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day04_Ornek {

    //Day04_Ornek adinda bir class olusturduktan sonra
    //1."https://amazon.com" a gidelim.
    //2."Books" kategorisini secelim.
    // 3.Arama kurusuna JAVA yazalim ve arama yapalim
    // 4.Toplam sonuc sayisini ekrana yazdiralim.
    // 5.Ilk siradaki ürüne tiklayalim.
    // 6.Bu ürünün isminin(Effective Java) görünüp görünmedigini dogrulayalim.(isDisplay)

    static WebDriver driver;

    @BeforeClass
    public static void setup() { // Junit 4.13  version'dan sonra beforeClass ve afterClass methodlar static olmak zorunda
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @Test
    public void dropdown01() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement BookIcin= driver.findElement(By.id("searchDropdownBox"));
        Select select =new  Select(BookIcin);
        select.selectByVisibleText("Books");

        WebElement yaziYaz= driver.findElement(By.id("twotabsearchtextbox"));
        yaziYaz.sendKeys("JAVA");
        yaziYaz.submit();

        WebElement toplamSonuc= driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(toplamSonuc.getText());

        WebElement ilkUrun = driver.findElement(By.xpath("//*[.='Effective Java']"));
        ilkUrun.click();

        WebElement urunIsmi =driver.findElement(By.id("productTitle"));
        boolean gorunuyorMu = urunIsmi.isDisplayed();
        System.out.println("gorunuyor MU : "+gorunuyorMu);



}
    }