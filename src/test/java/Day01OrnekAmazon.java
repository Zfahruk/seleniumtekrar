import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01OrnekAmazon {
    //1--Amazon.com'a gidiniz.
     //2--Arama kutusuna "baby stroller" yaziniz
    //3--2. siradaki ürüne tiklayiniz.
    //4--Ürün sayfasina gittikten sonra, ürünün fiyatini aliniz.
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("baby stroller"+ Keys.ENTER);
        //searchbox.submit();
        WebElement secondproduct = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        secondproduct.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement price = driver.findElement(By.id("newBuyBoxPrice"));
        System.out.println(price.getText());
        String pricee = price.getText();
        System.out.println(pricee);
        driver.close();
    }

}
