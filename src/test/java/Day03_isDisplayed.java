import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_isDisplayed {


    static WebDriver driver;

    @BeforeClass
    public static void setup() { // Junit 4.13  version'dan sonra beforeClass ve afterClass methodlar static olmak zorunda
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void isDisplayed(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement baslik = driver.findElement(By.xpath("//*[.='Dynamic Controls']"));
        boolean gorunuyorMu = baslik.isDisplayed();
        System.out.println(gorunuyorMu);

    }
    @Test
    public void isSelected(){

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement seciliMi = driver.findElement(By.xpath("//*[@label='blah']"));

        System.out.println("Secili mi 1:" + seciliMi.isSelected());

        //seciliMi.click();

        System.out.println("Secili mi 2:" + seciliMi.isSelected());


        if(seciliMi.isSelected()){

            System.out.println("dogru");
        }
        else{
            System.out.println("su an secili degil,tikla bak ");
            seciliMi.click();
            System.out.println("su an secildi ");

        }

    }
    @Test
    public void isEnabled() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement isEanabled= driver.findElement(By.xpath("//input[@type='text']"));

        WebElement isEanabled2= driver.findElement(By.xpath("(//button[@autocomplete='off'])[2]"));

        isEanabled2.click();

        Thread.sleep(5000);

        System.out.println("Enabled mi :" + isEanabled.isEnabled());

    }

}