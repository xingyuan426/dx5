package web.testCase;

import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import web.page.BasePage;
import web.page.WeWork;

import java.util.concurrent.TimeUnit;

/**
 * @author ：xingyuan.zhang
 * @date ：Created in 2021/4/20 22:56
 * @description：
 * @version:
 */
public class BaseTest {
    WebDriver driver;
    BasePage basePage = new BasePage(driver);
    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        //todo: 支持多浏览器
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }


}
