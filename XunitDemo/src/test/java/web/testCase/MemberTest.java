package web.testCase;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import util.Calculator;
import web.entity.Member;
import web.page.ContactPage;
import web.page.MainPage;
import web.page.WeWork;
import xunit.junit.entity.User;

import io.qameta.allure.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Epic("企业微信项目")
@Feature("通讯录测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberTest extends BaseTest {


    public void add(){
        //todo: 登录企业微信
        //todo: 进入通讯录
        //todo：添加成员  头像（有无）  姓名（中英文 特殊字符 长度） 帐号（唯一性、命名规则） 手机（正确 错误 重复） 部门（父子）
        //todo: 参数化 排列组合
        //todo: 保存
        //todo: 判断结果 若干断言
    }

    @DisplayName("创建成员")
    @Order(1)
    @ParameterizedTest
    @MethodSource("readMemberValues")
    public void addUpload(Member member){
        String accountId="zxytest_"+System.currentTimeMillis();
        String username="zxytest";
        String mobile=String.valueOf(System.currentTimeMillis()).substring(0, 11);
        String res = weWork.startWeb().login().toMemberPage().add(
                username,accountId,mobile,member
        ).search(accountId).getMember();
        assertThat(res, equalTo(username));
    }

    static List<Member> readMemberValues() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference typeReference = new TypeReference<List<Member>>(){
        };
        List<Member> members = mapper.readValue(new File("src/main/resources/Data/member.yaml"),typeReference);
        return members;

    }

    @DisplayName("创建部门")
    @Order(2)
    @Test
    public void addDepart(){
        String departName = "部门"+System.currentTimeMillis();
        String res = weWork.startWeb().login().toMemberPage().addDepart(departName, "测试").search(departName).getDepart();
        assertThat(res,equalTo(departName));
    }

    @DisplayName("创建标签")
    @Order(3)
    @Test
    public void addLabel(){
        String labelName = "标签"+System.currentTimeMillis();
        String res = weWork.startWeb().login().toMemberPage().toLabel().addLabel(labelName,"所有管理员").searchLabel(labelName).getLabel();
        assertThat(labelName,equalTo(labelName));
    }


}
