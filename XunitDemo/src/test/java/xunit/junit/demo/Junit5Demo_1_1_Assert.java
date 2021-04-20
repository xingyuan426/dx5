package xunit.junit.demo;

import org.junit.jupiter.api.Test;
import util.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit5Demo_1_1_Assert {
    @Test
    public void addTest() throws InterruptedException {
        int result = Calculator.add(4,2);
        System.out.println("加法计算结果： "+ result);
        assertEquals(6,result);
        int result01 = Calculator.add(1,-1);
        System.out.println("加法计算结果： "+ result01);
        assertEquals(1,result01);//未用软断言则程序停在断言出错的那一步不会继续，为解决该问题引入软断言
        int result02 = Calculator.add(0,2);
        System.out.println("加法计算结果： "+ result02);
        assertEquals(1,result02);


    }

}
