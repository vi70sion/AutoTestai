import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WayToAutomation {
    WebDriver _globalDriver;

    @BeforeTest
    public void SetupWebDriver() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _globalDriver = new ChromeDriver();
        //_globalDriver.get("https://www.way2automation.com/way2auto_jquery/automation-practice-site.html");
        _globalDriver.manage().window().maximize();
        _globalDriver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

    }
    @AfterTest
    public void ResetToTitle() throws InterruptedException {
        //_globalDriver.get("https://www.way2automation.com/way2auto_jquery/automation-practice-site.html");
    }

    @Test
    public void testDraggable() {
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
            _globalDriver.get("https://www.way2automation.com/way2auto_jquery/draggable.php#load_box");
            WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
            _globalDriver.switchTo().frame(iframe);
            WebElement draggable = _globalDriver.findElement(By.id("draggable"));
            Point startPosition = draggable.getLocation();
            System.out.println("Start position: " + startPosition);

            // Actions objektas, veiksmui atlikti
            Actions actions = new Actions(_globalDriver);
            actions.clickAndHold(draggable)
                    .moveByOffset(100, 50) // 100 pikselių į dešinę ir 50 pikselių žemyn
                    .release()
                    .perform();
            Point newPosition = draggable.getLocation();
            System.out.println("New position: " + newPosition);

            int expectedX = startPosition.getX() + 100;
            int expectedY = startPosition.getY() + 50;
            int actualX = newPosition.getX();
            int actualY = newPosition.getY();

            Assert.assertEquals( actualX, expectedX, "X wrong value");
            Assert.assertEquals( actualY, expectedY, "Y wrong value");

            Thread.sleep(10 * 1000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (_globalDriver != null) {
                _globalDriver.quit();
            }
        }
    }

    @Test
    public void testDroppable() throws InterruptedException {
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
            _globalDriver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
            WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
            _globalDriver.switchTo().frame(iframe);
            WebElement draggable = _globalDriver.findElement(By.id("draggable"));
            Point draggPosition = draggable.getLocation();
            System.out.println("Start draggable position: " + draggPosition);

            WebElement droppable = _globalDriver.findElement(By.id("droppable"));
            Point droppPosition = droppable.getLocation();
            System.out.println("Droppable position: " + droppPosition);
            String droppableText = droppable.getText();
            System.out.println("Droppable text: " + droppableText);

            Actions actions = new Actions(_globalDriver);
            actions.clickAndHold(draggable)
                    .moveByOffset(droppPosition.getX()-draggPosition.getX(), droppPosition.getY()-draggPosition.getY())
                    .release()
                    .perform();

            String expectedDroppableText = droppable.getText();
            System.out.println("Droppable text: " + expectedDroppableText);

            String actualText = "Dropped!";
            Assert.assertEquals(actualText, expectedDroppableText, "Wrong possition");

            Thread.sleep(10 * 1000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (_globalDriver != null) {
                _globalDriver.quit();
            }
        }
    }

    @Test
    public void testResizable() {
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
            _globalDriver.get("https://www.way2automation.com/way2auto_jquery/resizable.php#load_box");
            WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
            _globalDriver.switchTo().frame(iframe);
            //WebElement resizable = _globalDriver.findElement(By.id("resizable"));
            WebElement resizable = _globalDriver.findElement(By.cssSelector(".ui-resizable-se"));

            Actions actions = new Actions(_globalDriver);
            actions.clickAndHold(resizable)
                    .moveByOffset(200, 100)
                    .release()
                    .perform();

            int actualWidth = Integer.parseInt(resizable.getCssValue("width"));
            int actualHeight = Integer.parseInt(resizable.getCssValue("height"));

            Assert.assertEquals(actualWidth, actualWidth + 200, "Wrong width possition");
            Assert.assertEquals(actualHeight, actualHeight + 100, "Wrong height possition");

            Thread.sleep(10 * 1000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (_globalDriver != null) {
                _globalDriver.quit();
            }
        }
    }

    @Test
    public void testDatepicker() {
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(5));
            _globalDriver.get("https://www.way2automation.com/way2auto_jquery/datepicker.php#load_box");
            WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
            _globalDriver.switchTo().frame(iframe);

            WebElement datepicker = _globalDriver.findElement(By.id("datepicker"));
            datepicker.click();

            WebElement specificDate = _globalDriver.findElement(By.xpath("//a[text()='15']"));
            specificDate.click();

            String actualDate = datepicker.getAttribute("value");
            String expectetDate = "12/15/2024";

            Assert.assertEquals(actualDate, expectetDate, "Selected wrong date.");

            Thread.sleep(10 * 1000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (_globalDriver != null) {
                _globalDriver.quit();
            }
        }
    }

}
