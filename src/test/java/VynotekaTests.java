import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class VynotekaTests {
    WebDriver _globalDriver;

    @BeforeTest
    public void SetupWebDriver() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _globalDriver = new ChromeDriver();
        _globalDriver.get("https://vynoteka.lt/");
        _globalDriver.manage().window().maximize();
        _globalDriver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button")).click();
        Thread.sleep(2000);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/a[2]")).click();


    }
    @AfterTest
    public void ResetToTitle() throws InterruptedException {
        _globalDriver.get("https://vynoteka.lt/");
    }

    //1.Testas
    //tikrinama vartotojo registracija- turi matytis asmeninė infomacija, užregistruoto vartotojo vardas ir pavardė
    @Test
    public void test1() throws InterruptedException {
        _globalDriver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        //Spaudžiame Prisijungti
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[4]/nav/div[1]/button")).click();
        Thread.sleep(1000);
        //Spaudžiame Sukurti Paskyrą
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[1]/div/button")).click();
        Thread.sleep(1000);
        //Užpildyti Jūsų vardas
        _globalDriver.findElement(By.id("firstname")).sendKeys("Juozas");
        Thread.sleep(1000);
        //Užpildyti Jūsų pavardė
        _globalDriver.findElement(By.id("lastname")).sendKeys("Antanas");
        Thread.sleep(1000);
        //Metai
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[1]/div/div/span[1]/button")).click();
        Thread.sleep(1000);
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[1]/div/div/span[2]/div/div/button[9]/span")).click();
        Thread.sleep(1000);
        //Mėnuo
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[2]/div/div/span[1]/button")).click();
        Thread.sleep(1000);
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[2]/div/div/span[2]/div/div/button[1]/span")).click();
        Thread.sleep(1000);
        //Diena
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[3]/div/div/span[1]/button")).click();
        Thread.sleep(1000);
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[3]/div/div/span[2]/div/div/button[5]")).click();
        Thread.sleep(1000);
        _globalDriver.findElement(By.id("email")).sendKeys("juozas.antanas8@gmail.com");
        Thread.sleep(1000);
        _globalDriver.findElement(By.id("phone")).sendKeys("60012345");
        Thread.sleep(1000);
        _globalDriver.findElement(By.id("password")).sendKeys("JuozasAntanas0");
        Thread.sleep(1000);
        _globalDriver.findElement(By.id("password_repeat")).sendKeys("JuozasAntanas0");
        Thread.sleep(1000);
        //Pažymėti žymimąjį lauką "Susipažinau ir sutinku..."
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[8]/div[1]/div/label/span")).click();
        Thread.sleep(1000);
        //Paspausti Registruotis
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[2]/div/div[2]/button")).click();
        Thread.sleep(35000);
        //Praleisti mygtukas
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/button")).click();
        Thread.sleep(1000);
        //Vartotojo prisijungimas
        _globalDriver.findElement(By.cssSelector(".user-actions__link--login")).click();
        Thread.sleep(1000);
        String vardasPavarde = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/span")).getText();
        Assert.assertEquals(vardasPavarde,"Juozas Antanas");
        Thread.sleep(1000);
    }



}

