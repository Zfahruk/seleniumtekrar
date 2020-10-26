import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day02_Anotations {

    //ilk once @Test , @Before ve @After class kuralim
    static WebDriver driver;

    @BeforeClass
    public static void setup(){ // Junit 4.13  version'dan sonra beforeClass ve afterClass methodlar static olmak zorunda
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test() throws InterruptedException {
        // http:a.testaddressbook.com adrese gidiniz
        driver.get("http://a.testaddressbook.com");
        WebElement signInLink =driver.findElement(By.linkText("Sign in"));
        signInLink.click();

        // şimdi bu sayfadaki tüm linkleri bulalım. 3 link var. (Home, Sign in ve Sign up)
Thread.sleep(2000);
        List<WebElement> tumLinkler = driver.findElements(By.tagName("a"));
        for(WebElement w: tumLinkler){
            System.out.println(w.getText());


        }
        // Şimdi Email ve passwordu girerek signin tıkla
        //i. Username : testtechproed@gmail.com
        //ii. Password : Test1234!
        WebElement userName = driver.findElement(By.cssSelector(".form-control"));
        userName.sendKeys("testtechproed@gmail.com");
        WebElement pass = driver.findElement(By.cssSelector("#session_password"));
        pass.sendKeys("Test1234!");

        WebElement signInButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        signInButton.click();

        //Sayfadaki tüm yazıları alalım
        WebElement tumYazilar = driver.findElement(By.tagName("body"));
        System.out.println(tumYazilar.getText());

    }

    @AfterClass
    public static void tearDown(){


    }
}
