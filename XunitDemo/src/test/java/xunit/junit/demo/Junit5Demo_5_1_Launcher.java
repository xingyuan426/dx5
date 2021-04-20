package xunit.junit.demo;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import xunit.junit.example.packageA.ClassATest;

import java.io.File;
import java.nio.file.Paths;
import java.util.Collections;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.ClassNameFilter.excludeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.*;

/**
 * @author ：xingyuan.zhang
 * @date ：Created in 2021/4/13 22:05
 * @description：代码API触发
 * @version: V1.0
 */
public class Junit5Demo_5_1_Launcher {
    public static void main(String[] args) {
/*
    启动分一下几步：
        1. 构造LauncherDiscoveryRequest指定测试类的查找和过滤规则
        2. 通过 LauncherFactory.create()　来获取Launcher默认实现
        3. 通过添加TestExecutionListener来进行测试结果的监听
        4. 执行launcher.execute(req)方法启动测试
*/

/*        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectPackage("xunit/junit/example/packageA")
//                        selectClass(ClassATest.class),
//                        selectMethod("xunit.junit.demo.Junit5Demo_1_1_Assert#addTest")
                ).filters(
//                        includeClassNamePatterns(".*ATest")
//                        excludeClassNamePatterns(".*ATest")
                ).build();*/


/*        //By classpath root
        File classesDir = new File("C:\\Users\\Sherry\\workspace\\junit5Demo\\target\\test-classes");

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClasspathRoots(Collections.singleton(Paths.get(classesDir.toURI()))))
//               Standard include pattern in the form of a regular expression that is used to match against fully qualified class names: "^(Test.*|.+[.$]Test.*|.*Tests?)$"
                .filters(includeClassNamePatterns("(.*Tests?)$"))
                .build();*/

        //By package
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectPackage("xunit.junit.example"))
                .filters(includeClassNamePatterns(".*ATest"))
                .build();

/*        //By Class
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(ClassATest.class))
                .filters(includeClassNamePatterns(".*"))
                .build();*/

/*        //By Method
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectMethod(ClassATest.class, "testCaseA02"))
                .filters(includeClassNamePatterns(".*"))
                .build();*/
        Launcher launcher = LauncherFactory.create();

        // Register a listener of your choice
        TestExecutionListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);

        launcher.execute(request);
    }
}
