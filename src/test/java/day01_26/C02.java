package day01_26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com");

        //3. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");


        //4. Tekrar YouTube’sayfasina donelim
        driver.navigate().back();

        //5. Yeniden Amazon sayfasina gidelim

        driver.navigate().forward();


        /*6. Sayfayi Refresh(yenile) yapalim*/
        driver.navigate().refresh();


        //7. Sayfayi min ekran yapalim
        driver.manage().window().minimize();
        Thread.sleep(3000);

        //8. Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();

    }


}
