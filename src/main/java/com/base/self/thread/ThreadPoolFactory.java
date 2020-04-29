package com.base.self.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * new ThreadPoolExecutor 创建一个指定大小的、普通地并发执行线程的线程池
 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * newCachedThreadPool 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 * newSingleThreadScheduledExecutor 与上一个一样，只是线程池大小为1
 *
 * @author linsizhan
 */
public class ThreadPoolFactory {

    private final static Logger LOGGER = LoggerFactory.getLogger(ThreadPoolFactory.class);

    private final static int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    /**
     * 普通线程池
     * 1、支持普通线程的并发执行
     * 2、支持Future线程并发执行
     */
    private volatile static ThreadPoolExecutor simplePoolExecutor;
    /**
     * 单例线程池
     * 1、只有一个线程的线程池，即每次只能执行一个线程任务
     * 2、多余的任务会保存到一个任务队列中，等待这一个线程空闲
     * 3、当这个线程空闲了再按FIFO方式顺序执行任务队列中的任务
     */
    private volatile static ExecutorService singlePoolExecutor;
    /**
     * 缓存线程池
     * 1、根据实际情况调整线程池中线程的数量的线程池
     */
    private volatile static ExecutorService cachedPoolExecutor;
    /**
     * 固定线程池
     * 1、线程池中的所有线程都正在工作，而此时有新任务提交，那么将会创建新的线程去处理该任务
     * 2、假如之前有一些线程完成了任务，现在又有新任务提交，那么将不会创建新线程去处理
     */
    private volatile static ThreadPoolExecutor fixedPoolExecutor;
    /**
     * 定时线程池
     * 1、支持延时执行线程（普通线程，Future线程均可）
     * 2、支持连续间隔执行普通线程
     */
    private volatile static ScheduledExecutorService scheduledPoolExecutor;
    /**
     * 单例定时线程池
     */
    private volatile static ScheduledExecutorService singleScheduledPoolExecutor;

    /**
     * 获取一个普通的线程池， 最大50并发，初始化25， 每个线程保持10秒生存时间
     * 经测试， 并发线程只有初始化25个
     */
    public static ThreadPoolExecutor getSimpleExecutorInstance() {
        if (simplePoolExecutor == null) {
            synchronized (ThreadPoolExecutor.class) {
                if (simplePoolExecutor == null) {
                    simplePoolExecutor = new ThreadPoolExecutor(CPU_COUNT * 6, 50, 10, TimeUnit.SECONDS,
                            new LinkedBlockingQueue<Runnable>(),
                            new DefaultThreadFactory("Simple_Pool"));
                }
            }
        }
        return simplePoolExecutor;
    }

    /**
     * 线程默认优先级是5。
     * 线程优先级的范围是：1-10。
     * 获取线程对象的优先级: public final int getPriority()
     * 设置线程对象的优先级: public final void setPriority(int newPriority)
     * 具体实现：
     * Runnable run = new Runnable() {
     *
     * @Override public void run() {}
     * };
     * Thread thread = new Thread(run);
     * int priority = thread.getPriority();
     * thread.setPriority(10);
     */
    public static ExecutorService getSinglePoolExecutorInstance() {
        if (singlePoolExecutor == null) {
            synchronized (ThreadPoolExecutor.class) {
                if (singlePoolExecutor == null) {
                    singlePoolExecutor = Executors.newSingleThreadExecutor(new DefaultThreadFactory("Single_Pool"));
                }
            }
        }
        return singlePoolExecutor;
    }

    /**
     * 根据提交未完成的线程数量而增长的池子,保证提交的所有任务都执行
     */
    public static ExecutorService getCachedPoolExecutorInstance() {
        if (cachedPoolExecutor == null) {
            synchronized (ThreadPoolExecutor.class) {
                if (cachedPoolExecutor == null) {
                    cachedPoolExecutor = Executors.newCachedThreadPool(new DefaultThreadFactory("Cached_Pool"));
                }
            }
        }
        return cachedPoolExecutor;
    }

    /**
     * 固定大小50，多余的任务会排队，空闲时根据优先级调用下一个线程
     */
    public static ThreadPoolExecutor getFixedPoolExecutorInstance() {
        if (fixedPoolExecutor == null) {
            synchronized (ThreadPoolExecutor.class) {
                if (fixedPoolExecutor == null) {
                    fixedPoolExecutor = new ThreadPoolExecutor(50, 50, 0L, TimeUnit.MILLISECONDS,
                            new LinkedBlockingQueue<Runnable>(),
                            new DefaultThreadFactory("Fixed_Pool"));
                }
            }
        }
        return fixedPoolExecutor;
    }

    /**
     * 获取一个周期的线程池， 池子大小为25
     * <p>
     * 方法说明：
     * scheduledPool.schedule(callable, delay, unit); 参数类型:Callable, long, TimeUnit.SECONDS
     * scheduledPool.schedule(command, delay, unit); Callable是Future线程， command是普通线程
     * <p>
     * 等待上一个任务完成，再间隔delay执行一次
     * scheduledPool.scheduleWithFixedDelay(command, initialDelay, delay, unit);
     * <p>
     * 等待上一个任务完成，如果上一个任务执行时间 > period, 直接开始下一个任务。
     * 如果上一个任务执行时间 < period, 等待的间隔时间为period - 上一个任务执行时间。
     * scheduledPool.scheduleAtFixedRate(command, initialDelay, period, unit);
     */
    public static ScheduledExecutorService getScheduledPoolExecutorInstance() {
        if (scheduledPoolExecutor == null) {
            synchronized (ThreadPoolExecutor.class) {
                if (scheduledPoolExecutor == null) {
                    scheduledPoolExecutor = Executors.newScheduledThreadPool(25, new DefaultThreadFactory("Scheduled_Pool"));
                }
            }
        }
        return scheduledPoolExecutor;
    }

    /**
     * 与上一个方法一样，但池子容量为1, 多余排队, 按优先级执行
     */
    public static ScheduledExecutorService getSingleScheduledPoolExecutorInstance() {
        if (singleScheduledPoolExecutor == null) {
            synchronized (ThreadPoolExecutor.class) {
                if (singleScheduledPoolExecutor == null) {
                    singleScheduledPoolExecutor = Executors.newSingleThreadScheduledExecutor(new DefaultThreadFactory("Single_Scheduled_Pool"));
                }
            }
        }
        return singleScheduledPoolExecutor;
    }

    /**
     * 关闭传入的线程池
     * 等待secnods秒后关闭线程池。如果还有任务在运行，则等待任务完成
     * 该方法调用后，不能再提交任务
     * 通常在容器摧毁时调用该方法释放资源
     */
    public static boolean shutdownAndWait(ExecutorService executor, int secnods) {
        if (executor != null) {
            try {
                executor.shutdown();
                boolean result = executor.awaitTermination(secnods, TimeUnit.SECONDS);
                return result;
            } catch (InterruptedException e) {
                LOGGER.error("====线程池关闭异常", e);
            }
        }
        return false;
    }

    public static boolean shutdownAndWait(int secnods) {

        boolean result = false;

        if (simplePoolExecutor != null) {
            try {
                simplePoolExecutor.shutdown();
                result = simplePoolExecutor.awaitTermination(secnods, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                LOGGER.error("====线程池simplePoolExecutor关闭异常", e);
            }
        }

        if (singlePoolExecutor != null) {
            try {
                singlePoolExecutor.shutdown();
                result = result && singlePoolExecutor.awaitTermination(secnods, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                LOGGER.error("====线程池singlePoolExecutor关闭异常", e);
            }
        }

        if (cachedPoolExecutor != null) {
            try {
                cachedPoolExecutor.shutdown();
                result = result && cachedPoolExecutor.awaitTermination(secnods, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                LOGGER.error("====线程池cachedPoolExecutor关闭异常", e);
            }
        }

        if (fixedPoolExecutor != null) {
            try {
                fixedPoolExecutor.shutdown();
                result = result && fixedPoolExecutor.awaitTermination(secnods, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                LOGGER.error("====线程池fixedPoolExecutor关闭异常", e);
            }
        }

        if (scheduledPoolExecutor != null) {
            try {
                scheduledPoolExecutor.shutdown();
                result = result && scheduledPoolExecutor.awaitTermination(secnods, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                LOGGER.error("====线程池scheduledPoolExecutor关闭异常", e);
            }
        }

        if (singleScheduledPoolExecutor != null) {
            try {
                singleScheduledPoolExecutor.shutdown();
                result = result && singleScheduledPoolExecutor.awaitTermination(secnods, TimeUnit.SECONDS);
                return result;
            } catch (InterruptedException e) {
                LOGGER.error("====线程池singleScheduledPoolExecutor关闭异常", e);
            }
        }

        return false;
    }

    /**
     * 内部线程池工厂，可自定义线程池中线程名
     */
    private static class DefaultThreadFactory implements ThreadFactory {

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;

        /**
         * 定义每个线程名前缀
         */
        DefaultThreadFactory(String poolName) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "第" + poolNumber.getAndIncrement() + "个池:name = " + poolName + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

}

