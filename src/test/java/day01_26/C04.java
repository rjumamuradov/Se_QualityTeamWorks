package day01_26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04 {


   static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void test() {
        //a. http://a.testaddressbook.com adresine gidiniz.

        driver.get("http://a.testaddressbook.com");
//b. Sign in butonuna basin
      driver.findElement(By.id("sign-in")).click();

//c
//. email textbox,password textbox, and signin button elementlerini locate
       WebElement emailTextBox= driver.findElement(By.id("session_email"));
       WebElement paswordTextBox= driver.findElement(By.id("session_password"));
       WebElement signinButon= driver.findElement(By.name("commit"));


//d
//. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign i n)buttonunu tıklayın:
//i. Username :
//testtechproed@gmail.com
        emailTextBox.sendKeys("testtechproed@gmail.com");
//ii. Password : Test1234!
paswordTextBox.sendKeys("Test1234!");
signinButon.click();
//e. Expected user id nin

//testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement userId=driver.findElement(By.xpath("//span[@class='navbar-text']"));
        String actualUseerId= userId.getText();
        System.out.println("actualUseerId = " + actualUseerId);
        String expectedUserId="testtechproed@gmail.com";
        Assert.assertEquals("user id esit degil",expectedUserId,actualUseerId);

//f
//. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).

        WebElement addrss= driver.findElement(By.xpath("(//a[@class='nav-item nav-link'])[1]"));
       // System.out.println("addrss texti= " + addrss.getText());
        WebElement singout= driver.findElement(By.xpath("(//a[@class='nav-item nav-link'])[2]"));
       // System.out.println("singout texti= " + singout.getText());
        System.out.println(addrss.isDisplayed());
        System.out.println(singout.isDisplayed());
        Assert.assertTrue(addrss.isDisplayed());
        Assert.assertTrue(singout.isDisplayed());
    }

}
