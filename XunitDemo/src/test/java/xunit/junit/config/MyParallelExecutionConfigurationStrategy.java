package xunit.junit.config;

import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;

/**
 * @author ：xingyuan.zhang
 * @date ：Created in 2021/4/13 20:57
 * @description：配置线程数
 * @version: V1.0
 */
public class MyParallelExecutionConfigurationStrategy implements ParallelExecutionConfigurationStrategy {
    @Override
    public ParallelExecutionConfiguration createConfiguration(ConfigurationParameters configurationParameters) {
        //这里可以添加逻辑，动态的调节线程配置
        int parallelism = 2;
        return new MyParallelExecutionConfiguration(parallelism, parallelism, 256 + parallelism, parallelism, 30);
    }
}
