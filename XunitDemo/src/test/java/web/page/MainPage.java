package web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public ContactPage toContactPage(){
        driver.findElement(By.linkText("通讯录"));
        return new ContactPage(driver);
    }

    public ContactPage toMemberPage(){
//        driver.findElement(By.linkText("添加成员"));
        try {
            click(By.linkText("添加成员"));
            Thread.sleep(10000);
            return new ContactPage(driver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
