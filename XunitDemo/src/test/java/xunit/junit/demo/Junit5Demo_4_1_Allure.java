package xunit.junit.demo;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import util.Calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ：xingyuan.zhang
 * @date ：Created in 2021/4/13 21:43
 * @description：生成allure报告
 * @version: V1.0
 */

@Epic("Epic计算器项目")
@Feature("Feature冒烟测试用例")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Junit5Demo_4_1_Allure {
    @Description("Description加法测试-assertAll应用")
    @Story("Story加法测试")
    @DisplayName("DisplayName加法测试")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("123")
    @TmsLink("test-1")
    @Test
    @Order(1)
    public void addTest() throws InterruptedException {
        int result = Calculator.add(4, 2);
        System.out.println("加法计算结果： "+result);
        int result01 = Calculator.add(-1, 1);
        System.out.println("加法计算结果： "+result01);
        int result02 = Calculator.add(0, 2);
        System.out.println("加法计算结果： "+result02);

        assertAll("计算结果校验！",
                () -> assertEquals(6, result),
                () -> assertEquals(1, result01),
                () -> assertEquals(2,result02)
        );
    }

    @Test
    @Order(2)
    public void multiplyTest() {
        int result = Calculator.multiply(4, 2);
        System.out.println("乘法计算结果： "+result);
        assertThat(result,equalTo(8));
    }
    @Test
    @Order(3)
    public void divideTest() {
        int result = Calculator.divide(4, 2);
        System.out.println("除法计算结果： "+result);
        assertEquals(4,result);
    }
    @BeforeEach
    public void clear(){
        Calculator.clear();
    }
}
