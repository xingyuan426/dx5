/**
 * projectName: Junit5Demo0410
 * fileName: Junit5Demo_3_1_parallel.java
 * packageName: com.junit5.xunit.junit.demo
 * date: 2021-04-10 下午2:12
 */
package xunit.junit.demo;

import org.junit.jupiter.api.RepeatedTest;
import util.Calculator;

/**
 * @version: V1.0
 * @author: kuohai
 * @className: Junit5Demo_3_1_parallel
 * @packageName: com.junit5.xunit.junit.demo
 * @description: 并发场景测试
 * @data: 2021-04-10 下午2:12
 **/
public class Junit5Demo_3_1_parallel {
    @RepeatedTest(10)
    public void countTest() throws InterruptedException {
        int result = Calculator.count(1);
        long threadId = Thread.currentThread().getId();
        System.out.println("线程号+"+threadId+"为您计算当前报名人数为：" +result);
    }

    @RepeatedTest(10)
    public void atoicTest() throws InterruptedException {
        int result = Calculator.atoicCount(1);
        //long threadId = Thread.currentThread().getId();
        //System.out.println("线程号+"+threadId+"为您计算当前报名人数为：" +result);
        System.out.println("为您计算当前报名人数为：" +result);
    }

    //为什么这个也可以避免出现脏读
    @RepeatedTest(10)
    public void leftTest() throws InterruptedException {
        int result = Calculator.leftCount(1);
        long threadId = Thread.currentThread().getId();
        System.out.println("线程号+"+threadId+"为您计算当前报名人数为：" +result);
    }

}