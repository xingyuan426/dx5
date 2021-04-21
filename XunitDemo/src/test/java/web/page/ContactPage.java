package web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.entity.Member;

public class ContactPage extends BasePage {
    By username = By.name("username");
    By accountId = By.name("accid");
    By mobil = By.name("mobile");
    By nickName = By.id("memberAdd_english_name");
    By genderMale=By.cssSelector("[name='gender'][value='1']");
    By genderFemale=By.cssSelector("[name='gender'][value='2']");
    By telephone = By.id("memberAdd_telephone");
    By mail = By.id("memberAdd_mail");
    By addr = By.id("memberEdit_address");
    By innerPostion=By.id("memberAdd_title");
    By imageIcon = By.id("js_upload_file");
    By imageUpl = By.cssSelector(".ww_fileInput.js_file");



    public ContactPage(WebDriver driver) {
        super(driver);
    }

/*    public ContactPage add(String name, String accountId, String mobile, HashMap<String,String> data){
        driver.findElement(By.name("username")).sendKeys(name);
        driver.findElement(By.name("acctid")).sendKeys(accountId);
        driver.findElement(By.name("mobile")).sendKeys(mobile);
        if(null!=data){
            driver.findElement(By.id("memberAdd_english_name")).sendKeys();

        }
        driver.findElement(By.linkText("保存")).click();
       return this;

    }*/

    public ContactPage add(String username, String accountId, String mobile,Member member){
        //todo: 性别，部门，标签未做，是否需要每个参数的输入都封装成方法调用？嵌套太多层是否影响代码执行速率和可读性？
        try {
            driver.findElement(By.name("username")).sendKeys(username);
            driver.findElement(By.name("acctid")).sendKeys(accountId);
            driver.findElement(By.name("mobile")).sendKeys(mobile);
            if(null!=member) {
                driver.findElement(nickName).sendKeys(member.getNickName());
                driver.findElement(telephone).sendKeys(member.getTelephone());
                driver.findElement(mail).sendKeys(member.getMail());
                driver.findElement(addr).sendKeys(member.getAddress());
                driver.findElement(innerPostion).sendKeys(member.getInnerPostion());
                if (null != member.getImagPath()) {
                    driver.findElement(imageIcon).click();
                    driver.findElements(imageUpl).get(0).sendKeys(System.getProperty("user.dir")+member.getImagPath());
                    driver.findElement(By.cssSelector(".qui_btn.ww_btn.ww_btn_Blue.js_save")).click();
                }
            }
            Thread.sleep(300);
            driver.findElement(By.linkText("保存")).click();
            return this;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;

    }

    //导入成员示意
    public ContactPage importMember(String filePath){
        driver.findElements(By.cssSelector(".ww_btn_PartDropdown_left")).get(1).click();
        driver.findElement(By.linkText("文件导入")).click();
        driver.findElement(By.id("js_upload_file_input")).sendKeys(filePath);
        driver.findElement(By.linkText("确认导入")).click();
        driver.findElement(By.linkText("前往查看")).click();
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

    public ContactPage searchLabel(String condition ){
        driver.findElement(By.cssSelector("input.js_search_in")).sendKeys(condition);
        return this;
    }

    public String getMember(){
        String name = driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
        return name;

    }

    public ContactPage addDepart(String name, String parent) {
        try {
            click(By.linkText("添加"));
            click(By.linkText("添加部门"));
            sendKeys(By.name("name"),name);
            click(By.linkText("选择所属部门"));
            //避免使用滚动
            Thread.sleep(300);
            // 按老师的方法先找form再linkText找选项，死活找不到，不明白
            // driver.findElement(By.tagName("form")).findElement(By.linkText(parent)).click();
            driver.findElement(By.cssSelector(".js_party_list_container>div>ul>li>a")).click();
            driver.findElement(By.linkText("确定")).click();
            return this;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDepart(){
        try {
            Thread.sleep(300);
            String departName = driver.findElement(By.cssSelector("span#party_name")).getText();
            return departName;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ContactPage toLabel(){
        try {
            driver.findElement(By.linkText("标签")).click();
            Thread.sleep(1000);
            return this;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ContactPage addLabel(String labelName, String parent){
        driver.findElement(By.cssSelector("i.member_colLeft_top_addBtn")).click();
        driver.findElement(By.name("name")).sendKeys(labelName);
        driver.findElement(By.cssSelector(".qui_btn.ww_btn.ww_btn_Dropdown.js_toggle_share_range")).click();
        driver.findElement(By.tagName("form")).findElement(By.linkText(parent)).click();
        driver.findElement(By.linkText("确定")).click();
        return this;
    }

    public String getLabel(){
        String label = driver.findElement(By.cssSelector("span.ww_commonCntHead_title_inner_text")).getText();
        return label;
    }
}
