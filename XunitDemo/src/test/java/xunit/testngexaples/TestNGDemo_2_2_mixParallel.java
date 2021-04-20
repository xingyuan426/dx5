package xunit.testngexaples;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.Calculator;


public class TestNGDemo_2_2_mixParallel {
    @Test(invocationCount = 10)
    public void addTest() throws InterruptedException {
        int result = Calculator.add(4,2);
        System.out.println("加法计算结果为： "+result);
        Assert.assertEquals(result,6);
    }

    @Test(invocationCount = 10)
    public void subTest02() throws InterruptedException {
        int result = Calculator.subtract(4,2);
        System.out.println("减法计算结果为： "+result);
        Assert.assertEquals(result,2);
    }
}