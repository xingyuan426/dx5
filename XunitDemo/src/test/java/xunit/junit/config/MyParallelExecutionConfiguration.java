package xunit.junit.config;

import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;

/**
 * @author ：xingyuan.zhang
 * @date ：Created in 2021/4/13 20:55
 * @description：实现接口ParallelExecutionConfiguration
 * @version: V1.0
 */
public class MyParallelExecutionConfiguration implements ParallelExecutionConfiguration {
    private final int parallelism;
    private final int minimumRunnable;
    private final int maxPoolSize;
    private final int corePoolSize;
    private final int keepAliveSeconds;

    MyParallelExecutionConfiguration(int parallelism, int minimumRunnable, int maxPoolSize, int corePoolSize, int keepAliveSeconds) {
        this.parallelism = parallelism;//指定线程池数量。
        this.minimumRunnable = minimumRunnable;//线程池中允许的最小线程数。
        this.maxPoolSize = maxPoolSize;//线程池中允许的最大线程数，线程池中的当前线程数目不会超过该值。如果队列中任务已满，并且当前线程个数小于maximumPoolSize，那么会创建新的线程来执行任务。
        this.corePoolSize = corePoolSize;//线程池的基本大小，即在没有任务需要执行的时候线程池的大小，并且只有在工作队列满了的情况下才会创建超出这个数量的线程
        this.keepAliveSeconds = keepAliveSeconds;//如果一个线程处在空闲状态的时间超过了该属性值，就会因为超时而退出
    }

    public int getParallelism() {
        return this.parallelism;
    }

    public int getMinimumRunnable() {
        return this.minimumRunnable;
    }

    public int getMaxPoolSize() {
        return this.maxPoolSize;
    }

    public int getCorePoolSize() {
        return this.corePoolSize;
    }

    public int getKeepAliveSeconds() {
        return this.keepAliveSeconds;
    }
}
