package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public WebDriver driver;

    public Actions act = new Actions(driver);

    @Parameters({"os", "browserName", "url"})

    @BeforeMethod
    public void setUp(@Optional("https://expertautomationteam.com/index.html") String url, @Optional("windows") String os, @Optional("chrome") String browserName) {
        getDriver(os, browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        click("//a[@href='practice.html']");
    }

    public WebDriver getDriver(String os, String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/src/driver/chromedriver");
            } else if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/src/driver/chromedriver.exe");
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/src/driver/geckodriver");
            } else if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/src/driver/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        }
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void click(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception e) {
            driver.findElement(By.xpath(locator)).click();
        }
    }

    public void type(String locator, String text) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(text);
        } catch (Exception e) {
            driver.findElement(By.xpath(locator)).sendKeys(text);
        }
    }

    public void hitEnter(String locator, String text) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(text, Keys.ENTER);
        } catch (Exception e) {
            driver.findElement(By.xpath(locator)).sendKeys(text, Keys.ENTER);
        }
    }

    public void dragAndDrop(String drag, String drop) {
        WebElement source = driver.findElement(By.xpath(drag));
        WebElement destination = driver.findElement(By.xpath(drop));
        act.dragAndDrop(source, destination).build().perform();
    }


}
