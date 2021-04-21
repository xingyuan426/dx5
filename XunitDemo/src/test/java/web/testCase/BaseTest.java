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
    public WeWork weWork;
    public WebDriver driver;

    @BeforeEach
    public void init(){
        weWork= new WeWork(this.driver);
    }

/*    @AfterEach
    public void tearDown(){
        weWork.quit();
    }*/


}
