import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day03_Dropdown {

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
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select =new  Select(dropdown);

        // seçili olan option(seçimi) alabiliriz.
       String deneme=  select.getFirstSelectedOption().getText();
        System.out.println(deneme);
    select.selectByVisibleText("Baby");
    Thread.sleep(1000);
    select.selectByIndex(5);
    select.selectByValue("search-alias=fashion-mens-intl-ship");

        List<WebElement> allOptions = select.getOptions();
        System.out.println(allOptions.size()+ ": toplam sayi");


        for (WebElement w: allOptions ){

            System.out.println(w.getText());

        }
        System.out.println();
       // allOptions.forEach(t->System.out.println(t.getText() + " ")); Lambda Kodu





    }
}
