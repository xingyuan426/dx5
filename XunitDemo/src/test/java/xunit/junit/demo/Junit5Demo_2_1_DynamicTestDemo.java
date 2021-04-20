package xunit.junit.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import xunit.junit.entity.ResultList;
import xunit.junit.entity.ShellResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：xingyuan.zhang
 * @date ：Created in 2021/4/13 20:57
 * @description：动态测试范例，常用于整合其他测试工具的测试结果
 * @version: V1.0
 */
public class Junit5Demo_2_1_DynamicTestDemo {


/*    @Test
    public void entityTest() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ResultList resultList = objectMapper.readValue(new File("src/main/resources/data/shell_test_result.yaml"), ResultList.class);
    }*/

    @TestFactory
    Collection<DynamicTest> runShellResult() throws IOException {
        List<DynamicTest> dynamicTestList = new ArrayList<>();
        //yaml反序列化
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ResultList resultList = objectMapper.readValue(new File("src/main/resources/data/shell_test_result.yaml"), ResultList.class);
        //动态遍历生成测试方法
        for(ShellResult shellResult : resultList.getResultList()){
            dynamicTestList.add(dynamicTest(shellResult.getCaseName(),() -> {
                assertTrue(shellResult.isResult());
            }));
        }




        return dynamicTestList;



    }
}
