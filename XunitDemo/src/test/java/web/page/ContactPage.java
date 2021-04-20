package web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class ContactPage {
    private WebDriver driver;
    public ContactPage(WebDriver driver) {
        this.driver=driver;
    }

    public ContactPage add(String name, String accountId, String mobile, HashMap<String,String> data){
        driver.findElement(By.name("username")).sendKeys(name);
        driver.findElement(By.name("acctid")).sendKeys(accountId);
        driver.findElement(By.name("mobile")).sendKeys(mobile);
        driver.findElement(By.linkText("保存")).click();
       return this;

    }

    public void addWithFail(){
    }

    public void delete(){

    }

    public ContactPage search(String condition){
        driver.findElement(By.id("memberSearchInput")).sendKeys(condition);
        return this;
    }

    public String getMember(){
        String name = driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
        return name;

    }

    public ContactPage addDepart(String name, String parent) {
        driver.findElement(By.linkText("添加")).click();
        driver.findElement(By.linkText("添加部门")).click();
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.linkText("选择所属部门")).click();
        //避免使用滚动
        driver.findElement(By.linkText(parent)).click();
        driver.findElement(By.linkText("确定")).click();
        return this;
    }

    public String getDepart(){
        String name = driver.findElement(By.id("party_name")).getText();
        return name;

    }

    public ContactPage toLabel(){
        driver.findElement(By.linkText("标签")).click();
        return this;
    }

    public ContactPage addLabel(){
        driver.findElement(By.cssSelector(".member_colLeft_top_addBtn")).click();
        return this;
    }
}
