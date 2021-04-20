package web;

/**
 * @author ：xingyuan.zhang
 * @date ：Created in 2021/4/14 20:43
 * @description：搜索微信小程序贴
 * @version: V1.0
 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CeShiRenTest {
    public static WebDriver driver;

    @BeforeAll
    public static void init(){
        //也可以指定浏览器地址
        // System.setProperty("webdriver.chrome.bin", "D:\\ProgramFiles\\Google\\chrome.exe");
        String chromedriver = "src/main/resources/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromedriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void search() throws InterruptedException {
        try {
            driver.get("https://ceshiren.com");
            //点击搜索框
            driver.findElement(By.id("search-button")).click();
            //输入微信小程序
            driver.findElement(By.cssSelector("#search-term")).sendKeys("微信小程序自动化");
            //选择最后一个帖子进入
            //xpath
            WebElement element = driver.findElements(By.xpath("//span[text()='微信小程序自动化']")).get(7);
            //cssSelector 貌似没有包含特定文本的选择器，可以通过jQuery语法$('span.topic:contains(\'微信小程序自动化\')')查找
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript("arguments[0].scrollIntoView();",element);
            element.click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
