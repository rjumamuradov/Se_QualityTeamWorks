package day01_26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {

    public static void main(String[] args) {



        WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com.tr");

        //4. Sayfa basligini(title) yazdirin
        String actualTitle=driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        //5. Sayfa basliginin “Amazon” icerdigini test edin
        String expectedTitle="Amazon";


        //6. Sayfa adresini(url) yazdirin
        Assert.assertTrue("title Amazon icermez ---> ",actualTitle.contains(expectedTitle));
        //7
        //. Sayfa url’inin “amazon” icerdigini test edin.
        String actualUrl = driver.getCurrentUrl();
        System.out.println("driver = " + driver.getCurrentUrl());
        String expectedUrl="amazon";

        Assert.assertTrue("url amazon icermiyor gardas ",actualUrl.contains(expectedUrl));
        Assert.assertFalse("url amazon iceriyor ",!actualUrl.contains(expectedUrl));


        //8. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());
        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        String actualHtml = driver.getPageSource();
        System.out.println("actualHtml = " + actualHtml);
        String expectedHtml="Merhaba";
        Assert.assertTrue("saysa alisveris icermez",actualHtml.contains(expectedHtml));


        //10


        //. Sayfayi kapatin.

        driver.close();

    }





}
