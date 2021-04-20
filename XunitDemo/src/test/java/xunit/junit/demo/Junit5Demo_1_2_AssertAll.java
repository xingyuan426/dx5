package xunit.junit.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import util.Calculator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Junit5Demo_1_2_AssertAll {
    @Test
    public void addTest() throws InterruptedException {
        int result = Calculator.add(4,2);
        System.out.println("加法计算结果： "+ result);

        int result01 = Calculator.add(1,-1);
        System.out.println("加法计算结果： "+ result01);

        int result02 = Calculator.add(0,2);
        System.out.println("加法计算结果： "+ result02);

        //使用软断言
        assertAll("校验计算结果",
                ()->{
                        assertEquals(6,result);
                        System.out.println("Done01");
                    },
                ()->{assertEquals(1,result01);System.out.println("Done02");},//如果该断言失败了，则不会再执行该代码块内断言失败之后的语句
                ()->{assertEquals(2,result02);System.out.println("Done03");}

        );
    }

    //更规范的写法
    @Test
    public void addTest2() throws InterruptedException {
        ArrayList<Executable> assertList = new ArrayList<>();
        int result = Calculator.add(4,2);
        System.out.println("加法计算结果： "+ result);
        assertList.add(()->{assertEquals(6,result);System.out.println("Done01");});
        int result01 = Calculator.add(1,-1);
        System.out.println("加法计算结果： "+ result01);
        assertList.add(() -> assertEquals(6,result01));
        int result02 = Calculator.add(0,2);
        System.out.println("加法计算结果： "+ result02);

        assertAll("校验计算结果",assertList.stream());

    }
}
