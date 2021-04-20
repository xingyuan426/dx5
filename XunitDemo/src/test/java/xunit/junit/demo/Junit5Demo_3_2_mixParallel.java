package xunit.junit.demo;

import org.junit.jupiter.api.RepeatedTest;
import util.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ：xingyuan.zhang
 * @date ：Created in 2021/4/13 21:23
 * @description：混合并发场景测试
 * @version: V1.0
 */
public class Junit5Demo_3_2_mixParallel {
    @RepeatedTest(10)
    public void add() throws InterruptedException {
        int result = Calculator.add(4, 2);
        long threadId = Thread.currentThread().getId();
        System.out.println("线程号+"+threadId+"加法计算结果： "+result);
        assertEquals(6,result);
    }

    @RepeatedTest(10)
    public void subtract() throws InterruptedException {
        int result = Calculator.subtract(4, 2);
        long threadId = Thread.currentThread().getId();
        System.out.println("线程号+"+threadId+"减法计算结果： "+result);
        assertEquals(2,result);
    }
}
