package xunit.testngexaples;

import org.testng.annotations.Test;
import util.Calculator;


public class TestNGDemo_2_1_Paraller {
    // invocationCount 方法执行的次数据
    // threadPoolSize 线程数
    @Test(threadPoolSize = 2,invocationCount = 10)
    public void countTest() throws InterruptedException {
        int result = Calculator.count(1);
        long threadId = Thread.currentThread().getId();
        System.out.println("线程ID:"+threadId+"为您计算，结果为： "+result);
    }

    @Test(threadPoolSize = 2,invocationCount = 10)
    public void syncTest() throws InterruptedException {
        int result = Calculator.synCount(1);
        long threadId = Thread.currentThread().getId();
        System.out.println("线程ID:"+threadId+"为您计算，结果为： "+result);
    }
}