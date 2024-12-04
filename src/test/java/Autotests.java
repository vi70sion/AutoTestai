import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Autotests {
    WebDriver _globalDriver;

    @BeforeTest
    public void SetupWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _globalDriver = new ChromeDriver();
        _globalDriver.get("https://elenta.lt/");
        _globalDriver.manage().window().maximize();
        _globalDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement sutikimas = _globalDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div[2]/button[1]"));
        sutikimas.click();
    }
    @AfterTest
    public void ResetToTitle() throws InterruptedException {
        //_globalDriver.get("https://elenta.lt/");
    }
////1.Testas
//    @Test
//    public void testTC0101() throws InterruptedException {
//        Thread.sleep(3000);
//        _globalDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr/td[1]/input")).sendKeys("peugeot");
//        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr/td[2]/input")).click();
//        String adName = _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div[1]/p/span[1]")).getText();
//        Assert.assertEquals(adName.toLowerCase(),"peugeot");
//    }


////2.Testas
//    @Test
//    public void testTC0102() throws InterruptedException {
//        Thread.sleep(2000);
//        _globalDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/a[5]")).click();
//        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/ul/li[4]/div[1]/h3/a")).click();
//        Thread.sleep(1000);
//        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div[2]/div")).click();
//        Thread.sleep(1000);
//        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/span[3]/a/span")).click();
//        Thread.sleep(1000);
//        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/ul/li[5]/div[1]/h3/a")).click();
//        Thread.sleep(1000);
//        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div[2]/div/div[1]")).click();
//        Thread.sleep(1000);
//        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/a[2]")).click();
//        Thread.sleep(10000);
//    }

//3 ir 4.Testas
    @Test
    public void testTC0101() throws InterruptedException {
        Thread.sleep(3000);
        _globalDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/a[1]")).click();
        Thread.sleep(500);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[6]/a")).click();
        Thread.sleep(500);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/a")).click();
        Thread.sleep(500);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[1]/input")).sendKeys("Parduodu procesorių");
        Thread.sleep(500);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/span/textarea")).sendKeys("Labai galingas Celeron");
        Thread.sleep(500);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[3]/input")).sendKeys("10");
        Thread.sleep(500);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[5]/input")).sendKeys("37060012345");
        Thread.sleep(500);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[7]/input[2]")).click();
        Thread.sleep(500);
        _globalDriver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\User\\Downloads\\animal2.jpg");
        Thread.sleep(500);
        String pavadinimas = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/input[2]")).getAttribute("title");
        Assert.assertEquals(pavadinimas, "Pašalinti nuotrauką");
        Thread.sleep(5000);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/input[2]")).click();

    }






//    @Test
//    public void testCategoryItemClick() throws InterruptedException {
//        Thread.sleep(3000);
//        WebElement automobiliuKategorijas = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/a[2]"));
//        automobiliuKategorijas.click();
//        WebElement kiekioLaikiklis = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div[1]/span"));
//        int count = Integer.parseInt(kiekioLaikiklis.getText());
//        Assert.assertNotEquals(count, 0);
//    }


}