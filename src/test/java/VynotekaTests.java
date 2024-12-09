import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
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
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(60));
        WebElement acceptAgeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button")));
        acceptAgeButton.click();
        WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[1]/div/div[1]/a[2]")));
        acceptCookiesButton.click();
        WebElement popupCloseButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[2]/div[2]/button")));
        popupCloseButton.click();
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
        _globalDriver.findElement(By.id("email")).sendKeys("juozas.antanas9@gmail.com");
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
        //Vartotojo informacija
        _globalDriver.findElement(By.cssSelector(".user-actions__link--login")).click();
        Thread.sleep(1000);
        String vardasPavarde = _globalDriver.findElement(
                By.xpath("/html/body/div[1]/div[1]/main/section/div/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/span")).getText();
        Assert.assertEquals(vardasPavarde,"Juozas Antanas");
        Thread.sleep(1000);
    }

    //2.Testas
    // tikrinama vartotojo prisijungimas- turi matytis asmeninė infomacija, užregistruoto vartotojo vardas ir pavardė
    @Test
    public void test2() throws InterruptedException {
        //_globalDriver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        Thread.sleep(1000);
        //Spaudžiame Prisijungti
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[4]/nav/div[1]/button")).click();
        Thread.sleep(1000);
        _globalDriver.findElement(
                By.xpath("//input[@placeholder='El. paštas']")).sendKeys("juozas.antanas9@gmail.com");
        Thread.sleep(1000);
        _globalDriver.findElement(
                By.xpath("//input[@placeholder='Slaptažodis']")).sendKeys("JuozasAntanas0");
        Thread.sleep(1000);
        //Prisijungti
        //_globalDriver.findElement(By.xpath("//button[@class='btn primary full-w']")).click();
        _globalDriver.findElement(By.xpath("//button[contains(text(), 'PRISIJUNGTI')]")).click();
        Thread.sleep(1000);
        //Vartotojo informacija
        _globalDriver.findElement(By.cssSelector(".btn.user-actions__link.user-actions__link--login")).click();
        Thread.sleep(1000);
        //Tikrinimas
        String actualText = _globalDriver.findElement(
                By.xpath("/html/body/div[1]/div[1]/main/section/div/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/span")).getText();
        String expectedText = "Juozas Antanas";
        Assert.assertEquals(actualText, expectedText, "Vartotojo vardas ir pavardė nesutampa!");
    }

    //3.Testas
    // tikrinama prekės įdėjimas į krepšelį- krepšelyje turi būti ieškoma prekė
    @Test
    public void test3() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
        _globalDriver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        //Paieškos laukelyje įvedame reikšmę
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Pvz.: dovanos...']")));
        inputField.sendKeys("Johann Brunner Premium Riesling");
        //Spaudžiame į krepšelį
        WebElement toCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Į KREPŠELĮ')]"))
        );
        toCartButton.click();
        //Tikriname ar prekė krepšelyje
        WebElement itemInCart = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[contains(@class, 'cart-item__title') and contains(text(), 'Johann Brunner Premium Riesling')]"))
        );
        Assert.assertNotNull(itemInCart,"Prekė su pavadinimu 'Johann Brunner Premium Riesling' nerasta krepšelyje.");
    }

    //4.Testas
    // tikrinama prekės informacinis langas ar pritaikoma prekei kainos nuolaida
    @Test
    public void test4() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
        _globalDriver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        //Paieškos laukelyje įvedame reikšmę
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Pvz.: dovanos...']")));
        inputField.sendKeys("Dallmayr Classic Intense");
        //Spaudžiame ant surastos prekės
        WebElement productTitle = _globalDriver.findElement(By.xpath("//a[@class='cart-item__title' and contains(span/text(), 'Dallmayr Classic Intense')]"));
        productTitle.click();
        //Tikriname ar teisinga kaina
        WebElement priceIntElement = _globalDriver.findElement(By.xpath("//span[@class='product-price__int']"));
        String priceInt = priceIntElement.getText();
        WebElement priceDecimalElement = _globalDriver.findElement(By.xpath("//span[@class='product-price__decimal']"));
        String priceDecimal = priceDecimalElement.getText();
        String actualPrice = priceInt + "." + priceDecimal + " €";
        String expectedPrice = "4.99 €";
        Assert.assertEquals(actualPrice, expectedPrice, "Kaina už prekę nesutampa!");
    }

}

