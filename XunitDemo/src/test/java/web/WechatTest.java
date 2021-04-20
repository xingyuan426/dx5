package web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WechatTest {
    private static WebDriver driver;
    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }


    @Test
    public void saveCookie(){
        try {
            driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx?from=myhome");
            Thread.sleep(10000);
            Set<Cookie> cookies = driver.manage().getCookies();
            driver.navigate().refresh();
            ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
            objectMapper.writeValue(new File("cookie.yaml"),cookies);
            cookies.forEach(cookie-> System.out.println(cookie.getName()+":"+cookie.getValue()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void loginTest(){
        String username = "zxytest"+getRandomString(2);
        String acctid = getRandomString(12);
        String tel = getTelNumber();
        try {
            driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx?from=myhome");

            ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
            TypeReference<List<HashMap<String, Object>>> typeReference=new TypeReference<List<HashMap<String, Object>>>(){};
            List<HashMap<String, Object>> cookies = objectMapper.readValue(new File("cookie.yaml"), typeReference);
            cookies.forEach(cookie->{
               driver.manage().addCookie(new Cookie(cookie.get("name").toString(),cookie.get("value").toString()));
            });
            driver.navigate().refresh();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//span[text()='添加成员']")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.cssSelector("input[id='memberAdd_acctid']")).sendKeys(acctid);
            driver.findElement(By.cssSelector("input#memberAdd_phone[type='tel']")).sendKeys(tel);
            driver.findElements(By.cssSelector("a.qui_btn.ww_btn.js_btn_save")).get(0).click();
            driver.findElement(By.xpath("//span[text()='"+username+"']"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("can't find element '//span[text()=username]'" );
        }
    }


    public String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }


    public String getTelNumber(){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<8;i++){
            int number=random.nextInt(9);
            sb.append(number);
        }
        String telNumber = "138" + sb.toString();
        return telNumber;
    }

}




