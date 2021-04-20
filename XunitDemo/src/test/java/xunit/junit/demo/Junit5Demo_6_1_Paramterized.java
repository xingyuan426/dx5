package xunit.junit.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import xunit.junit.entity.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


/**
 * @author ：xingyuan.zhang
 * @date ：Created in 2021/4/19 21:12
 * @description：利用methodSource数据驱动
 * @version: V1.0
 */
public class Junit5Demo_6_1_Paramterized {

    @ParameterizedTest
    @MethodSource("testDDTFromYaml")
    public void testDDTFromYaml(User user){
        assertTrue(user.getUsername().length()>3);


    }

    static List<User> testDDTFromYaml() throws IOException{
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference typeReference = new TypeReference<List<User>>(){
        };
        List<User> users = mapper.readValue(new File("src/main/resources/data/user.yaml"),typeReference);
        return users;

    }
}
