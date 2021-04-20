package web.testCase;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import web.page.ContactPage;
import web.page.MainPage;
import web.page.WeWork;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MemberTest {



    public void add(){
        //todo: 登录企业微信
        //todo: 进入通讯录
        //todo：添加成员  头像（有无）  姓名（中英文 特殊字符 长度） 帐号（唯一性、命名规则） 手机（正确 错误 重复） 部门（父子）
        //todo: 参数化 排列组合
        //todo: 保存
        //todo: 判断结果 若干断言
    }

    @Test
    public void addLink(){
        String accountId="zxytest_"+System.currentTimeMillis();
        String username="zxytest";
        String mobile=String.valueOf(System.currentTimeMillis()).substring(0, 11);
        String res = new WeWork().startWeb().login().toMemberPage().add(
                username,accountId,mobile,null
        ).search(accountId).getMember();
        assertThat(res, equalTo(username));
    }

    @Test
    public void addDepart(){
        String departName = "部门"+System.currentTimeMillis();
        String res = new WeWork().startWeb().login().toMemberPage().addDepart(departName, "PML-课题5-服务定制网络").search(departName).getDepart();
        assertThat(res,equalTo(departName));
    }
}
