package xunit.testngexaples;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.Calculator;

public class TestNGDemo_1_1_SoftAssert {
    @Test
    public void addTest() throws InterruptedException {
        int result01 = Calculator.add(4,2);
        System.out.println(result01);
        Assert.assertEquals(result01,6);

        int result02 = Calculator.add(4,2);
        System.out.println(result02);
        Assert.assertEquals(result02,2);

        int result03 = Calculator.add(4,2);
        System.out.println(result03);
        Assert.assertEquals(result03,2);

    }

    @Test
    public void softAddTest() throws InterruptedException {
        //软断言
        SoftAssert assertion = new SoftAssert();

        int result01 = Calculator.add(4,2);
        System.out.println(result01);
        assertion.assertEquals(result01,6);

        int result02 = Calculator.add(4,2);
        System.out.println(result02);
        assertion.assertEquals(result02,2);

        int result03 = Calculator.add(4,2);
        System.out.println(result03);
        assertion.assertEquals(result03,2);

        assertion.assertAll();

    }
}